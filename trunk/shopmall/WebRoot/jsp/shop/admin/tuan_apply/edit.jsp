<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css">
	<link type="text/css" rel="stylesheet" href="<%=path %>/resources/js/plugin/datepicker/date_input.css">	
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
		
		$("#beginDate").date_input();
    	$("#endDate").date_input();
    	
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
				<form action="tuanApply.xhtml?method=onEdit" class="validate" id="saveform" name="saveform" method="post">
					<input type="hidden" name="applyId" class="formText {required: true}" id="applyId" value="${entity.applyId}">
						<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
						  <tbody>
							<tr>
								<th>店铺名称</th>
								<td><input type="text" name="shopId" class="formText {required: true}" id="shopId" value="${entity.shopId}"></td>
							</tr>
							<tr>
								<th>团购名称</th>
								<td><input type="text" name="topicName" class="formTextLL {required: true}" id="topicName" value="${entity.topicName}"></td>
							</tr>
							<tr>
								<th>团购图片</th>
								<td><input type="text" name="faceImageId" class="formText {required: true}" id="faceImageId" value="${entity.faceImageId}">
								<div class="userTip">团购页封面图片，只能上传一张...</div>
								</td>
							</tr>							
							<tr>
								<th>团购起止日期</th>
								<td>
								<input type="text" name="beginDate" class="formTextS {required: true,dateISO:true}" id="beginDate" value="${entity.beginDateStr}"> - 
								<input type="text" name="endDate" class="formTextS {required: true,dateISO:true}" id="endDate" value="${entity.endDateStr}">
								<div class="userTip">团购日期范围不能超过三天，超过三天的需在备注中进行说明</div>
								</td>
							</tr>
							<tr>
								<th>价格</th>
								<td><input type="text" name="price" class="formTextS {required: true,number:true}" id="price" value="${entity.priceStr}"></td>
							</tr>
							<tr>
								<th>折扣价格</th>
								<td><input type="text" name="discountPrice" class="formText {required: true}" id="discountPrice" value="${entity.discountPriceStr}"></td>
							</tr>
							<tr>
								<th>最大团购数量</th>
								<td><input type="text" name="maxQty" class="formText {required: true,positiveInteger:true}" id="maxQty" value="${entity.maxQty}"></td>
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