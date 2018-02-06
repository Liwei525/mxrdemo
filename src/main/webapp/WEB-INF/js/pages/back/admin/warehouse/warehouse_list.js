$(function(){
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
	$("span[id^=wid-]").each(function(){
		$(this).on("click",function(){
			wid = splitGet(this.id) ;
			$("#selectWid").text(wid) ;
			loadData() ;
			$("#warehouseGoodsInfo").modal("toggle") ;
		}) ;
	}) ;
}) ;
function loadData() {	
	wid = $("#selectWid").text() ;
	wiid = $("#wiid-" + wid).text() ;
	if(wiid == 1){
		$.post("pages/back/admin/warehouse/get_ucgoods.action",{"wid":wid,"jsCommonCp":jsCommonCp,"jsCommonLs":jsCommonLs},function(data){
			$("#ucgoods").empty() ;
			for(var i = 0 ; i < data.allWarehouseUCGoods.length ; i ++){
				if(data.allWarehouseUCGoods[i].unit == 1){
					trInfo = $(	"<tr class='text-primary'> " +
							"	<td class='text-center'>" + data.allWarehouseUCGoods[i].ucid + "</td> " +
							"	<td class='text-center'>" + data.allWarehouseUCGoods[i].name + "</td> " +
							"	<td class='text-center'>" + data.allWarehouseUCGoods[i].size + "</td> " +
							"	<td class='text-center'>" + data.allWarehouseUCGoods[i].num + " 个" + "</td> " + 
							"</tr>") ;
				}else{
					trInfo = $(	"<tr class='text-primary'> " +
							"	<td class='text-center'>" + data.allWarehouseUCGoods[i].ucid + "</td> " +
							"	<td class='text-center'>" + data.allWarehouseUCGoods[i].name + "</td> " +
							"	<td class='text-center'>" + data.allWarehouseUCGoods[i].size + "</td> " +
							"	<td class='text-center'>" + data.allWarehouseUCGoods[i].num + " 米" + "</td> " + 
							"</tr>") ;
				}
				
				$("#ucgoods").append(trInfo) ;
			}
			createSplitBar(data.count) ;	
		},"json") ;
	}else{
		
	}
}