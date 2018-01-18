$(function(){
	$("#showCustomer").on("click",function(){
		$("#customerInfo").modal("toggle") ;
	}) ;
	$("#showPlant").on("click",function(){
		$("#plantInfo").modal("toggle") ;
	}) ;
	$("#showMember").on("click",function(){
		$("#userInfo").modal("toggle") ;
	}) ;
	$("#showWarehouse").on("click",function(){
		$("#warehouseInfo").modal("toggle") ;
	}) ;
})