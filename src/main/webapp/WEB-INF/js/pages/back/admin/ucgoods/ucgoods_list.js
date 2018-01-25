$(function(){
	$("span[id^=storage-]").each(function(){
		$(this).on("click",function(){
			ucid = splitGet(this.id) ;
			$.post("pages/back/admin/ucgoods/num_details",{"ucid":ucid},function(data){
				$('#recordTable').empty() ;
				for(var i = 0 ; i < data.allWarehouseUCGoods.length ; i ++){
					warehouseUCGoods = data.allWarehouseUCGoods[i] ;
					trInfo = $("<tr class='text-primary'> " +
								"	<td class='text-left'>" + data.allWarehouse[warehouseUCGoods.wuid].name + "</td>" + 
								"	<td class='text-center'>" + data.allProvince[data.allWarehouse[warehouseUCGoods.wuid].wid].title + "</td> " +
								"	<td class='text-center'>" + data.allCity[data.allWarehouse[warehouseUCGoods.wuid].wid].title + "</td> " +
								"	<td class='text-center'>" + warehouseUCGoods.num + "</td> " + 
								"</tr> ") ;
					$('#recordTable').append(trInfo) ;
				}
				$("#goodsRecordInfo").modal("toggle") ; 
			},"json") ;
		}) ;
	}) ;
	$("span[id^=mid-]").each(function(){
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
})