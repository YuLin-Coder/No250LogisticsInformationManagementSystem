<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 2019/8/1
  Time: 15:15
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
    <title>财务审核 - 业务管理 - 物流管理系统</title>
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
    <form class="form form-horizontal" method="post" id="orderForm" action="transaction/print">

        <input type="hidden" name="orderId" value="${export.orderId}">
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">订单编号：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.orderId}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">业务员：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.staff}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">客户：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.customerName}">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">到达国家：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" value="${export.area}" disabled>
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">收货地址：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.shippingAddress}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">收货人：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.shippingName}">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">联系电话：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.shippingPhone}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">付款方式：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.payment}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">货运方式：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.shippingMethod}">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">取件方式：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.pickupMehtod}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">入库人：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.storageStaff}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">入库选择：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.storage}">
                </div>
            </div>
        </div>
        <h2>费用明细</h2>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">体积收费：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.volumeFee}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">总体积：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.totalVolume}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">体积费率：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${transaction.volumeRate}">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">重量收费：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.weightFee}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">总重量：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.totalWeight}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">重量费率：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${transaction.weightRate}">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">过关税费：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.taxFee}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">总价格：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.totalValue}">
                </div>
            </div>
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">税率：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${info.taxRate}">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">取件费用：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.pickUpFee}">
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-4 col-sm-4">
                <label class="form-label col-xs-4 col-sm-4">总费用：</label>
                <div class="formControls col-xs-8 col-sm-8">
                    <input type="text" class="input-text" disabled value="${export.totalFee}">
                </div>
            </div>
        </div>




        <h2>货物清单</h2>
        <div  id="order_detail" class="row cl">
            <div>
                <div  class="col-xs-2 col-sm-2 order_detail">货物名称</div>
                <div  class="col-xs-2 col-sm-1 order_detail">数量</div>
                <div  class="col-xs-2 col-sm-1 order_detail">单位</div>
                <div  class="col-xs-2 col-sm-1 order_detail">长（mm）</div>
                <div  class="col-xs-2 col-sm-1 order_detail">宽（mm）</div>
                <div  class="col-xs-2 col-sm-1 order_detail">高（mm）</div>
                <div  class="col-xs-2 col-sm-2 order_detail">核算体积（立方）</div>
                <div  class="col-xs-2 col-sm-2 order_detail">核算重量（千克）</div>
                <div  class="col-xs-2 col-sm-1 order_detail">总价值</div>
            </div>
            <c:forEach items="${exportDetails}" var="exportDetail">
                <div id="goods_detail" class="goods_detail">
                    <div  class="col-xs-2 col-sm-2 order_detail">
                        <input type="text" disabled value="${exportDetail.goodsName}">
                    </div>
                    <div  class="col-xs-2 col-sm-1 order_detail">
                        <input type="text" size="3" disabled value="${exportDetail.goodsNumber}">
                    </div>
                    <div  class="col-xs-2 col-sm-1 order_detail">
                        <input type="text" size="3" disabled value="${exportDetail.goodsUnit}">
                    </div>
                    <div  class="col-xs-2 col-sm-1 order_detail">
                        <input type="text" size="3" disabled value="${exportDetail.length}">
                    </div>
                    <div  class="col-xs-2 col-sm-1 order_detail">
                        <input type="text" size="3" disabled value="${exportDetail.width}">
                    </div>
                    <div  class="col-xs-2 col-sm-1 order_detail">
                        <input type="text" size="3" disabled value="${exportDetail.height}">
                    </div>
                    <div  class="col-xs-2 col-sm-2 order_detail">
                        <input type="text" size="3" disabled value="${exportDetail.volume}">
                    </div>
                    <div  class="col-xs-2 col-sm-2 order_detail order_add">
                        <input type="text" size="3" disabled value="${exportDetail.weight}">
                    </div>
                    <div  class="col-xs-2 col-sm-1 order_detail order_add">
                        <input type="text" size="3" disabled value="${exportDetail.goodsTotal}">
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="row cl">
            <div class="col-xs-12 col-sm-12 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;导出&nbsp;&nbsp;">
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
                ${form}.ajaxSubmit()
            }
        })

    })




</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>

