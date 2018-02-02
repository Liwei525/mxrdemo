<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/ucgoodsmanage/ucgoodsmanage_storage.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="9"/>
			<jsp:param name="msi" value="91"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;入库清单</strong>
			</div>
			<shiro:hasPermission name="ucgoodsmanage:storage">
				<div class="panel-body">
					<div>
						<table class="table table-striped table-bordered table-hover">
							<tr> 
								<td style="width:150px;"><strong>合同编号：</strong></td>
								<td id="usaid">${ucgoodsStorageApply.usaid }</td>
							</tr>
							<tr> 
								<td><strong>入库标题：</strong></td>
								<td>${ucgoodsStorageApply.title }</td>
							</tr>
							<tr>
								<td><strong>存入仓库名称：</strong></td>
								<td><span style="cursor:pointer;" id="storageWid-${warehouse.wid }">${warehouse.name }</span></td>
							</tr>
							<tr>
								<td><strong>仓库类型：</strong></td>
								<td>${warehouse.wiid == 1 ? "半成品库" : "成品库" }</td>
							</tr>
							<tr>
								<td><strong>备注信息：</strong></td>
								<td>${ucgoodsStorageApply.note }</td>
							</tr>
							<tr>
								<td><strong>审核信息：</strong></td>
								<td>${ucgoodsStorageApply.auditNote }</td>
							</tr>
							<tr>
								<td><strong>历史入库单号：</strong></td>
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
					<c:if test="${restUcgoods != null}">
						<div>
							<form class="form-horizontal" action="" id="myform" method="post">
								<fieldset>
									<div class="form-group" id="usawid2Div">
										<!-- 定义表单提示文字 -->
										<label class="col-md-3 control-label" for="usawid2">申请单编号：</label>
										<div class="col-md-5">
											<input type="text" id="usawid2" name="usawid2" class="form-control"
												placeholder="请输入申请单编号">
										</div>
										<!-- 定义表单错误提示显示元素 -->
										<div class="col-md-4" id="usawid2Msg"></div>
									</div>
									<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
									<div class="form-group" id="noteDiv">
										<!-- 定义表单提示文字 -->
										<label class="col-md-3 control-label" for="note">备注：</label>
										<div class="col-md-5">
											<!-- 定义表单输入组件 -->
											<textarea id="note" name="note" rows="3"
												class="form-control" placeholder="请输入备注信息" rows="10"></textarea>
										</div>
										<!-- 定义表单错误提示显示元素 -->
										<div class="col-md-4" id="noteMsg"></div>
									</div> 
									<div class="form-group">
										<div class="col-md-5 col-md-offset-3">
											<button type="submit" class="btn btn-primary">增加</button>
										</div>
									</div>
								</fieldset>
							</form>
						</div>
						<div>
							<table class="table table-condensed" id="detailsTab">
								<thead>
									<tr>
										<th class="text-left" style="width:15%;">半成品编号</th> 
										<th class="text-left" style="width:15%;">半成品名称</th> 
										<th class="text-left" style="width:15%;">入库数量</th>
										<th class="text-left" style="width:15%;">规格</th>
										<th class="text-left" style="width:15%;">实际入库数量</th>
										<th class="text-center" style="width:25%;">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${restUcgoods }" var="ucgoodsStorageApplyDetails">
										<tr id="dettr-${ucgoodsStorageApplyDetails.ucid }" class="text-success">
											<td>${ucgoodsStorageApplyDetails.ucid }</td>
											<td>${ucgoodsStorageApplyDetails.name }</td>
											<td>${ucgoodsStorageApplyDetails.num }  ${ucgoodsStorageApplyDetails.unit == 1 ? "个" : "米" }</td>
											<td>${ucgoodsStorageApplyDetails.size }</td>
											<td>
												<div class='col-md-8'>
													<input type='hidden' id='realnum-${ucgoodsStorageApplyDetails.ucid }' name='realnum-${ucgoodsStorageApplyDetails.ucid }' class='form-control input-sm'>
												</div>
												<div class='col-md-4'>
													<span id="unit" style="display: none">${ucgoodsStorageApplyDetails.unit == 1 ? "个" : "米" }</span>
												</div>
											</td>
											<td class="text-center">
												<%-- <button id="edit-${ucgoodsStorageApplyDetails.ucid }" class="btn btn-warning btn-xs" style="display: none">
													<span class="glyphicon glyphicon-edit"></span>&nbsp;修改</button> --%>
												<button id="save-${ucgoodsStorageApplyDetails.ucid }" class="btn btn-primary btn-xs" style="display: none">
													<span class="glyphicon glyphicon-save"></span>&nbsp;保存</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:if>
				</div>
				<div style="display: none" id="selectUsawid"></div>
				<div class="panel-footer" style="height:100px;">
					<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
				</div>
			</shiro:hasPermission>
			<shiro:lacksPermission name="ucgoodsmanage:storage">
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
<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
