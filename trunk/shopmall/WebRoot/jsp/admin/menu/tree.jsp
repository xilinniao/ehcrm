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
    <script type="text/javascript">
	<!--
	var saveform_validator;
	$(document).ready(function(){
		$("#msg_info").hide();
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
				$('#btnAddSame').hide();
				$('#btnSave').hide();
			}else{
				$('#btnAddSame').show();
				$('#btnSave').show();
			}
			$('#mainContent').mask("loading...");
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
			$("#msg_info").hide();
			$('#mainContent').unmask();
		});
		
		//加载验证框架
		saveform_validator = $('#saveform').validate({
			rules: {
				menuName:{
					required:true
				},
				resType:{
					required:true
				},
				sortNum:{
					required:true,
					digits:true
				}				
			},
			messages: {
				menuName:{
					required:"请填写菜单名称"
				},
				resType:{
					required:"请选择菜单类型"
				},
				sortNum:{
					required:"请输入排序号",
					digits:"请输入数字"
				}
			},
			focusInvalid: false,
			onkeyup: false,
			onsubmit: false,
			errorClass: "notification",
			validClass: "valid",
			errorElement: "span",
			errorPlacement: function(error, element) {
				error.appendTo( element.parent()); 
			}
		});
    	
    	$('#btnSave').click(function(){
    		//验证输入数据
    		if (saveform_validator.form()) {
	    		$('#mainContent').mask("正在保存数据,请稍候...");
					$('#saveform').ajaxSubmit({
						success:function(respText){
							if(respText=='OK'){
								$("#menu_tree").jstree("refresh");
							}else{
								alert('数据保存失败');
							}
							$("#msg_info").hide();
							$('#mainContent').unmask();							
						},
						error:function (xhr, ajaxOptions, thrownError){
							alert('xhr请求失败');
						}
					});
			}
    	});
    	
    	$('#parent_menu_select').click(function(){
			$.colorbox({
				href:'<%=path%>/admin/user.do?method=editUser&userId=-99&deptId=1',
				iframe:true,
				width:"500",
				height:"90%",
				onClosed:function(){alert('33');}
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
		<input type="button" class="addButton" onclick="location.href='product!add.action'" value="新增菜单">
	</div>
	
	<div class="box column-left">
		<h2 class="box-header">菜单列表</h2>
		<div class="box-content" id="menu_tree" style="display: block; "></div>
	</div>
	 <div class="box column-right">
		<h2 class="box-header">菜单详情</h2>
		<div class="box-content form-table" style="display: block; ">
			<div class="notification note-info" id="msg_info"></div>
			<form action="<%=path%>/admin/menu.do?method=onEditMenu" id="saveform" name="saveform" method="post">
						<input type="hidden" name="menuId" id="menuId"/>
						<input type="hidden" name="parentMenuId" id="parentMenuId" />
							<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
							  <tbody>
							  <tr>
							    <td class="right">上级菜单</td>
								<td class="left"><input type="text" name="parentMenuName" class="formText ro {required: true}" readonly id="parentMenuName" size="40">
								<input type="button" class="formButton" id="parent_menu_select" value="选择" hidefocus="true"/>
								</td>
							  </tr>
							  <tr>
							    <td width="24%" class="right">菜单名称</td>
								<td width="76%" class="left"><input type="text" name="menuName"  class="formText {required: true}" id="menuName" size="40"></td>
							  </tr>
							  <tr>
							    <td class="right">资源类型</td>
								<td class="left"><select name="resType" id="resType">
								  <option value="">请选择</option>
								  <option value="1">菜单</option>
								  <option value="2">权限资源</option>
								  </select>
								</td>
							  </tr>
							  <tr>
							    <td class="right">菜单地址</td>
							    <td class="left"><input type="text" name="menuUrl" class="formText" id="menuUrl" size="70"></td>
							  </tr>
							  <tr>
							    <td class="right">资源编码</td>
							    <td class="left"><input type="text" name="menuCode" class="formText" id="menuCode"></td>
							  </tr>
							  <tr>
							    <td class="right">排序号</td>
							    <td class="left"><input type="text" name="sortNum" class="formText {required: true}" id="sortNum" ></td>
							  </tr>
							  </tbody>
							</table>
							<div class="buttonArea">
								<input type="button" class="formButton" id="btnSave" value="保存" hidefocus="true"/>
						</div>
							
						</form>
    	</div>
    </div>
  </body>
</html>