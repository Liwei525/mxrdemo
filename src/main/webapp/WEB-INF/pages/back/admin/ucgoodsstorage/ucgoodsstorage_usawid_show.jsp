<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/ucgoodsstorage/ucgoodsstorage_usawid_show.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="7"/>
			<jsp:param name="msi" value="72"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-info">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-list"></span>&nbsp;查看订单编号信息</strong>
				</div>
				<shiro:hasPermission name="ucgoodsstorage:list">
					<div class="panel-body">
						<table class="table table-striped table-bordered table-hover">
							<tr> 
								<td style="width:150px;"><strong>合同号：</strong></td>
								<td>${ucgoodsStorageApply.usaid }</td>
							</tr>
							<tr> 
								<td style="width:150px;"><strong>入库标题：</strong></td>
								<td>${ucgoodsStorageApply.title }</td>
							</tr>
							<tr>
								<td><strong>存入仓库名称：</strong></td>
								<td><span style="cursor:pointer;" id="storageWid-${warehouse.wid }">${warehouse.name }</span></td>
							</tr>
							<tr>
								<td><strong>备注信息：</strong></td>
								<td>${ucgoodsStorageApply.note }</td>
							</tr>
							<tr>
								<td><strong>订单号</strong></td>
								<td>
									<table class="table table-bordered table-hover">
										<c:forEach items="${allUsawid }" var="usawid">
											<tr id="usawid-${usawid }" style="cursor:pointer;" title="查看入库单详情">
												<td>入库单编号</td>
												<td class="text:align">
													<div>
														<span>${usawid }</span>
													</div>
												</td>
											</tr>
										</c:forEach>
									</table>									
								</td>
							</tr>
						</table>
					</div>
					<div style="display: none" id="selectUsawid"></div>
					<div class="panel-footer" style="height:100px;">
						<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
					</div>
				</shiro:hasPermission>
				<shiro:lacksPermission name="ucgoodsstorage:list">
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
<jsp:include page="/WEB-INF/pages/plugins/back/info/usawid_details_modal.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
