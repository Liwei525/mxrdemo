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
			"dname" : {
				required : true ,
//				remote : {
//					url : "pages/back/admin/dept/check_dname.action", 
//					type : "post", 
//					dataType : "json", 
//					data : { 
//						dname : function() {
//							return $("#dname").val();
//						}
//					},
//					dataFilter : function(data, type) {
//						if (data.trim() == 'true')
//							return true;
//						else
//							return false;
//					}
//				}
			} ,
			"maxnum" : {
				required : true ,
				digits: true
			}
		} ,
		messages: {
			dname : {
				remote : "该部门已存在！" 
			}
		}
	});
})