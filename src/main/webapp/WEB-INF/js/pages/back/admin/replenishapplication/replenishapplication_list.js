$(function(){
	$("span[id^=wid-]").each(function(){
		$(this).on("click",function(){
			wid = splitGet(this.id) ;
			console.log("仓库编号：" + wid) ;
			$("#warehouseInfo").modal("toggle") ;
		}) ;
	}) ;
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = splitGet(this.id) ;
			console.log("仓库管理员编号：" + mid) ;
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
}) ;
