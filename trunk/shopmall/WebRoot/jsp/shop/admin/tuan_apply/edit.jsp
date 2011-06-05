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
		$('#id_upload_ajax_tip').hide();
		if($('#id_face_image').attr("src")==''){
			$('#id_face_image').attr("src",'<%=path%>/resources/admin/images/noimage.jpg');
		}
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
    			$('#applySt').val('0');
    			$('#saveform').submit();
			}
    	});
    	
    	$('#btnSubmitApply').click(function(){
    		//验证输入数据
    		if (saveform_validator.form()) {
    			if(confirm('申请信息准确无误，确认提交审批?')){
    				$('#applySt').val('1');
    				$('#saveform').submit();
    			}
			}
    	});
    	
    	$('#uploadButton').click(function(){
			if ($("#upload").val() != "") {
				$("#uploadButton").ajaxStart(function() {
					$(this).attr("disabled", true);
					$('#id_upload_ajax_tip').show();
				}).ajaxComplete(function() {
					$(this).attr("disabled", false);
					$('#id_upload_ajax_tip').hide();
				});
				$.ajaxFileUpload({
					url: "<%=path%>/upload.xhtml?method=image&zoom=true",
					secureuri: false,
					dataType: "json",
					fileElementId: "upload",
					success: function (data) {
						if(data.status == "error") {
							alert(data.message);
							return false;
						}
						if (data.status == "success") {
							$('#id_face_image').attr("src",data.urld);
							$('#faceImageid').val(data.imgid);
						}
					}
				})
				return false;
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
				<form action="tuanApply.xhtml?method=onEdit" class="validate" id="saveform" name="saveform" method="post">
					<input type="hidden" name="applyId" class="formText {required: true}" id="applyId" value="${entity.applyId}">
					<input type="hidden" name="applySt" id="applySt" value="">	
						<div class="userTipTitle">亲爱的朋友，欢迎您将优质产品加入我们的团购，请仔细填写你的团购申请。对于您的申请，我们将仔细审核，并将在一个工作日内给你准确的答复！</div>						
						<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
						  <tbody>
							<tr>
								<th>团购名称</th>
								<td><input type="text" name="topicName" class="formTextLL {required: true}" id="topicName" value="${entity.topicName}"></td>
							</tr>
							<tr>
								<th>团购封面图片</th>
								<td>
								<div>
								<img id="id_face_image" src="${entity.faceImage.filePathD}" width="160" height="160"/>
								</div>
								<input type="hidden" name="faceImageid" class="formText {required: true}" id="faceImageid" value="${entity.faceImage.recId}">								
																
								<input type="file" id="upload" name="upload" />
								<input type="button" id="uploadButton" class="formButtonSubmit" value="上传"/>
								<span id="id_upload_ajax_tip" class="ajaxtip">正在上传团购封面,请稍候...</span>
								
								<div class="userTip">团购页封面图片，只能上传一张</div>
								</td>
							</tr>							
							<tr>
								<th>团购起止日期</th>
								<td>
								<input type="text" name="beginDate" class="formTextS {required: true,dateISO:true}" id="beginDate" value="${entity.beginDateStr}"> - 
								<input type="text" name="endDate" class="formTextS {required: true,dateISO:true}" id="endDate" value="${entity.endDateStr}">
								<div class="userTip">团购日期范围不能超过三天，超过三天的需在团购须知中进行说明,日期格式为：2011-01-01</div>
								</td>
							</tr>
							<tr>
								<th>联系电话</th>
								<td><input type="text" name="linkTel" class="formText {required: true}" id="linkTel" value="${entity.linkTel}"></td>
							</tr>							
							<tr>
								<th>联系QQ</th>
								<td><input type="text" name="linkQq" class="formText {required: true}" id="linkQq" value="${entity.linkQq}"></td>
							</tr>
							<tr>
								<th>价格</th>
								<td><input type="text" name="price" class="formTextS {required: true,number:true}" id="price" value="${entity.priceBlank}">元</td>
							</tr>
							<tr>
								<th>折扣价格</th>
								<td><input type="text" name="discountPrice" class="formTextS {required: true}" id="discountPrice" value="${entity.discountPriceBlank}">元</td>
							</tr>
							<tr>
								<th>最大团购数量</th>
								<td><input type="text" name="maxQty" class="formTextS {required: true,positiveInteger:true}" id="maxQty" value="${entity.maxQty}">个</td>
							</tr>
							<tr>
								<th>团购须知</th>
								<td>
									<textarea name="rules" class="formTextarea {required: true}" id="rules" style="width: 500px; height: 100px;">${entity.ext.rules }</textarea>
								</td>
							</tr>							
							<tr>
								<th>团购内容</th>
								<td>
									<textarea name="topicContent" class="wysiwyg" id="topicContent" style="width: 100%; height: 400px;">${entity.ext.topicContent }</textarea>
									<div class="userTip">团购内容尽量描述仔细</div>
								</td>
							</tr>						
						  </tbody>
						</table>
						
						<c:if test="${entity.applyStatus == 20 || entity.applyStatus == 21}">
						<div class="userTipTitle">${entity.applyStatusStr},管理员备注如下:<br/>${entity.applyResult }</div>
						</c:if>
						<div class="buttonArea">
							<c:if test="${entity.applyStatus==0 || entity.applyStatus==20 }">
							<input type="button" name="save" class="formButtonSubmit" id="btnSave" value="保 存" hidefocus="true"/>
							<input type="button" name="submitApply" class="formButtonSubmit" id="btnSubmitApply" value="提交审批" hidefocus="true"/>
							</c:if>
							<input type="button" name="back" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus="true" />
						</div>
					</form>
						
    	</div>
    </div>
  </body>
</html>