<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="0"/>
			<jsp:param name="msi" value="00"/>
		</jsp:include>
		<div class="content-wrapper text-left">
			<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;错误页</strong>
				</div>
				<h3>&nbsp;&nbsp;不知道你是咋弄的，反正出错了！ 不要调皮哦，在调皮扣你工资！我有记录的哦...</h3>
			</div>
			<!-- 导入公司尾部认证信息 -->
			<jsp:include page="/WEB-INF/pages/plugins/back/include_title_foot.jsp" />
			<!-- 导入右边工具设置栏 -->
			<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_sidebar.jsp" />
			<div class="control-sidebar-bg"></div>
		</div>
	</div>
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
