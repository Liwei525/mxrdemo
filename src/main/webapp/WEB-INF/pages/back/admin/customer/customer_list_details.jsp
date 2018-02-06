<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/customer/customer_list_details.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="4"/>
			<jsp:param name="msi" value="42"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-user"></span>&nbsp;公司信息</strong>
			</div>
			<div class="panel-body">
				<div>
					<table class="table table-condensed" >
						<tr>
							<td style="width:20%;"><strong>公司编号：</strong></td> 
							<td><span>${customer.ctid }</span></td>
							<td><strong>公司图片：</strong></td>
						</tr>
						<tr>
							<td><strong>公司名称：</strong></td>
							<td><span>${customer.name }</span></td>
							<td rowspan="7"><img src="${customer.photo }" style="height:250px;width:250px"></td>
						</tr>
						<tr>
							<td><strong>公司重要性：</strong></td>
							<td>${citem.title }</td>
						</tr>
						<tr>
							<td><strong>地址：</strong></td>
							<td>${customer.address }</td>
						</tr>
						<tr>
							<td><strong>公司账号：</strong></td>
							<td>${customer.account }</td>
						</tr>
						<tr>
							<td><strong>开户行：</strong></td>
							<td>${customer.openBank }</td>
						</tr>
						<tr>
							<td><strong>税号：</strong></td>
							<td>${customer.dutyPara }</td>
						</tr>
						<tr>
							<td><strong>传真：</strong></td>
							<td>${customer.fax }</td>
						</tr>
						<tr>
							<td><strong>联系人姓名：</strong></td>
							<td>${customer.lname }</td>
						</tr>
						<tr>
							<td><strong>联系人电话：</strong></td>
							<td>${customer.phone }</td>
						</tr>
						<tr>
							<td><strong>录入人：</strong></td>
							<td><span id="eid-${recorder.eid }" style="cursor:pointer;">${recorder.ename }</span></td>
						</tr>
						<tr>
							<td><strong>录入日期：</strong></td>
							<td><fmt:formatDate value="${customer.indate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
						<tr>
							<td><strong>备注：</strong></td>
							<td><pre class="pre-scrollable" style="width:700px;height:150px;">${customer.note }</pre></td>
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
<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
