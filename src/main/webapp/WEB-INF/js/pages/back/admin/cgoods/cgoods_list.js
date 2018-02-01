$(function(){
	$("button[id^=out-]").each(function(){
		$(this).on("click",function(){
			cid = splitGet(this.id) ;
			operateAlert(true,"待出库商品添加成功！","待出库商品添加失败！") ;
		}) ;
	}) ;
	$("span[id^=storage-]").each(function(){
		$(this).on("click",function(){
			mid = splitGet(this.id) ;
			$("#goodsRecordInfo").modal("toggle") ; 
		}) ;
	}) ;
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = splitGet(this.id) ;
			$("#userInfo").modal("toggle") ;
		}) ;
	}) ;
})