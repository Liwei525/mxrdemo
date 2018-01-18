<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<%!
	public static final String CUSTOMER_ADD_URL = "" ;
%>
<script type="text/javascript" src="js/pages/back/admin/customer/customer_add.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="4"/>
			<jsp:param name="msi" value="41"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-info">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;增加公司信息</strong>
				</div>
				<shiro:hasPermission name="customer:add">
					<div class="panel-body">
						<form class="form-horizontal" action="<%=CUSTOMER_ADD_URL%>" id="myform" method="post">
							<fieldset>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="cnameDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="cname">公司名称：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="cname" name="cname" class="form-control"
											placeholder="请输入公司名称">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="cnameMsg"></div>
								</div>
								<div class="form-group" id="ciidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="ciid">公司重要性：</label>
									<div class="col-md-5">
										<select id="ciid" name="ciid" class="form-control">
											<option value="">====== 请选择客户重要性 ======</option>
											<option value="1">潜在客户</option>
											<option value="2">大单客户</option>
											<option value="3">重要客户</option>
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="ciidMsg"></div>
								</div>
								<div class="form-group" id="pidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="pid">所在省份：</label>
									<div class="col-md-5">
										<select id="pid" name="pid" class="form-control">
											<option value="">====== 请选择所在省份 ======</option>
											<option value="1">河北省</option>
											<option value="2">山西部</option>
											<option value="3">广东省</option>
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
											<option value="1">石家庄</option>
											<option value="2">沧州</option>
											<option value="3">邯郸</option>
										</select>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="cidMsg"></div>
								</div>
								<div class="form-group" id="addressDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="address">公司详细地址：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="address" name="address" class="form-control"
											placeholder="请输入公司详细地址信息">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="addressMsg"></div>
								</div>
								<div class="form-group" id="accountDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="account">公司账号：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="account" name="account" class="form-control"
											placeholder="请输入公司账号">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="accountMsg"></div>
								</div>
								<div class="form-group" id="openbankDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="openbank">开户行：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="openbank" name="openbank" class="form-control"
											placeholder="请输入账号开户行">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="openbankMsg"></div>
								</div>
								<div class="form-group" id="dutyparaDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="dutypara">税号：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="dutypara" name="dutypara" class="form-control"
											placeholder="请输入公司税号">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="dutyparaMsg"></div>
								</div>
								<div class="form-group" id="faxDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="fax">传真：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="fax" name="fax" class="form-control"
											placeholder="请输入公司传真">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="faxMsg"></div>
								</div>
								<div class="form-group" id="lnameDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="tid">联系人姓名：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="lname" name="lname" class="form-control"
											placeholder="请输入联系人姓名">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="lnameMsg"></div>
								</div>
								<div class="form-group" id="phoneDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="phone">联系电话：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="phone" name="phone" class="form-control"
											placeholder="请输入联系人联系电话">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="phoneMsg"></div>
								</div>
								<div class="form-group" id="picDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="pic">公司图片：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="file" id="pic" name="pic" class="form-control"
											placeholder="请上传公司正门照片">
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
											class="form-control" placeholder="请输入公司的详细信息" rows="10"></textarea>
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
				<shiro:lacksPermission name="customer:add">
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
