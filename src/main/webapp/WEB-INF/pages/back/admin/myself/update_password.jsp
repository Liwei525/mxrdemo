<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<%!
	public static final String UPDATE_PASSWORD_URL = "pages/back/admin/myself/update_password.action" ;
%>
<script type="text/javascript" src="js/pages/back/admin/myself/update_password.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="0"/>
			<jsp:param name="msi" value="00"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-edit"></span>&nbsp;修改密码</strong>
				</div>
					<div class="panel-body">
					<form class="form-horizontal" action="<%=UPDATE_PASSWORD_URL%>" id="myform" method="post" enctype="multipart/form-data">
						<fieldset>
							<div class="form-group" id="oldPasswordDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="oldPassword">原始密码：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="password" id="oldPassword" name="oldPassword" class="form-control"
										placeholder="请输入原始密码">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="oldPasswordMsg"></div>
							</div>
							<div class="form-group" id="newPasswordDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="newPassword">新密码：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="password" id="newPassword" name="newPassword" class="form-control"
										placeholder="请输入新密码">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="newPasswordMsg"></div>
							</div>
							<div class="form-group" id="repeatPasswordDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="repeatPassword">确认密码：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="password" id="repeatPassword" name="repeatPassword" class="form-control"
										placeholder="请输入确认密码">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="repeatPasswordMsg"></div>
							</div>
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary">修改</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
				<div class="panel-footer">
					<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
				</div>
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
