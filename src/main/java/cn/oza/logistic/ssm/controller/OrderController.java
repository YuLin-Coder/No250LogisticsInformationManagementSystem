package cn.oza.logistic.ssm.controller;

import cn.oza.logistic.constant.ConstantDataField;
import cn.oza.logistic.ssm.pojo.*;
import cn.oza.logistic.ssm.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderViewService orderViewService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BasicDataService basicDataService;

    @Autowired
    private OrderDetailService orderDetailService;

    //工具方法
    public PageInfo<OrderView> getOrdersUtil(String keyWord, Integer pageNum, Integer pageSize) {
        //开始分页，这里启动并设置页码，和每页结果数量后，后续结果会自动为分页后结果
        PageHelper.startPage(pageNum, pageSize);

        OrderViewExample orderViewExample = new OrderViewExample();
        OrderViewExample.Criteria criteria = orderViewExample.createCriteria();
        /**
         * StringUtils.isNotBlank 可以判断 ""/" "/null 为 false
         */
        if (StringUtils.isNotBlank(keyWord)) {
            //客户名条件
            criteria.andCustomerNameLike("%" + keyWord + "%");
        }

        //判断当前登录用户是否为业务员，业务员只能查看自己的订单
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (user.getRoleId() == ConstantDataField.SALESMAN_ROLE_ID) {
            //客户的业务员用户名等于登录用户的用户名
            criteria.andUsernameEqualTo(user.getUsername());
        }

        List<OrderView> orders = orderViewService.selectByExample(orderViewExample);
        //获得分页对象
        PageInfo<OrderView> pageInfo = new PageInfo<>(orders);

        return pageInfo;
    }

    @RequestMapping("/list")
    @RequiresPermissions("order:list")
    public String list() {
        return "order/list";
    }

    @ResponseBody
    @RequestMapping("/getOrders")
    @RequiresPermissions("order:list")
    public PageInfo<OrderView> getOrders(String keyWord,
                                        @RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "10") Integer pageSize) {
        return getOrdersUtil(keyWord, pageNum, pageSize);
    }

    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("order:delete")
    public Map<String, String> delete(Long[] orderIds) {
        HashMap<String, String> map = new HashMap<>();
        //单个删除
        if (orderIds.length == 1) {
            int res = orderService.deleteByPrimaryKey(orderIds[0]);
            if (res == 1) {
                map.put("status", "true");
                map.put("info", "删除成功！");
                return map;
            }
            map.put("status", "false");
            map.put("info", "删除失败！订单已经不存在");
            return map;
        }
        //批量删除
        int success = 0;
        int total = orderIds.length;
        for(Long orderId : orderIds) {
            success += orderService.deleteByPrimaryKey(orderId);
        }
        map.put("status", "true");
        map.put("info", "成功删除选中 " + total + " 个订单中的 " + success + " 个订单");
        return map;
    }

    @RequestMapping("/add")
    @RequiresPermissions("order:insert")
    public String add(Model m) {
        this.getOrderGeneralData(m);
        return "order/add";
    }


    /*
    用 @RequestBody 注解，将前台传入的 JSON 字符串解析成对象
     */
    @RequestMapping("/insert")
    @RequiresPermissions("order:insert")
    @ResponseBody
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, timeout = 5)
    public Boolean insert(@RequestBody Order order) {
        //插入 order，在此之后，order 获得了 orderId
        int res = orderService.insert(order);
        //获取订单详情集合
        List<OrderDetail> orderDetails = order.getorderDetails();
        orderDetails.forEach(orderDetail -> {
            orderDetail.setOrderId(order.getOrderId());
            orderDetailService.insert(orderDetail);
        });
        if (res == 1) {
            return true;
        }
        return false;
    }

    @RequestMapping("/edit")
    @RequiresPermissions("order:update")
    public String edit(Long orderId, Model m) {
        //获取常规数据
        getOrderGeneralData(m);

        //添加选中的订单
        Order selectedOrder = orderService.selectByPrimaryKey(orderId);
        m.addAttribute("selectedOrder", selectedOrder);

        //添加订单详情
        OrderDetailExample orderDetailExample = new OrderDetailExample();
        orderDetailExample.createCriteria().andOrderIdEqualTo(orderId);
        List<OrderDetail> orderDetails = orderDetailService.selectByExample(orderDetailExample);
        m.addAttribute("orderDetails", orderDetails);

        return "order/edit";
    }

    @RequiresPermissions("order:update")
    @RequestMapping("/update")
    @ResponseBody
    public Boolean update(@RequestBody Order order) {
        OrderDetailExample orderDetailExample = new OrderDetailExample();
        orderDetailExample.createCriteria().andOrderIdEqualTo(order.getOrderId());
        List<OrderDetail> dbOrderDetails = orderDetailService.selectByExample(orderDetailExample); //数据库中的orderDetails
        List<OrderDetail> formOrderDetails = order.getorderDetails(); //表单数据中的orderDetails

        //循环比较数据库数据和表单新数据，删除数据库中在修改中删除的数据
        dbOrderDetails.forEach(dbOrderDetail -> {
            if (!formOrderDetails.contains(dbOrderDetail)) {
                orderDetailService.deleteByPrimaryKey(dbOrderDetail.getOrderDetailId());
            }
        });

        //循环比较表单新数据和数据库数据，若存在则修改，不存在则新增
        formOrderDetails.forEach(formOrderDetail -> {
            if (dbOrderDetails.contains(formOrderDetail)) {
                orderDetailService.updateByPrimaryKeySelective(formOrderDetail);
            } else {
                formOrderDetail.setOrderId(order.getOrderId());
                orderDetailService.insert(formOrderDetail);
            }
        });

        //修改Order
        int res = orderService.updateByPrimaryKey(order);
        if (res == 1){
            return true;
        }
        return false;
    }

    //抽取的工具方法
    private void getOrderGeneralData(Model m){
        User user = (User)SecurityUtils.getSubject().getPrincipal(); //获取当前用户
        Long userRoleId = user.getRoleId(); //当前用户角色ID
        Long userId = user.getUserId(); //当前用户ID

        //查找业务员
        UserExample userExample = new UserExample();
        List<User> users = new ArrayList<>();
        //如果当前用户是业务员只能用自己用户添加
        if (userRoleId == ConstantDataField.SALESMAN_ROLE_ID) {
            users.add(userService.selectByPrimaryKey(userId));
        } else {
            userExample.createCriteria().andRoleIdEqualTo(ConstantDataField.SALESMAN_ROLE_ID);
            users = userService.selectByExample(userExample);
        }
        m.addAttribute("users", users);

        //查找客户
        CustomerExample customerExample = new CustomerExample();
        List<Customer> customers;
        //如果当前用户是业务员只能获得自己的客户
        if (userRoleId == ConstantDataField.SALESMAN_ROLE_ID) {
            customerExample.createCriteria().andUserIdEqualTo(userId);
            customers = customerService.selectByExample(customerExample);
        } else {
            customers = customerService.selectByExample(customerExample);
        }
        m.addAttribute("customers", customers);

        //查找地区
        BasicDataExample areaExample = new BasicDataExample();
        areaExample.createCriteria().andParentIdEqualTo(ConstantDataField.AREA_BASICDATA_ID);
        List<BasicData> areas = basicDataService.selectByExample(areaExample);
        m.addAttribute("areas", areas);

        //查找付款方式
        BasicDataExample paymentExample = new BasicDataExample();
        paymentExample.createCriteria().andParentIdEqualTo(ConstantDataField.PAYMENT_BASICDATA_ID);
        List<BasicData> payments = basicDataService.selectByExample(paymentExample);
        m.addAttribute("payments", payments);

        //查找运送方式
        BasicDataExample transportExample = new BasicDataExample();
        transportExample.createCriteria().andParentIdEqualTo(ConstantDataField.TRANSPORT_BASICDATA_ID);
        List<BasicData> transports = basicDataService.selectByExample(transportExample);
        m.addAttribute("transports", transports);

        //查找取件方式
        BasicDataExample pickupExample = new BasicDataExample();
        pickupExample.createCriteria().andParentIdEqualTo(ConstantDataField.PICKUP_BASICDATA_ID);
        List<BasicData> pickups = basicDataService.selectByExample(pickupExample);
        m.addAttribute("pickups", pickups);

        //查找单位
        BasicDataExample unitExample = new BasicDataExample();
        unitExample.createCriteria().andParentIdEqualTo(ConstantDataField.UNIT_BASICDATA_ID);
        List<BasicData> units = basicDataService.selectByExample(unitExample);
        m.addAttribute("units", units);
    }
}
