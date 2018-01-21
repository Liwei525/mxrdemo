<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<%!
	public static final String EMP_ADD_URL = "pages/back/admin/emp/add.action" ;
%>
<script type="text/javascript" src="js/pages/back/admin/emp/emp_add.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="2"/>
			<jsp:param name="msi" value="21"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;雇员入职</strong>
				</div>
				<shiro:hasPermission name="emp:add">
					<div class="panel-body">
						<form class="form-horizontal" action="<%=EMP_ADD_URL%>" id="myform" method="post" enctype="multipart/form-data">
							<fieldset>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="eidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="eid">雇员编号：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="eid" name="eid" class="form-control"
											placeholder="请输入雇员编号">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="eidMsg"></div>
								</div>
								<div class="form-group" id="enameDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="ename">雇员姓名：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="ename" name="ename" class="form-control"
											placeholder="请输入雇员真实姓名">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="enameMsg"></div>
								</div>
								<div class="form-group" id="sexDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="sex">雇员性别：</label>
									<div class="col-md-5">
										<select id="sex" name="sex" class="form-control">
											<option value="">====== 请选择雇员性别 ======</option>
											<option value="1">男</option>
											<option value="2">女</option>
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="sexMsg"></div>
								</div>
								<div class="form-group" id="phoneDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="phone">联系电话：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="phone" name="phone" class="form-control"
											placeholder="请输入雇员联系电话">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="phoneMsg"></div>
								</div>
								<div class="form-group" id="didDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="did">所属部门：</label>
									<div class="col-md-5">
										<select id="did" name="did" class="form-control">
											<option value="">====== 请选择所在部门 ======</option>
											<c:forEach items="${allDepts }" var="dept">
												<option value="${dept.did }">${dept.dname}</option>
											</c:forEach>
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="didMsg"></div>
								</div>
								<div class="form-group" id="lidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="lid">雇员职位：</label>
									<div class="col-md-5">
										<select id="lid" name="lid" class="form-control">
											<option value="">====== 请选择雇员职位 ======</option>
											<c:forEach items="${allLevelsNoMaster }" var="level">
												<option value="${level.lid }">${level.title}</option>
											</c:forEach>
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="lidMsg"></div>
								</div>
								<div class="form-group" id="etidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="etid">雇员种类：</label>
									<div class="col-md-5">
										<select id="etid" name="etid" class="form-control">
											<option value="">====== 请选择雇员种类 ======</option>
											<c:forEach items="${allEmpTypes }" var="empType">
												<option value="${empType.etid }">${empType.title}</option>
											</c:forEach>
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="etidMsg"></div>
								</div>
								<div class="form-group" id="salaryDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="salary">基本工资：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="salary" name="salary" class="form-control"
											placeholder="请输入雇员基本工资">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="salaryMsg"></div>
								</div>
								<div class="form-group" id="picDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="pic">雇员照片：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="file" id="pic" name="pic" class="form-control"
											placeholder="请选择雇员照片">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="picMsg"></div>
								</div>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="empnoteDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="empnote">备注信息：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<textarea id="empnote" name="empnote"
											class="form-control" placeholder="请输入雇员的面试情况" rows="10"></textarea>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="empnoteMsg"></div>
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
				<shiro:lacksPermission name="emp:add">
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
