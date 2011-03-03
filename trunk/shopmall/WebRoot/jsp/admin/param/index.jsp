<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

<%@include file="/common/headB.jsp"%>
	<link type="text/css" rel="stylesheet" href="<%=path %>/resources/js/plugin/jstree/themes/default/style.css">
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jquery.loadmask.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jquery.form.js"></script>
    <script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.cookie.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.jstree.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/validator/jquery.metadata.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/validator/jquery.validate.js"></script>
		
    <script type="text/javascript">
	<!--
	var saveform_validator;
	$(document).ready(function(){
		$("#msg_info").hide();
		$("#id_tree_div").jstree({
			"ui" : {
				"select_limit" : 2,
				"select_multiple_modifier" : "alt",
				"selected_parent_close" : "select_parent",
				"initially_select":['id_${rootId}']
			},
			"html_data" : {
				"ajax" : {
					"url" : "<%=path%>/admin/param.do?method=getXmlTree"
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
				  url: '<%=path%>/admin/param.do',
				  type: 'POST',
				  dataType:'json',
				  data: 'method=editParam&keyId='+data_id.substr(3),
				  success: function(data) {
				  	  saveform_validator.resetForm();
					  $('#keyId').val(data.keyId);
					  $('#parentKeyId').val(data.parentKeyId);
					  $('#parentKeyName').val(data.parentKeyName);
					  $('#keyCode').val(data.keyCode);
					  $('#keyName').val(data.keyName);
					  $('#isSystem').val(data.isSystem);
					  $('#keyStatus').val(data.keyStatus);
					  $('#orderNum').val(data.orderNum);
				  }
			});
			$("#msg_info").hide();
			$('#mainContent').unmask();
		});
		
		//加载验证框架
		saveform_validator = $('#saveform').validate({
			rules: {		
				  keyId:{
					required:true
				  },
				  keyCode:{
					required:true
				  },
				  keyName:{
					required:true
				  },
				  fatherId:{
					required:true
				  },
				  isSystem:{
					required:true
				  },
				  keyStatus:{
					required:true
				  },
				  orderNum:{
					required:true
				  },
			},
			messages: {
				  keyId:{
					required:"请填写KEY编号"		
				  },
				  keyCode:{
					required:"请填写参数编号"		
				  },
				  keyName:{
					required:"请填写参数名称"		
				  },
				  fatherId:{
					required:"请填写上级编号"		
				  },
				  isSystem:{
					required:"请填写系统参数"		
				  },
				  keyStatus:{
					required:"请填写参数状态"		
				  },
				  orderNum:{
					required:"请填写排序号"		
				  },
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
								$("#id_tree_div").jstree("refresh");
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
    		$("#msg_info").html("<p><strong>当前操作:</strong>新增同级参数</p>");
    		$("#msg_info").show();
    		$('#saveform').clearForm();
    		var select_node = $("#id_tree_div").jstree("get_selected");
    		var parent_node = $.jstree._reference("#id_tree_div")._get_parent(select_node) 
    		var node_text = $("#id_tree_div").jstree("get_text",select_node);
    		var parent_text = $("#id_tree_div").jstree("get_text",parent_node);
    		$('#keyId').val('-99');
    		$('#parentKeyId').val(parent_node.attr("id").substr(3));
    		$('#parentKeyName').val(parent_text);
    	});
    	
    	$('#btnAddDown').click(function(){
    		$("#msg_info").html("<p><strong>当前操作:</strong>新增下级参数</p>");
    		$("#msg_info").show();
    		$('#saveform').clearForm();
    		var select_node = $("#id_tree_div").jstree("get_selected");
    		var parent_node = $.jstree._reference("#id_tree_div")._get_parent(select_node) 
    		var node_text = $("#id_tree_div").jstree("get_text",select_node);
    		var parent_text = $("#id_tree_div").jstree("get_text",parent_node);
    		$('#keyId').val('-99');
    		$('#parentKeyId').val(select_node.attr("id").substr(3));
    		$('#parentKeyName').val(node_text);
    	});
	});
	
	//-->
	</script>
    <%@include file="/common/headC.jsp"%>
    <div class="head"><span class="home">系统管理</span><span class="arrow">参数管理</span></div>
    <div class="clear height_5"></div>
	<div class="box column-left">
		<h2 class="box-header">参数列表</h2>
		<div class="box-content" id="id_tree_div" style="display: block; "></div>
	</div>
	 <div class="box column-right">
		<h2 class="box-header">参数详情</h2>
		<div class="box-content form-table" style="display: block; ">
			<div>
				<button id="btnAddDown"  class="classy"><span>新增下级参数</span></button>
				<button id="btnAddSame"  class="classy"><span>新增同级参数</span></button>
				<button id="btnSave" class="classy"><span>保存</span></button>
			</div>
			<div class="notification note-info" id="msg_info"></div>
			<form action="<%=path%>/admin/param.do?method=onEditParam" id="saveform" name="saveform" method="post">
						<input type="hidden" name="keyId" id="keyId" />
						<input type="hidden" name="parentKeyId" id="parentKeyId" />
							<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ext">
							  <tr>
							    <th colspan="2" class="left">参数信息</th>
							  </tr>
							   <tr>
							    <td class="right">所属参数</td>
							    <td class="left"><input type="text" class="ro" readonly name="parentKeyName" id="parentKeyName"></td>
							  </tr>
							  <tr>
							    <td class="right precent_20">参数编号</td>
							    <td class="left"><input type="text" name="keyCode" id="keyCode"></td>
							  </tr>
							  <tr>
							    <td class="right">参数名称</td>
							    <td class="left"><input type="text" name="keyName" id="keyName"></td>
							  </tr>
							  <tr>
							    <td class="right">系统参数</td>
							    <td class="left"><input type="text" name="isSystem" id="isSystem"></td>
							  </tr>
							  <tr>
							    <td class="right">参数状态</td>
							    <td class="left"><input type="text" name="keyStatus" id="keyStatus"></td>
							  </tr>
							  <tr>
							    <td class="right">排序号</td>
							    <td class="left"><input type="text" name="orderNum" id="orderNum"></td>
							  </tr>
							</table>
						</form>
    	</div>
    </div>
  </body>
</html>