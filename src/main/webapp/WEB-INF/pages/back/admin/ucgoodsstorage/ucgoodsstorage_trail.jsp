<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<jsp:include page="/WEB-INF/pages/plugins/back/back_header.jsp"/>
<link rel="stylesheet" href="css/ystep.css">
<script type="text/javascript" src="js/pages/back/admin/ucgoodsstorage/ucgoodsstorage_trail.js"></script>
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
				<strong><span class="glyphicon glyphicon-list"></span>&nbsp;入库订单详情</strong>
			</div>
			<shiro:hasPermission name="ucgoodsstorage:list">
				<div class="panel-body">
					<c:if test="${ucgoodsStorageApply.status == 0 }">
						<div class="stepCont stepCont1" style="overflow: hidden;">
						    <!-- 菜单导航显示-->
							<div class="ystep-container ystep-lg ystep-blue" style="left: 80px;">
						        <ul class="ystep-container-steps">
						        	<li class="ystep-step-active" id="order-app">订单创建</li>
						        	<li class="ystep-step-undone" id="order-send">订单发送</li>
						        	<li class="ystep-step-undone" id="order-audit">订单审核</li>
						        	<li class="ystep-step-undone" id="order-storage">订单入库</li>
						        </ul>
						        <div class="ystep-progress" style="width: 630px;">
						        	<p class="ystep-progress-bar" style="width: 630px;">
						        		<span class="ystep-progress-highlight" style="width: 10%;"></span>
						        	</p>
						        </div>
					    	</div>
				   			<div class="ystep-container list"  style="left: 80px;">
					      		<ul class="ystep-container-steps">
					        		<li>
					        			<div class="list list-app">
					               			申请人：${appMember.ename }<br>
											<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ucgoodsStorageApply.appDate }" />
					              		</div>
					          		</li>
					          		<li>
					              		<div class="list list-send">
					              		</div>
					          		</li>
						          	<li>
						              	<div class="list list-audit">
						              	</div>
						          	</li>
						          	<li>
						              	<div class="list list-storage">
						              	</div>
						          	</li>
						          	<li>
						              	<div class="list list-complete">
						              	</div>
						          	</li>
					        	</ul>
				      		</div>
				  		</div>
				  	</c:if>
				  	<c:if test="${ucgoodsStorageApply.status == 1 }">
						<div class="stepCont stepCont1" style="overflow: hidden;">
						    <!-- 菜单导航显示-->
							<div class="ystep-container ystep-lg ystep-blue" style="left: 80px;">
						        <ul class="ystep-container-steps">
						        	<li class="ystep-step-done" id="order-app">订单创建</li>
						        	<li class="ystep-step-active" id="order-send">订单发送</li>
						        	<li class="ystep-step-undone" id="order-audit">订单审核</li>
						        	<li class="ystep-step-undone" id="order-storage">订单入库</li>
						        </ul>
						        <div class="ystep-progress" style="width: 630px;">
						        	<p class="ystep-progress-bar" style="width: 630px;">
						        		<span class="ystep-progress-highlight" style="width: 43%;"></span>
						        	</p>
						        </div>
					    	</div>
				   			<div class="ystep-container list"  style="left: 80px;">
					      		<ul class="ystep-container-steps">
					        		<li>
					        			<div class="list list-app">
					               			申请人：${appMember.ename }<br>
					            			<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ucgoodsStorageApply.appDate }" />
					              		</div>
					          		</li>
					          		<li>
					              		<div class="list list-send">
					                		发送人：${sendMember.ename}<br>
					                		<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ucgoodsStorageApply.sendDate }" />
					              		</div>
					          		</li>
						          	<li>
						              	<div class="list list-audit">
						              	</div>
						          	</li>
						          	<li>
						              	<div class="list list-storage">
						              	</div>
						          	</li>
					        	</ul>
				      		</div>
				  		</div>
				  	</c:if>
				  	<c:if test="${ucgoodsStorageApply.status == 2 }">
						<div class="stepCont stepCont1" style="overflow: hidden;">
						    <!-- 菜单导航显示-->
							<div class="ystep-container ystep-lg ystep-blue" style="left: 80px;">
						        <ul class="ystep-container-steps">
						        	<li class="ystep-step-done" id="order-app">订单创建</li>
						        	<li class="ystep-step-done" id="order-send">订单发送</li>
						        	<li class="ystep-step-active" id="order-audit">审核未通过</li>
						        </ul>
						        <div class="ystep-progress" style="width: 420px;">
						        	<p class="ystep-progress-bar" style="width: 420px;">
						        		<span class="ystep-progress-highlight" style="width: 100%;"></span>
						        	</p>
						        </div>
					    	</div>
			   				<div class="ystep-container list"  style="left: 80px;">
					      		<ul class="ystep-container-steps">
					        		<li>
					        			<div class="list list-app">
					               			申请人：${appMember.ename }<br>
					            			<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ucgoodsStorageApply.appDate }" />
					              		</div>
					          		</li>
					          		<li>
					              		<div class="list list-send">
					                		发送人：${sendMember.ename }<br>
					                		<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ucgoodsStorageApply.sendDate }" />
					              		</div>
					          		</li>
						          	<li>
						              	<div class="list list-audit">
					                		审核人：${auditMember.ename }<br>
						               	 	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ucgoodsStorageApply.auditDate }" />
						              	</div>
						          	</li>
					        	</ul>
				      		</div>
				  		</div>
					</c:if>
				  	<c:if test="${ucgoodsStorageApply.status == 3 }">
						<div class="stepCont stepCont1" style="overflow: hidden;">
						    <!-- 菜单导航显示-->
							<div class="ystep-container ystep-lg ystep-blue" style="left: 80px;">
						        <ul class="ystep-container-steps">
						        	<li class="ystep-step-done" id="order-app">订单创建</li>
						        	<li class="ystep-step-done" id="order-send">订单发送</li>
						        	<li class="ystep-step-active" id="order-audit">订单审核</li>
						        	<li class="ystep-step-undone" id="order-storage">订单入库</li>
						        </ul>
						        <div class="ystep-progress" style="width: 630px;">
						        	<p class="ystep-progress-bar" style="width: 630px;">
						        		<span class="ystep-progress-highlight" style="width: 76%;"></span>
						        	</p>
						        </div>
					    	</div>
				   			<div class="ystep-container list"  style="left: 80px;">
					      		<ul class="ystep-container-steps">
					        		<li>
					        			<div class="list list-app">
					               			申请人：${appMember.ename }<br>
					            			<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ucgoodsStorageApply.appDate }" />
					              		</div>
					          		</li>
					          		<li>
					              		<div class="list list-send">
					                		发送人：${sendMember.ename }<br>
					                		<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ucgoodsStorageApply.sendDate }" />
					              		</div>
					          		</li>
						          	<li>
						              	<div class="list list-audit">
					                		审核人：${auditMember.ename }<br>
						               	 	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ucgoodsStorageApply.auditDate }" />
						              	</div>
						          	</li>
						          	<li>
						              	<div class="list list-storage">
						              	</div>
						          	</li>
					        	</ul>
				      		</div>
				  		</div>
				  	</c:if>
				  	<c:if test="${ucgoodsStorageApply.status == 4 }">
						<div class="stepCont stepCont1" style="overflow: hidden;">
						    <!-- 菜单导航显示-->
							<div class="ystep-container ystep-lg ystep-blue" style="left: 80px;">
						        <ul class="ystep-container-steps">
						        	<li class="ystep-step-done" id="order-app">订单创建</li>
						        	<li class="ystep-step-done" id="order-send">订单发送</li>
						        	<li class="ystep-step-done" id="order-audit">订单审核</li>
						        	<li class="ystep-step-active" id="order-storage">订单入库</li>
						        </ul>
						        <div class="ystep-progress" style="width: 630px;">
						        	<p class="ystep-progress-bar" style="width: 630px;">
						        		<span class="ystep-progress-highlight" style="width: 100%;"></span>
						        	</p>
						        </div>
					    	</div>
				   			<div class="ystep-container list"  style="left: 80px;">
					      		<ul class="ystep-container-steps">
					        		<li>
					        			<div class="list list-app">
					               			申请人：${appMember.ename }<br>
					            			<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ucgoodsStorageApply.appDate }" />
					              		</div>
					          		</li>
					          		<li>
					              		<div class="list list-send">
					                		发送人：${sendMember.ename }<br>
					                		<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ucgoodsStorageApply.sendDate }" />
					              		</div>
					          		</li>
						          	<li>
						              	<div class="list list-audit">
						              		审核人：${auditMember.ename }<br>
						               	 	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ucgoodsStorageApply.auditDate }" />
						              	</div>
						          	</li>
						          	<li>
						              	<div class="list list-storage">
						              		入库人：${storageMember.ename }<br>
						               	 	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ucgoodsStorageApply.storageDate }" />
						              	</div>
						          	</li>
					        	</ul>
				      		</div>
				  		</div>
				  	</c:if>
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
	<jsp:include page="/WEB-INF/pages/plugins/back/info/emp_info_modal.jsp"/>
	<jsp:include page="/WEB-INF/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/WEB-INF/pages/plugins/back/back_footer.jsp"/>
