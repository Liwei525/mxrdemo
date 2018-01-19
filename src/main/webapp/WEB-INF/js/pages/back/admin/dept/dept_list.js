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
		}) ;
	}) ;
}) ;
