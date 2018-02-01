$(function(){
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = splitGet(this.id) ;
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
	$("span[id^=sid-]").each(function(){
		$(this).on("click",function(){
			sid = splitGet(this.id) ;
			$("#storageDetailsInfo").modal("toggle") ;
		}) ;
	}) ;
	$("span[id^=wid-]").each(function(){
		$(this).on("click",function(){
			sid = splitGet(this.id) ;
			$("#warehouseInfo").modal("toggle") ;
		}) ;
	}) ;
}) ;
