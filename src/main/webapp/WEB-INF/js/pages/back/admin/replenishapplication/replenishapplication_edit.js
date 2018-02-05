$(function(){
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			form.submit(); // 提交表单
		},
		errorPlacement : function(error, element) {
			$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});

			})
		},
		unhighlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1,function() {
						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
				});
			})
		},
		errorClass : "text-danger",
		rules : {
			"raid" : {
				required : true
			} ,
			"name" : {
				required : true
			} ,
			"pid" : {
				required : true 
			},
			"cid" : {
				required : true 
			},
			"wid" : {
				required : true 
			},
			"note" : {
				required : true
			}
		}
	});
	$("#pid").on("change",function(){
		pid = $("#pid").val() ;
		$("#cid").empty() ;
		$("#wid").empty() ;
		$("#cid").append("<option value=''>====== 请选择所在城市 ======</option>") ;
		$("#wid").append("<option value=''>====== 请选择要存储的仓库 ======</option>") ;
		if(pid != ''){
			$.post("pages/back/admin/replenishapplication/get_city.action",{"pid":pid},function(data){
				for(var i = 0 ; i < data.length ; i ++){
					$("#cid").append("<option value=" + data[i].cid + ">" + data[i].title + "</option>") ;
				}
			},"json") ;
		}
	}) ;
	$("#cid").on("change",function(){
		pid = $("#pid").val() ;
		cid = $("#cid").val() ;
		$("#wid").empty() ;
		$("#wid").append("<option value=''>====== 请选择要存储的仓库 ======</option>") ;
		if(cid != ''){
			$.post("pages/back/admin/replenishapplication/get_warehouse.action",{"pid":pid,"cid":cid},function(data){
				for(var i = 0 ; i < data.length ; i ++){
					$("#wid").append("<option value=" + data[i].wid + ">" + data[i].name + "</option>") ;
				}
			},"json") ;
		}
	}) ;
})