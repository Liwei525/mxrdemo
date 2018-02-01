<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/ucgoodsstorageaudit/ucgoodsstorageaudit_list_history.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="8"/>
			<jsp:param name="msi" value="82"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;审核历史记录</strong>
			</div>
			<shiro:hasPermission name="ucgoodsstorageaudit:list">
				<div class="panel-body">
					<div>
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_search_bar.jsp"/>
					</div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center" style="width:20%;">合同编号</th> 
								<th class="text-left" style="width:20%;">申请标题</th>  
								<th class="text-left" style="width:20%;">入库仓库</th>
								<th class="text-center" style="width:10%;">审核日期</th>
								<th class="text-center" style="width:10%;">提交人</th>
								<th class="text-center" style="width:10%;">总价（￥）</th>
								<th class="text-center" style="width:10%;">审核人员</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allUCGoodsStorageApply }" var="ucgoodsStorageApply">
								<tr>
									<td class="text-center" style="width:10%;">${ucgoodsStorageApply.usaid }</td> 
									<td class="text-left"><span id="usaid-${ucgoodsStorageApply.usaid }" style="cursor:pointer;">${ucgoodsStorageApply.title }</span></td>
									<td class="text-left"><span id="storageWid-${ucgoodsStorageApply.wid}" style="cursor:pointer;">${allUCWarehouse[ucgoodsStorageApply.usaid].name }</span></td>
									<td class="text-center"><fmt:formatDate value="${ucgoodsStorageApply.auditDate }" type="date"/></td>
									<td class="text-center"><span id="eid-${ucgoodsStorageApply.sendMid }" style="cursor:pointer;">${allSendMember[ucgoodsStorageApply.usaid].ename }</span></td>
									<td class="text-center">${allTotalPrice[ucgoodsStorageApply.usaid] }</td>
									<td class="text-center"><span id="eid-${ucgoodsStorageApply.auditMid }" style="cursor:pointer;">${allAuditMember[ucgoodsStorageApply.usaid].ename }</span></td>
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
			<shiro:lacksPermission name="ucgoodsstorageaudit:list">
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
<jsp:include page="/WEB-INF/pages/plugins/back/info/storage_details_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/warehouse_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
