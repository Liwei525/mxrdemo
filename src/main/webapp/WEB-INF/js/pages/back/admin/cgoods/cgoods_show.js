loadFlag = false ;
$(function() {
	$("button[id^=constitute-]").each(function(){
		$(this).on("click",function(){
			wid = splitGet(this.id) ;
			loadData() ;
			$("#ucgoodsConstituteInfo").modal("toggle") ;
		}) ;
	}) ;
	$("button[id^=storage-]").each(function(){
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
	$('#storageDetails').on('show.bs.collapse', function () {
		if (loadFlag == false) {
			// ajax异步加载库存信息
			operateAlert(true,"成品库存信息加载成功！","成品库存信息加载失败！") ;
			loadFlag = true ; // 数据已经加载完成
			$("span[id^=mid-]").each(function(){
				$(this).on("click",function(){
					mid = splitGet(this.id) ;
					$("#memberInfo").modal("toggle") ;
				}) ;
			}) ;
		}
	}) ;
})

function loadData() {	// 该函数名称一定要固定，不许修改
	// $("#memberBasicInfo tr:gt(0)").remove() ; // 加载之前要进行原有数据删除
	createSplitBar(10) ;	// 创建分页控制项
}