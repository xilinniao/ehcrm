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
	var mainTable;
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
			if(mainTable=='undefined'||mainTable==null){
				mainTable = $('#id_mainTable').dataTable({
					"bAutoWidth" : false,
			 		"bProcessing": true,
			 		"bServerSide": true,
			 		"bSort":false,
			 		"bFilter":false,
			 		"bInfo": true,
					"oLanguage":oLanguage_cn,
					"sPaginationType": "full_numbers",
					"sAjaxSource": "<%=path%>/shop/admin/goodsInfo.xhtml?method=goodsList",
					"fnServerData": function ( sSource, aoData, fnCallback ) {
						var select_node = $("#goodscat_tree").jstree("get_selected");
						aoData.push( { "name": "categoryId","value": select_node.attr("id").substr(3)} );						
						$.ajax( {
							"dataType": 'json',
							"type": "POST", 
							"url": sSource,
							"data": aoData, 
							"success": fnCallback
						} );
					}
				});
			}else{
			 	mainTable.fnDraw();
			}
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
    	
    	$('#getProductByCategory').click(function(){
    		var select_node = $("#goodscat_tree").jstree("get_selected");
    		var categoryId = select_node.attr("id").substr(3);
    		document.location.href='goodscat.xhtml?method=getProductByCategory&categoryId='+categoryId;
    	});
	});
	
	
	//-->
	</script>

  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>商品管理</h1>
	</div>
	<div class="operateBar">
		<input type="button" class="addButton" onclick="location.href='goodsInfo.xhtml?method=add'" value="新增商品">
		<input type="button" class="addButton" id="getProductByCategory" value="京东商品">
	</div>
	
	<div class="box column-left-20">
		<h2 class="box-header">商品分类列表</h2>
		<div class="box-content min-height-500" id="goodscat_tree" style="display: block; "></div>
	</div>
	<div class="box column-right-80">
		<h2 class="box-header">商品信息查询</h2>
		<div class="box-content padding-zero" style="display: block; ">
			<table class="display stylized" id="id_mainTable">
				<thead class="table-header">
					<tr>
							<th><input type="checkbox"></th>
						    <th nowrap>商品名称</th>
						    <th nowrap>商品编号</th>
						    <th nowrap>所属分类</th>
						    <th nowrap>市场价</th>
						    <th nowrap>商城价</th>
						    <th nowrap>热卖</th>
						    <th nowrap>新品</th>
						    <th nowrap>库存</th>
						    <th nowrap>操作</th>
					</tr>
				</thead>							
			</table>
		</div>
    </div>
  </body>
</html>