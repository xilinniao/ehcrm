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
				<form action="goodsRemark.xhtml?method=onEdit" class="validate" id="saveform" name="saveform" method="post">
					<input type="hidden" name=articleId id="articleId" value="${entity.recId}"/>
						<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
						  <tbody>						 
						  
							<tr>
								<th></th>
								<td><input type="text" name="recId" class="formText {required: true}" id="recId" value="${entity.recId}"></td>
							</tr>
							<tr>
								<th>客户编号</th>
								<td><input type="text" name="custId" class="formText {required: true}" id="custId" value="${entity.custId}"></td>
							</tr>
							<tr>
								<th>客户名称</th>
								<td><input type="text" name="custName" class="formText {required: true}" id="custName" value="${entity.custName}"></td>
							</tr>
							<tr>
								<th>所属商品</th>
								<td><input type="text" name="goodsId" class="formText {required: true}" id="goodsId" value="${entity.goodsId}"></td>
							</tr>
							<tr>
								<th>客户评价</th>
								<td><input type="text" name="content" class="formText {required: true}" id="content" value="${entity.content}"></td>
							</tr>
							<tr>
								<th>描述相符得分</th>
								<td><input type="text" name="descSocre" class="formText {required: true}" id="descSocre" value="${entity.descSocre}"></td>
							</tr>
							<tr>
								<th>服务相符得分</th>
								<td><input type="text" name="serviceScore" class="formText {required: true}" id="serviceScore" value="${entity.serviceScore}"></td>
							</tr>
							<tr>
								<th>发货速度得分</th>
								<td><input type="text" name="speedScore" class="formText {required: true}" id="speedScore" value="${entity.speedScore}"></td>
							</tr>
							<tr>
								<th>评论时间</th>
								<td><input type="text" name="createTime" class="formText {required: true}" id="createTime" value="${entity.createTime}"></td>
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