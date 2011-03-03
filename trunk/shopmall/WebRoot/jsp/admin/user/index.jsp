<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

<link rel="stylesheet" type="text/css" href="<%=path %>/resources/js/plugin/colorbox.css" media="screen"/>
<%@include file="/common/headB.jsp"%>
	
	<link type="text/css" rel="stylesheet" href="<%=path %>/resources/jquery-ui.css">
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jquery.loadmask.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jquery.form.js"></script>
    <script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.cookie.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.jstree.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/validator/jquery.metadata.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/validator/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/datatables/jquery.dataTables.js"></script>
	<script language="javascript" src="<%=path %>/resources/js/plugin/jquery.colorbox.js"></script>
		
    <script type="text/javascript">
	<!--
	var saveform_validator;
	var userTable;
	$(document).ready(function(){
		$("#dept_tree").jstree({
			"ui" : {
				"initially_select":['id_${rootId}']
			},
			"html_data" : {
				"ajax" : {
					"url" : "<%=path%>/admin/dept.do?method=getXmlTree"
				}
			},
			"plugins" : [ "themes","ui","html_data"]
		}).bind("select_node.jstree", function(e, data) {
			$('#mainContent').mask("loading...");
			if(userTable=='undefined'||userTable==null){
				userTable = $('#tabledata').dataTable({
					"bAutoWidth" : false,
					"aoColumns": [
						{"sWidth": "16%"},
						{"sWidth": "12%"},
						{"sWidth": "12%"},
						{"sWidth": "6%"},
						{"sWidth": "12%"},
						{"sWidth": "12%"},
						{"sWidth": "8%"},
						{"sWidth": "14%"}
					],
			 		"bProcessing": true,
			 		"bServerSide": true,
			 		"bSort":false,
			 		"bFilter":false,			 		
					"bJQueryUI": true,
					"oLanguage":oLanguage_cn,
					"sPaginationType": "full_numbers",
					"sAjaxSource": "<%=path%>/admin/user.do?method=userList",
					"fnServerData": function ( sSource, aoData, fnCallback ) {
						var select_node = $("#dept_tree").jstree("get_selected");
						aoData.push( { "name": "deptId","value": select_node.attr("id").substr(3)} );
						aoData.push( { "name": "userCode","value":$('#userCode').val()} );
						aoData.push( { "name": "userName","value":$('#userName').val()} );
						
						$.ajax( {
							"dataType": 'json',
							"type": "POST", 
							"url": sSource,
							"data": aoData, 
							"success": fnCallback
						} );
					}
				});
				$("div.toolbar").html('Custom tool bar! Text/images etc.');
			}else{
			 	userTable.fnDraw();
			}
			$('#mainContent').unmask();
		});
		
		//处理查询
		$('#btnSubmit').click(function(){
			userTable.fnDraw();
		});
		
		$('#btnAddUser').click(function(){
    		var select_node = $("#dept_tree").jstree("get_selected");
			$.colorbox({
				href:'<%=path%>/admin/user.do?method=editUser&userId=-99&deptId='+select_node.attr("id").substr(3),
				iframe:true,
				width:"500",
				height:"90%",
				onClosed:function(){userTable.fnDraw();}
			});
    	});
	});	
	
	function editUser(userId){
		$.colorbox({
			href:'<%=path%>/admin/user.do?method=editUser&userId='+userId,
			iframe:true,
			width:"500",
			height:"90%",
			onClosed:function(){userTable.fnDraw();}
		});
	}
	
	function editUserPriv(userId){
		$.colorbox({
			href:'<%=path%>/admin/user.do?method=userApplyRoles&userId='+userId,
			iframe:true,
			width:"500",
			height:"90%"
		});
	}
	//-->
	</script>
    <%@include file="/common/headC.jsp"%>
    
    <div class="head"><span class="home">系统管理</span><span class="arrow">用户管理</span></div>
    		
   	<div class="clear height_5"></div>
	<div class="box column-left">
		<h2 class="box-header">机构列表</h2>
		<div class="box-content" id="dept_tree" style="display: block; "></div>
	</div>
	
	<div class="box column-right">
		<h2 class="box-header">人员列表</h2>
		<div class="box-content form-table" style="display: block; ">
			<div>
				<button id="btnAddUser" class="classy"><span>新增用户</span></button>
			</div>
			<div id="main_search">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ext">
					  <tr>
					    <th class="left">用户查询</th>
					  </tr>
					  <tr>
					    <td>用户编号：<input type="text" id="userCode" name="userCode" size="15">用户名称：<input type="text" id="userName" name="userName" size="15"><button id="btnSubmit" class="minibutton"><span>查询</span></button></td>
					  </tr>
					</table>
			</div>
			
			<div class="clear height_5"></div>
			
			<table class="display" id="tabledata">
				<thead class="table-header">
					<tr>
						    <th>所属部门</th>
						    <th>登录帐号</th>
						    <th>用户名称</th>
						    <th>性别</th>
						    <th>年龄</th>
						    <th>职位</th> 
						    <th>状态</th>   
						    <th>操作</th>
					</tr>
				</thead>							
			</table>
			
		</div>
	</div>
	
	
	<!-- DIV FORM -->
	<div style='display:none'>	
	<div id="id_user_form">
	<div>
		<button id="btnSaveUser" class="classy"><span>保存</span></button>
	</div>
	<form action="<%=path%>/admin/user.do?method=onEditUser" id="saveform" name="saveform" method="post">
		<input type="hidden" name="userId" id="userId"/>
		<input type="hidden" name="deptId" id="deptId"/>
  
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ext">
		  <tr>
		    <td class="body-l">所属部门</td>
		    <td class="body-l"><input type="text" name="deptName" class="ro" readonly id="deptName" size="30"></td>
		  </tr>
		  <tr>
		    <td width="24%" class="body-l">用户编号</td>
			<td width="76%" class="body-l"><input name="userCode" type="text" id="userCode" size="30"></td>
		  </tr>
		  <tr>
		    <td class="body-l">密码</td>
		    <td class="body-l"><input name="tmpLoginPwd" type="password" id="tmpLoginPwd" size="20"></td>
		  </tr>
		  <tr>
		    <td class="body-l">用户名称</td>
		    <td class="body-l"><input name="userName" type="text" id="userName" size="30"></td>
		  </tr>
		  <tr>
		    <td class="body-l">性别</td>
		    <td class="body-l"><select name="sex" id="sex">
		      <option value="1">男</option>
		      <option value="2">女</option>
		    </select>    </td>
		  </tr>
		  <tr>
		    <td class="body-l">生日</td>
		    <td class="body-l"><input name="birthday" type="text" id="birthday" size="12"><a href="#" id="trigger_birthday" class="dateSelectBtn"></a></td>
		  </tr>
		  <tr>
		    <td class="body-l">职位</td>
		    <td class="body-l"><input name="job" type="text" id="job" size="30"></td>
		  </tr>
		  
		  <tr>
		    <td class="body-l">手机</td>
		    <td class="body-l"><input name="mobile" type="text" id="mobile" size="30"></td>
		  </tr>
		  <tr>
		    <td class="body-l">电子邮箱</td>
		    <td class="body-l"><input name="email" type="text" id="email"" size="30"></td>
		  </tr>
		  <tr>
		    <td class="body-l">学历</td>
		    <td class="body-l"><input name="edu" type="text" id="edu"></td>
		  </tr>
		  <tr>
		    <td class="body-l">毕业学校</td>
		    <td class="body-l"><input name="eduShcool" type="text" id="eduShcool" size="50"></td>
		  </tr>
		  <tr>
		    <td class="body-r">是否禁用</td>
		    <td class="body-l"><select name="status" id="status">
		      <option value="0">有效</option>
		      <option value="1">禁用</option>
		    </select></td>
		  </tr>
		</table>
		<div class="clear height_5"></div>		
		</form>
		
	</div>
	</div>
	
  </body>
</html>