<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/productplan/productplan_list_details.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="11"/>
			<jsp:param name="msi" value="112"/>
		</jsp:include>
		<div class="content-wrapper text-left">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;生产计划单</strong>
			</div>
			<shiro:hasPermission name="productplan:edit">
				<div class="panel-body">
					<div>
						<table class="table table-striped table-bordered table-hover">
							<tr> 
								<td style="width:150px;"><strong>计划名称：</strong></td>
								<td>双13备货</td>
							</tr>
							<tr>
								<td><strong>公司名称：</strong></td>
								<td id="showCustomer"><span id="mid-admin" style="cursor:pointer;">公司1</span></td>
							</tr>
							<tr>
								<td><strong>出半成品库：</strong></td>
								<td id="showUCWarehouse"><span id="mid-admin" style="cursor:pointer;">半成品库1</span></td>
							</tr>
							<tr>
								<td><strong>入成品库：</strong></td>
								<td id="showWarehouse"><span id="mid-admin" style="cursor:pointer;">成品库2</span></td>
							</tr>
							<tr>
								<td><strong>生产车间：</strong></td>
								<td id="showPlant"><span id="mid-admin" style="cursor:pointer;">生产车间1</span></td>
							</tr>
							<tr>
								<td><strong>申请人：</strong></td>
								<td id="showMember"><span id="mid-admin" style="cursor:pointer;">老李</span></td>
							</tr>
							<tr>
								<td><strong>创建日期：</strong></td>
								<td>2018-01-15</td>
							</tr>
							<tr>
								<td><strong>完成日期：</strong></td>
								<td>2018-01-30</td>
							</tr>
							<tr>
								<td><strong>发货单号：</strong></td>
								<td>1231243241341234</td>
							</tr>
							<tr>
								<td><strong>驾驶员姓名：</strong></td>
								<td>小李</td>
							</tr>
							<tr>
								<td><strong>发货日期：</strong></td>
								<td>2018-02-05</td>
							</tr>							
							<tr>
								<td><strong>备注信息：</strong></td>
								<td>我要上</td>
							</tr>
							<tr>
								<td><strong>入库操作：</strong></td>
								<td>
									<button id="addbut" class="btn btn-danger btn-xs">
											<span class="glyphicon glyphicon-edit"></span>&nbsp;追加成品</button>
								</td>
							</tr>
						</table>
					</div>
					<div>
						<table class="table table-condensed" id="detailsTab">
							<thead>
								<tr>
									<th class="text-left" style="width:10%;">成品编号</th> 
									<th class="text-left" style="width:20%;">成品名称</th> 
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
				<div class="panel-footer" style="height:100px;">
					<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
				</div>
			</shiro:hasPermission>
			<shiro:lacksPermission name="productplan:edit">
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
<jsp:include page="/WEB-INF/pages/plugins/back/info/customer_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/warehouse_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/plant_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
