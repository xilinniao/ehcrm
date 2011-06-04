<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

<%@include file="/common/headB.jsp"%>
	<link type="text/css" rel="stylesheet" href="<%=path %>/resources/js/plugin/jstree/themes/default/style.css">
	<link type="text/css" rel="stylesheet" href="<%=path %>/resources/js/plugin/datepicker/date_input.css">
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jquery.loadmask.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jquery.form.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/validator/jquery.metadata.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/validator/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/datepicker/jquery.date_input.js"></script>
	
		
    <script type="text/javascript">
	<!--
	var saveform_validator;
	$(document).ready(function(){
		$("#birthday").date_input();
		$("#status").val('${entity.status}');
		$("#sex").val('${entity.sex}');
		
		//加载验证框架
		saveform_validator = $('#saveform').validate({
			rules: {
				userCode:{
					required:true,
					remote: "<%=path%>/admin/user.do?method=checkUserExists"
				},
				loginPwd:{
					required:true
				},
				userName:{
					required:true
				},
				sex:{
					required:true
				},
				birthday:{
				}
			},
			messages: {
				userCode:{
					required:"请输入用户编号",
					remote:"用户名已存在，请重新输入"
				},
				loginPwd:{
					required:"请输入登录密码"
				},
				userName:{
					required:"请输入用户名称"
				},
				sex:{
					required:"请选择用户性别"
				},
				birthday:{

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
		
		$('#btnSaveUser').click(function(){
    		//验证输入数据
    		if (saveform_validator.form()) {
    				$('body').mask("正在保存数据,请稍候...");
					$('#saveform').ajaxSubmit({
						success:function(respText) {
						 	if(respText=='OK'){
								$('body').unmask();
								$("#msg_info").html("<p>用户信息保存成功</p>").show();
								<c:if test="${entity.userId==-99}">
									$('#btnSaveUser').hide();
									$("#msg_info").html("<p>用户新增成功</p>").show();
								</c:if>
							}else{
								$('body').unmask();
								alert('数据保存失败');	
							}
						},
						error:ajaxError
					});
			}
    	});
    	$("#msg_info").hide();
	});
	//-->
	</script>
    <%@include file="/common/headC.jsp"%>
    
    <div class="box">
		<h2 class="box-header">人员资料</h2>		
		<div class="box-content form-table">
		<div class="notification note-info" id="msg_info"></div>	
		<div><button id="btnSaveUser" class="classy"><span>保存</span></button></div>
		<form action="<%=path%>/admin/user.do?method=onEditUser" id="saveform" name="saveform" method="post">
			<input type="hidden" name="userId" id="userId" value="${entity.userId }"/>
			<input type="hidden" name="deptId" id="deptId" value="${entity.dept.deptId }"/>
	  
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ext">
			  <tr>
			    <td class="body-l">所属部门</td>
			    <td class="body-l"><input type="text" class="ro" readonly size="30" value="${entity.dept.deptName }"></td>
			  </tr>
			  <c:choose>
			  <c:when test="${entity.userId==-99}">
			  <tr>
			    <td width="24%" class="body-l">用户编号</td>
				<td width="76%" class="body-l"><input name="userCode" type="text" id="userCode" size="30" value="${entity.userCode }"></td>
			  </tr>			  
			  <tr>
			    <td class="body-l">密码</td>
			    <td class="body-l"><input name="loginPwd" type="password" id="loginPwd" size="20" value=""></td>
			  </tr>
			  </c:when>
			  <c:otherwise>
			  <tr>
			    <td width="24%" class="body-l">用户编号</td>
				<td width="76%" class="body-l"><input name="userCodeRo" type="text" id="userCodeRo" class="ro" readonly size="30" value="${entity.userCode }"></td>
			  </tr>
			  </c:otherwise>
			  </c:choose>
			  <tr>
			    <td class="body-l">用户名称</td>
			    <td class="body-l"><input name="userName" type="text" id="userName" size="30" value="${entity.userName }"></td>
			  </tr>
			  <tr>
			    <td class="body-l">性别</td>
			    <td class="body-l"><select name="sex" id="sex">
			      <option value="">请选择</option>
			      <option value="1">男</option>
			      <option value="2">女</option>
			    </select>    </td>
			  </tr>
			  <tr>
			    <td class="body-l">生日</td>
			    <td class="body-l"><input name="birthday" type="text" id="birthday" size="12" value="${entity.birthdayStr }"></td>
			  </tr>
			  <tr>
			    <td class="body-l">职位</td>
			    <td class="body-l"><input name="job" type="text" id="job" size="30" value="${entity.job }"></td>
			  </tr>
			  
			  <tr>
			    <td class="body-l">手机</td>
			    <td class="body-l"><input name="mobile" type="text" id="mobile" size="30" value="${entity.mobile }"></td>
			  </tr>
			  <tr>
			    <td class="body-l">电子邮箱</td>
			    <td class="body-l"><input name="email" type="text" id="email"" size="30" value="${entity.email }"></td>
			  </tr>
			  <tr>
			    <td class="body-l">学历</td>
			    <td class="body-l"><input name="edu" type="text" id="edu" value="${entity.edu }"></td>
			  </tr>
			  <tr>
			    <td class="body-l">毕业学校</td>
			    <td class="body-l"><input name="eduShcool" type="text" id="eduShcool" size="50" value="${entity.eduShcool }"></td>
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