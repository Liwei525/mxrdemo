<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<%!
	public static final String PRODUCTPLAN_SEND_URL = "" ;
%>
<script type="text/javascript" src="js/pages/back/admin/productplan/productplan_send.js"></script>
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
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;新增发货单</strong>
				</div>
				<shiro:hasPermission name="productplan:send">
					<div class="panel-body">
						<form class="form-horizontal" action="<%=PRODUCTPLAN_SEND_URL%>" id="myform" method="post" enctype="multipart/form-data">
							<fieldset>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="sidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="sid">发货单号：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="sid" name="sid" class="form-control"
											placeholder="请输入发货单号">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="sidMsg"></div>
								</div>
								<div class="form-group" id="nameDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="name">计划名称：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="name" name="name" class="form-control"
											placeholder="请输入计划名称" disabled>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="nameMsg"></div>
								</div>
								<div class="form-group" id="cuidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="cuid">公司名称：</label>
									<div class="col-md-5">
										<select id="cuid" name="cuid" class="form-control" disabled>
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
											placeholder="请选择完成日期" disabled>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="completeDateMsg"></div>
								</div>
								<div class="form-group" id="sendDateDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="sendDate">发货日期：</label>
									<div class="col-md-5">
										<input type="text" id="sendDate" name="sendDate" class="form-control"
											placeholder="请选择发货日期">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="sendDateMsg"></div>
								</div>
								<div class="form-group" id="driverNameDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="driverName">驾驶员姓名：</label>
									<div class="col-md-5">
										<input type="text" id="driverName" name="driverName" class="form-control"
											placeholder="请输入驾驶员姓名">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="driverNameMsg"></div>
								</div>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="noteDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="note">备注信息：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<textarea id="note" name="note"
											class="form-control" placeholder="请输入发货的备注信息" rows="10"></textarea>
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
				<shiro:lacksPermission name="productplan:send">
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
