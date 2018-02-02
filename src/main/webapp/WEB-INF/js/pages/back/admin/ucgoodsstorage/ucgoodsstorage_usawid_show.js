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
	$("tr[id^=usawid-]").each(function(){
		$(this).on("click",function(){
			usawid = splitGet(this.id) ;
			$("#selectUsawid").text(usawid) ;
			loadData() ;
			$("#usawidDetailsInfo").modal("toggle") ;
		}) ;
	})
})

function loadData() {	
	usawid = $("#selectUsawid").text() ;
	$.post("pages/back/admin/ucgoodsstorage/usawid_details.action",{"usawid":usawid,"jsCommonCp":jsCommonCp,"jsCommonLs":jsCommonLs},function(data){
		$("#usawid").text(data.ucgoodsStorageApplyWarehouse.usawid) ;
		$("#inMember").text(data.inMember.ename) ;
		$("#inDate").text(datetimeFormat(data.ucgoodsStorageApplyWarehouse.date)) ;
		$("#inNote").text(data.ucgoodsStorageApplyWarehouse.note) ;
		$("#details").empty() ;
		for(var i = 0 ; i < data.allUCGoodsStorageApplyRecord.length ; i ++){
			trInfo = $(	"<tr class='text-primary'> " + 
						"	<td class='text-left'>" + data.allUCGoodsStorageApplyRecord[i].ucid + "</td> " + 
						"	<td class='text-center'>" + data.allUCGoodsStorageApplyRecord[i].name + "</td> " +
						"	<td class='text-center'>" + data.allUCGoodsStorageApplyRecord[i].size + "</td> " +
						"	<td class='text-center'>" + data.allUCGoodsStorageApplyRecord[i].num + "</td> " + 
						"</tr> ") ;
			$("#details").append(trInfo) ;
		}
		createSplitBar(data.count) ;	
	},"json") ;
}