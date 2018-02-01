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
			"ucgsid" : {
				required : true,
			},
			"note" : {
				required : true
			}
		}
	});
	$("button[id^=access-]").each(function(){
		$(this).on("click",function(){
			sdid = splitGet(this.id) ;
			operateAlert(true,"半成品入库成功！","半成品入库失败！") ;
			$("input[id$=" + sdid + "]").attr("disabled","disabled") ;
		}) ;
	}) ;
	$("button[id^=edit-]").each(function(){
		$(this).on("click",function(){
			sdid = splitGet(this.id) ;
			$("input[id$=" + sdid + "]").removeAttr("disabled") ;
		}) ;
	}) ;
	
	
})