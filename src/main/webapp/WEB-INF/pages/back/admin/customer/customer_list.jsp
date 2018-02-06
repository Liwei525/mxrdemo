<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/customer/customer_list.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<%!
	public static final String CUSTOMER_EDIT_URL = "pages/back/admin/customer/edit_pre.action" ;
	public static final String CUSTOMER_REMOVE_URL = "pages/back/admin/customer/remove.action" ;
	public static final String CUSTOMER_LIST_DETAILS_URL = "pages/back/admin/customer/list_details.action" ;
%>
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
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;公司信息列表</strong>
			</div>
			<shiro:hasPermission name="customer:list">
				<div class="panel-body">
					<div>
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_search_bar_notime.jsp"/>
					</div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center" style="width:10%;">公司编号</th> 
								<th class="text-left" style="width:10%;">公司名称</th>
								<th class="text-left" style="width:10%;">重要性</th>
								<th class="text-left" style="width:20%;">联系地址</th>
								<th class="text-left" style="width:10%;">记录日期</th>
								<th class="text-center" style="width:10%;">联系人姓名</th>
								<th class="text-center" style="width:10%;">联系人电话</th>
								<th class="text-center" style="width:20%;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allCustomers }" var="customer">
								<tr>
									<td class="text-center">${customer.ctid }</td>
									<td class="text-left">${customer.name }</td>
									<td class="text-left">${allCitems[customer.ctid].title }</td>
									<td class="text-left">${customer.address }</td>
									<td class="text-left"><fmt:formatDate type="date" value="${customer.indate }"/></td>
									<td class="text-center">${customer.lname }</td>
									<td class="text-center">${customer.phone }</td> 
									<td class="text-center">
										<a type="button" class="btn btn-warning btn-xs" href="<%=CUSTOMER_EDIT_URL%>?ctid=${customer.ctid }">
													<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
										<a type="button" class="btn btn-danger btn-xs" href="<%=CUSTOMER_REMOVE_URL%>?ctid=${customer.ctid }">
													<span class="glyphicon glyphicon-remove"></span>&nbsp;删除</a>
										<a type="button" class="btn btn-primary btn-xs" href="<%=CUSTOMER_LIST_DETAILS_URL%>?ctid=${customer.ctid }">
													<span class="glyphicon glyphicon-th"></span>&nbsp;查看详情</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div id="splitBarDiv" style="float:right">
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_page_bar_notime.jsp"/> 
					</div>
				</div>
				<div class="panel-footer" style="height:100px;">
					<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
				</div>
			</shiro:hasPermission>
			<shiro:lacksPermission name="customer:list">
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
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
