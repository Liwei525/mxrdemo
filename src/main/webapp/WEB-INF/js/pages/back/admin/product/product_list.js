$(function(){
	$("span[id^=wid-]").each(function(){
		$(this).on("click",function(){
			sid = splitGet(this.id) ;
			$("#warehouseInfo").modal("toggle") ;
		}) ;
	}) ;
	
})