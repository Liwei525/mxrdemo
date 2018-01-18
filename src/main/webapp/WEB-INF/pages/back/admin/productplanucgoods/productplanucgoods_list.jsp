<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/productplanucgoods/productplanucgoods_list.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<%!
	public static final String PRODUCTPLANUCGOODS_EDIT_URL = "pages/back/admin/productplanucgoods/edit_pre.action" ; 
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="12"/>
			<jsp:param name="msi" value="121"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;生产计划原材料列表</strong>
			</div>
			<shiro:hasPermission name="productplanucgoods:list">
				<div class="panel-body">
					<div>
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_search_bar.jsp"/>
					</div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-left" style="width:10%;">计划编号</th> 
								<th class="text-left" style="width:15%;">计划名称</th> 
								<th class="text-left" style="width:15%;">公司名称</th> 
								<th class="text-center" style="width:10%;">出半成品库</th>
								<th class="text-center" style="width:10%;">生产车间</th>
								<th class="text-center" style="width:10%;">提交日期</th>
								<th class="text-center" style="width:10%;">提交人</th>
								<th class="text-left" style="width:15%;">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-left">100001</td>
								<td class="text-left">计划-1</td>
								<td class="text-left"><span id="cuid-admin" style="cursor:pointer;">公司1</span></td>
								<td class="text-center"><span id="wid-admin" style="cursor:pointer;">半成品库1</span></td>
								<td class="text-center"><span id="plantid-admin" style="cursor:pointer;">生产车间1</span></td>
								<td class="text-center">2018-10-13</td>
								<td class="text-center"><span id="mid-admin" style="cursor:pointer;">老李</span></td> 
								<td class="text-left">
									<a href="<%=PRODUCTPLANUCGOODS_EDIT_URL%>" class="btn btn-primary btn-xs">
											<span class="glyphicon glyphicon-edit"></span>&nbsp;处理申请</a>
								</td>
							</tr>
						</tbody>
					</table>
					<div id="splitBarDiv" style="float:right">
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_page_bar.jsp"/> 
					</div>
				</div>
				<div class="panel-footer" style="height:100px;">
					<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
				</div>
			</shiro:hasPermission>
			<shiro:lacksPermission name="productplanucgoods:list">
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
<jsp:include page="/WEB-INF/pages/plugins/back/info/plant_info_modal.jsp"/>	
<jsp:include page="/WEB-INF/pages/plugins/back/info/warehouse_info_modal.jsp"/>	
<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/goods_storage_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
