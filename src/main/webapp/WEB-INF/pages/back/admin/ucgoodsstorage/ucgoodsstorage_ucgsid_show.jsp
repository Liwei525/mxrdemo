<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/ucgoodsstorage/ucgoodsstorage_ucgsid_show.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/WEB-INF/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="7"/>
			<jsp:param name="msi" value="72"/>
		</jsp:include>
		<div class="content-wrapper text-left">
					<div class="panel panel-info">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-list"></span>&nbsp;查看订单编号信息</strong>
				</div>
				<shiro:hasPermission name="ucgoodsstorage:list">
					<div class="panel-body">
						<table class="table table-striped table-bordered table-hover">
							<tr> 
								<td style="width:150px;"><strong>合同号：</strong></td>
								<td>321123321</td>
							</tr>
							<tr> 
								<td style="width:150px;"><strong>入库标题：</strong></td>
								<td>双13备货</td>
							</tr>
							<tr>
								<td><strong>存入仓库名称：</strong></td>
								<td>北京市 北京市 通州一号仓库</td>
							</tr>
							<tr>
								<td><strong>备注信息：</strong></td>
								<td>我要上</td>
							</tr>
							<tr>
								<td><strong>订单号</strong></td>
								<td>
									<table class="table table-bordered table-hover">
										<tr id="ucgsid-1" style="cursor:pointer;" title="查看入库单详情">
											<td>入库单编号</td>
											<td class="text:align">
												<div>
													<span>123123123</span>
												</div>
											</td>
										</tr>
										<tr id="ucgsid-2"  style="cursor:pointer;" title="查看入库单详情">
											<td>入库单编号</td>
											<td class="text:align">
												<div>
													<span>321321321</span>
												</div>
											</td>
										</tr>
									</table>									
								</td>
							</tr>
						</table>
					</div>
					<div class="panel-footer" style="height:100px;">
						<jsp:include page="/WEB-INF/pages/plugins/include_alert.jsp"/>
					</div>
				</shiro:hasPermission>
				<shiro:lacksPermission name="ucgoodsstorage:list">
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
<jsp:include page="/WEB-INF/pages/plugins/back/info/ucgsid_details_modal.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
