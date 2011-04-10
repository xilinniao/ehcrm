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
		$("#dept_tree").jstree({
			"ui" : {
				"select_limit" : 2,
				"select_multiple_modifier" : "alt",
				"selected_parent_close" : "select_parent",
				"initially_select":['id_${rootId}']
			},
			"html_data" : {
				"ajax" : {
					"url" : "<%=path%>/admin/dept.xhtml?method=getXmlTree"
				}
			},
			"plugins" : [ "themes","ui","html_data"]
		}).bind("select_node.jstree", function(e, data) {
			var data_id = data.rslt.obj.attr("id");
			if(data_id=='id_${rootId}'){
				$('#btnAddSame').hide();
			}else{
				$('#btnAddSame').show();
			}
			$('#mainContent').mask("loading...");
			//更新右边的输入框
			$.ajax({
				  url: '<%=path%>/admin/dept.xhtml',
				  type: 'POST',
				  dataType:'json',
				  data: 'method=editDept&deptId='+data_id.substr(3),
				  success: function(data) {
				  	saveform_validator.resetForm();
				  	$('#deptId').val(data.deptId);
					$('#deptCode').val(data.deptCode);
					$('#deptName').val(data.deptName);
					$('#deptKind').val(data.deptKind);
					$('#deptStatus').val(data.deptStatus);
					$('#sortNum').val(data.sortNum);
					$('#adminId').val(data.adminId);
					$('#linkMan').val(data.linkMan);
					$('#linkTel').val(data.linkTel);
					$('#parentDeptId').val(data.parentDeptId);
					$('#parentDeptName').val(data.parentDeptName);
				  }
			});
			$("#msg_info").hide();
			$('#mainContent').unmask();
		});
		
		//加载验证框架
		saveform_validator = $('#saveform').validate({
			rules: {
				deptCode:{
					required:true
				},
				deptName:{
					required:true
				},
				deptKind:{
					required:true
				},
				deptStatus:{
					required:true
				},
				sortNum:{
					required:true
				}
			},
			messages: {
				deptCode:{
					required:"请输入机构编号"
				},
				deptName:{
					required:"请输入机构名称"
				},
				deptKind:{
					required:"请选择机构类别"
				},
				deptStatus:{
					required:"请选择机构状态"
				},
				sortNum:{
					required:"请输入排序号"
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
		
		$("#btn_refresh").click(function () {
        	$("#dept_tree").jstree("refresh");
    	});
    	
    	$('#btnSaveDept').click(function(){
    		//验证输入数据
    		if (saveform_validator.form()) {
	    		$('#mainContent').mask("正在保存数据,请稍候...");
					$('#saveform').ajaxSubmit({
						success:function(respText){
							if(respText=='OK'){
								$("#dept_tree").jstree("refresh");
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
    		$("#msg_info").html("<p><strong>当前操作:</strong>新增同级机构</p>");
    		$("#msg_info").show();
    		$('#saveform').clearForm();
    		var select_node = $("#dept_tree").jstree("get_selected");
    		var parent_node = $.jstree._reference("#dept_tree")._get_parent(select_node) 
    		var node_text = $("#dept_tree").jstree("get_text",select_node);
    		var parent_text = $("#dept_tree").jstree("get_text",parent_node);
    		$('#deptId').val('-99');
    		$('#parentDeptId').val(parent_node.attr("id").substr(3));
    		$('#parentDeptName').val(parent_text);
    	});
    	
    	$('#btnAddDown').click(function(){
    		$("#msg_info").html("<p><strong>当前操作:</strong>新增下级机构</p>");
    		$("#msg_info").show();
    		$('#saveform').clearForm();
    		var select_node = $("#dept_tree").jstree("get_selected");
    		var parent_node = $.jstree._reference("#dept_tree")._get_parent(select_node) 
    		var node_text = $("#dept_tree").jstree("get_text",select_node);
    		var parent_text = $("#dept_tree").jstree("get_text",parent_node);
    		$('#deptId').val('-99');
    		$('#parentDeptId').val(select_node.attr("id").substr(3));
    		$('#parentDeptName').val(node_text);
    	});
    	
    	
	});
	
	//-->
	</script>
    <%@include file="/common/headC.jsp"%>
    
    <div class="head"><span class="home">系统管理</span><span class="arrow">机构管理</span></div>
    
    <div class="clear height_5"></div>
	<div class="box column-left">
		<h2 class="box-header">机构列表<button id="btn_refresh" class="minibutton"><span>刷新</span></button></h2>
		<div class="box-content" id="dept_tree" style="display: block; "></div>
	</div>
    
    <div class="box column-right">
		<h2 class="box-header">机构信息</h2>
		<div class="box-content form-table" style="display: block; ">				
						<div>
						<button id="btnAddDown"  class="classy"><span>新增下级机构</span></button>
						<button id="btnAddSame"  class="classy"><span>新增同级机构</span></button>		
						<button id="btnSaveDept" class="classy"><span>保存</span></button>
						</div>
						 						
 						<div class="notification note-info" id="msg_info">							
						</div>
						<div id="table_form">
							<form action="<%=path%>/admin/dept.xhtml?method=onEditDept" id="saveform" name="saveform" method="post">
							<input type="hidden" name="deptId" id="deptId" />
							<input type="hidden" name="parentDeptId" id="parentDeptId" />
							<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ext">
							  <tr>
							    <th colspan="2" class="left">菜单信息</th>
							  </tr>
							  <tr>
							    <td class="right">上级部门</td>
							    <td class="left"><input type="text" name="parentDeptName" class="ro" readonly id="parentDeptName" size="30"></td>
							  </tr>
							  <tr>
							    <td width="24%" class="right">部门名称</td>
								<td width="76%" class="left"><input type="text" name="deptName" id="deptName" size="30">
								</td>
							  </tr>
							  <tr>
							    <td class="right">部门编号</td>
							    <td class="left"><input type="text" name="deptCode" id="deptCode" size="15" ></td>
							  </tr>
							  <tr>
							    <td class="right">部门性质</td>
							    <td class="left"><select name="deptKind" id="deptKind">
							      <option value="1">机构</option>
							      <option value="2">部门</option>
							    </select></td>
							  </tr>
							  
							  <tr>
							    <td class="right">联系人</td>
							    <td class="left"><input type="text" name="linkMan" id="linkMan" size="30"></td>
							  </tr>
							  <tr>
							    <td class="right">联系电话</td>
							    <td class="left"><input type="text" name="linkTel" id="linkTel" size="30"></td>
							  </tr>
							  
							  <tr>
							    <td class="right">排序号</td>
							    <td class="left"><input type="text" id="sortNum" name="sortNum"></td>
							  </tr>
							  
							  <tr>
							    <td class="right">是否禁用</td>
							    <td class="left"><select name="deptStatus" id="deptStatus">
							      <option value="0">有效</option>
							      <option value="1">禁用</option>
							    </select></td>
							  </tr>
							</table>
							</form>
						</div>			       
    	</div>
    </div>
  </body>
</html>