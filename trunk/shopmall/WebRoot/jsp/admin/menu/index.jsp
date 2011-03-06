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
		$("#menu_tree").jstree({
			"ui" : {
				"select_limit" : 2,
				"select_multiple_modifier" : "alt",
				"selected_parent_close" : "select_parent",
				"initially_select":['id_${rootId}']
			},
			"html_data" : {
				"ajax" : {
					"url" : "<%=path%>/admin/menu.do?method=getXmlTree"
				}
			},
			"plugins" : [ "themes","ui","html_data"]
		}).bind("select_node.jstree", function(e, data) {
			var data_id = data.rslt.obj.attr("id");
			if(data_id=='id_${rootId}'){
				$('#parent_menu_select').hide();
				$('#btnSave').hide();
				$('#btnDelete').hide();
			}else{
				$('#parent_menu_select').show();
				$('#btnSave').show();
				$('#btnDelete').show();
			}
			//更新右边的输入框
			$.ajax({
				  url: '<%=path%>/admin/menu.do',
				  type: 'POST',
				  dataType:'json',
				  data: 'method=editMenu&menuId='+data_id.substr(3),
				  success: function(data) {
				  	saveform_validator.resetForm();
				  	$('#menuId').val(data.menuId);
					$('#parentMenuId').val(data.parentMenuId);
					$('#parentMenuName').val(data.parentMenuName);
					$('#menuCode').val(data.menuCode);
					$('#menuName').val(data.menuName);
					$('#menuUrl').val(data.menuUrl);
					$('#resType').val(data.resType);
					$('#sortNum').val(data.sortNum);
					$('#status').val(data.status);
					$('#treeNo').val(data.treeNo);
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
							$("#menu_tree").jstree("refresh");
						}else{
							alert('操作失败');
						}
					},
					error:defaultErrorHandler
				});
			}
    	});
    	
    	$('#btnDelete').click(function(){
    		if(confirm('是否删除该菜单?')){
	    		$.ajax({
					  url: '<%=path%>/admin/menu.do',
					  type: 'POST',
					  dataType:'text',
					  data: 'method=deleteMenu&menuId='+$('#menuId').val(),
					  success: function(respText) {
						  	if(respText=='OK'){
								alert('菜单删除成功！');
								$("#menu_tree").jstree("refresh");
							}else if(respText=='EER01'){
								alert('操作失败：请先删除该菜单下子菜单');
							}else{
								alert('操作失败');
							}
					  },
					  error:defaultErrorHandler
				});
			}
    	});
    	
    	$('#parent_menu_select').click(function(){
			$.colorbox({
				href:'<%=path%>/admin/menu.do?method=selectMenu',
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
		<h1><span class="icon">&nbsp;</span>系统管理->菜单管理</h1>
	</div>
	<div class="operateBar">
		<input type="button" class="addButton" onclick="location.href='menu.do?method=addMenu'" value="新增菜单">
	</div>
	
	<div class="box column-left">
		<h2 class="box-header">菜单列表</h2>
		<div class="box-content" id="menu_tree" style="display: block; "></div>
	</div>
	 <div class="box column-right">
		<h2 class="box-header">菜单详情</h2>
		<div class="box-content form-table" style="display: block; ">
			<%@include file="/jsp/admin/menu/form.jsp"%>
    	</div>
    </div>
  </body>
</html>