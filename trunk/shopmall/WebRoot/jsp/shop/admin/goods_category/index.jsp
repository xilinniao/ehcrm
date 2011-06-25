<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
	<link type="text/css" rel="stylesheet" href="<%=path %>/resources/js/plugin/jstree/themes/default/style.css">
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.jstree.js"></script>
	<script src="<%=path %>/resources/common/js/base.js" type="text/javascript"></script>
    <script type="text/javascript">
	<!--
	var saveform_validator;
	
	$(document).ready(function(){
		$("#goodscat_tree").jstree({
			"ui" : {
				"select_limit" : 1,
				"select_multiple_modifier" : "alt",
				"selected_parent_close" : "select_parent"
			},
			"html_data" : {
				"ajax" : {
					"url" : "<%=path%>/shop/admin/goodsCategory.xhtml?method=getXmlTree"
				}
			},
			"plugins" : [ "themes","ui","html_data","cookies"]
		}).bind("select_node.jstree", function(e, data) {
			var data_id = data.rslt.obj.attr("id");
			if(data_id=='id_${root.categoryId}'){
				$('#btnSave').hide();
				$('#btnDelete').hide();
			}else{
				$('#btnSave').show();
				$('#btnDelete').show();
			}
			//更新右边的输入框
			$.ajax({
				  url: '<%=path%>/shop/admin/goodsCategory.xhtml',
				  type: 'POST',
				  dataType:'json',
				  data: 'method=editGoodscat&categoryId='+data_id.substr(3),
				  success: function(data) {
				  	saveform_validator.resetForm();
				  	$('#categoryId').val(data.categoryId);
					$('#id_category_id').val(data.parentCategoryId);
					$('#id_category_name').val(data.parentCategoryName);
					$('#categoryName').val(data.categoryName);
					$('#keyWords').val(data.keyWords);
					$('#categoryDesc').val(data.categoryDesc);
					$('#orderNum').val(data.orderNum);
				  }
			});
		});
				
		//加载验证框架
		saveform_validator = $("form.validate").validate({
			errorClass: "validateError",
			ignore: ".ignoreValidate",
			errorPlacement:defaultErrorPlacement,
			submitHandler:defaultSubmitHandler
		});
    	
    	$('#btnSave').click(function(){
    		//验证输入数据
    		if (saveform_validator.form()) {
				$('#saveform').ajaxSubmit({
					success:function(respText){
						if(respText=='OK'){
							$.dialog({type: "success", content: "保存成功！", width: 360, modal: true, ok:'确定'});//$.message({type: "warn", content: "保存成功！"});
							$("#goodscat_tree").jstree("refresh");
						}else{
							$.dialog({type: "error", content: '操作失败:'+respText, width: 360, modal: true,ok:'确定'});
						}
					},
					error:defaultErrorHandler
				});
			}
    	});
    	
    	$('#btnDelete').click(function(){
    		if(confirm('是否删除该商品分类?')){
	    		$.ajax({
					  url: '<%=path%>/shop/admin/goodsCategory.xhtml',
					  type: 'POST',
					  dataType:'text',
					  data: 'method=deleteGoodscat&categoryId='+$('#categoryId').val(),
					  success: function(respText) {
						  	if(respText=='OK'){
								$.dialog({type: "success", content: "商品分类删除成功！！", width: 360, modal: true, ok:'确定'});
								$("#goodscat_tree").jstree("refresh");
							}else if(respText=='EER01'){
								$.dialog({type: "error", content: "操作失败：请先删除该商品分类下子商品分类！", width: 360, modal: true,ok:'确定'});
							}else{
								$.dialog({type: "error", content: "操作失败", width: 360, modal: true,ok:'确定'});
							}
					  },
					  error:defaultErrorHandler
				});
			}
    	});
    	
	});
	
	//-->
	</script>

  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>系统管理->商品分类管理</h1>
	</div>
	<div class="operateBar" style="margin:2px 13px;text-align:right;">
		<input type="button" class="formButton" onclick="location.href='goodsCategory.xhtml?method=addGoodscat'" value="新增分类">
	</div>
	
	<div class="box column-left">
		<h2 class="box-header">商品分类列表</h2>
		<div class="box-content" id="goodscat_tree" style="display: block; "></div>
	</div>
	 <div class="box column-right">
		<h2 class="box-header">商品分类详情</h2>
		<div class="box-content form-table" style="display: block; ">
			<%@include file="/jsp/shop/admin/goods_category/form.jsp"%>
    	</div>
    </div>
  </body>
</html>