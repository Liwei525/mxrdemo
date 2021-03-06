<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/emp/emp_list.js"></script>
<%!
	public static final String EMP_EDIT_URL = "pages/back/admin/emp/edit_pre.action" ;
	public static final String EMP_EDIT_STATE_URL = "pages/back/admin/emp/state_pre.action" ;	
	public static final String EMP_LIST_DETAILS_URL = "pages/back/admin/emp/list_details.action" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="2"/>
			<jsp:param name="msi" value="22"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;雇员信息列表</strong>
			</div>
			<div class="panel-body">
				<shiro:hasPermission name="emp:list">
					<div>
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_search_bar.jsp"/>
					</div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center">雇员编号</th>
								<th class="text-center">照片</th> 
								<th class="text-center">姓名</th>
								<th class="text-center">级别</th>
								<th class="text-center">所在部门</th>
								<th class="text-center">雇佣日期</th>
								<th class="text-center">基本工资</th>
								<th class="text-center">联系电话</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allEmps }" var="emp">
								<tr ${emp.state == 0 ? "class='text-danger'":"" }>
									<td class="text-center">${emp.eid }</td>
									<td class="text-center">
										<img src="${emp.photo }" style="width:20px;"/> 
									</td> 
									<td class="text-center">${emp.ename }</td>
									<td class="text-center">${levelTitles[emp.eid].title }</td>
									<td class="text-center">${deptNames[emp.eid].dname }</td>
									<td class="text-center"><fmt:formatDate type="date" value="${emp.hiredate }" /></td>
									<td class="text-center">${emp.salary }</td>
									<td class="text-center">${emp.phone }</td>
									<td class="text-center">
										<c:if test="${emp.lid != 0 && emp.state == 1}">
											<a type="button" class="btn btn-warning btn-xs" href="<%=EMP_EDIT_URL%>?eid=${emp.eid}">
													<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
											<a type="button" class="btn btn-danger btn-xs" href="<%=EMP_EDIT_STATE_URL%>?eid=${emp.eid}">
													<span class="glyphicon glyphicon-pencil"></span>&nbsp;离职</a>
										</c:if>
										<a type="button" class="btn btn-primary btn-xs" href="<%=EMP_LIST_DETAILS_URL%>?eid=${emp.eid}">
													<span class="glyphicon glyphicon-list"></span>&nbsp;查看详情</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div id="splitBarDiv" style="float:right">
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_page_bar.jsp"/>
					</div>
				</shiro:hasPermission>
				<shiro:lacksPermission name="emp:list">
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
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
