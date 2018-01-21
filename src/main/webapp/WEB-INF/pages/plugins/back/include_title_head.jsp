<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%!
	public static final String UPDATE_PASSWORD_PRE_URL = "pages/back/admin/myself/update_password_pre.action" ;
	public static final String SHOW_MYSELF = "pages/back/admin/myself/show_myself.action" ;
%>
<header class="main-header">

	<!-- Logo -->
	<a href="pages/back/index.action" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>MX</b>R</span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>Internal</b>System</span>
	</a>

	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>
		<!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			
			<ul class="nav navbar-nav">
				<li>
					<a href="<%=SHOW_MYSELF %>"><span class="hidden-xs"><span class="glyphicon glyphicon-user"></span>个人信息</span></a>
				</li>
				<li>
					<a href="<%=UPDATE_PASSWORD_PRE_URL %>"><span class="hidden-xs"><span class="glyphicon glyphicon-edit"></span>修改密码</span></a>
				</li>
				<li class="dropdown user user-menu">
				
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<img src="${loginEmp.photo }" class="user-image" alt="User Image">
						<span class="hidden-xs">${loginEmp.ename}</span>
					</a>
					<ul class="dropdown-menu"> 
						<!-- User image -->
						<li class="user-header"><img src="${loginEmp.photo }"
							class="img-circle" alt="User Image"> 
						</li>
						<!-- Menu Body -->
						<li>
							<div class="text-center">
								上次登录日期：<fmt:formatDate value="${loginEmp.lastDate}" type="both"/>
							</div>
						</li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="text-center">
								<a href="logout.page" class="btn btn-default btn-flat">系统注销</a>
							</div>
						</li>
					</ul>
				</li>
				<li>
					<a href="#" data-toggle="control-sidebar">
						<span class="hidden-xs"><i class="fa fa-gears"></i>&nbsp;</span>
					</a>
				</li>
			</ul>
		</div>

	</nav>
</header>