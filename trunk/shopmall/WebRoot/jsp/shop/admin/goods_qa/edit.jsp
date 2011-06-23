<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css">
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
    		//验证输入数据
    		if (saveform_validator.form()) {
    			$('#saveform').submit();
			}
    	});
	});
	
	//-->
	</script>

  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>系统管理-></h1>
	</div>
	 <div class="box column-center">
		<div class="box-content form-table" style="display: block; ">				
				<form action="goodsQa.xhtml?method=onEdit" class="validate" id="saveform" name="saveform" method="post">
					<input type="hidden" name=articleId id="articleId" value="${entity.recId}"/>
						<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
						  <tbody>						 
						  
							<tr>
								<th></th>
								<td><input type="text" name="recId" class="formText {required: true}" id="recId" value="${entity.recId}"></td>
							</tr>
							<tr>
								<th>客户ID</th>
								<td><input type="text" name="custId" class="formText {required: true}" id="custId" value="${entity.custId}"></td>
							</tr>
							<tr>
								<th>商店ID</th>
								<td><input type="text" name="shopId" class="formText {required: true}" id="shopId" value="${entity.shopId}"></td>
							</tr>
							<tr>
								<th>所属商品</th>
								<td><input type="text" name="goodsId" class="formText {required: true}" id="goodsId" value="${entity.goodsId}"></td>
							</tr>
							<tr>
								<th>是否发布</th>
								<td><input type="text" name="isPublish" class="formText {required: true}" id="isPublish" value="${entity.isPublish}"></td>
							</tr>
							<tr>
								<th>咨询内容</th>
								<td><input type="text" name="question" class="formText {required: true}" id="question" value="${entity.question}"></td>
							</tr>
							<tr>
								<th>店铺回答</th>
								<td><input type="text" name="answer" class="formText {required: true}" id="answer" value="${entity.answer}"></td>
							</tr>
							<tr>
								<th>提问时间</th>
								<td><input type="text" name="createTime" class="formText {required: true}" id="createTime" value="${entity.createTime}"></td>
							</tr>
							<tr>
								<th>回答时间</th>
								<td><input type="text" name="answerTime" class="formText {required: true}" id="answerTime" value="${entity.answerTime}"></td>
							</tr>
						  
						  </tbody>
						</table>
						<div class="buttonArea">
							<input type="button" class="formButtonSubmit" id="btnSave" value="保存" hidefocus="true"/>
							<input type="button" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus="true" />
						</div>
					</form>
						
    	</div>
    </div>
  </body>
</html>