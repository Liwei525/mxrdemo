<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/dept/dept_list_details.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="11"/>
			<jsp:param name="msi" value="112"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;修改部门权限</strong>
			</div>
			<shiro:hasPermission name="dept:edit">
				<div class="panel-body">
					<div>
						<table class="table table-striped table-bordered table-hover">
							<tr> 
								<td style="width:150px;"><strong>部门编号：</strong></td>
								<td>1</td>
							</tr>
							<tr> 
								<td><strong>部门名称：</strong></td>
								<td>采购部</td>
							</tr>
							<tr> 
								<td><strong>部门人数：</strong></td>
								<td>2</td>
							</tr>
							<tr> 
								<td><strong>部门最大人数：</strong></td>
								<td>10</td>
							</tr>
							<tr> 
								<td><strong>部门经理：</strong></td>
								<td id="showMember"><span id="mid-admin" style="cursor:pointer;">老李</span></td>
							</tr>
							<tr>
								<td><strong>入库操作：</strong></td>
								<td>
									<button id="addbut" class="btn btn-danger btn-xs">
											<span class="glyphicon glyphicon-edit"></span>&nbsp;追加权限</button>
								</td>
							</tr>
						</table>
					</div>
					<div>
						<table class="table table-condensed" id="detailsTab">
							<thead>
								<tr>
									<th class="text-left" style="width:10%;">角色</th> 
									<th class="text-left" style="width:20%;">权限</th> 
									<th class="text-left" style="width:20%;">操作</th>
								</tr>
							</thead>
							<tbody>
								<tr id="dettr-1" class="text-success">
									<td>
										<select id="role" class="form-control">
											<option value="1">【人事部】部门信息管理</option>
											<option value="2">【人事部】雇员信息管理</option>
											<option value="3">【仓储部】仓库信息管理</option>
										</select>
									</td>
									<td>
										<select id="action" class="form-control">
											<option value="1">部门列表</option>
											<option value="2">部门编辑</option>
											<option value="3">部门增加</option>
										</select>
									</td>
									<td>
										<button id="save-1" class="btn btn-primary btn-xs">
											<span class="glyphicon glyphicon-edit"></span>&nbsp;保存</button>
										<button id="remove-1" class="btn btn-danger btn-xs">
											<span class="glyphicon glyphicon-edit"></span>&nbsp;移除</button>
									</td>
								</tr>		
							</tbody>
						</table>
					</div>
				</div>
				<div class="panel-footer" style="height:100px;">
					<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
				</div>
			</shiro:hasPermission>
			<shiro:lacksPermission name="dept:edit">
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
