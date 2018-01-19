<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/dept/dept_list.js"></script>
<%!
	public static final String DEPT_EDIT_PRE = "pages/back/admin/dept/edit_pre.action" ;
	public static final String DEPT_EDIT_ROLE = "pages/back/admin/dept/edit_role.action" ;
	public static final String DEPT_LIST_DETAILS = "pages/back/admin/dept/list_details.action" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="1"/>
			<jsp:param name="msi" value="12"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-success">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;部门信息列表</strong>
			</div>
			<shiro:hasPermission name="dept:list">
				<div class="panel-body">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-left" style="width:10%;">部门编号</th> 
								<th class="text-left" style="width:10%;">部门名称</th> 
								<th class="text-left" style="width:10%;">名额上限</th>
								<th class="text-center" style="width:10%;">领导姓名</th>
								<th class="text-center" style="width:10%;">当前员工数</th>
								<th class="text-center" style="width:10%;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allDepts }" var="dept">
								<tr>
								<td class="text-left">${dept.did }</td>
								<td class="text-left"><a href="<%=DEPT_EDIT_PRE %>?did=${dept.did}" title="修改部门信息">${dept.dname }</a></td>
								<td class="text-left">${dept.maxnum }</td>
								<td class="text-center"><span id="eid-${dept.eid }" style="cursor:pointer;">${allEmps[dept.did].ename }</span></td> 
								<td class="text-center">
									<c:if test="${dept.maxnum == dept.currnum }">
										<span class="text-error">${dept.currnum }</span>
									</c:if>
									<c:if test="${dept.maxnum != dept.currnum }">
										<span class="text-success">${dept.currnum }</span>
									</c:if>
								</td>
								<td class="text-center">
									<a class="btn btn-warning btn-xs" href="<%=DEPT_EDIT_ROLE%>?did=${dept.did}">
											<span class="glyphicon glyphicon-edit"></span>角色管理</a>
									<a class="btn btn-primary btn-xs" href="<%=DEPT_LIST_DETAILS%>?did=${dept.did}">
											<span class="glyphicon glyphicon-list"></span>详细列表</a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="panel-footer" style="height:100px;">
					<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
				</div>
			</shiro:hasPermission>
			<shiro:lacksPermission name="dept:list">
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
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
