<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<%!
	public static final String CUSTOMER_ADD_URL = "pages/back/admin/customer/edit.action" ;
%>
<script type="text/javascript" src="js/pages/back/admin/customer/customer_edit.js"></script>
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
					<strong><span class="glyphicon glyphicon-user"></span>&nbsp;修改公司信息</strong>
				</div>
				<shiro:hasPermission name="customer:edit">
					<div class="panel-body">
						<form class="form-horizontal" action="<%=CUSTOMER_ADD_URL%>" id="myform" method="post" enctype="multipart/form-data">
							<fieldset>
								<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
								<div class="form-group" id="nameDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="name">公司名称：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="name" name="name" class="form-control"
											placeholder="请输入公司名称" value="${customer.name }">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="nameMsg"></div>
								</div>
								<div class="form-group" id="ciidDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="ciid">公司重要性：</label>
									<div class="col-md-5">
										<select id="ciid" name="ciid" class="form-control">
											<option value="">====== 请选择客户重要性 ======</option>
											<c:forEach items="${allCitems }" var="citem">
												<option value="${citem.ciid }" ${customer.ciid == citem.ciid ? "selected" : "" }>${citem.title }</option>
											</c:forEach>
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
											<c:forEach items="${allProvinces }" var="province">
												<option value="${province.pid }" ${customer.pid == province.pid ? "selected" : "" }>${province.title }</option>
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
											<c:forEach items="${allCitys }" var="city">
												<option value="${city.cid }" ${customer.cid == city.cid ? "selected" : "" }>${city.title }</option>
											</c:forEach>
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
											placeholder="请输入公司详细地址信息" value="${customer.address }">
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
											placeholder="请输入公司账号" value="${customer.account }">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="accountMsg"></div>
								</div>
								<div class="form-group" id="openBankDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="openBank">开户行：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="openBank" name="openBank" class="form-control"
											placeholder="请输入账号开户行" value="${customer.openBank }">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="openBankMsg"></div>
								</div>
								<div class="form-group" id="dutyParaDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="dutyPara">税号：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="dutyPara" name="dutyPara" class="form-control"
											placeholder="请输入公司税号" value="${customer.dutyPara }">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="dutyParaMsg"></div>
								</div>
								<div class="form-group" id="faxDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="fax">传真：</label>
									<div class="col-md-5">
										<!-- 定义表单输入组件 -->
										<input type="text" id="fax" name="fax" class="form-control"
											placeholder="请输入公司传真" value="${customer.fax }">
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
											placeholder="请输入联系人姓名" value="${customer.lname }">
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
											placeholder="请输入联系人联系电话" value="${customer.phone }">
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="phoneMsg"></div>
								</div>
								<div class="form-group" id="picDiv">
									<!-- 定义表单提示文字 -->
									<label class="col-md-3 control-label" for="pic">公司图片：</label>
									<div class="col-md-5">
										<img src="${customer.photo }" style="width:200px;"/>
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
											class="form-control" placeholder="请输入公司的详细信息" rows="10">${customer.note }</textarea>
									</div>
									<!-- 定义表单错误提示显示元素 -->
									<div class="col-md-4" id="noteMsg"></div>
								</div> 
								<div class="form-group">
									<div class="col-md-5 col-md-offset-3">
										<input type="hidden" id="photo" name="photo" value="${customer.photo }">
										<input type="hidden" id="ctid" name="ctid" value="${customer.ctid }">
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
				<shiro:lacksPermission name="customer:edit">
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
