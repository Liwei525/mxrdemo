$(function() {
	$("button[id^=storage-]").each(function(){
		$(this).on("click",function(){
			ucid = splitGet(this.id) ;
			$.post("pages/back/admin/ucgoods/num_details",{"ucid":ucid},function(data){
				$('#recordTable').empty() ;
				for(var i = 0 ; i < data.allWarehouseUCGoods.length ; i ++){
					warehouseUCGoods = data.allWarehouseUCGoods[i] ;
					if(warehouseUCGoods.unit == 1){
						trInfo = $("<tr class='text-primary'> " +
									"	<td class='text-left'>" + data.allWarehouse[warehouseUCGoods.wuid].name + "</td>" + 
									"	<td class='text-center'>" + data.allProvince[data.allWarehouse[warehouseUCGoods.wuid].wid].title + "</td> " +
									"	<td class='text-center'>" + data.allCity[data.allWarehouse[warehouseUCGoods.wuid].wid].title + "</td> " +
									"	<td class='text-center'>" + warehouseUCGoods.num + " 个</td> " + 
									"</tr> ") ;
					}else{
						trInfo = $("<tr class='text-primary'> " +
								"	<td class='text-left'>" + data.allWarehouse[warehouseUCGoods.wuid].name + "</td>" + 
								"	<td class='text-center'>" + data.allProvince[data.allWarehouse[warehouseUCGoods.wuid].wid].title + "</td> " +
								"	<td class='text-center'>" + data.allCity[data.allWarehouse[warehouseUCGoods.wuid].wid].title + "</td> " +
								"	<td class='text-center'>" + warehouseUCGoods.num + " 米</td> " + 
								"</tr> ") ;
					}
					$('#recordTable').append(trInfo) ;
				}
				$("#goodsRecordInfo").modal("toggle") ; 
			},"json") ;
		}) ;
	}) ;
	$('#storageDetails').on('show.bs.collapse', function () {
		$.post("pages/back/admin/ucgoods/show_storage_details",{"ucid":$("#ucid").text()},function(data){
			$('#storageTable').empty() ;
			for(var i = 0 ; i < data.allUCGoodsStorageApplyRecord.length ; i ++){
				ucgoodsStorageApplyRecord = data.allUCGoodsStorageApplyRecord[i] ;
				if(ucgoodsStorageApplyRecord.unit == 1){
					trInfo = $("<tr class='text-primary'> " +
								"	<td class='text-center'>" + ucgoodsStorageApplyRecord.usawid + "</td>" + 
								"	<td class='text-left'><span style='cursor:pointer;' id='storageWid-" + data.allWarehouse[ucgoodsStorageApplyRecord.usarid].wid + "'>" + data.allWarehouse[ucgoodsStorageApplyRecord.usarid].name + "</td> " +
								"	<td class='text-center'>" + ucgoodsStorageApplyRecord.num + " 个</td> " +
								"	<td class='text-center'>" + datetimeFormat(ucgoodsStorageApplyRecord.date) + "</td> " + 
								"</tr> ") ;
				}else{
					trInfo = $("<tr class='text-primary'> " +
							"	<td class='text-center'>" + ucgoodsStorageApplyRecord.usawid + "</td>" + 
							"	<td class='text-left'><span style='cursor:pointer;' id='storageWid-" + data.allWarehouse[ucgoodsStorageApplyRecord.usarid].wid + "'>" + data.allWarehouse[ucgoodsStorageApplyRecord.usarid].name + "</td> " +
							"	<td class='text-center'>" + ucgoodsStorageApplyRecord.num + " 米</td> " +
							"	<td class='text-center'>" + datetimeFormat(ucgoodsStorageApplyRecord.date) + "</td> " + 
							"</tr> ") ;
				}
				$('#storageTable').append(trInfo) ;
			}
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
		},"json") ;
		operateAlert(true,"半成品入库信息加载成功！","半成品入库加载失败！") ;
	}) ;
	$('#outputDetails').on('show.bs.collapse', function () {
		$.post("pages/back/admin/ucgoods/show_output_details",{"ucid":$("#ucid").text()},function(data){
			$('#outputTable').empty() ;
			for(var i = 0 ; i < data.allUCGoodsOutputRecord.length ; i ++){
				ucgoodsOutputRecord = data.allUCGoodsOutputRecord[i] ;
				trInfo = $("<tr class='text-primary'> " +
							"	<td class='text-center'>" + ucgoodsOutputRecord.uorid + "</td>" + 
							"	<td class='text-left'><span style='cursor:pointer;' id='wid-" +  data.allWarehouse[ucgoodsOutputRecord.uorid].wid + "'>" + data.allWarehouse[ucgoodsOutputRecord.uorid].name + "</td> " +
							"	<td class='text-center'><span style='cursor:pointer;' id='plid-" +  data.allPlant[ucgoodsOutputRecord.uorid].plid + "'>" + data.allPlant[ucgoodsOutputRecord.uorid].name + "</td> " +
							"	<td class='text-center'>" + ucgoodsOutputRecord.num + "</td> " +
							"	<td class='text-center'>" + datetimeFormat(ucgoodsOutputRecord.date) + "</td> " + 
							"</tr> ") ;
				$('#outputTable').append(trInfo) ;
			}
			$("span[id^=wid-]").each(function(){
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
			$("span[id^=plid-]").each(function(){
				$(this).on("click",function(){
					plid = splitGet(this.id);
					$.post("pages/back/admin/plant/show_info.action",{plid:plid},function(data){
						$("#plantPhoto").attr("src",data.plant.photo) ;
						$("#plantName").text(data.plant.name) ;
						$("#plantProvince").text(data.province.title) ;
						$("#plantCity").text(data.city.title) ;
						$("#plantAddress").text(data.plant.address) ;
						$("#plantPhone").text(data.plant.phone) ;
						$("#plantNote").text(data.plant.note) ;
						$("#plantInfo").modal("toggle") ;
					},"json") ;
				}) ;
			}) ;
		},"json") ;
		operateAlert(true,"半成品出库信息加载成功！","半成品出库加载失败！") ;
	}) ;
})