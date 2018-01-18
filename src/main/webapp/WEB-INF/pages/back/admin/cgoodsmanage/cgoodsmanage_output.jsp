<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/cgoodsmanage/cgoodsmanage_output.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="16"/>
			<jsp:param name="msi" value="161"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;出库清单</strong>
			</div>
			<shiro:hasPermission name="cgoodsmanage:output">
				<div class="panel-body">
					<div>
						<table class="table table-striped table-bordered table-hover">
							<tr> 
								<td style="width:150px;"><strong>发货单号：</strong></td>
								<td>34513452345</td>
							</tr>
							<tr> 
								<td style="width:150px;"><strong>驾驶员名称：</strong></td>
								<td>小李</td>
							</tr>
							<tr> 
								<td style="width:150px;"><strong>发货日期：</strong></td>
								<td>2018-02-05</td>
							</tr>
							<tr> 
								<td><strong>计划标题：</strong></td>
								<td>样本</td>
							</tr>
							<tr> 
								<td><strong>公司名称：</strong></td>
								<td><span id="showCustomer" style="cursor:pointer;">公司1</span></td>
							</tr>
							<tr>
								<td><strong>出仓库名称：</strong></td>
								<td><span id="showWarehouse" style="cursor:pointer;">北京市 北京市 通州一号仓库</span></td>
							</tr>
							<tr>
								<td><strong>备注信息：</strong></td>
								<td>我要上</td>
							</tr>
						</table>
					</div>
					<div>
						<table class="table table-condensed" id="detailsTab">
							<thead>
								<tr>
									<th class="text-left" style="width:15%;">成品编号</th> 
									<th class="text-left" style="width:15%;">成品名称</th> 
									<th class="text-left" style="width:15%;">规格</th>
									<th class="text-left" style="width:15%;">出库数量</th>
								</tr>
							</thead>
							<tbody>
								<tr id="dettr-1" class="text-success">
									<td>100001</td>
									<td>衣服</td>
									<td>100</td>
									<td>30m*5cm</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="panel-footer" style="height:100px;">
					<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
				</div>
			</shiro:hasPermission>
			<shiro:lacksPermission name="cgoodsmanage:output">
				您没有该权限哦！
			</shiro:lacksPermission>
		</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
<jsp:include page="/WEB-INF/pages/plugins/back/info/customer_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/warehouse_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
