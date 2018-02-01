<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/pages/back/admin/ucgoodsstorage/ucgoodsstorage_list.js"></script>
<script type="text/javascript" src="js/split_page.js"></script>
<%!
	public static final String UCGOODSSTORAGE_SUBMIT_URL = "pages/back/admin/ucgoodsstorage/submit.action" ;
	public static final String UCGOODSSTORAGE_EDIT_URL = "pages/back/admin/ucgoodsstorage/edit_pre.action" ;
	public static final String UCGOODSSTORAGE_LIST_DETAILS_URL = "pages/back/admin/ucgoodsstorage/list_details.action" ;
	public static final String UCGOODSSTORAGE_TRAIL_URL = "pages/back/admin/ucgoodsstorage/trail.action" ;
	public static final String UCGOODSSTORAGE_DELETE_URL = "pages/back/admin/ucgoodsstorage/remove.action" ;
	public static final String UCGOODSSTORAGE_USAWID_URL = "pages/back/admin/ucgoodsstorage/usawid_show.action" ;
%>
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
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;入库申请列表</strong>
			</div>
			<shiro:hasPermission name="ucgoodsstorage:list">
				<div class="panel-body">
					<div>
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_search_bar.jsp"/>
					</div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center" style="width:15%;">合同编号 </th> 
								<th class="text-left" style="width:10%;">申请标题</th> 
								<th class="text-left" style="width:10%;">入库仓库</th>
								<th class="text-center" style="width:6%;">申请状态</th>
								<th class="text-center" style="width:10%;">申请日期</th>
								<th class="text-center" style="width:25%;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allUCGoodsStorageApplys }" var="ucgoodsStorageApply">
								<tr>
									<c:if test="${ucgoodsStorageApply.status == 4 }">
										<td class="text-center"><a href="<%=UCGOODSSTORAGE_USAWID_URL%>?usaid=${ucgoodsStorageApply.usaid }">${ucgoodsStorageApply.usaid }</a></td>
									</c:if>
									<c:if test="${ucgoodsStorageApply.status == 0 || ucgoodsStorageApply.status == 1 || ucgoodsStorageApply.status == 2 || ucgoodsStorageApply.status == 3  }">
										<td class="text-center">${ucgoodsStorageApply.usaid }</td>
									</c:if>
									<c:if test="${ucgoodsStorageApply.status == 0 || ucgoodsStorageApply.status == 2 }">
										<td class="text-left">
											<a href="<%=UCGOODSSTORAGE_EDIT_URL%>?usaid=${ucgoodsStorageApply.usaid }">${ucgoodsStorageApply.title }</a>
										</td>
									</c:if>
									<c:if test="${ucgoodsStorageApply.status == 1 || ucgoodsStorageApply.status == 3 || ucgoodsStorageApply.status == 4}">
										<td class="text-left">${ucgoodsStorageApply.title }</td>
									</c:if>
									<td class="text-left"><span style="cursor:pointer;" id="storageWid-${allUCWarehouses[ucgoodsStorageApply.usaid].wid }">${allUCWarehouses[ucgoodsStorageApply.usaid].name }</span></td>
									<c:if test="${ucgoodsStorageApply.status == 0 }">
										<td class="text-center text-warning">待提交</td>
									</c:if>
									<c:if test="${ucgoodsStorageApply.status == 1 }">
										<td class="text-center text-primary">待审核</td>
									</c:if>
									<c:if test="${ucgoodsStorageApply.status == 2 }">
										<td class="text-center text-danger">未通过</td>
									</c:if>
									<c:if test="${ucgoodsStorageApply.status == 3 }">
										<td class="text-center text-info">待入库</td>
									</c:if>
									<c:if test="${ucgoodsStorageApply.status == 4 }">
										<td class="text-center text-success">已完成</td>
									</c:if>
									<td class="text-center"><fmt:formatDate type="date" value="${ucgoodsStorageApply.appDate }" /></td>
									<td class="text-center">
										<c:if test="${ucgoodsStorageApply.status == 0 || ucgoodsStorageApply.status == 2 }">
											<a href="<%=UCGOODSSTORAGE_SUBMIT_URL%>?usaid=${ucgoodsStorageApply.usaid }" class="btn btn-primary btn-xs">
												<span class="fa fa-rocket"></span>&nbsp;提交申请</a>
										</c:if>
										<a href="<%=UCGOODSSTORAGE_LIST_DETAILS_URL%>?usaid=${ucgoodsStorageApply.usaid }" class="btn btn-warning btn-xs">
											<span class="fa fa-th-list"></span>&nbsp;入库清单</a>
										<a href="<%=UCGOODSSTORAGE_TRAIL_URL%>?usaid=${ucgoodsStorageApply.usaid }" class="btn btn-info btn-xs">
											<span class="glyphicon glyphicon-th"></span>&nbsp;订单轨迹</a>
										<c:if test="${ucgoodsStorageApply.status == 0}">
											<a href="<%=UCGOODSSTORAGE_DELETE_URL%>?usaid=${ucgoodsStorageApply.usaid }" class="btn btn-danger btn-xs">
												<span class="glyphicon glyphicon-trash"></span>&nbsp;删除申请</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div id="splitBarDiv" style="float:right">
						<jsp:include page="/WEB-INF/pages/plugins/split_plugin_page_bar.jsp"/> 
					</div>
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
<jsp:include page="/WEB-INF/pages/plugins/back/info/warehouse_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
