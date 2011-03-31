<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/resources/admin/css/datatables.css" rel="stylesheet" type="text/css">
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
				"selected_parent_close" : "select_parent",
				"initially_select":['id_${rootId}']
			},
			"html_data" : {
				"ajax" : {
					"url" : "<%=path%>/shop/admin/goodscat.xhtml?method=getXmlTree"
				}
			},
			"plugins" : [ "themes","ui","html_data"]
		}).bind("select_node.jstree", function(e, data) {
			var data_id = data.rslt.obj.attr("id");
			if(data_id=='id_${rootId}'){
				$('#parent_goodscat_select').hide();
				$('#btnSave').hide();
				$('#btnDelete').hide();
			}else{
				$('#parent_goodscat_select').show();
				$('#btnSave').show();
				$('#btnDelete').show();
			}
			//更新右边的输入框
			$.ajax({
				  url: '<%=path%>/shop/admin/goodscat.xhtml',
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
							$("#goodscat_tree").jstree("refresh");
						}else{
							alert('操作失败');
						}
					},
					error:defaultErrorHandler
				});
			}
    	});
    	
    	$('#btnDelete').click(function(){
    		if(confirm('是否删除该商品分类?')){
	    		$.ajax({
					  url: '<%=path%>/shop/admin/goodscat.xhtml',
					  type: 'POST',
					  dataType:'text',
					  data: 'method=deleteGoodscat&categoryId='+$('#categoryId').val(),
					  success: function(respText) {
						  	if(respText=='OK'){
								alert('商品分类删除成功！');
								$("#goodscat_tree").jstree("refresh");
							}else if(respText=='EER01'){
								alert('操作失败：请先删除该商品分类下子商品分类');
							}else{
								alert('操作失败');
							}
					  },
					  error:defaultErrorHandler
				});
			}
    	});
    	
    	$('#parent_category_select').click(function(){
			$.colorbox({
				href:'<%=path%>/shop/admin/goodscat.xhtml?method=selectGoodscat',
				iframe:true,
				width:"500",
				height:"90%"
			});
    	});
	});
	
	//-->
	</script>

  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>系统管理->商品分类管理</h1>
	</div>
	<div class="operateBar">
		<input type="button" class="addButton" onclick="location.href='goodscat.xhtml?method=addGoodscat'" value="新增分类">
		
		<input type="button" class="addButton" onclick="location.href='goodscat.xhtml?method=getJingDongCat'" value="京东分类">
	</div>
	
	<div class="box column-left">
		<h2 class="box-header">商品分类列表</h2>
		<div class="box-content" id="goodscat_tree" style="display: block; "></div>
	</div>
	 <div class="box column-right">
		<h2 class="box-header">商品分类详情</h2>
		<div class="box-content form-table" style="display: block; ">
			<%@include file="/jsp/shop/admin/goodscat/form.jsp"%>
    	</div>
    </div>
  </body>
</html>