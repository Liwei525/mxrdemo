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
			"usaid" : {
				required : true ,
				remote : {
					url : "pages/back/admin/ucgoodsstorage/check_usaid.action", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "json", // 接受数据格式
					data : { // 要传递的数据
						usaid : function() {
							return $("#usaid").val();
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
			"title" : {
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
		} ,
		messages : {
			usaid : {
				remote : "该合同号已存在！"
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
			$.post("pages/back/admin/ucgoodsstorage/get_city.action",{"pid":pid},function(data){
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
			$.post("pages/back/admin/ucgoodsstorage/get_warehouse.action",{"pid":pid,"cid":cid},function(data){
				for(var i = 0 ; i < data.length ; i ++){
					$("#wid").append("<option value=" + data[i].wid + ">" + data[i].name + "</option>") ;
				}
			},"json") ;
		}
	}) ;
})