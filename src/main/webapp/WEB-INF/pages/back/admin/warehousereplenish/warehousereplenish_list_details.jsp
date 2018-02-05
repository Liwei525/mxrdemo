<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/warehousereplenish/warehousereplenish_list_details.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
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
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;补货申请单</strong>
			</div>
			<shiro:hasPermission name="warehousereplenish:list">
				<div class="panel-body">
					<div>
						<table class="table table-striped table-bordered table-hover">
							<tr> 
								<td style="width:150px;"><strong>补货单号：</strong></td>
								<td>${replenishApply.raid }</td>
							</tr>
							<tr> 
								<td><strong>补货标题：</strong></td>
								<td>${replenishApply.name }</td>
							</tr>
							<tr>
								<td><strong>存入仓库名称：</strong></td>
								<td><span style="cursor:pointer;" id="storageWid-${warehouse.wid }">${warehouse.name }</span></td>
							</tr>
							<tr>
								<td><strong>发送人：</strong></td>
								<td><span id="eid-${sendMember.eid }" style="cursor:pointer;">${sendMember.ename }</span></td>
							</tr>
							<tr>
								<td><strong>发送时间：</strong></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${replenishApply.sendDate }" /></td>
							</tr>
							<tr>
								<td><strong>总价：</strong></td>
								<td>${totalPrice }</td>
							</tr>
							<c:if test="${replenishApply.status == 2 }">
								<tr>
									<td><strong>查看人：</strong></td>
									<td><span id="eid-${watchMember.eid }" style="cursor:pointer;">${watchMember.ename }</span></td>
								</tr>
								<tr>
									<td><strong>查看时间：</strong></td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${replenishApply.watchDate }" /></td>
								</tr>
							</c:if>
							<tr>
								<td><strong>备注信息：</strong></td>
								<td>${replenishApply.note }</td>
							</tr>
						</table>
					</div>
					<div>
						<table class="table table-condensed" id="detailsTab">
							<thead>
									<tr>
										<th class="text-center" style="width:10%;">半成品编号</th> 
										<th class="text-left" style="width:40%;">半成品名称</th> 
										<th class="text-center" style="width:10%;">入库数量</th>
										<th class="text-center" style="width:15%;">商品单价（￥）</th>
										<th class="text-center" style="width:15%;">规格</th>
										<th class="text-center" style="width:10%;">总价（￥）</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${allReplenishApplyDetails }" var="ReplenishApplyDetails">
										<tr class="text-primary">
											<td class="text-center">${ReplenishApplyDetails.ucid }</td>
											<td class="text-left">${ReplenishApplyDetails.name }</td>
											<td class="text-center">${ReplenishApplyDetails.num }&nbsp;${ReplenishApplyDetails.unit == 1 ? "个" : "米" }</td>
											<td class="text-center">${ReplenishApplyDetails.price }</td>
											<td class="text-center">${ReplenishApplyDetails.size }</td>
											<td class="text-center">${ReplenishApplyDetails.totalPrice }</td>
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
