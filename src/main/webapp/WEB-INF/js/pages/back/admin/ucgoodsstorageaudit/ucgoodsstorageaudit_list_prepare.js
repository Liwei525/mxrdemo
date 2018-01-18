$(function(){
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("-")[1] ;
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
	$("span[id^=sid-]").each(function(){
		$(this).on("click",function(){
			sid = this.id.split("-")[1] ;
			$("#storageDetailsInfo").modal("toggle") ;
		}) ;
	}) ;
	$("span[id^=wid-]").each(function(){
		$(this).on("click",function(){
			sid = this.id.split("-")[1] ;
			$("#warehouseInfo").modal("toggle") ;
		}) ;
	}) ;
}) ;
