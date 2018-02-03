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
			"name" : {
				required : true ,
				remote : {
					url : "pages/back/admin/warehouse/check_name_myself.action" ,
					type : "post", 
					dataType : "json", 
					data : { // 要传递的数据
						name : function() {
							return $("#name").val();
						},
						wid :  function() {
							return $("#wid").val();
						},
					},
					dataFilter : function(data, type) {
						if (data.trim() == "true")
							return true;
						else
							return false;
					}
				}
			} ,
			"pid" : {
				required : true 
			},
			"cid" : {
				required : true 
			},
			"address" : {
				required : true 
			},
			"wiid" : {
				required : true 
			},
			"note" : {
				required : true
			}
		},
		messages:{
			name : {
				remote : "该仓库名称已存在！" 
			}
		}
	});
	$(cid).on("change",function() {
		handleAddress() ;	// 处理地址 
	}) ;
	$(pid).on("change",function(){
		pid = $("#pid").val() ;
		$("#cid").empty() ;
		$("#cid").append("<option value=''>====== 请选择所在城市 ======</option>") ;
		if(pid != ''){
			$.post("pages/back/admin/warehouse/get_city.action",{"pid":pid},function(data){
				for(var i = 0 ; i < data.length ; i ++){
					$("#cid").append("<option value=" + data[i].cid + ">" + data[i].title + "</option>") ;
				}
			},"json") ;
		}
		if (this.value != "") {	// 有内容，需要进行ajax异步加载
			handleAddress() ;	// 处理地址 
		} else {
			$("#cid option:gt(0)").remove() ;
		}
	}) ;
})

function handleAddress() {	// 实现地址处理过程
	address = $("#address").val() ;	// 获得address原始内容
	ptitle = $("#pid option:selected").text() + " " ;
	ctitle = " " ;
	if ($("#cid option:selected").val() != "") {
		ctitle = $("#cid option:selected").text() + " " ;
	}
	adr = address.split(" ") ; 
	if (adr.length >= 3) {	// 都填写完了，现在要修改了
		str = ptitle + ctitle + adr[2] ;
		for (x = 2 ; x < adr.length ; x ++) {
			str += adr[x] + " " ; 
		}  
		$("#address").val(str) ;  
	} else {
		$("#address").val(ptitle + ctitle) ;  
	}
}