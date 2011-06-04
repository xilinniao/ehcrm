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
		$("#${moduleName}_tree").jstree({
			"ui" : {
				"select_limit" : 2,
				"select_multiple_modifier" : "alt",
				"selected_parent_close" : "select_parent",
				"initially_select":['id_${r"${rootId}"}']
			},
			"html_data" : {
				"ajax" : {
					"url" : "<%=path%>/${url}?method=getXmlTree"
				}
			},
			"plugins" : [ "themes","ui","html_data"]
		}).bind("select_node.jstree", function(e, data) {
			var data_id = data.rslt.obj.attr("id");
			if(data_id=='id_${r"{rootId}"}'){
				$('#parent_${moduleName}_select').hide();
				$('#btnSave').hide();
				$('#btnDelete').hide();
			}else{
				$('#parent_${moduleName}_select').show();
				$('#btnSave').show();
				$('#btnDelete').show();
			}
			//更新右边的输入框
			$.ajax({
				  url: '<%=path%>/${url}',
				  type: 'POST',
				  dataType:'json',
				  data: 'method=edit${moduleName?cap_first}&${moduleName}Id='+data_id.substr(3),
				  success: function(data) {
				  	saveform_validator.resetForm();
				  	$('#${moduleName}Id').val(data.${moduleName}Id);
					$('#parent${moduleName?cap_first}Id').val(data.parent${moduleName?cap_first}Id);
					$('#parent${moduleName?cap_first}Name').val(data.parent${moduleName?cap_first}Name);
					$('#${moduleName}Code').val(data.${moduleName}Code);
					$('#${moduleName}Name').val(data.${moduleName}Name);
					$('#${moduleName}Url').val(data.${moduleName}Url);
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
							$("#${moduleName}_tree").jstree("refresh");
						}else{
							alert('操作失败');
						}
					},
					error:defaultErrorHandler
				});
			}
    	});
    	
    	$('#btnDelete').click(function(){
    		if(confirm('是否删除该${moduleNameChn}?')){
	    		$.ajax({
					  url: '<%=path%>/${url}',
					  type: 'POST',
					  dataType:'text',
					  data: 'method=delete${moduleName?cap_first}&${moduleName}Id='+$('#${moduleName}Id').val(),
					  success: function(respText) {
						  	if(respText=='OK'){
								alert('${moduleNameChn}删除成功！');
								$("#${moduleName}_tree").jstree("refresh");
							}else if(respText=='EER01'){
								alert('操作失败：请先删除该${moduleNameChn}下子${moduleNameChn}');
							}else{
								alert('操作失败');
							}
					  },
					  error:defaultErrorHandler
				});
			}
    	});
    	
    	$('#parent_${moduleName}_select').click(function(){
			$.colorbox({
				href:'<%=path%>/${url}?method=select${moduleName?cap_first}',
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
		<h1><span class="icon">&nbsp;</span>系统管理->${moduleNameChn}管理</h1>
	</div>
	<div class="operateBar">
		<input type="button" class="addButton" onclick="location.href='${moduleName}.do?method=add${moduleName?cap_first}'" value="新增${moduleNameChn}">
	</div>
	
	<div class="box column-left">
		<h2 class="box-header">${moduleNameChn}列表</h2>
		<div class="box-content" id="${moduleName}_tree" style="display: block; "></div>
	</div>
	 <div class="box column-right">
		<h2 class="box-header">${moduleNameChn}详情</h2>
		<div class="box-content form-table" style="display: block; ">
			<%@include file="${jspfilepath}/form.jsp"%>
    	</div>
    </div>
  </body>
</html>