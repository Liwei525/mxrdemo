<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<%!
	public static final String DEPT_EDIT_URL = "pages/back/admin/dept/edit.action" ;
%>
<script type="text/javascript" src="js/pages/back/admin/dept/dept_edit.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="1"/>
			<jsp:param name="msi" value="11"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-file"></span>&nbsp;修改部门</strong>
				</div>
				<shiro:hasPermission name="dept:edit">
					<div class="panel-body">
						<form class="form-horizontal" action="<%=DEPT_EDIT_URL%>" id="myform" method="post">
							<fieldset>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="dnameDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="dname">部门名称：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="dname" name="dname" class="form-control"
											placeholder="请输入修改的部门名称" value="${dept.dname }" disabled>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="dnameMsg"></div>
								</div>
								<div class="form-group" id="maxnumDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="maxnum">最大雇员人数：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="maxnum" name="maxnum" class="form-control"
											placeholder="请输入该部门的最多雇员人数" value="${dept.maxnum }">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="maxnumMsg"></div>
								</div>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group">
									<div class="col-md-5 col-md-offset-3">
										<input type="hidden" value="${param.did }" id="did" name="did">
										<button type="submit" class="btn btn-primary">修改</button>
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
				<shiro:lacksPermission name="dept:edit">
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
