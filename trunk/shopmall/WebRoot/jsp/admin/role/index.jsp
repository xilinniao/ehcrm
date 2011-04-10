<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

<%@include file="/common/headB.jsp"%>
	<link type="text/css" rel="stylesheet" href="<%=path %>/resources/js/plugin/jstree/themes/default/style.css">
	<LINK rel="stylesheet" href="<%=path %>/resources/js/plugin/colorbox.css" type="text/css">
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jquery.loadmask.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jquery.form.js"></script>
    <script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.cookie.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.jstree.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/validator/jquery.metadata.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/validator/jquery.validate.js"></script>
	<script language="javascript" src="<%=path %>/resources/js/plugin/jquery.colorbox.js"></script>
		
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
					"url" : "<%=path%>/admin/role.xhtml?method=getXmlTree"
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
				  url: '<%=path%>/admin/role.xhtml',
				  type: 'POST',
				  dataType:'json',
				  data: 'method=editRole&roleId='+data_id.substr(3),
				  success: function(data) {
				  	saveform_validator.resetForm();
					$('#roleId').val(data.roleId);
					$('#parentRoleId').val(data.parentRoleId);
					$('#parentRoleName').val(data.parentRoleName);
					$('#roleName').val(data.roleName);
					$('#roleDesc').val(data.roleDesc);
					$('#sortNum').val(data.sortNum);
				  }
			});
			$("#msg_info").hide();
			$('#mainContent').unmask();
		});
		
		//加载验证框架
		saveform_validator = $('#saveform').validate({
			rules: {
				roleName:{
					required:true
				}
			},
			messages: {
				menuName:{
					required:"请填写角色名称"
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
    	
    	$('#btnAddSame').click(function(){
    		$("#msg_info").html("<p><strong>当前操作:</strong>新增同级角色</p>");
    		$("#msg_info").show();
    		$('#saveform').clearForm();
    		var select_node = $("#menu_tree").jstree("get_selected");
    		var parent_node = $.jstree._reference("#menu_tree")._get_parent(select_node) 
    		var node_text = $("#menu_tree").jstree("get_text",select_node);
    		var parent_text = $("#menu_tree").jstree("get_text",parent_node);
    		$('#roleId').val('-99');
    		$('#parentMenuId').val(parent_node.attr("id").substr(3));
    		$('#parentMenuName').val(parent_text);
    	});
    	
    	$('#btnAddDown').click(function(){
    		$("#msg_info").html("<p><strong>当前操作:</strong>新增下级角色</p>");
    		$("#msg_info").show();
    		$('#saveform').clearForm();
    		var select_node = $("#menu_tree").jstree("get_selected");
    		var parent_node = $.jstree._reference("#menu_tree")._get_parent(select_node) 
    		var node_text = $("#menu_tree").jstree("get_text",select_node);
    		var parent_text = $("#menu_tree").jstree("get_text",parent_node);
    		$('#roleId').val('-99');
    		$('#parentMenuId').val(select_node.attr("id").substr(3));
    		$('#parentMenuName').val(node_text);
    	});
    	
    	$('#btnRolePriv').click(function(){
    		var select_node = $("#menu_tree").jstree("get_selected");
	    	$.colorbox({
				href:'<%=path%>/admin/role.xhtml?method=editRolePriv&roleId='+select_node.attr("id").substr(3),
				iframe:true,
				width:"500", 
				height:"80%"
			});
		});
	});
	
	//-->
	</script>
    <%@include file="/common/headC.jsp"%>
    <div class="head"><span class="home">系统管理</span><span class="arrow">角色管理</span></div>
    <div class="clear height_5"></div>
	<div class="box column-left">
		<h2 class="box-header">角色列表</h2>
		<div class="box-content" id="menu_tree" style="display: block; "></div>
	</div>
	 <div class="box column-right">
		<h2 class="box-header">角色详情</h2>
		<div class="box-content form-table" style="display: block; ">
			<div>
				<button id="btnAddDown"  class="classy"><span>新增下级角色</span></button>
				<button id="btnAddSame"  class="classy"><span>新增同级角色</span></button>
				<button id="btnSave" class="classy"><span>保存</span></button>
				<button id="btnRolePriv" class="classy"><span>权限设置</span></button>
			</div>
			<div class="notification note-info" id="msg_info"></div>
					<form action="<%=path%>/admin/role.xhtml?method=onEditRole" id="saveform" name="saveform" method="post">
							<input type="hidden" name="roleId" id="roleId" value=""/>
							<input type="hidden" name="parentRoleId" id="parentRoleId" value=""/>
							<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ext">
							  <tr>
							    <th colspan="2" class="left">角色信息</th>
							  </tr>
							
							  <tr>
							    <td class="right">上级角色</td>
								<td class="left"><input type="text" name="parentRoleName" class="ro" readonly id="parentRoleName" size="40"></td>
							  </tr>
							  <tr>
							    <td width="24%" class="right">角色名称</td>
								<td width="76%" class="left"><input type="text" name="roleName" id="roleName" size="40"></td>
							  </tr>
							  <tr>
							    <td class="right">角色描述</td>
							    <td class="left"><input type="text" name="roleDesc" id="roleDesc" size="40"></td>
							  </tr>
							  <tr>
							    <td class="right">排序号</td>
							    <td class="left"><input type="text" name="sortNum" id="sortNum" size="20"></td>
							  </tr>
							</table>
						</form>
    	</div>
    </div>
  </body>
</html>