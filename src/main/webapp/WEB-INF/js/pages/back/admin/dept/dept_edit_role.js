temp_did = 1 ;
flag = true ;
$(function(){
	$("span[id^=eid-]").each(function(){
		$(this).on("click",function(){
			eid = splitGet(this.id) ;
			$.post("pages/back/admin/emp/show_emp.action",{eid,eid},function(data){
				$("#photo").attr("src",data.emp.photo) ;
				$("#ename").text(data.emp.ename) ;
				$("#levelTitle").text(data.levelTitle) ;
				$("#dname").text(data.deptName) ;
				$("#empType").text(data.empTypeTitle) ;
				if(data.flag == true){
					$("#salary").text(data.emp.salary) ;
				}else{
					$("#salary").text("******") ;
				}
				$("#phone").text(data.emp.phone) ;
				$("#hiredate").text(dateFormat(data.emp.hiredate)) ;
				$("#note").text(data.emp.empnote) ;
			},"json") ;
			$("#userInfo").modal("toggle") ;
		})
	}) ;
	$(addbut).on("click",function(){
		// 通过ajax保存一行新的数据，而后把详情id取得，替换掉如下的id设置
		if(flag == true){
			addDetails("temp" + temp_did ++) ; // 设置一个临时 id信息
			flag = false ; 
		}
	}) ;
	
	$("button[id^=remove-]").each(function(){
		$(this).on("click",function(){
			rid = this.id.split("-") [1] ;
			deleteDetails(rid) ;
		}) ;
	}) ;
})

function addDetails(tdid) {
	did = $("#did").text() ;
	$.post("pages/back/admin/dept/list_role.action",{did,did},function(data){
		trElement = document.createElement("tr") ;
		trElement.setAttribute("id","dettr-" + tdid) ;
		trElement.setAttribute("class","text-danger") ;
		
		roleTdElement = document.createElement("td") ;
		btnTdElement = document.createElement("td") ;
		btnTdElement.setAttribute("class","text-center") ;
		
		selectElement = document.createElement("select") ;
		selectElement.setAttribute("class","form-control") ;
		selectElement.setAttribute("id","role-" + tdid) ;
		
		saveButtonElement = document.createElement("button") ;
		saveButtonElement.setAttribute("id","save-" + tdid) ;
		saveButtonElement.setAttribute("class","btn btn-primary btn-xs") ;
		saveSpanElement = document.createElement("span") ;
		saveSpanElement.setAttribute("class","glyphicon glyphicon-save") ;
		saveButtonElement.appendChild(saveSpanElement) ;
		saveButtonElement.appendChild(document.createTextNode(" 保存")) ;
		
		deleteButtonElement = document.createElement("button") ;
		deleteButtonElement.setAttribute("id","remove-" + tdid) ;
		deleteButtonElement.setAttribute("class","btn btn-danger btn-xs") ;
		deleteSpanElement = document.createElement("span") ;
		deleteSpanElement.setAttribute("class","glyphicon glyphicon-edit") ;
		deleteButtonElement.appendChild(deleteSpanElement) ;
		deleteButtonElement.appendChild(document.createTextNode(" 移除")) ;
		
		btnTdElement.appendChild(deleteButtonElement) ;
		trElement.appendChild(roleTdElement) ;
		trElement.appendChild(btnTdElement) ;
		roleTdElement.appendChild(selectElement) ;
		
		optionElement = document.createElement("option") ;
		optionElement.setAttribute("value",0) ;
		optionElement.appendChild(document.createTextNode("=============== 请选择角色 ================")) ;
		selectElement.appendChild(optionElement) ;
		
		for(var i = 0 ; i < data.length ; i ++){
			optionElement = document.createElement("option") ;
			optionElement.setAttribute("value",data[i].rid) ;
			optionElement.appendChild(document.createTextNode(data[i].title)) ;
			selectElement.appendChild(optionElement) ;
		}
		$(detailsTab).append(trElement) ;
		
		$("#role-" + tdid).on("change",function(){
			rid = $(this).find(":selected").val() ;
			if(rid == 0){
				btnTdElement.removeChild(saveButtonElement) ;
				btnTdElement.appendChild(deleteButtonElement) ;
			}else{
				btnTdElement.appendChild(saveButtonElement) ;
				btnTdElement.appendChild(deleteButtonElement) ;
			}
			title = $(this).find(":selected").text() ;
			selectElement.setAttribute("id","role-" + rid) ;
			trElement.setAttribute("id","dettr-" + rid) ;
			saveButtonElement.setAttribute("id","save-" + rid) ;
			deleteButtonElement.setAttribute("id","remove-" + rid) ;
			
			$("#save-" + rid).on("click",function(){
				rid = this.id.split("-") [1] ;
				saveDetails(rid) ;
			}) ;
			
			$("#remove-" + rid).on("click",function(){
				rid = this.id.split("-") [1] ;
				deleteDetails(rid) ;
			}) ;
		})
		
	},"json");
}	

function saveDetails(rid) {
	did = $("#did").text() ;
	$.post("pages/back/admin/dept/save_role.action",{"did":did,"rid":rid},function(data){
		if(data == true){
			operateAlert(true,"角色增加成功！","角色增加失败！") ;
			$("#dettr-" + rid).attr("class","text-success") ;
			flag = true ;
		}else{
			operateAlert(false,"角色增加成功！","角色增加失败！") ;
			$("#dettr-" + rid).attr("class","text-error") ;
			flag = false ;
		}
	},"json")
}

function deleteDetails(rid) {
	if(rid == 0){
		operateAlert(true,"角色删除成功！","角色删除失败！") ;
		$("#dettr-" + rid).remove() ;
		flag = true ;
		return ;
	}
	did = $("#did").text() ;
	$.post("pages/back/admin/dept/delete_role.action",{"did":did,"rid":rid},function(data){
		if(data == true){
			operateAlert(true,"角色删除成功！","角色删除失败！") ;
			$("#dettr-" + rid).remove() ;
			flag = true ;
		}else{
			operateAlert(false,"角色删除成功！","角色删除失败！") ;
			flag = false ;
		}
	},"json")
}