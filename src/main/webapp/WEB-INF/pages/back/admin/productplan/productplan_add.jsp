<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<%!
	public static final String PRODUCTPLAN_ADD_URL = "" ;
%>
<script type="text/javascript" src="js/pages/back/admin/productplan/productplan_add.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="11"/>
			<jsp:param name="msi" value="111"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-info">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;增加生产计划</strong>
				</div>
				<shiro:hasPermission name="productplan:add">
					<div class="panel-body">
						<form class="form-horizontal" action="<%=PRODUCTPLAN_ADD_URL%>" id="myform" method="post" enctype="multipart/form-data">
							<fieldset>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="nameDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="name">计划名称：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="name" name="name" class="form-control"
											placeholder="请输入计划名称">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="nameMsg"></div>
								</div>
								<div class="form-group" id="cuidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="cuid">公司名称：</label>
									<div class="col-md-5">
										<select id="cuid" name="cuid" class="form-control">
											<option value="">====== 请选择公司名称 ======</option>
											<option value="1">公司1</option>
											<option value="2">公司2</option>
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="cuidMsg"></div>
								</div>
								<div class="form-group" id="completeDateDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="completeDate">完成日期：</label>
									<div class="col-md-5">
										<input type="text" id="completeDate" name="completeDate" class="form-control"
											placeholder="请选择完成日期">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="completeDateMsg"></div>
								</div>
								<div class="form-group" id="ucidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="ucid">出半成品库：</label>
									<div class="col-md-5">
										<select id="ucid" name="ucid" class="form-control">
											<option value="">====== 请选择所出半成品库 ======</option>
											<option value="1">半成品库1</option>
											<option value="2">半成品库2</option>
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="ucidMsg"></div>
								</div>
								<div class="form-group" id="cidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="cid">入成品库：</label>
									<div class="col-md-5">
										<select id="cid" name="cid" class="form-control">
											<option value="">====== 请选择所入成品库 ======</option>
											<option value="1">成品库1</option>
											<option value="2">成品库2</option>
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="cidMsg"></div>
								</div>
								<div class="form-group" id="plantidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="plantid">生产车间：</label>
									<div class="col-md-5">
										<select id="plantid" name="plantid" class="form-control">
											<option value="">====== 请选择生产车间 ======</option>
											<option value="1">相城车间1</option>
											<option value="2">相城车间2</option>
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="plantidMsg"></div>
								</div>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="noteDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="note">备注信息：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<textarea id="note" name="note"
											class="form-control" placeholder="请输入计划的备注信息" rows="10"></textarea>
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
					<div class="panel-footer" style="height:100px;">
						<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
					</div>
				</shiro:hasPermission>
				<shiro:lacksPermission name="productplan:add">
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
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
