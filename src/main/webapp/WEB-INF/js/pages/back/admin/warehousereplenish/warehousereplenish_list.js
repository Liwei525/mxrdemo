$(function(){
	$("span[id^=wid-]").each(function(){
		$(this).on("click",function(){
			wid = this.id.split("-")[1] ;
			console.log("仓库编号：" + wid) ;
			$("#warehouseInfo").modal("toggle") ;
		}) ;
	}) ;
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("-")[1] ;
			console.log("仓库管理员编号：" + mid) ;
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
}) ;
