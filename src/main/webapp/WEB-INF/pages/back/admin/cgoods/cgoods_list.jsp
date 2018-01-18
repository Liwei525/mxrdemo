<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/cgoods/cgoods_list.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<%!
	public static final String CGOODS_EDIT_URL = "pages/back/admin/cgoods/edit_pre.action" ; 
	public static final String CGOODS_SHOW_URL = "pages/back/admin/cgoods/show.action" ; 
	public static final String CGOODS_LIST_DETAILS = "pages/back/admin/cgoods/list_details.action" ; 
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="6"/>
			<jsp:param name="msi" value="62"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;成品信息列表</strong>
			</div>
			<shiro:hasPermission name="cgoods:list">
				<div class="panel-body">
					<div>
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_search_bar.jsp"/>
					</div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-left" style="width:10%;">成品编号</th> 
								<th class="text-left" style="width:30%;">成品名称</th> 
								<th class="text-center" style="width:10%;">单价（￥）</th>
								<th class="text-center" style="width:10%;">规格</th>
								<th class="text-center" style="width:10%;">最近入库日期</th>
								<th class="text-center" style="width:10%;">库存量</th>
								<th class="text-center" style="width:10%;">录入员工</th>
								<th class="text-left" style="width:20%;">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-left"><a href="<%=CGOODS_EDIT_URL%>">100001</a></td>
								<td class="text-left"><a href="<%=CGOODS_SHOW_URL%>" title="查看成品信息详情">123型钢管</a></td>
								<td class="text-center">4456</td>
								<td class="text-center">200g</td>
								<td class="text-center">2018-10-13</td>
								<td class="text-center"><span id="storage-1" style="cursor:pointer;">3000</span></td>
								<td class="text-center"><span id="mid-admin" style="cursor:pointer;">老李</span></td> 
								<td class="text-left">
									<a href="<%=CGOODS_LIST_DETAILS%>" class="btn btn-primary btn-xs">
											<span class="glyphicon glyphicon-edit"></span>&nbsp;追加半成品</a>
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
			<shiro:lacksPermission name="cgoods:list">
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
	<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
	<jsp:include page="/WEB-INF/pages/plugins/back/info/goods_storage_modal.jsp"/>
	<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
