<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/product/product_list_details.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="15"/>
			<jsp:param name="msi" value="152"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;生产计划单</strong>
			</div>
			<shiro:hasPermission name="product:list">
				<div class="panel-body">
					<div>
						<table class="table table-striped table-bordered table-hover">
							<tr> 
								<td style="width:150px;"><strong>计划名称：</strong></td>
								<td>双13备货</td>
							</tr>
							<tr>
								<td><strong>出半成品库：</strong></td>
								<td id="showUCWarehouse"><span id="mid-admin" style="cursor:pointer;">半成品库1</span></td>
							</tr>
							<tr>
								<td><strong>入成品库：</strong></td>
								<td id="showWarehouse"><span id="mid-admin" style="cursor:pointer;">成品库2</span></td>
							</tr>
							<tr>
								<td><strong>生产车间：</strong></td>
								<td id="showPlant"><span id="mid-admin" style="cursor:pointer;">生产车间1</span></td>
							</tr>
							<tr>
								<td><strong>申请人：</strong></td>
								<td id="showMember"><span id="mid-admin" style="cursor:pointer;">老李</span></td>
							</tr>
							<tr>
								<td><strong>创建日期：</strong></td>
								<td>2018-01-15</td>
							</tr>
							<tr>
								<td><strong>完成日期：</strong></td>
								<td>2018-01-30</td>
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
									<th class="text-left" style="width:10%;">成品编号</th> 
									<th class="text-left" style="width:20%;">成品名称</th> 
									<th class="text-left" style="width:10%;">规格</th>
									<th class="text-left" style="width:10%;">数量</th>
								</tr>
							</thead>
							<tbody>
								<tr id="dettr-1" class="text-success">
									<td>10001</td>
									<td>钢管</td>
									<td>50m*5</td>
									<td>1000</td>
								</tr>		
							</tbody>
						</table>
					</div>
				</div>
				<div class="panel-footer" style="height:100px;">
					<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
				</div>
			</shiro:hasPermission>
			<shiro:lacksPermission name="product:list">
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
<jsp:include page="/WEB-INF/pages/plugins/back/info/plant_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
