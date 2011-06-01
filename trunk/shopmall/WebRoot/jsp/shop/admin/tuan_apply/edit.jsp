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
				<form action="<%=path%>/shop/admin/article.xhtml?method=onEdit" class="validate" id="saveform" name="saveform" method="post">
					<input type="hidden" name=articleId id="articleId" value="${entity.applyId}"/>
						<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
						  <tbody>						 
						  
							<tr>
								<th>团购记录ID</th>
								<td><input type="text" name="entity.applyId" class="formText {required: true}" id="applyId" value="${entity.applyId}"></td>
							</tr>
							<tr>
								<th>店铺名称</th>
								<td><input type="text" name="entity.shopId" class="formText {required: true}" id="shopId" value="${entity.shopId}"></td>
							</tr>
							<tr>
								<th>团购图片</th>
								<td><input type="text" name="entity.faceImageId" class="formText {required: true}" id="faceImageId" value="${entity.faceImageId}"></td>
							</tr>
							<tr>
								<th>团购名称</th>
								<td><input type="text" name="entity.topicName" class="formText {required: true}" id="topicName" value="${entity.topicName}"></td>
							</tr>
							<tr>
								<th>团购开始日期</th>
								<td><input type="text" name="entity.beginDate" class="formText {required: true}" id="beginDate" value="${entity.beginDate}"></td>
							</tr>
							<tr>
								<th>团购结束日期</th>
								<td><input type="text" name="entity.endDate" class="formText {required: true}" id="endDate" value="${entity.endDate}"></td>
							</tr>
							<tr>
								<th>价格</th>
								<td><input type="text" name="entity.price" class="formText {required: true}" id="price" value="${entity.price}"></td>
							</tr>
							<tr>
								<th>折扣价格</th>
								<td><input type="text" name="entity.discountPrice" class="formText {required: true}" id="discountPrice" value="${entity.discountPrice}"></td>
							</tr>
							<tr>
								<th>最大团购数量</th>
								<td><input type="text" name="entity.maxQty" class="formText {required: true}" id="maxQty" value="${entity.maxQty}"></td>
							</tr>
							<tr>
								<th>当前数量</th>
								<td><input type="text" name="entity.currQty" class="formText {required: true}" id="currQty" value="${entity.currQty}"></td>
							</tr>
							<tr>
								<th>创建人</th>
								<td><input type="text" name="entity.createUser" class="formText {required: true}" id="createUser" value="${entity.createUser}"></td>
							</tr>
							<tr>
								<th>创建时间</th>
								<td><input type="text" name="entity.createTime" class="formText {required: true}" id="createTime" value="${entity.createTime}"></td>
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