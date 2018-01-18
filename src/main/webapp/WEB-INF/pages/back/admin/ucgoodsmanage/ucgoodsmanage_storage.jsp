<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/ucgoodsmanage/ucgoodsmanage_storage.js"></script>
<%!
	public static final String UCGSID_SAVE_URL = "" ;
%>
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
								<td>1101010</td>
							</tr>
							<tr> 
								<td><strong>入库标题：</strong></td>
								<td>双13备货</td>
							</tr>
							<tr>
								<td><strong>存入仓库名称：</strong></td>
								<td>北京市 北京市 通州一号仓库</td>
							</tr>
							<tr>
								<td><strong>仓库类型：</strong></td>
								<td>半成品库</td>
							</tr>
							<tr>
								<td><strong>备注信息：</strong></td>
								<td>我要上</td>
							</tr>
							<tr>
								<td><strong>审核信息：</strong></td>
								<td>这是审核信息</td>
							</tr>
						</table>
					</div>
					<div>
						<form class="form-horizontal" action="<%=UCGSID_SAVE_URL%>" id="myform" method="post">
							<fieldset>
								<div class="form-group" id="ucgsidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="destination">申请单编号：</label>
									<div class="col-md-5">
										<input type="text" id="ucgsid" name="ucgsid" class="form-control"
											placeholder="请输入申请单编号">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="ucgsidMsg"></div>
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
										<button type="reset" class="btn btn-warning">重置</button>
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
								<tr id="dettr-1" class="text-success">
									<td>100001</td>
									<td>衣服</td>
									<td>100</td>
									<td>30m*5cm</td>
									<td><input type="text" id="realnum-1" class="form-control input-sm" ></td>
									<td class="text-center">
										<button id="edit-1" class="btn btn-warning btn-xs">
											<span class="glyphicon glyphicon-edit"></span>&nbsp;修改</button>
										<button id="access-1" class="btn btn-primary btn-xs">
											<span class="glyphicon glyphicon-save"></span>&nbsp;保存</button>
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
	<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
	<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
