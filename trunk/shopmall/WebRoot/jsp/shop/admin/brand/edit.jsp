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
		<h1><span class="icon">&nbsp;</span>系统管理->品牌管理</h1>
	</div>
	 <div class="box column-center">
		<div class="box-content form-table" style="display: block; ">				
				<form action="<%=path%>/shop/admin/brandInfo.xhtml?method=onEdit" class="validate" id="saveform" name="saveform" method="post">
					<input type="hidden" name=brandId id="brandId" value="${entity.brandId }"/>
						<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
						  <tbody>	
						  <tr>
						    <th nowrap>品牌名称</th>
							<td><input type="text" name="name" class="formText {required: true}" id="name" size="40" value="${entity.name }"></td>
						  </tr>		  
						  
						  <tr>
						    <th nowrap>排序号</th>
							<td><input type="text" name="orderNum" class="formTextSS {required: true,positiveInteger:true}" id="orderNum" size="40" value="${entity.orderNum }"></td>
						  </tr>
						  <tr>
						    <th nowrap>品牌描述</th>
							<td>
							<textarea name="introduction" class="wysiwyg"  style="width: 70%; height: 200px;">${entity.introduction }</textarea>
							</td>
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