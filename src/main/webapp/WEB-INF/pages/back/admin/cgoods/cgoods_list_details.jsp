<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/cgoods/cgoods_list_details.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="6"/>
			<jsp:param name="msi" value="62"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;成品信息详细</strong>
			</div>
			<shiro:hasPermission name="cgoods:edit">
				<div class="panel-body">
					<div>
						<table class="table table-striped table-bordered table-hover">
							<tr> 
								<td style="width:150px;"><strong>成品编号：</strong></td>
								<td>10001</td>
							</tr>
							<tr>
								<td><strong>成品名称：</strong></td>
								<td>123型钢管</td>
							</tr>
							<tr>
								<td><strong>单价：</strong></td>
								<td>123（￥）</td>
							</tr>
							<tr>
								<td><strong>规格：</strong></td>
								<td>50cm</td>
							</tr>
							<tr>
								<td><strong>操作：</strong></td>
								<td>
									<button id="addbut" class="btn btn-danger btn-xs">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;追加半成品
									</button>
								</td>
							</tr>
						</table>
						<div>
							<table class="table table-condensed" id="detailsTab">
								<thead>
									<tr>
										<th class="text-left" style="width:10%;">半成品编号</th> 
										<th class="text-left" style="width:20%;">半成品名称</th> 
										<th class="text-left" style="width:10%;">规格</th>
										<th class="text-left" style="width:10%;">数量</th>
										<th class="text-left" style="width:20%;">操作</th>
									</tr>
								</thead>
								<tbody>
									<tr id="dettr-1" class="text-success">
										<td><input type="text" id="gid-1" value="100001"/></td>
										<td><input type="text" id="name-1" value="衣服" size="30"/></td>
										<td><input type="text" id="weight-1" value="200g" maxlength="8" size="8"/></td>
										<td><input type="text" id="amount-1" value="50" maxlength="8" size="8"/></td>
										<td>
											<button id="save-1" class="btn btn-primary btn-xs">
												<span class="glyphicon glyphicon-edit"></span>&nbsp;保存</button>
											<button id="remove-1" class="btn btn-danger btn-xs">
												<span class="glyphicon glyphicon-edit"></span>&nbsp;移除</button>
										</td>
									</tr>		
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="panel-footer" style="height:100px;">
					<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
				</div>
			</shiro:hasPermission>
			<shiro:lacksPermission name="cgoods:edit">
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
	<jsp:include page="/WEB-INF/pages/plugins/back/info/goods_storage_modal.jsp"/>
	<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
