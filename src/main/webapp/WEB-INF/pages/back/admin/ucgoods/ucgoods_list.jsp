<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/ucgoods/ucgoods_list.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<%!
	public static final String UCGOODS_EDIT_URL = "pages/back/admin/ucgoods/edit_pre.action" ; 
	public static final String UCGOODS_SHOW_URL = "pages/back/admin/ucgoods/show.action" ; 
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="5"/>
			<jsp:param name="msi" value="52"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;半成品信息列表</strong>
			</div>
			<shiro:hasPermission name="ucgoods:list">
				<div class="panel-body">
					<div>
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_search_bar.jsp"/>
					</div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-left" style="width:10%;">半成品编号</th> 
								<th class="text-left" style="width:20%;">半成品名称</th> 
								<th class="text-center" style="width:10%;">单价（￥）</th>
								<th class="text-center" style="width:10%;">规格</th>
								<th class="text-center" style="width:10%;">最近入库日期</th>
								<th class="text-center" style="width:10%;">库存量</th>
								<th class="text-center" style="width:10%;">录入员工</th>
								<th class="text-center" style="width:20%;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allUCGoods}" var="ucgoods">
								<tr>
									<td class="text-left">${ucgoods.ucid }</td>
									<td class="text-left"><a href="<%=UCGOODS_SHOW_URL%>?ucid=${ucgoods.ucid}" title="查看半成品详情">${ucgoods.name }</a></td>
									<td class="text-center">${ucgoods.price }</td>
									<td class="text-center">${ucgoods.size }</td>
									<td class="text-center"><fmt:formatDate type="date" value="${ucgoods.lastin }" /></td>
									<td class="text-center"><span id="storage-${ucgoods.ucid }" style="cursor:pointer;">${ucgoods.stornum }${ucgoods.unit == 1 ? "个" : "米" }</span></td>
									<td class="text-center"><span id="mid-${allMembers[ucgoods.ucid].eid }" style="cursor:pointer;">${allMembers[ucgoods.ucid].ename }</span></td> 
									<td class="text-center">
										<a href="<%=UCGOODS_EDIT_URL%>?ucid=${ucgoods.ucid}" class="btn btn-primary btn-xs">
												<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
									</td>
								</tr>
							</c:forEach>
							
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
			<shiro:lacksPermission name="ucgoods:list">
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
