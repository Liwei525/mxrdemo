<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/warehousereplenish/warehousereplenish_list.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<%!
	public static final String WAREHOUSEREPLENISH_SUBMIT_URL = "pages/back/admin/warehousereplenish/submit.action" ;
	public static final String WAREHOUSEREPLENISH_LIST_DETAILS_URL = "pages/back/admin/warehousereplenish/list_details.action" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="14"/>
			<jsp:param name="msi" value="141"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;补货列表</strong>
			</div>
			<shiro:hasPermission name="warehousereplenish:list">
				<div class="panel-body">
					<div>
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_search_bar.jsp"/>
					</div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center" style="width:15%;">补货单号 </th> 
								<th class="text-left" style="width:15%;">补货标题</th> 
								<th class="text-left" style="width:15%;">入库仓库</th>
								<th class="text-center" style="width:10%;">申请状态</th>
								<th class="text-center" style="width:10%;">申请日期</th>
								<th class="text-center" style="width:10%;">申请人</th>
								<th class="text-left" style="width:25%;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allReplenishApply }" var="replenishApply">
								<tr>
									<td class="text-center">${replenishApply.raid }</td> 
									<td class="text-left">${replenishApply.name }</td>
									<td class="text-left"><span style="cursor:pointer;" id="storageWid-${allWarehouses[replenishApply.raid ].wid }">${allWarehouses[replenishApply.raid ].name }</span></td>
									<c:if test="${replenishApply.status == 1 }">
										<td class="text-center text-primary">待查看</td>
									</c:if>
									<c:if test="${replenishApply.status == 2 }">
										<td class="text-center text-success">已查看</td>
									</c:if>
									<td class="text-center"><fmt:formatDate type="date" value="${replenishApply.sendDate }" /></td>
									<td class="text-center"><span id="eid-${allSendMembers[replenishApply.raid].eid }" style="cursor:pointer;">${allSendMembers[replenishApply.raid].ename }</span></td>
									<td class="text-left">
										<c:if test="${replenishApply.status == 1 }">
											<a href="<%=WAREHOUSEREPLENISH_SUBMIT_URL%>?raid=${replenishApply.raid }" class="btn btn-primary btn-xs">
												<span class="fa fa-rocket"></span>&nbsp;已查看</a>
										</c:if>
										<a href="<%=WAREHOUSEREPLENISH_LIST_DETAILS_URL%>?raid=${replenishApply.raid }" class="btn btn-warning btn-xs">
											<span class="fa fa-th-list"></span>&nbsp;补货清单</a>
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
			<shiro:lacksPermission name="warehousereplenish:list">
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
<jsp:include page="/WEB-INF/pages/plugins/back/info/warehouse_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
