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
			loadData() ;
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
function loadData() {	// 该函数名称一定要固定，不许修改
	// $("#memberBasicInfo tr:gt(0)").remove() ; // 加载之前要进行原有数据删除
	createSplitBar(10) ;	// 创建分页控制项
}