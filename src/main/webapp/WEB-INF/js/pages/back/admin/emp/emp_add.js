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
			"eid" : {
				required : true ,
				remote : {
					url : "pages/back/admin/emp/check_eid.action", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : { // 要传递的数据
						eid : function() {
							return $("#eid").val();
						}
					},
					dataFilter : function(data, type) {
						if (data == "true")
							return true;
						else
							return false;
					}
				}
			} ,
			"ename" : {
				required : true
			} ,
			"sex" : {
				required : true ,
				digits:true
			} ,
			"phone" : {
				required : true ,
				digits:true
			},
			"lid" : {
				required : true ,
				digits:true
			},
			"etid" : {
				required : true ,
				digits:true
			},
			"did" : {
				required : true ,
				digits:true ,
				remote : {
					url : "pages/back/admin/emp/check_did.action", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : { // 要传递的数据
						did : function() {
							return $("#did").val();
						}
					},
					dataFilter : function(data, type) {
						if (data == "true")
							return true;
						else
							return false;
					}
				}
			},
			"salary" : {
				required : true ,
				number : true 
			},
			"pic" : {
				required : true ,
				accept : ["jpg","png","gif","bmp"]
			},
			"empnote" : {
				required : true
			}
		} ,
		messages : {
			eid : {
				remote : "该雇员编号已存在！"
			},
			did : {
				remote : "该部门人数已满！"
			}
		}
	});
})