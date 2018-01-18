$(function(){
	$("tr[id^=ucgsid-]").each(function(){
		$(this).on("click",function(){
			ucgsid = this.id.split("-")[1] ;
			loadData() ;
			$("#ucgsidDetailsInfo").modal("toggle") ;
		}) ;
	})
})

function loadData() {	// 该函数名称一定要固定，不许修改
	// $("#memberBasicInfo tr:gt(0)").remove() ; // 加载之前要进行原有数据删除
	createSplitBar(10) ;	// 创建分页控制项
}