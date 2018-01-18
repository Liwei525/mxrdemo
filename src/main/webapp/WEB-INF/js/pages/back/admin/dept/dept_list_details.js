temp_did = 1 ;
$(function(){
	$("#showMember").on("click",function(){
		$("#userInfo").modal("toggle") ;
	}) ;
	$(addbut).on("click",function(){
		// 通过ajax保存一行新的数据，而后把详情id取得，替换掉如下的id设置
		addDetails("temp" + temp_did ++) ; // 设置一个临时 id信息
	}) ;
	
	$("button[id^=remove-]").each(function(){
		$(this).on("click",function(){
			did = this.id.split("-") [1] ;
			deleteDetails(did) ;
		}) ;
	}) ;
})

function addDetails(tdid) {
	trInfo = 	$("<tr id='dettr-"+tdid+"' class='text-danger'>" +
				"	<td>" +
				"		<select id='role' class='form-control'> " +
				"			<option value='1'>【人事部】部门信息管理</option> " + 
				"			<option value='2'>【人事部】雇员信息管理</option> " +
				"			<option value='3'>【仓储部】仓库信息管理</option> " +
				"		</select>" +
				"	</td>" + 
				"	<td>" +
				"		<select id='action' class='form-control'> " +
				"			<option value='1'>部门列表</option> " + 
				"			<option value='2'>部门编辑</option> " + 
 				"			<option value='3'>部门增加</option> " +
				"		</select>" +
				"	</td>" +
				"	<td>" +
				"		<button id='save-"+tdid+"' class='btn btn-primary btn-xs'>" +
				"			<span class='glyphicon glyphicon-edit'></span>&nbsp;保存</button>" +
				"		<button id='remove-"+tdid+"' class='btn btn-danger btn-xs'>" +
				"			<span class='glyphicon glyphicon-edit'></span>&nbsp;移除</button>" +
				"	</td>" +
				"</tr>") ;
	$(detailsTab).append(trInfo) ;
	$("#save-" + tdid).on("click",function(){
		saveDetails(tdid) ;
	}) ;
	$("#remove-" + tdid).on("click",function(){
		deleteDetails(tdid) ;
	}) ;
}

function saveDetails(did) {
	console.log("【增加】详情编号：" + did) ;
	// 需要进行数据验证，而后再进行ajax提交处理，当提交成功后应该获取最后一次增长ID信息，替换掉原始的临时id
	operateAlert(true,"权限增加成功！","权限增加失败！") ;
	$("#dettr-" + did).attr("class","text-success") ;
}

function deleteDetails(did) {
	console.log("【删除】详情编号：" + did) ;
	// ajax移除信息，而后删除表格；
	$("#dettr-" + did).remove() ;
	operateAlert(true,"权限删除成功！","权限删除失败！") ;
}