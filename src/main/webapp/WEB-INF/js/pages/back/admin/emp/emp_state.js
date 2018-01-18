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
				required : true
			} ,
			"leaveDate": {
				required : true
			} ,
			"leaveNote" : {
				required : true
			}
		}
	});
	
	$("#leaveDate").datetimepicker({
		format: 'yyyy-mm-dd hh:ii:ss',
		autoclose: true,
		todayBtn: true,
        pickerPosition: "bottom-right",
        startDate: "2015-01-01 00:00",
        language:  'zh-CN',
        minView: 0,
        todayHighlight: true
	});
})