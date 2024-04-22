<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 2019/7/31
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
    <title>报价入库 - 业务管理 - 物流管理系统</title>
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
    <form class="form form-horizontal" method="post" action="order/update" id="orderForm">

        <%--隐藏域，订单ID--%>
        <input type="hidden" name="orderId" value="${order.orderId}">
        <input type="hidden" name="transactionId" value="${transaction.transactionId}">

        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">订单编号：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${order.orderId}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">业务员：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${orderView.username}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">客户：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${orderView.customerName}">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">到达国家：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" value="${area}" disabled>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">收货地址：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${order.shippingAddress}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">收货人：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${order.shippingName}">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">客户电话：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${orderView.customerPhone}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">付款方式：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${payment}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">货运方式：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${shippingMethod}">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">取件方式：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${pickUpMethod}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">取件费用：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input ${allowedQuote ? '' : "readonly"} type="text" class="input-text" value="${transaction.pickUpFee}" name="pickUpFee">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">入库人：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <select name="userId" ${allowedStorage ? '' : "disabled"}>
                        <c:forEach items="${users}" var="user">
                            <option value="${user.userId}" ${user.userId eq transaction.userId ? 'selected' : ''}>${user.username}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">体积费率：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input ${allowedStorage ? '' : "readonly"} type="text" class="input-text" value="${transaction.volumeRate}" name="volumeRate">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">重量费率：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input ${allowedStorage ? '' : "readonly"} type="text" class="input-text" value="${transaction.weightRate}" name="weightRate">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">入库选择：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <select name="storageId" ${allowedStorage ? '' : "disabled"}>
                        <c:forEach items="${storages}" var="storage">
                            <option value="${storage.baseId}" ${storage.baseId eq transaction.storageId ? 'selected' : ''}>${storage.baseName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>




        <div  id="order_detail" class="row cl">
            <div>
                <div  class="col-xs-2 col-sm-3 order_detail">货物名称</div>
                <div  class="col-xs-2 col-sm-1 order_detail">数量</div>
                <div  class="col-xs-2 col-sm-1 order_detail">单位</div>
                <div  class="col-xs-2 col-sm-1 order_detail">长（mm）</div>
                <div  class="col-xs-2 col-sm-1 order_detail">宽（mm）</div>
                <div  class="col-xs-2 col-sm-1 order_detail">高（mm）</div>
                <div  class="col-xs-2 col-sm-2 order_detail">核算体积（立方）</div>
                <div  class="col-xs-2 col-sm-2 order_detail">核算重量（千克）</div>
            </div>
            <c:forEach var="i" begin="0" end="${orderDetails.size() - 1}">
                <div id="goods_detail" class="goods_detail">
                    <%--隐藏域，详情ID--%>
                    <input type="hidden" name="transactionDetails[][orderDetailId]" value="${orderDetails[i].orderDetailId}">
                    <input type="hidden" name="transactionDetails[][transactionDetailId]" value="${transactionDetails[i].transactionDetailId}">
                    <div  class="col-xs-2 col-sm-3 order_detail">
                        <input type="text" disabled value="${orderDetails[i].goodsName}">
                    </div>
                    <div  class="col-xs-2 col-sm-1 order_detail">
                        <input type="text" size="3" disabled value="${orderDetails[i].goodsNumber}">
                    </div>
                    <div  class="col-xs-2 col-sm-1 order_detail">
                        <c:forEach items="${units}" var="unit">
                            <c:if test="${unit.baseId eq orderDetails[i].goodsUnit}">
                                <input type="text" size="3" disabled value="${unit.baseName}">
                            </c:if>
                        </c:forEach>
                    </div>
                    <div  class="col-xs-2 col-sm-1 order_detail">
                        <input ${allowedStorage ? '' : "readonly"} type="text" size="3" name="transactionDetails[][length]" id="length" value="${transactionDetails[i].length}">
                    </div>
                    <div  class="col-xs-2 col-sm-1 order_detail">
                        <input ${allowedStorage ? '' : "readonly"} type="text" size="3" name="transactionDetails[][width]" id="width"  value="${transactionDetails[i].width}">
                    </div>
                    <div  class="col-xs-2 col-sm-1 order_detail">
                        <input ${allowedStorage ? '' : "readonly"} type="text" size="3" name="transactionDetails[][height]" id="height" value="${transactionDetails[i].height}">
                    </div>
                    <div  class="col-xs-2 col-sm-2 order_detail">
                        <input ${allowedQuote ? '' : "readonly"} type="text" name="transactionDetails[][volume]" id="volume" class="volume" value="${transactionDetails[i].volume}">
                    </div>
                    <div  class="col-xs-2 col-sm-2 order_detail order_add">
                        <input ${allowedQuote ? '' : "readonly"} type="text" name="transactionDetails[][weight]" value="${transactionDetails[i].weight}">
                    </div>
                </div>
            </c:forEach>
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


    //文档加载完执行
    $(function () {

        //表单验证和提交
        $('#orderForm').validate({
            submitHandler:function (form) {
                let JSONobj = $(form).serializeJSON()
                let JSONstr = JSON.stringify(JSONobj)//将JSON对象格式化成字符串
                $.ajax({
                    type:"POST",
                    url:"transaction/update",
                    contentType: "application/json; charset=utf-8",
                    data:JSONstr,
                    success:function (res) {
                        if (res == true) {
                            //弹出一个提示消息
                            layer.msg("修改成功！", {time: 1000, icon:6},function () {
                                parent.refreshTable()
                                let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                                parent.layer.close(index); //再执行关闭
                            });
                        } else {
                            //弹出一个提示消息
                            layer.msg("修改失败！请联系管理员", {time: 1000, icon:5},function () {
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


    $('.goods_detail').change(function (e) {
        culTotal(e)
    })


    //自动计算总金额方法
    function culTotal(e) {
        let length = $(e.currentTarget).children().children("#length").val()
        let width = $(e.currentTarget).children().children("#width").val()
        let height = $(e.currentTarget).children().children("#height").val()
        let realVolume = length * width * height / 1000000000
        let volume = $(e.currentTarget).children().children("#volume").val()
        if (volume < realVolume) {
            $(e.currentTarget).children().children("#volume").val(realVolume)
        }
    }


</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
