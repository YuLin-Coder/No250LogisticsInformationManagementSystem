package cn.oza.logistic.ssm.controller;

import cn.oza.logistic.constant.ConstantDataField;
import cn.oza.logistic.ssm.pojo.*;
import cn.oza.logistic.ssm.service.BasicDataService;
import cn.oza.logistic.ssm.service.CustomerService;
import cn.oza.logistic.ssm.service.CustomerViewService;
import cn.oza.logistic.ssm.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerViewService customerViewService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BasicDataService basicDataService;
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @RequiresPermissions("customer:list")
    public String list() {
        return "customer/list";
    }

    @ResponseBody
    @RequestMapping("/getCustomers")
    @RequiresPermissions("customer:list")
    public PageInfo<CustomerView> getCustomers(String keyWord,
                                                 @RequestParam(defaultValue = "1") Integer pageNum,
                                                 @RequestParam(defaultValue = "10") Integer pageSize) {
        //开始分页，这里启动并设置页码，和每页结果数量后，后续结果会自动为分页后结果
        PageHelper.startPage(pageNum, pageSize);

        CustomerViewExample customerViewExample = new CustomerViewExample();
        CustomerViewExample.Criteria criteria = customerViewExample.createCriteria();
        /**
         * StringUtils.isNotBlank 可以判断 ""/" "/null 为 false
         */
        if (StringUtils.isNotBlank(keyWord)) {
            //权限名条件
            criteria.andCustomerNameLike("%" + keyWord + "%");
        }

        //判断当前登录用户是否为业务员，业务员只能查看自己的客户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        if (user.getRoleId() == ConstantDataField.SALESMAN_ROLE_ID) {
            //客户的业务员id等于登录用户的id
            criteria.andUserIdEqualTo(user.getUserId());
        }

        List<CustomerView> customers = customerViewService.selectByExample(customerViewExample);
        //获得分页对象
        PageInfo<CustomerView> pageInfo = new PageInfo<>(customers);

        return pageInfo;
    }

    @ResponseBody
    @RequestMapping("/delete")
    @RequiresPermissions("customer:delete")
    public Map<String, String> delete(Long[] customerIds) {
        HashMap<String, String> map = new HashMap<>();
        if (customerIds.length == 1) {
            int res = customerService.deleteByPrimaryKey(customerIds[0]);
            if (res == 1) {
                map.put("status", "true");
                map.put("info", "删除成功！");
                return map;
            }
            map.put("status", "false");
            map.put("info", "删除失败！客户已经不存在");
            return map;
        }
        //批量删除
        int success = 0;
        int total = customerIds.length;
        for(Long customerId : customerIds) {
            success += customerService.deleteByPrimaryKey(customerId);
        }
        map.put("status", "true");
        map.put("info", "成功删除选中 " + total + " 个客户中的 " + success + " 个客户");
        return map;
    }


    @RequestMapping("/add")
    @RequiresPermissions("customer:insert")
    public String add(Model m) {
        //查出地区列表
        BasicDataExample basicDataExample = new BasicDataExample();
        basicDataExample.createCriteria().andParentIdEqualTo(ConstantDataField.AREA_BASICDATA_ID);
        List<BasicData> basicDatas= basicDataService.selectByExample(basicDataExample);
        m.addAttribute("areas",basicDatas);

        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        //如果是业务员进行操作，只能选择自己作为业务员
        List<User> users = new ArrayList<>();
        if (user.getRoleId() == ConstantDataField.SALESMAN_ROLE_ID) {
            users.add(user);
        } else {
            UserExample userExample = new UserExample();
            userExample.createCriteria().andRoleIdEqualTo(ConstantDataField.SALESMAN_ROLE_ID);
            users = userService.selectByExample(userExample);
        }
        m.addAttribute("users", users);

        return "customer/add";
    }

    @ResponseBody
    @RequestMapping("/insert")
    @RequiresPermissions("customer:insert")
    public Boolean insert(Customer customer){
        int res = customerService.insert(customer);
        if (res == 1) {
            return true;
        }
        return false;
    }

    @RequestMapping("/edit")
    @RequiresPermissions("customer:update")
    public String edit(Model m, Long customerId) {
        //查出地区列表
        BasicDataExample basicDataExample = new BasicDataExample();
        basicDataExample.createCriteria().andParentIdEqualTo(ConstantDataField.AREA_BASICDATA_ID);
        List<BasicData> basicDatas= basicDataService.selectByExample(basicDataExample);
        m.addAttribute("areas",basicDatas);

        //查出业务员
        UserExample userExample = new UserExample();
        userExample.createCriteria().andRoleIdEqualTo(ConstantDataField.SALESMAN_ROLE_ID);
        List<User> users = userService.selectByExample(userExample);
        m.addAttribute("users", users);

        //查出当前客户
        Customer customer = customerService.selectByPrimaryKey(customerId);
        m.addAttribute("customer", customer);
        return "customer/edit";
    }

    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("customer:update")
    public Boolean update(Customer customer) {
        int res = customerService.updateByPrimaryKeySelective(customer);
        if (res == 1) {
            return true;
        }
        return false;
    }
}
