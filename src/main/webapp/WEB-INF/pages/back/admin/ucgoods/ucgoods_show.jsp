<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/ucgoods/ucgoods_show.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="5"/>
			<jsp:param name="msi" value="52"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-info">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;半成品信息</strong>
				</div>
				<shiro:hasPermission name="ucgoods:show">
					<c:if test="${errors == null}">
						<div class="panel-body">
							<div>
								<table class="table table-condensed" >
									<tr>
										<td style="width:20%;"><strong>半成品编号：</strong></td> 
										<td><span id="ucid">${ucgoods.ucid }</span></td>
										<td><strong>半成品图片：</strong></td>
									</tr>
									<tr>
										<td><strong>半成品名称：</strong></td>
										<td><span>${ucgoods.name }</span></td>
										<td rowspan="7"><img src="${ucgoods.photo }" style="width:220px" /></td>
									</tr>
									<tr>
										<td><strong>拼音码：</strong></td>
										<td>${ucgoods.pinyin }</td>
									</tr>
									<tr>
										<td><strong>入库次数：</strong></td>
										<td>${storageCount }</td>
									</tr>
									<tr>
										<td><strong>出库次数：</strong></td>
										<td>${outputCount }</td>
									</tr>
									<tr>
										<td><strong>半成品库存量：</strong></td>
										<td>${ucgoods.stornum }${ucgoods.unit == 1 ? "个" : "米" }（
											<button id="storage-${ucgoods.ucid }" class="btn btn-danger btn-xs">
												<span class="glyphicon glyphicon-list"></span>&nbsp;库存详情</button>）</td>
									</tr>
									<tr>
										<td><strong>当前半成品价格：</strong></td>
										<td>${ucgoods.price }（￥）</td>
									</tr>
									<tr>
										<td><strong>当前半成品规格：</strong></td>
										<td>${ucgoods.size }</td>
									</tr>
									<tr>
										<td><strong>备注信息：</strong></td>
										<td><pre class="pre-scrollable" style="width:700px;height:150px;">${ucgoods.note }</pre></td>
									</tr>
								</table>
							</div>
							<div class="panel-group" id="storageDetails">
								<div class="panel panel-info">
									<div class="panel-heading">
										<h4 class="panel-title"> 
											<a data-toggle="collapse" data-parent="news" href="#contentOne">
												<strong><span class="glyphicon glyphicon-user"></span>&nbsp;半成品入库详情：</strong>
											</a>
										</h4>
									</div>
									<div id="contentOne" class="panel-collapse collapse"> 
										<div class="panel-body">
											<table class="table table-condensed">
												<thead>
													<tr>
														<th class="text-center" style="width:10%;">入库单号</th> 
														<th class="text-left" style="width:20%;">入库仓库</th> 
														<th class="text-center" style="width:10%;">入库数量</th>
														<th class="text-center" style="width:20%;">入库日期</th> 
													</tr>
												</thead>
												<tbody id="storageTable">
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
							<div class="panel-group" id="outputDetails">
								<div class="panel panel-info">
									<div class="panel-heading">
										<h4 class="panel-title"> 
											<a data-toggle="collapse" data-parent="news" href="#contentTwo">
												<strong><span class="glyphicon glyphicon-user"></span>&nbsp;半成品出库详情：</strong>
											</a>
										</h4>
									</div>
									<div id="contentTwo" class="panel-collapse collapse"> 
										<div class="panel-body">
											<table class="table table-condensed">
												<thead>
													<tr>
														<th class="text-center" style="width:10%;">计划编号</th> 
														<th class="text-left" style="width:20%;">出库仓库</th> 
														<th class="text-center" style="width:20%;">入库车间</th> 
														<th class="text-center" style="width:10%;">出库数量</th>
														<th class="text-center" style="width:20%;">出库日期</th>
													</tr>
												</thead>
												<tbody id="outputTable">
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="panel-footer" style="height:100px;">
							<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
						</div>
					</c:if>
					<c:if test="${errors != null }">
						${errors }
					</c:if>
				</shiro:hasPermission>
				<shiro:lacksPermission name="ucgoods:show">
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
<jsp:include page="/WEB-INF/pages/plugins/back/info/plant_info_modal.jsp"/>	
<jsp:include page="/WEB-INF/pages/plugins/back/info/warehouse_info_modal.jsp"/>	
<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/goods_storage_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
