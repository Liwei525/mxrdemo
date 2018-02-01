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
	$("span[id^=usaid-]").each(function(){
		$(this).on("click",function(){
			usaid = splitGet(this.id) ;
			$("#selectUsaid").text(usaid) ;
			loadData() ;
			$("#storageDetailsInfo").modal("toggle") ;
		}) ;
	}) ;
}) ;
function loadData() {	
	usawid = $("#selectUsaid").text() ;
	$.post("pages/back/admin/ucgoodsstorageaudit/apply_details.action",{"usaid":usaid,"jsCommonCp":jsCommonCp,"jsCommonLs":jsCommonLs},function(data){
		$("#storageTitle").text(data.ucgoodsStorageApply.title) ;
		$("#storageWarehouse").text(data.warehouse.name) ;
		$("#storageWiid").text(data.warehouse.wiid == 1?"半成品":"成品") ;
		$("#storageTotalPrice").text(data.totalPrice) ;
		$("#storageNote").text(data.ucgoodsStorageApply.note) ;
		$("#storageDetails").empty() ;
		for(var i = 0 ; i < data.allUCGoodsStorageApplyDetails.length ; i ++){
			if(data.allUCGoodsStorageApplyDetails[i].unit == 1){
				trInfo = $(	"<tr class='text-primary'> " +
						"	<td class='text-center'>" + data.allUCGoodsStorageApplyDetails[i].ucid + "</td> " +
						"	<td class='text-left'>" + data.allUCGoodsStorageApplyDetails[i].name + "</td> " +
						"	<td class='text-center'>" + data.allUCGoodsStorageApplyDetails[i].num + " 个" + "</td> " + 
						"	<td class='text-center'>" + data.allUCGoodsStorageApplyDetails[i].price + "</td> " + 
						"	<td class='text-center'>" + data.allUCGoodsStorageApplyDetails[i].size + "</td> " +
						"	<td class='text-center'>" + data.allUCGoodsStorageApplyDetails[i].totalPrice + "</td> " +
						"</tr>") ;
			}else{
				trInfo = $(	"<tr class='text-primary'> " +
						"	<td class='text-center'>" + data.allUCGoodsStorageApplyDetails[i].ucid + "</td> " +
						"	<td class='text-left'>" + data.allUCGoodsStorageApplyDetails[i].name + "</td> " +
						"	<td class='text-center'>" + data.allUCGoodsStorageApplyDetails[i].num + " 米" + "</td> " + 
						"	<td class='text-center'>" + data.allUCGoodsStorageApplyDetails[i].price + "</td> " + 
						"	<td class='text-center'>" + data.allUCGoodsStorageApplyDetails[i].size + "</td> " +
						"	<td class='text-center'>" + data.allUCGoodsStorageApplyDetails[i].totalPrice + "</td> " +
						"</tr>") ;
			}
			
			$("#storageDetails").append(trInfo) ;
		}
		createSplitBar(data.count) ;	
	},"json") ;
}