$(function(){
	$("span[id^=storageWid-]").each(function(){
		$(this).on("click",function(){
			wid = splitGet(this.id);
			$.post("pages/back/admin/warehouse/show_info.action",{wid:wid},function(data){
				$("#warehousePhoto").attr("src",data.warehouse.photo) ;
				$("#warehouseName").text(data.warehouse.name) ;
				$("#warehouseProvince").text(data.province.title) ;
				$("#warehouseCity").text(data.city.title) ;
				$("#warehouseAddress").text(data.warehouse.address) ;
				$("#warehouseWiid").text(data.warehouse.wiid == 1 ? "半成品" : "成品") ;
				$("#warehouseNote").text(data.warehouse.note) ;
				$("#warehouseInfo").modal("toggle") ;
			},"json") ;
		}) ;
	}) ;
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
