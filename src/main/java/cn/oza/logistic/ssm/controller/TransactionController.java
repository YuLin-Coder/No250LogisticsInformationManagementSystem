package cn.oza.logistic.ssm.controller;

import cn.oza.logistic.constant.ConstantDataField;
import cn.oza.logistic.ssm.pojo.*;
import cn.oza.logistic.ssm.service.*;
import com.github.pagehelper.PageInfo;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/transaction")
@Controller
public class TransactionController {
    @Autowired
    private OrderController orderController;

    @Autowired
    private OrderViewService orderViewService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private BasicDataService basicDataService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionDetailService transactionDetailService;

    @Autowired
    private InfoService infoService;

    @Autowired
    private ExportService exportService;

    @Autowired
    private ExportDetailService exportDetailService;

    @RequestMapping("/list")
    @RequiresPermissions("transaction:deal")
    public String list() {
        return "transaction/list";
    }

    @RequestMapping("/getOrders")
    @RequiresPermissions("transaction:deal")
    @ResponseBody
    public PageInfo<OrderView> getOrders(String keyWord,
                                        @RequestParam(defaultValue = "1") Integer pageNum,
                                        @RequestParam(defaultValue = "10") Integer pageSize) {
        return orderController.getOrdersUtil(keyWord, pageNum, pageSize);
    }

    @RequestMapping("/deal")
    public String deal(Model m, Long orderId) {
        Order order = orderService.selectByPrimaryKey(orderId);

        OrderViewExample orderViewExample = new OrderViewExample();
        orderViewExample.createCriteria().andOrderIdEqualTo(orderId);
        OrderView orderView = orderViewService.selectByExample(orderViewExample).get(0);

        String area = basicDataService.selectByPrimaryKey(order.getIntervalId()).getBaseName();

        String payment = basicDataService.selectByPrimaryKey(order.getPaymentMethodId()).getBaseName();

        String shippingMethod = basicDataService.selectByPrimaryKey(order.getFreightMethodId()).getBaseName();

        String pickUpMethod = basicDataService.selectByPrimaryKey(order.getTakeMethodId()).getBaseName();

        BasicDataExample basicDataExample = new BasicDataExample();
        basicDataExample.createCriteria().andParentIdEqualTo(ConstantDataField.STORAGE_BASICDATA_ID);
        List<BasicData> storages = basicDataService.selectByExample(basicDataExample);

        OrderDetailExample orderDetailExample = new OrderDetailExample();
        orderDetailExample.createCriteria().andOrderIdEqualTo(orderId);
        List<OrderDetail> orderDetails = orderDetailService.selectByExample(orderDetailExample);

        BasicDataExample basicDataExample1 = new BasicDataExample();
        basicDataExample.createCriteria().andParentIdEqualTo(ConstantDataField.UNIT_BASICDATA_ID);
        List<BasicData> units = basicDataService.selectByExample(basicDataExample1);

        UserExample userExample = new UserExample();
        userExample.createCriteria().andRoleIdEqualTo(ConstantDataField.STORAGE_ROLE_ID);
        List<User> users = userService.selectByExample(userExample);

        TransactionExample transactionExample = new TransactionExample();
        transactionExample.createCriteria().andOrderIdEqualTo(orderId);
        List<Transaction> transactions = transactionService.selectByExample(transactionExample);

        List<TransactionDetail> transactionDetails = new ArrayList<>();
        orderDetails.forEach(orderDetail -> {
            TransactionDetailExample transactionDetailExample = new TransactionDetailExample();
            transactionDetailExample.createCriteria().andOrderDetailIdEqualTo(orderDetail.getOrderDetailId());
            List<TransactionDetail> details = transactionDetailService.selectByExample(transactionDetailExample);
            if (details.size() == 0){
                transactionDetails.add(null);
            } else {
                transactionDetails.add(details.get(0));
            }

        });

        Subject subject = SecurityUtils.getSubject();
        Boolean allowedQuote = subject.isPermitted("transaction:quote");
        Boolean allowedStorage = subject.isPermitted("transaction:storage");


        m.addAttribute("order", order);
        m.addAttribute("orderView", orderView);
        m.addAttribute("area", area);
        m.addAttribute("payment", payment);
        m.addAttribute("shippingMethod", shippingMethod);
        m.addAttribute("pickUpMethod", pickUpMethod);
        m.addAttribute("storages", storages);
        m.addAttribute("orderDetails", orderDetails);
        m.addAttribute("units", units);
        m.addAttribute("users", users);
        if (transactions.size() > 0) {
            m.addAttribute("transaction", transactions.get(0));
        } else {
            m.addAttribute("transaction", null);
        }
        m.addAttribute("transactionDetails",transactionDetails);
        m.addAttribute("allowedQuote", allowedQuote);
        m.addAttribute("allowedStorage", allowedStorage);

        return "transaction/deal";
    }

    @RequestMapping("/update")
    @RequiresPermissions("transaction:deal")
    @ResponseBody
    public Boolean update(@RequestBody Transaction transaction){
        //判断是否存在
        TransactionExample transactionExample = new TransactionExample();
        transactionExample.createCriteria().andOrderIdEqualTo(transaction.getOrderId());
        int res;
        if (transactionService.selectByExample(transactionExample).size() == 0 ) {
            res = transactionService.insert(transaction);
        } else {
            res = transactionService.updateByPrimaryKeySelective(transaction);
        }
        List<TransactionDetail> transactionDetails = transaction.getTransactionDetails();
        transactionDetails.forEach(transactionDetail -> {
            if (transactionDetail.getTransactionDetailId() == null){
                transactionDetailService.insert(transactionDetail);
            } else {
                transactionDetailService.updateByPrimaryKeySelective(transactionDetail);
            }
        });

        //修改为入库
        Order order = orderService.selectByPrimaryKey(transaction.getOrderId());
        order.setOrderStatus(1);
        orderService.updateByPrimaryKeySelective(order);

        if (res == 1) {
            return true;
        }
        return false;
    }

    @RequestMapping("/export")
    @RequiresPermissions("transaction:export")
    public String export(Model m, Long orderId) {
        //判定是否入库了，若否，返回错误页面
        Order order = orderService.selectByPrimaryKey(orderId);
        if (order.getOrderStatus() == 0) {
            m.addAttribute("errorMsg","该订单还未报价入库！");
            return "transaction/error";
        }

        Info info = null;
        try {
            info = resolveInfo(orderId);
        } catch (Exception e) {
            m.addAttribute("errorMsg", "出现异常，请检查是否完成报价入库！");
            return "transaction/error";
        }

        Info dbInfo = infoService.selectByPrimaryKey(orderId);
        if (dbInfo == null) {
            infoService.insert(info);
        } else {
            infoService.updateByPrimaryKeySelective(info);
        }

        ExportExample exportExample = new ExportExample();
        exportExample.createCriteria().andOrderIdEqualTo(orderId);
        Export export = exportService.selectByExample(exportExample).get(0);
        m.addAttribute("export", export);

        ExportDetailExample exportDetailExample = new ExportDetailExample();
        exportDetailExample.createCriteria().andOrderIdEqualTo(orderId);
        List<ExportDetail> exportDetails = exportDetailService.selectByExample(exportDetailExample);
        m.addAttribute("exportDetails", exportDetails);

        TransactionExample transactionExample = new TransactionExample();
        transactionExample.createCriteria().andOrderIdEqualTo(orderId);
        Transaction transaction = transactionService.selectByExample(transactionExample).get(0);
        m.addAttribute("transaction", transaction);

        m.addAttribute("info", info);

        return "transaction/export";
    }

    @RequiresPermissions("transaction:export")
    @RequestMapping("/print")
    public void print(HttpServletResponse response, Long orderId){
        //查找处需要的信息
        Info info = infoService.selectByPrimaryKey(orderId);

        ExportExample exportExample = new ExportExample();
        exportExample.createCriteria().andOrderIdEqualTo(orderId);
        Export export = exportService.selectByExample(exportExample).get(0);

        ExportDetailExample exportDetailExample = new ExportDetailExample();
        exportDetailExample.createCriteria().andOrderIdEqualTo(orderId);
        List<ExportDetail> exportDetails = exportDetailService.selectByExample(exportDetailExample);

        TransactionExample transactionExample = new TransactionExample();
        transactionExample.createCriteria().andOrderIdEqualTo(orderId);
        Transaction transaction = transactionService.selectByExample(transactionExample).get(0);

        //excel 制作
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet();


        HSSFRow row_0 = sheet.createRow(0);
        sheet.addMergedRegion(new CellRangeAddress(0,0,1,3));
        sheet.addMergedRegion(new CellRangeAddress(0,0,5,7));
        sheet.addMergedRegion(new CellRangeAddress(0,0,9,11));
        row_0.createCell(0).setCellValue("订单编号");
        row_0.createCell(1).setCellValue(export.getOrderId());
        row_0.createCell(4).setCellValue("业务员");
        row_0.createCell(5).setCellValue(export.getStaff());
        row_0.createCell(8).setCellValue("客户");
        row_0.createCell(9).setCellValue(export.getCustomerName());

        HSSFRow row_1 = sheet.createRow(1);
        sheet.addMergedRegion(new CellRangeAddress(1,1,1,3));
        sheet.addMergedRegion(new CellRangeAddress(1,1,5,7));
        sheet.addMergedRegion(new CellRangeAddress(1,1,9,11));
        row_1.createCell(0).setCellValue("到达国家");
        row_1.createCell(1).setCellValue(export.getArea());
        row_1.createCell(4).setCellValue("收货地址");
        row_1.createCell(5).setCellValue(export.getShippingAddress());
        row_1.createCell(8).setCellValue("收件人");
        row_1.createCell(9).setCellValue(export.getShippingName());

        HSSFRow row_2 = sheet.createRow(2);
        sheet.addMergedRegion(new CellRangeAddress(2,2,1,3));
        sheet.addMergedRegion(new CellRangeAddress(2,2,5,7));
        sheet.addMergedRegion(new CellRangeAddress(2,2,9,11));
        row_2.createCell(0).setCellValue("联系电话");
        row_2.createCell(1).setCellValue(export.getShippingPhone());
        row_2.createCell(4).setCellValue("付款方式");
        row_2.createCell(5).setCellValue(export.getPayment());
        row_2.createCell(8).setCellValue("货运方式");
        row_2.createCell(9).setCellValue(export.getShippingMethod());

        HSSFRow row_3 = sheet.createRow(3);
        sheet.addMergedRegion(new CellRangeAddress(3,3,1,3));
        sheet.addMergedRegion(new CellRangeAddress(3,3,5,7));
        sheet.addMergedRegion(new CellRangeAddress(3,3,9,11));
        row_3.createCell(0).setCellValue("取件方式");
        row_3.createCell(1).setCellValue(export.getPickupMehtod());
        row_3.createCell(4).setCellValue("入库人");
        row_3.createCell(5).setCellValue(export.getStorageStaff());
        row_3.createCell(8).setCellValue("入库选择");
        row_3.createCell(9).setCellValue(export.getStorage());

        HSSFRow row_4 = sheet.createRow(4);
        sheet.addMergedRegion(new CellRangeAddress(4,4,0,11));
        row_4.createCell(0).setCellValue("费用明细");

        HSSFRow row_5 = sheet.createRow(5);
        sheet.addMergedRegion(new CellRangeAddress(5,5,1,3));
        sheet.addMergedRegion(new CellRangeAddress(5,5,5,7));
        sheet.addMergedRegion(new CellRangeAddress(5,5,9,11));
        row_5.createCell(0).setCellValue("体积收费");
        row_5.createCell(1).setCellValue(export.getVolumeFee());
        row_5.createCell(4).setCellValue("总体积");
        row_5.createCell(5).setCellValue(export.getTotalVolume());
        row_5.createCell(8).setCellValue("体积费率");
        row_5.createCell(9).setCellValue(transaction.getVolumeRate());

        HSSFRow row_6 = sheet.createRow(6);
        sheet.addMergedRegion(new CellRangeAddress(6,6,1,3));
        sheet.addMergedRegion(new CellRangeAddress(6,6,5,7));
        sheet.addMergedRegion(new CellRangeAddress(6,6,9,11));
        row_6.createCell(0).setCellValue("重量收费");
        row_6.createCell(1).setCellValue(export.getWeightFee());
        row_6.createCell(4).setCellValue("总重量");
        row_6.createCell(5).setCellValue(export.getTotalWeight());
        row_6.createCell(8).setCellValue("重量费率");
        row_6.createCell(9).setCellValue(transaction.getWeightRate());

        HSSFRow row_7 = sheet.createRow(7);
        sheet.addMergedRegion(new CellRangeAddress(7,7,1,3));
        sheet.addMergedRegion(new CellRangeAddress(7,7,5,7));
        sheet.addMergedRegion(new CellRangeAddress(7,7,9,11));
        row_7.createCell(0).setCellValue("过关税费");
        row_7.createCell(1).setCellValue(export.getTaxFee());
        row_7.createCell(4).setCellValue("总价值");
        row_7.createCell(5).setCellValue(export.getTotalValue());
        row_7.createCell(8).setCellValue("税率");
        row_7.createCell(9).setCellValue(info.getTaxRate());

        HSSFRow row_8 = sheet.createRow(8);
        sheet.addMergedRegion(new CellRangeAddress(8,8,1,11));
        row_8.createCell(0).setCellValue("取件费用");
        row_8.createCell(1).setCellValue(export.getPickUpFee());

        HSSFRow row_9 = sheet.createRow(9);
        sheet.addMergedRegion(new CellRangeAddress(9,9,1,11));
        row_9.createCell(0).setCellValue("总费用");
        row_9.createCell(1).setCellValue(export.getTotalFee());

        HSSFRow row_10 = sheet.createRow(10);
        sheet.addMergedRegion(new CellRangeAddress(10,10,0,11));
        row_10.createCell(0).setCellValue("货物清单");

        HSSFRow row_11 = sheet.createRow(11);
        sheet.addMergedRegion(new CellRangeAddress(11,11,0,1));
        sheet.addMergedRegion(new CellRangeAddress(11,11,7,8));
        sheet.addMergedRegion(new CellRangeAddress(11,11,9,10));
        row_11.createCell(0).setCellValue("货物名称");
        row_11.createCell(2).setCellValue("数量");
        row_11.createCell(3).setCellValue("单位");
        row_11.createCell(4).setCellValue("长");
        row_11.createCell(5).setCellValue("宽");
        row_11.createCell(6).setCellValue("高");
        row_11.createCell(7).setCellValue("核算体积");
        row_11.createCell(9).setCellValue("核算重量");
        row_11.createCell(11).setCellValue("总价值");

        for(int i = 0; i < exportDetails.size(); i++) {
            HSSFRow row = sheet.createRow(i + 12);
            sheet.addMergedRegion(new CellRangeAddress(i+12,i+12,0,1));
            sheet.addMergedRegion(new CellRangeAddress(i+12,i+12,7,8));
            sheet.addMergedRegion(new CellRangeAddress(i+12,i+12,9,10));
            row.createCell(0).setCellValue(exportDetails.get(i).getGoodsName());
            row.createCell(2).setCellValue(exportDetails.get(i).getGoodsNumber());
            row.createCell(3).setCellValue(exportDetails.get(i).getGoodsUnit());
            row.createCell(4).setCellValue(exportDetails.get(i).getLength());
            row.createCell(5).setCellValue(exportDetails.get(i).getWidth());
            row.createCell(6).setCellValue(exportDetails.get(i).getHeight());
            row.createCell(7).setCellValue(exportDetails.get(i).getVolume());
            row.createCell(9).setCellValue(exportDetails.get(i).getWeight());
            row.createCell(11).setCellValue(exportDetails.get(i).getGoodsTotal());
        }

        try {
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + new String("财务审核表.xls".getBytes(), "ISO-8859-1"));
            book.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //添加info 方法
    private Info resolveInfo(Long orderId) {
        Info info = new Info();
        info.setOrderId(orderId);

        Double totalVolume = 0.0;
        Double totalWeight = 0.0;
        Double totalValue =0.0;
        Double taxRate = 0.0;
        Double weightFee = 0.0;
        Double volumeFee = 0.0;
        Double taxFee = 0.0;
        Double totalFee = 0.0;

        //获取订单
        Order order = orderService.selectByPrimaryKey(orderId);

        //获得税率
        if (order.getFreightMethodId() == ConstantDataField.SEA_BASICDATA_ID){
            if (order.getIntervalId() == ConstantDataField.SINGAPORE_BASICDATA_ID || order.getIntervalId() == ConstantDataField.AUSTRALIA_BASICDATA_ID) {
                taxRate = 0.07;
            }
        }

        //获取业务
        TransactionExample transactionExample = new TransactionExample();
        transactionExample.createCriteria().andOrderIdEqualTo(orderId);
        Transaction transaction = transactionService.selectByExample(transactionExample).get(0);

        //获取订单详情
        OrderDetailExample orderDetailExample = new OrderDetailExample();
        orderDetailExample.createCriteria().andOrderIdEqualTo(orderId);
        List<OrderDetail> orderDetails = orderDetailService.selectByExample(orderDetailExample);

        //获取业务详情，同时计算出总重量、总体积、总价值
        for (OrderDetail orderDetail : orderDetails) {
            TransactionDetailExample transactionDetailExample = new TransactionDetailExample();
            transactionDetailExample.createCriteria().andOrderDetailIdEqualTo(orderDetail.getOrderDetailId());
            List<TransactionDetail> transactionDetails = transactionDetailService.selectByExample(transactionDetailExample);
            //计算
            totalValue += orderDetail.getGoodsTotal();
            for (TransactionDetail transactionDetail : transactionDetails) {
                totalVolume += transactionDetail.getVolume();
                totalWeight += transactionDetail.getWeight();
            }
        }

        //重量价格
        if (totalWeight / totalVolume < 200) {
            weightFee = totalVolume * 200 * transaction.getWeightRate();
        } else {
            weightFee = totalWeight * transaction.getWeightRate();
        }

        //体积价格
        volumeFee = totalVolume * transaction.getVolumeRate();

        taxFee = totalValue * taxRate;

        totalFee = weightFee + taxFee + volumeFee + transaction.getPickUpFee();

        info.setTaxFee(taxFee);
        info.setTaxRate(taxRate);
        info.setTotalFee(totalFee);
        info.setTotalValue(totalValue);
        info.setTotalWeight(totalWeight);
        info.setTotalVolume(totalVolume);
        info.setVolumeFee(volumeFee);
        info.setWeightFee(weightFee);
        return info;
    }
}
