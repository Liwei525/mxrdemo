<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/plant/plant_list.js"></script>
<%!
	public static final String PLANT_EDIT_URL = "pages/back/admin/plant/edit_pre.action" ;
	public static final String PLANT_REMOVE_URL = "pages/back/admin/plant/remove.action" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="10"/>
			<jsp:param name="msi" value="102"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;车间信息列表</strong>
			</div>
			<div class="panel-body">
				<shiro:hasPermission name="plant:list">
					<div>
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_search_bar_notime.jsp"/>
					</div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center">车间编号</th>
								<th class="text-center">车间名称</th>
								<th class="text-center">车间地址</th>
								<th class="text-center">车间电话</th>
								<th class="text-center">录入日期</th>
								<th class="text-center">录入人</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allPlants }" var="plant">
								<tr>
									<td class="text-center">${plant.plid }</td>
									<td class="text-center">${plant.name }</td>
									<td class="text-center">${plant.address }</td>
									<td class="text-center">${plant.phone }</td>
									<td class="text-center"><fmt:formatDate value="${plant.indate }" type="date"/></td>
									<td class="text-center"><span id="eid-${plant.recorder }" style="cursor:pointer;">${allMembers[plant.plid].ename }</span></td>
									<td class="text-center">
										<a type="button" class="btn btn-warning btn-xs" href="<%=PLANT_EDIT_URL%>?plid=${plant.plid }">
												<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
										<a type="button" class="btn btn-danger btn-xs" href="<%=PLANT_REMOVE_URL%>?plid=${plant.plid }">
												<span class="glyphicon glyphicon-remove"></span>&nbsp;删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div id="splitBarDiv" style="float:right">
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_page_bar_notime.jsp"/>
					</div>
				</shiro:hasPermission>
				<shiro:lacksPermission name="plant:list">
					您没有该权限哦！
				</shiro:lacksPermission>
			</div>
			<div class="panel-footer">
				<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
			</div>
		</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
