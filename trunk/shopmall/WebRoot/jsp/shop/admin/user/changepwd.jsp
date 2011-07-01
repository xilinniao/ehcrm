<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/resources/admin/css/datatables.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
	<script src="<%=path %>/resources/common/js/base.js" type="text/javascript"></script>
    <script type="text/javascript">
	<!--
	var saveform_validator;
	$(document).ready(function(){
		//加载验证框架
		saveform_validator = $("form.validate").validate({
			errorClass: "validateError",
			ignore: ".ignoreValidate",
			errorPlacement:defaultErrorPlacement,
			submitHandler:defaultSubmitHandler			
		});
    	
    	$('#btnSave').click(function(){
    		if (saveform_validator.form()) {
    			$('#saveform').ajaxSubmit({
    				dataType: "json",
					success: function(data) {
						if (data.status == "success") {
							$.dialog({type: "success", content: data.message, width: 360, modal: true, ok:'确定'});
							$('#oldPwd').val('');
							$('#newPwd').val('');
							$('#newPwd2').val('');
						}else{
							$.dialog({type: "error", content: '操作失败:'+data.message, width: 360, modal: true,ok:'确定'});
						}
					},
					error:defaultErrorHandler
				});
			}
    	});
	});
	
	//-->
	</script>

  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>修改用户密码</h1>
	</div>
	 <div class="box column-center">
		<div class="box-content form-table" style="display: block; ">				
				<form action="<%=path %>/front/shoplogin.xhtml?method=onChangepwd" class="validate" id="saveform" name="saveform" method="post">
					<input type="hidden" name=brandId id="brandId" value="${entity.brandId }"/>
						<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
						  <tbody>	
						  <tr>
						    <th nowrap>登录帐号</th>
							<td>${userinfo.user.userCode}</td>
						  </tr>
						  <tr>
						    <th nowrap>用户昵称</th>
							<td><input type="text" name="userName" class="formText {required: true}" id="userName" size="40" value="${userinfo.user.userName}"></td>
						  </tr>
						 <tr>
						    <th nowrap>旧密码</th>
							<td><input type="password" name="oldPwd" class="formText {required: true,messages: {required:'请输入旧密码'}}" id="oldPwd" size="40" value=""></td>
						  </tr>
						  <tr>
						    <th nowrap>新密码</th>
							<td><input type="password" name="newPwd" class="formText {required: true,minlength: 5,messages: {required:'请输入新密码'}}" id="newPwd" size="40" value=""></td>
						  </tr>
						  <tr>
						    <th nowrap>确认新密码</th>
							<td><input type="password" name="newPwd2" class="formText {required: true,equalTo: '#newPwd',minlength: 5,messages: {required:'请输入确认密码',equalTo:'两次输入的新密码不一致,请重新输入！'}}" id="newPwd2" size="40" value=""></td>
						  </tr>
						  </tbody>
						</table>
						<div class="buttonArea">
							<input type="button" class="formButtonSubmit" id="btnSave" value="修   改" hidefocus="true"/>
						</div>
					</form>
						
    	</div>
    </div>
  </body>
</html>