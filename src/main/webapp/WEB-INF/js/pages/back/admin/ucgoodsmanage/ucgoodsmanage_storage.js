$(function(){
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			$.post("pages/back/admin/ucgoodsmanage/usawid_save.action",{"usaid":$("#usaid").text(),"usawid":$("#usawid2").val(),"note":$("#note").val()},function(data){
				if(data == true){
					$("#usawid2").attr("disabled","disabled") ;
					$("#note").attr("disabled","disabled") ;
					$("input[id^=realnum-]").each(function(){
						$(this).attr("type","text");
					}) ;
					$("span[id^=unit]").each(function(){
						$(this).attr("style","text");
					}) ;
					$("button[id^=edit-]").each(function(){
						$(this).attr("style","");
					}) ;
					$("button[id^=save-]").each(function(){
						$(this).attr("style","");
					}) ;
				}else{
					alert("出错了！") ;
				}
			},"json")
		},
		errorPlacement : function(error, element) {
			$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});

			})
		},
		unhighlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1,function() {
						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
				});
			})
		},
		errorClass : "text-danger",
		rules : {
			"usawid2" : {
				required : true,
				remote : {
					url : "pages/back/admin/ucgoodsmanage/check_usawid.action", 
					type : "post", 
					dataType : "json", 
					data : { 
						usawid : function() {
							return $("#usawid2").val();
						}
					},
					dataFilter : function(data, type) {
						if (data == "true")
							return true;
						else
							return false;
					}
				}
			},
			"note" : {
				required : true
			}
		} ,
		messages: {
			usawid2 : {
				remote : "该入库单号已存在！" 
			}
		}
	});
	$("button[id^=save-]").each(function(){
		$(this).on("click",function(){
			ucid = splitGet(this.id) ;
			usaid = $("#usaid").text() ;
			usawid = $("#usawid2").val() ;
			num = $("#realnum-" + ucid).val() ;
			$.post("pages/back/admin/ucgoodsmanage/ucid_save.action",{usaid:usaid,usawid:usawid,ucid:ucid,num:num},function(data){
				if(data == true){
					operateAlert(true,"半成品入库成功！","半成品入库失败！") ;
				}else{
					operateAlert(false,"半成品入库成功！","半成品入库失败！") ;
				}
			},"json") ;
			$("#realnum-" + ucid).attr("disabled","disabled") ;
		}) ;
	}) ;
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