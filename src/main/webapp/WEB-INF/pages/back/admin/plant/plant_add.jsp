<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<%!
	public static final String PLANT_ADD_URL = "pages/back/admin/plant/add.action" ;
%>
<script type="text/javascript" src="js/pages/back/admin/plant/plant_add.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="10"/>
			<jsp:param name="msi" value="101"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;增加车间</strong>
				</div>
				<shiro:hasPermission name="plant:add">
					<div class="panel-body">
						<form class="form-horizontal" action="<%=PLANT_ADD_URL%>" id="myform" method="post" enctype="multipart/form-data">
							<fieldset>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="nameDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="name">车间名称：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="name" name="name" class="form-control"
											placeholder="请输入车间名称">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="nameMsg"></div>
								</div>
								<div class="form-group" id="phoneDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="phone">车间电话：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="phone" name="phone" class="form-control"
											placeholder="请输入车间联系电话">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="phoneMsg"></div>
								</div>
								<div class="form-group" id="pidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="pid">所在省份：</label>
									<div class="col-md-5">
										<select id="pid" name="pid" class="form-control">
											<option value="">====== 请选择所在省份 ======</option>
											<c:forEach items="${allProvinces }" var="province">
												<option value="${province.pid }">${province.title}</option>
											</c:forEach>
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="pidMsg"></div>
								</div>
								<div class="form-group" id="cidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="cid">所在城市：</label>
									<div class="col-md-5">
										<select id="cid" name="cid" class="form-control">
											<option value="">====== 请选择所在城市 ======</option>
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="cidMsg"></div>
								</div>
								<div class="form-group" id="addressDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="address">车间地址：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="address" name="address" class="form-control"
											placeholder="请输入车间地址信息">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="addressMsg"></div>
								</div>
								<div class="form-group" id="picDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="pic">车间照片：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="file" id="pic" name="pic" class="form-control"
											placeholder="请选择车间照片">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="picMsg"></div>
								</div>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="noteDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="note">备注信息：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<textarea id="note" name="note"
											class="form-control" placeholder="请输入车间的备注信息" rows="10"></textarea>
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
					<div class="panel-footer">
						<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
					</div>
				</shiro:hasPermission>
				<shiro:lacksPermission name="plant:add">
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
