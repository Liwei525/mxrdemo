<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/myself/show_myself.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="0"/>
			<jsp:param name="msi" value="00"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-user"></span>&nbsp;个人信息</strong>
			</div>
			<div class="panel-body">
				<div>
					<table class="table table-condensed" >
						<tr>
							<td style="width:20%;"><strong>雇员编号：</strong></td> 
							<td><span>${emp.eid }</span></td>
							<td><strong>雇员图片：</strong></td>
						</tr>
						<tr>
							<td><strong>雇员姓名：</strong></td>
							<td><span>${emp.ename }</span></td>
							<td rowspan="7"><img src="${emp.photo }" style="height:220px;"></td>
						</tr>
						<tr>
							<td><strong>所属部门：</strong></td>
							<td>${deptName }</td>
						</tr>
						<tr>
							<td><strong>等级：</strong></td>
							<td>${levelTitle }</td>
						</tr>
						<tr>
							<td><strong>性别：</strong></td>
							<td>${emp.sex == 1?'男':'女' }</td>
						</tr>
						<tr>
							<td><strong>工种：</strong></td>
							<td>${empTypeTitle}</td>
						</tr>
						<tr>
							<td><strong>薪水：</strong></td>
							<td>${emp.salary }</td>
						</tr>
						<tr>
							<td><strong>电话号码：</strong></td>
							<td>${emp.phone }</td>
						</tr>
						<tr>
							<td><strong>雇佣日期：</strong></td>
							<td><fmt:formatDate type="date" value="${emp.hiredate }" /></td>
						</tr>
						<c:if test="${emp.state == 1 }">
							<tr>
								<td><strong>状态：</strong></td>
								<td>在职</td>
							</tr>
						</c:if>
						<c:if test="${emp.state != 1 }">
							<tr>
								<td><strong>状态：</strong></td>
								<td>离职</td>
							</tr>
							<tr>
								<td><strong>离职日期：</strong></td>
								<td><fmt:formatDate type="date" value="${emp.leaveDate }" /></td>
							</tr>
							<tr>
								<td><strong>离职备注：</strong></td>
								<td><td><pre class="pre-scrollable" style="width:700px;height:150px;">${emp.leaveNote }</pre></td></td>
							</tr>
						</c:if>
						<tr>
							<td><strong>录用备注：</strong></td>
							<td><pre class="pre-scrollable" style="width:700px;height:150px;">${emp.empnote }</pre></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="panel-footer" style="height:100px;">
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
<jsp:include page="/WEB-INF/pages/plugins/back/info/customer_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/warehouse_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/plant_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
