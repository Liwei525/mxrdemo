<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<%!
	public static final String INDEX_URL = "pages/back/index.action" ;

	public static final String DEPT_ADD_URL = "pages/back/admin/dept/add_pre.action" ;	
	public static final String DEPT_LIST_URL = "pages/back/admin/dept/list.action" ;

	public static final String EMP_ADD_URL = "pages/back/admin/emp/add_pre.action" ;
	public static final String EMP_LIST_URL = "pages/back/admin/emp/list.action" ;
	
	public static final String WAREHOUSE_ADD_URL = "pages/back/admin/warehouse/add_pre.action" ;	
	public static final String WAREHOUSE_LIST_URL = "pages/back/admin/warehouse/list.action" ;

	public static final String CUSTOMER_ADD_URL = "pages/back/admin/customer/add_pre.action" ;	
	public static final String CUSTOMER_LIST_URL = "pages/back/admin/customer/list.action" ;

	public static final String UCGOODS_ADD_URL = "pages/back/admin/ucgoods/add_pre.action" ;	
	public static final String UCGOODS_LIST_URL = "pages/back/admin/ucgoods/list.action" ;
	
	public static final String CGOODS_ADD_URL = "pages/back/admin/cgoods/add_pre.action" ;	
	public static final String CGOODS_LIST_URL = "pages/back/admin/cgoods/list.action" ;
	
	public static final String UCGOODSSTORAGE_ADD_URL = "pages/back/admin/ucgoodsstorage/add_pre.action" ;
	public static final String UCGOODSSTORAGE_LIST_URL = "pages/back/admin/ucgoodsstorage/list_myself.action" ;
	
	public static final String UCGOODSSTORAGE_AUDIT_LIST_URL = "pages/back/admin/ucgoodsstorageaudit/list_prepare.action" ;
	public static final String UCGOODSSTORAGE_AUDIT_HISTORY_URL = "pages/back/admin/ucgoodsstorageaudit/list_history.action" ;

	public static final String UCGOODSMANAGE_STORAGE_INPUT_URL = "pages/back/admin/ucgoodsmanage/storage_input_pre.action" ;

	public static final String PLANT_ADD_URL = "pages/back/admin/plant/add_pre.action" ;	
	public static final String PLANT_LIST_URL = "pages/back/admin/plant/list.action" ;
	
	public static final String PRODUCTPLAN_ADD_URL = "pages/back/admin/productplan/add_pre.action" ;	
	public static final String PRODUCTPLAN_LIST_URL = "pages/back/admin/productplan/list.action" ;
	
	public static final String PRODUCTPLANUCGOODS_LIST_URL = "pages/back/admin/productplanucgoods/list.action" ;
	
	public static final String REPLENISHAPPLICATION_ADD_URL = "pages/back/admin/replenishapplication/add_pre.action" ;
	public static final String REPLENISHAPPLICATION_LIST_URL = "pages/back/admin/replenishapplication/list.action" ;
	
	public static final String WAREHOUSEREPLENISH_LIST_URL = "pages/back/admin/warehousereplenish/list.action" ;
	
	public static final String PRODUCT_LIST_URL = "pages/back/admin/product/list.action" ;
	
	public static final String CGOODSMANAGE_OUTPUT_INPUT_URL = "pages/back/admin/cgoodsmanage/output_input_pre.action" ;
	
%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${emp.photo }" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>${emp.ename}</p>
			</div> 
		</div>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header"><i class="fa fa-university"></i> 内部系统平台</li>
				<shiro:hasRole name="dept">
					<li class="treeview ${param.mi==1 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
							class="fa fa-institution"></i> <span>部门管理</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
						<li class="${param.msi==11 ? 'active' : ''}"><a href="<%=DEPT_ADD_URL%>"><i class="fa fa-cube"></i>
							增加部门</a></li>
						<li class="${param.msi==12 ? 'active' : ''}"><a href="<%=DEPT_LIST_URL%>"><i class="fa fa-object-group"></i>
							部门列表</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="emp">
					<li class="treeview ${param.mi==2 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
							class="fa fa-sitemap"></i> <span>雇员管理</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
						<li class="${param.msi==21 ? 'active' : ''}"><a href="<%=EMP_ADD_URL%>"><i class="fa fa-user-plus"></i>
							增加雇员</a></li>
						<li class="${param.msi==22 ? 'active' : ''}"><a href="<%=EMP_LIST_URL%>"><i class="fa fa-users"></i>
							雇员列表</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="warehouse">
					<li class="treeview ${param.mi==3 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
							class="fa fa-institution"></i> <span>仓库管理</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==31 ? 'active' : ''}"><a href="<%=WAREHOUSE_ADD_URL%>"><i class="fa fa-cube"></i>
								增设仓库</a></li>
							<li class="${param.msi==32 ? 'active' : ''}"><a href="<%=WAREHOUSE_LIST_URL%>"><i class="fa fa-object-group"></i>
								仓库列表</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="customer">
					<li class="treeview ${param.mi==4 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
							class="fa fa-sitemap"></i> <span>客户管理</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==41 ? 'active' : ''}"><a href="<%=CUSTOMER_ADD_URL%>"><i class="fa fa-user-plus"></i>
								增加客户</a></li>
							<li class="${param.msi==42 ? 'active' : ''}"><a href="<%=CUSTOMER_LIST_URL%>"><i class="fa fa-users"></i>
								客户列表</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="ucgoods">
					<li class="treeview ${param.mi==5 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-gift"></i>
						<span>半成品信息</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==51 ? 'active' : ''}"><a href="<%=UCGOODS_ADD_URL%>"><i
								class="fa fa-gamepad"></i> 增加半成品</a></li>
							<li class="${param.msi==52 ? 'active' : ''}"><a href="<%=UCGOODS_LIST_URL%>"><i
								class="fa fa-list-alt"></i> 半成品清单</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="cgoods">
					<li class="treeview ${param.mi==6 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-gift"></i>
						<span>成品信息</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==61 ? 'active' : ''}"><a href="<%=CGOODS_ADD_URL%>"><i
								class="fa fa-gamepad"></i> 增加成品</a></li>
							<li class="${param.msi==62 ? 'active' : ''}"><a href="<%=CGOODS_LIST_URL%>"><i
								class="fa fa-list-alt"></i> 成品清单</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="ucgoodsstorage">
					<li class="treeview ${param.mi==7 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-dropbox"></i>
						<span>半成品入库</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==71 ? 'active' : ''}"><a href="<%=UCGOODSSTORAGE_ADD_URL%>"><i
								class="fa fa-train"></i> 入库申请单</a></li>
							<li class="${param.msi==72 ? 'active' : ''}"><a href="<%=UCGOODSSTORAGE_LIST_URL%>"><i
								class="fa fa-history"></i> 我的入库申请</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="ucgoodsstorageaudit">
					<li class="treeview ${param.mi==8 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-bitbucket-square"></i>
						<span>半成品入库审核</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==81 ? 'active' : ''}"><a href="<%=UCGOODSSTORAGE_AUDIT_LIST_URL%>"><i
								class="fa fa-slideshare"></i> 待审核申请</a></li>
							<li class="${param.msi==82 ? 'active' : ''}"><a href="<%=UCGOODSSTORAGE_AUDIT_HISTORY_URL%>"><i
								class="fa fa-tasks"></i> 历史入库审核</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="ucgoodsmanage">	
					<li class="treeview ${param.mi==9 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-trello"></i>
						<span>半成品仓储管理</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==91 ? 'active' : ''}"><a href="<%=UCGOODSMANAGE_STORAGE_INPUT_URL%>"><i
								class="fa fa-puzzle-piece"></i> 入库处理</a></li>
							<%-- <li class="${param.msi==92 ? 'active' : ''}"><a href="<%=MANAGE_DISTRIBUTION_INPUT_URL%>"><i
								class="fa fa-paste"></i> 出库处理</a></li> --%>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="plant">
					<li class="treeview ${param.mi==10 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
							class="fa fa-sitemap"></i> <span>车间管理</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
						<li class="${param.msi==101 ? 'active' : ''}"><a href="<%=PLANT_ADD_URL%>"><i class="fa fa-user-plus"></i>
							增加车间</a></li>
						<li class="${param.msi==102 ? 'active' : ''}"><a href="<%=PLANT_LIST_URL%>"><i class="fa fa-users"></i>
							车间列表</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="productplan">
					<li class="treeview ${param.mi==11 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-gift"></i>
						<span>生产计划管理</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==111 ? 'active' : ''}"><a href="<%=PRODUCTPLAN_ADD_URL%>"><i
								class="fa fa-gamepad"></i> 增加计划</a></li>
							<li class="${param.msi==112 ? 'active' : ''}"><a href="<%=PRODUCTPLAN_LIST_URL%>"><i
								class="fa fa-list-alt"></i> 计划列表</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="productplanucgoods">
					<li class="treeview ${param.mi==12 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-gift"></i>
						<span>生产计划原材料</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==121 ? 'active' : ''}"><a href="<%=PRODUCTPLANUCGOODS_LIST_URL%>"><i
								class="fa fa-list-alt"></i> 生产计划原材料列表</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="replenishapplication">
					<li class="treeview ${param.mi==13 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
							class="fa fa-sitemap"></i> <span>补货管理</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
						<li class="${param.msi==131 ? 'active' : ''}"><a href="<%=REPLENISHAPPLICATION_ADD_URL%>"><i class="fa fa-user-plus"></i>
							补货申请</a></li>
						<li class="${param.msi==132 ? 'active' : ''}"><a href="<%=REPLENISHAPPLICATION_LIST_URL%>"><i class="fa fa-users"></i>
							补货列表</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="warehousereplenish">
					<li class="treeview ${param.mi==14 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
							class="fa fa-sitemap"></i> <span>仓储补货管理</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
						<li class="${param.msi==141 ? 'active' : ''}"><a href="<%=WAREHOUSEREPLENISH_LIST_URL%>"><i class="fa fa-user-plus"></i>
							补货申请列表</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="product">
					<li class="treeview ${param.mi==15 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i
							class="fa fa-sitemap"></i> <span>生产计划管理</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
						<li class="${param.msi==151 ? 'active' : ''}"><a href="<%=PRODUCT_LIST_URL%>"><i class="fa fa-user-plus"></i>
							生产计划列表</a></li>
					</ul></li>
				</shiro:hasRole>
				<shiro:hasRole name="ucgoodsmanage">	
					<li class="treeview ${param.mi==16 ? 'active' : ''}"><a href="${basePath}<%=INDEX_URL%>"> <i class="fa fa-trello"></i>
						<span>成品仓储管理</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
					<ul class="treeview-menu">
							<li class="${param.msi==161 ? 'active' : ''}"><a href="<%=CGOODSMANAGE_OUTPUT_INPUT_URL%>"><i
								class="fa fa-paste"></i> 出库处理</a></li>
							<%-- <li class="${param.msi==162 ? 'active' : ''}"><a href="<%=MANAGE_DISTRIBUTION_INPUT_URL%>"><i
								class="fa fa-paste"></i> 出库处理</a></li> --%>
					</ul></li>
				</shiro:hasRole>
		</ul>
	</section>
</aside>