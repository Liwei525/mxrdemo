<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/dept/dept_edit_role.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
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
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-edit"></span>&nbsp;修改部门角色</strong>
			</div>
			<shiro:hasPermission name="dept:list">
				<div class="panel-body">
					<div>
						<table class="table table-striped table-bordered table-hover">
							<tr> 
								<td style="width:150px;"><strong>部门编号：</strong></td>
								<td id="did">${dept.did }</td>
							</tr>
							<tr> 
								<td><strong>部门名称：</strong></td>
								<td>${dept.dname }</td>
							</tr>
							<tr> 
								<td><strong>部门人数：</strong></td>
								<td>${dept.currnum }</td>
							</tr>
							<tr> 
								<td><strong>部门最大人数：</strong></td>
								<td>${dept.maxnum }</td>
							</tr>
							<tr> 
								<td><strong>部门经理：</strong></td>
								<td><span id="eid-${dept.eid }" style="cursor:pointer;">${emp.ename }</span></td>
							</tr>
							<shiro:hasPermission name="dept:edit">
								<tr>
									<td><strong>操作：</strong></td>
									<td>
										<button id="addbut" class="btn btn-danger btn-xs">
												<span class="glyphicon glyphicon-edit"></span>&nbsp;追加角色</button>
									</td>
								</tr>
							</shiro:hasPermission>
						</table>
					</div>
					<div>
						<table class="table table-condensed" id="detailsTab">
							<thead>
								<tr>
									<th class="text-left" style="width:80%;">角色</th> 
									<th class="text-center" style="width:20%;">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${allRoles }" var="role">
									<tr id="dettr-${role.rid }" class="text-success">
										<td>
											<select class="form-control" disabled>
												<option value="${role.rid }">${role.title }</option>
											</select>
										</td>
										<td class="text-center">
											<%-- <button id="save-${role.rid }" class="btn btn-primary btn-xs">
												<span class="glyphicon glyphicon-save"></span>&nbsp;保存
											</button> --%>
											<button id="remove-${role.rid }" class="btn btn-danger btn-xs">
												<span class="glyphicon glyphicon-edit"></span>&nbsp;移除
											</button>
										</td>
									</tr>
								</c:forEach>		
							</tbody>
						</table>
					</div>
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
