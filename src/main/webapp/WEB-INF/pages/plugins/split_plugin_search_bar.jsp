<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<script>
	$(function(){
		$("#startTime").datetimepicker({
			format: 'yyyy-mm-dd hh:ii:ss',
			autoclose: true,
			todayBtn: true,
	        pickerPosition: "bottom-right",
	        startDate: "2015-01-01 00:00",
	        language:  'zh-CN',
	        minView: 0,
	        todayHighlight: true
		});
		$("#endTime").datetimepicker({
			format: 'yyyy-mm-dd hh:ii:ss',
			autoclose: true,
			todayBtn: true,
	        pickerPosition: "bottom-right",
	        startDate: "2015-01-01 00:00",
	        language:  'zh-CN',
	        minView: 0,
	        todayHighlight: true
		});	
	})
</script>
<%
	request.setCharacterEncoding("UTF-8") ;
%>
<%--	// 考虑到以后的结合开发，本处使用request属性范围传递
	request.setAttribute("columnData",columnData) ;	// 属性名称
	request.setAttribute("handleUrl",dept_list_url) ;
	request.setAttribute("keyWord",keyWord) ;
	request.setAttribute("column",column) ;
--%>
<%	// columnData格式：标签名称:字段名称|标签名称:字段名称|
	String columnData = (String) request.getAttribute("columnData") ;
	String keyWord = (String) request.getAttribute("keyWord") ;
	String column = (String) request.getAttribute("column") ;
%>
<div id="searchPageDiv" class="text-center">
	<form action="${basePath2}${handleUrl}" method="post" class="form-group">
		<div>
			<div class="col-md-2">
				<input size="16" type="text" readonly class="form-control input-sm" id="startTime" name="startTime" placeholder="开始时间" value="${startTime == 'null'?'':startTime }">
			</div>
			<div class="col-md-2">
				<input size="16" type="text" readonly class="form-control input-sm" id="endTime" name="endTime" placeholder="结束时间" value="${endTime == 'null'?'':endTime}">
			</div>
		</div>
<%
	if (!(columnData == null || "".equals(columnData))) {
%>
	<div class="col-md-2">
		<select id="col" name="col" class="form-control">
	<%
		String columnResults [] = columnData.split("\\|") ;
		for (int x = 0 ; x < columnResults.length ; x ++) {
			String temp [] = columnResults[x].split(":") ;
	%>
			<option value="<%=temp[1]%>" <%=temp[1].equals(column) ? "selected" : ""%>><%=temp[0]%></option>
	<%
		}
	%>
		</select>
	</div>
<%
	}
%>
	<div class="col-md-4">
		<input type="text" id="kw" name="kw" value="<%=keyWord == null ? "" : keyWord%>" class="form-control input-sm">
	</div>
	<div class="col-md-2">
		<input type="hidden" name="${paramName}" id="${paramName}" value="${paramValue}">
		<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>&nbsp;检索</button>
	</div>
	</form>
</div>