<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<link rel="stylesheet" type="text/css" href="css/tautocomplete.css" />
<%!
	public static final String UCGOODSSTORAGE_INPUT_URL = "pages/back/admin/ucgoodsmanage/storage_input.action" ;
%>
<script type="text/javascript" src="js/pages/back/admin/ucgoodsmanage/ucgoodsmanage_storage_input.js"></script>
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
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;半成品入库</strong>
				</div>
				<shiro:hasPermission name="ucgoodsmanage:storage">
					<div class="panel-body">
						<form class="form-horizontal" action="<%=UCGOODSSTORAGE_INPUT_URL%>" id="myform" method="post">
							<fieldset>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="usaidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="usaid">合同编号：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="usaid" name="usaid" class="form-control"
											placeholder="请输入合同编号" readOnly>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="usaidMsg"></div>
								</div><div>&nbsp;</div>
								<div class="form-group" id="searchDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="search">搜索框：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="search" name="search" class="form-control">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="searchMsg"></div>
								</div><div>&nbsp;</div>
								<div class="form-group">
									<div class="col-md-5 col-md-offset-3">
										<button type="submit" class="btn btn-primary">查询</button>
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
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
