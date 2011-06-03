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
    		if (saveform_validator.form()) {
				if(confirm('确认审批通过吗？')){
	    			$('#applyStatus').val('21');
	    			$('#saveform').submit();
    			}
			}
    	});
    	
    	$('#btnSubmitApply').click(function(){
    		if (saveform_validator.form()) {
   				$('#applyStatus').val('20');
   				$('#saveform').submit();
			}
    	});
	});
	
	//-->
	</script>

  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>店铺设置->${title }</h1>
	</div>
	 <div class="box column-center">
		<div class="box-content form-table" style="display: block; ">
				<form action="tuanApply.xhtml?method=onApply" class="validate" id="saveform" name="saveform" method="post">
					<input type="hidden" name="applyId" class="formText {required: true}" id="applyId" value="${entity.applyId}">
					<input type="hidden" name="applyStatus" id="applyStatus" value="">						
						<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
						  <tbody>
							<tr>
								<th>团购名称</th>
								<td>${entity.topicName}</td>
							</tr>
							<tr>
								<th>团购图片</th>
								<td>${entity.faceImageId}</td>
							</tr>							
							<tr>
								<th>团购起止日期</th>
								<td>${entity.beginDateStr}-${entity.endDateStr}</td>
							</tr>
							<tr>
								<th>联系电话</th>
								<td>${entity.linkTel}</td>
							</tr>							
							<tr>
								<th>联系QQ</th>
								<td>${entity.linkQq}</td>
							</tr>							
							<tr>
								<th>价格</th>
								<td>${entity.priceStr}</td>
							</tr>
							<tr>
								<th>折扣价格</th>
								<td>${entity.discountPriceStr}</td>
							</tr>
							<tr>
								<th>最大团购数量</th>
								<td>${entity.maxQty}</td>
							</tr>
							<tr>
								<th>团购须知</th>
								<td>${entity.ext.rules }</td>
							</tr>
							<tr>
								<th>团购内容</th>
								<td>
								<div style="width:500px;">
								${entity.ext.topicContent }
								</div></td>
							</tr>
							<tr>
								<th>团购内容</th>
								<td><textarea name="applyResult" class="formTextarea {required: true}" id="applyResult" style="width: 500px; height: 100px;">${entity.applyResult }</textarea></td>
							</tr>
						  </tbody>
						</table>
						<div class="buttonArea">
							<c:if test="${entity.applyStatus==1 || entity.applyStatus==21 }">
							<input type="button" name="save" class="formButtonSubmit" id="btnSave" value="审批通过" hidefocus="true"/>
							<input type="button" name="submitApply" class="formButtonSubmit" id="btnSubmitApply" value="不通过" hidefocus="true"/>
							</c:if>
							<input type="button" name="back" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus="true" />
						</div>
					</form>
						
    	</div>
    </div>
  </body>
</html>