$(function(){
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = splitGet(this.id) ;
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
})