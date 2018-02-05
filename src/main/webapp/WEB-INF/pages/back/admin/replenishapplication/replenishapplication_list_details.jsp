<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<link rel="stylesheet" type="text/css" href="css/tautocomplete.css" />
<script type="text/javascript" src="js/pages/back/admin/replenishapplication/replenishapplication_list_details.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="13"/>
			<jsp:param name="msi" value="132"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;补货申请单</strong>
			</div>
			<shiro:hasPermission name="replenishapplication:edit">
				<div class="panel-body">
					<div>
						<table class="table table-striped table-bordered table-hover">
							<tr> 
								<td style="width:150px;"><strong>补货单号：</strong></td>
								<td id="raid">${replenishApply.raid }</td>
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
								<td><strong>备注信息：</strong></td>
								<td>${replenishApply.note }</td>
							</tr>
							<c:if test="${replenishApply.status == 0 }">
								<tr>
									<td><strong>入库操作：</strong></td>
									<td>
										<button id="addbut" class="btn btn-danger btn-xs">
												<span class="glyphicon glyphicon-edit"></span>&nbsp;追加商品</button>
									</td>
								</tr>
							</c:if>
						</table>
					</div>
					<div>
						<table class="table table-condensed" id="detailsTab">
							<thead>
								<tr>
									<th class="text-left" style="width:20%;">半成品编号</th> 
									<th class="text-left" style="width:20%;">半成品名称</th> 
									<th class="text-left" style="width:15%;">规格</th>
									<th class="text-left" style="width:15%;">数量</th>
									<c:if test="${replenishApply.status == 0 }">
										<th class="text-left" style="width:20%;">操作</th>
									</c:if>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${allUCGoods }" var="ucgoods">
									<tr id="dettr-${ucgoods.ucid }" class="text-success">
										<td id="ucid-${ucgoods.ucid }">${ucgoods.ucid }</td>
										<td>${ucgoods.name }</td>
										<td>${ucgoods.size }</td>
										<td>${allUCGoodsAmount[ucgoods.ucid] }&nbsp;${ucgoods.unit == 1 ?"个":"米" }</td>
										<c:if test="${replenishApply.status == 0 }">
											<td>
												<button id="remove-${ucgoods.ucid }" class="btn btn-danger btn-xs">
													<span class="glyphicon glyphicon-edit"></span>&nbsp;移除</button>
											</td>
										</c:if>
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
			<shiro:lacksPermission name="replenishapplication:edit">
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
