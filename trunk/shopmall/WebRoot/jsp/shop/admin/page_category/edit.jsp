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
		$('#pageType').val('${entity.pageType.typeId}');
	
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
		<h1><span class="icon">&nbsp;</span>系统管理->首页分类管理->首页分类</h1>
	</div>
	 <div class="box column-center">
		<div class="box-content form-table" style="display: block; ">				
				<form action="<%=path%>/shop/admin/pageCategory.do?method=onEdit" class="validate" id="saveform" name="saveform" method="post">
					<input type="hidden" name=categoryId id="categoryId" value="${entity.categoryId}"/>
						<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
						  <tbody>
						  <c:if test="${pageTypeList!=null}">
						  <tr>
						    <th>所属页面</th>
							<td>
							<select name="pageType" id="pageType" class="{required: true}">
							<option value="">请选择</option>
							<c:forEach items="${pageTypeList}" var="b">
							<option value="${b.typeId }">${b.typeName }</option>
							</c:forEach>
							</select>
						  </tr>
						  </c:if>
						  <tr>
						    <th>分类名称</th>
							<td><input type="text" name="categoryName" class="formText {required: true}" id="categoryName" size="40" value="${entity.categoryName}"></td>
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