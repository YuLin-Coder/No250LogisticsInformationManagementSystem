<%--
  Created by IntelliJ IDEA.
  User: carlo
  Date: 2019/7/31
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%-- 基本路径
协议+主机+端口+上下文路径 +/
http://localhost:8080/log/
在html中使用 <base href="<%=basePath%>">
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="Bookmark" href="/favicon.ico" >
    <link rel="Shortcut Icon" href="/favicon.ico" />
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
    <link rel="stylesheet" type="text/css" href="lib/bootstrap-table/bootstrap-table.min.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>权限列表</title>
</head>
<body>
<nav class="breadcrumb" style="padding: 0 20px;">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 订单管理
    <span class="c-gray en">&gt;</span> 订单列表
</nav>
<div class="page-container">
    <%--用 boostrap 生成--%>
    <table id="orderTable"></table>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<%--<script type="text/javascript" src="lib/bootstrap-3.3.7/js/bootstrap.js"></script>--%>
<script type="text/javascript" src="lib/bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="lib/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript">
    $('#orderTable').bootstrapTable({
        pagination: true,
        sidePagination: "server",//是否是服务器分页，每次请求都是对应的10条数据，下一页发送ajax请求
        search: true,
        // toolbar: "#toolbar",//顶部显示的工具条（添加和批量删除的）
        pageSize: 10,//默认的每页条数
        contentType: 'application/x-www-form-urlencoded',//条件搜索的时候ajax请求给后台数据的数据类型（条件搜索post提交必须设置）
        pageNumber: 1,//默认的页面 第一页
        pageList:[10,25,50,100],//每页能显示的条数
        paginationHAlign: 'right', //底部分页条
        showToggle: true, //是否显示详细视图和列表视图的切换按钮
        cardView: false, //是否显示详细视图
        showRefresh: true, //是否显示刷新按钮
        smartDisplay:false,
        showColumns:true,
        url:"transaction/getOrders", //从 url 获取 json 数据
        /*
			ajax请求以后回调函数的处理
			后台使用返回的PageInfo对象中的 结果 级的key是list，总条数是total
			而前台bootstrapTable插件需要的数据的key叫做rows ，总条数也是叫做total
			那么出现一个问题 : 总条数的key能对上，结果集对不上，就需要在ajax请求完成回调
			responseHandler 这个函数方法处理一下
			并且在自定义一个 json,rows做为key，返回json的 list作为值
				total：还是total
			这样才能满足 bootstrapTable插件数据的需要
		*/
        responseHandler: function(res) {
            /*
                rows: 对应的是表的结果集
                total: 是 pagination 分页信息显示所需要的总记录数，
                       设置 sidePagination: "server" 这个属性后才需要，
                       不设置个属性的话，总记录数就是当前页面的记录数
             */
            var data = {
                rows : res.list,
                total: res.total,
            }
            return data
        },
        columns: [ //表格显示数据对应的表头设置，
            // { checkbox: true},//是否显示前台的复选框（多选）
            /*
                每列数据的表头的设置
                filed:返回json数据对应数据的key
                title:表头要显示的名
            */
            {field: 'orderId',title: '订单编号'},
            {field: 'customerId',title: '客户编号'},
            {field: 'customerName',title: '客户姓名'},
            {field: 'customerPhone',title: '客户电话'},
            {field: 'shippingName',title: '收件人姓名'},
            {field: 'shippingAddress',title: '收件人地址'},
            {field: 'shippingPhone',title: '收件人电话'},
            {field: 'orderStatus',title: '订单状态',formatter:statusFormatter},
                <shiro:hasPermission name="order:update">{field: 'username',title: '业务员账号'},</shiro:hasPermission>
            /*
                操作列的设置（删除，修改）
                formatter: 格式化这一行，回调一个函数
            */
            {
                field:'orderId',
                title:'操作',
                align:'center',
                formatter:operationFormatter
            }
        ],
        /*发送请求的参数，
			params: bootstrapTable的插件内部参数对象包含如下参数
			limit, offset, search, sort
			limit：每页条数
			offset：每页的结束位置
			search:搜索框对应的值
			sort：排序
		*/
        queryParams: function(params) {
            //此方法在用户分页或者搜索的时候回自动发送ajax请求调用，并把对应的参数传递给后台
            return{
                pageSize: params.limit,
                keyWord: params.search,
                pageNum: params.offset / params.limit + 1,
            }
        },
    })

    /*
        操作行格式化对应的函数
        value: 当前列的值
        row：当前行的值(json对应的具体某一行)
        index：索引位置
    */
    function operationFormatter(value) {
        var html ="<shiro:hasPermission name='transaction:deal'><span onclick='transaction_deal("+value+")' style='cursor: pointer;' class='glyphicon glyphicon-log-in'></span></shiro:hasPermission>&nbsp;&nbsp";
        html+="<shiro:hasPermission name='transaction:export'><span onclick='transaction_export("+value+")'  style='cursor: pointer;color:red' class='glyphicon glyphicon-yen'></span></shiro:hasPermission>";
        return html;
    }

    function statusFormatter(value) {
        if (value == 0) {
            return '已取件'
        } else if (value == 1) {
            return '已入库'
        } else if (value == 2) {
            return '已完成'
        } else {
            return '未知状态'
        }
    }

    //刷新表格
    function refreshTable() {
        $('#orderTable').bootstrapTable('refresh');
    }



    function transaction_deal(orderId){
        layer_show("报价入库","transaction/deal?orderId="+orderId,1200,700);
    }

    function transaction_export(orderId){
        layer_show("财务审核","transaction/export?orderId="+orderId,1200,700);
    }

</script>
</body>
</html>