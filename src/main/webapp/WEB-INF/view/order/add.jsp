<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 2019/7/25
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%= basePath%>">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
    <link rel="stylesheet" type="text/css" href="lib/bootstrap-3.3.7/css/bootstrap.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>添加订单 - 订单管理 - 物流管理系统</title>
    <meta name="keywords" content="物流管理系统,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
    <meta name="description" content="物流管理系统，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
    <style type="text/css">
        .order_detail{
            background-color: white;
            border: 1px solid black;
            border-right: 0;
            height: 40px;
            line-height: 40px;
        }
        .order_detail input{
            height: 30px;
            text-align: center;
        }
        .order_add{
            border: 1px solid black;
        }
        #order_detail{
            text-align: center;
        }
    </style>
</head>
<body>
<article class="page-container">
    <form class="form form-horizontal" method="post" action="order/insert" id="orderForm">
        <!-- 隐藏域 ，订单状态-->
        <input type="hidden" name="orderStatus" value="0">

        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">业务员：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <select name="userId">
                        <c:forEach items="${users}" var="user">
                            <option value="${user.userId}">${user.realname}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">客户：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <select name="customerId" id="customerId">
                        <c:forEach items="${customers}" var="customer">
                            <option data-base_id="${customer.locationId}" value="${customer.customerId}">${customer.customerName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">到达地区：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <select id="area" name="intervalId">
                        <c:forEach items="${areas}" var="area">
                            <option value="${area.baseId}">${area.baseName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">收货地址：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" value="" required="required"  placeholder="" id="shippingAddress" name="shippingAddress">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">收货人：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" value="" required="required"   placeholder="" id="shippingName" name="shippingName">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">收货人电话：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" value="" required="required"  placeholder="" id="shippingPhone" name="shippingPhone">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">付款方式：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <select name="paymentMethodId">
                        <c:forEach items="${payments}" var="payment">
                            <option value="${payment.baseId}">${payment.baseName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">货运方式：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <select name="freightMethodId">
                        <c:forEach items="${transports}" var="transport">
                            <option value="${transport.baseId}">${transport.baseName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">取件方式：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <select name="takeMethodId">
                        <c:forEach items="${pickups}" var="pickup">
                            <option value="${pickup.baseId}">${pickup.baseName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">物流公司：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" value="xx物流公司"  disabled="disabled"  placeholder="" id="company" name="company">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">物流单号：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" value="243242343" disabled="disabled"   placeholder="" id="transactionId" name="transactionId">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">收件员工：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" value="张三" disabled="disabled"   placeholder="" id="pickupMan" name="pickupMan">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">取件地址：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" value="广州市天河区xxx" disabled="disabled"   placeholder="" id="pickupAddress" name="pickupAddress">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">员工电话：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" value="135xxxxx"  disabled="disabled"  placeholder="" id="pickupContact" name="pickupContact">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">实收件人：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" value=""   placeholder="" id="takeName" name="takeName">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">实收件地址：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" value=""   placeholder="" id="takeAddress" name="takeAddress">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">收件人电话：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" value=""   placeholder="" id="takePhone" name="takePhone">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">订单备注：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <textarea name="orderRemark" cols="" rows="" class="textarea"  placeholder="" ></textarea>
                </div>
            </div>
        </div>



        <div  id="order_detail" class="row cl">
            <div>
                <div  class="col-xs-2 col-sm-2 order_detail">货物名称</div>
                <div  class="col-xs-2 col-sm-1 order_detail">数量</div>
                <div  class="col-xs-2 col-sm-1 order_detail">单位</div>
                <div  class="col-xs-2 col-sm-2 order_detail">单价</div>
                <div  class="col-xs-2 col-sm-2 order_detail">总价值</div>
                <div  class="col-xs-2 col-sm-3 order_detail">备注</div>
                <div  class="col-xs-2 col-sm-1 order_detail order_add">
				<span style="cursor: pointer;color: green"
                      class="glyphicon glyphicon-plus"
                      onclick="addOrderDetail();"
                ></span>
                </div>
            </div>

            <div id="goods_detail">
                <div  class="col-xs-2 col-sm-2 order_detail">
                    <input type="text" name="orderDetails[][goodsName]">
                </div>
                <div  class="col-xs-2 col-sm-1 order_detail">
                    <input type="text" size="3" name="orderDetails[][goodsNumber]">
                </div>
                <div  class="col-xs-2 col-sm-1 order_detail">
                    <select name="orderDetails[][goodsUnit]">
                        <c:forEach items="${units}" var="unit">
                            <option value="${unit.baseId}">${unit.baseName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div  class="col-xs-2 col-sm-2 order_detail">
                    <input type="text" name="orderDetails[][goodsUnitPrice]">

                </div>
                <div  class="col-xs-2 col-sm-2 order_detail">
                    <input type="text" name="orderDetails[][goodsTotal]" readonly>
                </div>
                <div  class="col-xs-2 col-sm-3 order_detail">
                    <input type="text" name="orderDetails[][goodsRemark]">
                </div>
                <div  class="col-xs-2 col-sm-1 order_detail order_add">
                    <span style="cursor: pointer;color: red"
                          class="glyphicon glyphicon-remove"
                          onclick="removeOrderDetail(this);"
                    ></span>
                </div>
            </div>

        </div>
        <div class="row cl">
            <div class="col-xs-12 col-sm-12 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="lib/jquery.serializeJSON/jquery.serializejson.min.js"></script>
<script type="text/javascript">
    //获取订单细节栏备份
    let copy = $('#goods_detail').clone()

    //文档加载完执行
    $(function () {
        refreshAreaOption()

        //表单验证和提交
        $('#orderForm').validate({
            rules:{
                shippingAddress:"required",
                shippingName:"required",
                shippingPhone:"required",
            },
            submitHandler:function (form) {
                let JSONobj = $(form).serializeJSON()
                let JSONstr = JSON.stringify(JSONobj)//将JSON对象格式化成字符串
                $.ajax({
                    type:"POST",
                    url:"order/insert",
                    contentType: "application/json; charset=utf-8",
                    data:JSONstr,
                    success:function (res) {
                        if (res == true) {
                            //弹出一个提示消息
                            layer.msg("添加成功！", {time: 1000, icon:6},function () {
                                parent.refreshTable()
                                let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                                parent.layer.close(index); //再执行关闭
                            });
                        } else {
                            //弹出一个提示消息
                            layer.msg("添加失败！请联系管理员", {time: 1000, icon:5},function () {
                                let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                                parent.layer.close(index); //再执行关闭
                            });
                        }
                    },
                    error:function () {
                        layer.msg("修改失败，数据有误！",{time: 1000, icon:5})
                    }
                })
            }
        })

    })

    //地区选项刷新方法
    function refreshAreaOption() {
        //获取被选中选项
        let selectedCustomerOption = $('#customerId option:selected')
        //获取地区编号
        let customerAreaId = selectedCustomerOption.data("base_id")
        //获取地区选项
        let areaOption = $('#area option')
        //循环修改Option的selected属性
        for(let i = 0; i < areaOption.length; i++) {
            areaOption[i].selected = false
            if (areaOption[i].value == customerAreaId){
                areaOption[i].selected = true
            }
        }
    }

    //监听客户选项，实时修改地区选项
    $('#customerId').change(function () {
        refreshAreaOption()
    })

    //监听订单列表的输入，实时显示总金额
    $('#goods_detail').change(function (e) {
        culTotal(e)
    })


    //自动计算总金额方法
    function culTotal(e) {
        let goodsNumber = $(e.currentTarget).children().children("input[name='orderDetails[][goodsNumber]']").val()
        let goodsUnitPrice = $(e.currentTarget).children().children("input[name='orderDetails[][goodsUnitPrice]']").val()
        let total = goodsNumber * goodsUnitPrice
        $(e.currentTarget).children().children("input[name='orderDetails[][goodsTotal]']").val(total)
    }

    //添加订单方法
    function addOrderDetail() {
        //用备份克隆新的订单详情
        let newDetail = copy.clone()
        newDetail.change(function(e){
            culTotal(e)
        })
        //添加进order_detail
        $('#order_detail').append(newDetail)
    }

    //删除订单方法
    function removeOrderDetail(obj) {
        $(obj).parent().parent().remove()
    }
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
