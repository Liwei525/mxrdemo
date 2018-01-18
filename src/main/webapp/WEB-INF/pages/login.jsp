<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%!
	public static final String LOGIN_URL = "loginForm.action" ;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>梦昕瑞金属制品有限公司内部平台</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="icon" href="images/mxr.ico" type="image/x-icon" />
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="jquery/additional-methods.min.js"></script>
<script type="text/javascript" src="jquery/Message_zh_CN.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="js/mxr.js"></script> 
<link rel="stylesheet" type="text/css" href="css/mxr.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<script type="text/javascript" src="jquery/jquery.backstretch.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<div class="top-content">
		<div class="inner-bgx">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top"> 
							<div class="form-top-left">
								<h3>梦昕瑞金属制品有限公司内部平台</h3>
							</div> 
							<div class="form-top-right">
								<i class="fa fa-lock"><img src="images/login_lock.png"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form role="form" action="<%=LOGIN_URL%>" method="post" class="form-horizontal" id="myform">
								${errors }
								<c:if test="${error == 'org.apache.shiro.authc.AuthenticationException' }">
									<font color="red">服务器异常，请联系该系统管理员！</font>
								</c:if>
								<c:if test="${error == '验证码不允许为空！' }">
									<font color="red">验证码不允许为空！</font>
								</c:if>
								<c:if test="${error == '验证码输入错误！' }">
									<font color="red">验证码输入错误！</font>
								</c:if>
								<c:if test="${error == 'org.apache.shiro.authc.UnknownAccountException' }">
									<font color="red">未知的用户名！</font>
								</c:if>
								<c:if test="${error == 'org.apache.shiro.authc.IncorrectCredentialsException' }">
									<font color="red">用户名或密码错误！</font>
								</c:if>
								<c:if test="${error == 'org.apache.shiro.authc.ExcessiveAttemptsException' }">
									<font color="red">密码尝试次数过多，请稍等再试！</font>
								</c:if>
								<font color="red" id="kickout" hidden="hidden">您已在别处登录，请重新登录！</font>
								<div class="form-group" id="eidDiv">
									<div class="col-md-12">
										<!-- 定义表单输入组件 -->
										<input type="text" id="eid" name="eid" class="form-control"
											placeholder="请输入登录帐号">
									</div>
								</div>
								<div class="form-group" id="passwordDiv">
									<div class="col-md-12">
										<!-- 定义表单输入组件 -->
										<input type="password" id="password" name="password" class="form-control"
											placeholder="请输入登录密码...">
									</div>
								</div>
								<div class="form-group" id="codeDiv">
									<div class="col-md-6">
										<!-- 定义表单输入组件 -->
										<input type="text" id="code" name="code" class="form-control"
											placeholder="验证码..." size="4" maxlength="4" style="width:410px;">
									</div> 
									<div class="col-md-1 col-md-offset-3"><img id="imageCode" src="ImageCode"></div>
									<div class="col-md-2 col-md-pull-1"> 
									</div>
								</div> 
								<button type="submit" class="btn">登录系统</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
