$(function(){
	$("span[id^=cuid-]").each(function(){
		$(this).on("click",function(){
			sid = splitGet(this.id) ;
			$("#customerInfo").modal("toggle") ;
		}) ;
	}) ;
	$("span[id^=wid-]").each(function(){
		$(this).on("click",function(){
			sid = splitGet(this.id) ;
			$("#warehouseInfo").modal("toggle") ;
		}) ;
	}) ;
	$("span[id^=plantid-]").each(function(){
		$(this).on("click",function(){
			sid = splitGet(this.id) ;
			$("#plantInfo").modal("toggle") ;
		}) ;
	}) ;
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = splitGet(this.id) ;
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
})