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
		
		$('#showNum').val('${entity.showNum}');
		$('#isShow').val('${entity.isShow}');
	});
	
	//-->
	</script>

  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>系统管理->首页分类</h1>
	</div>
	 <div class="box column-center">
		<div class="box-content form-table" style="display: block; ">				
				<form action="<%=path%>/shop/admin/indexCategory.xhtml?method=onEdit" class="validate" id="saveform" name="saveform" method="post">
					<input type="hidden" name=categoryId id="categoryId" value="${entity.categoryId }"/>
						<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
						  <tbody>	
						  <tr>
						    <th>分类名称</th>
							<td><input type="text" name="categoryName" class="formText {required: true}" id="categoryName" value="${entity.categoryName}"></td>
						  </tr>
						  <tr>
						    <th>排序号</th>
							<td><input type="text" name="orderNum" class="formTextSS {required: true,positiveInteger:true}" id="orderNum" value="${entity.orderNum}"></td>
						  </tr>
						  <tr>
						    <th>显示商品数量</th>
							<td>
							<select name="showNum" id="showNum" class="formSelectS {required: true}">
								<option value="5">5</option>
								<option value="10">10</option>
								<option value="15">15</option>
								<option value="20">20</option>
								<option value="25">25</option>
							</select>个</td>
						  </tr>
						  <tr>
						    <th>是否显示</th>
							<td>
							<select name="isShow" id="isShow" class="formSelectS {required: true}">
								<option value="0">显示</option>
								<option value="1">隐藏</option>
							</select></td>
						  </tr>
						  </tbody>
						</table>
						<div class="buttonArea">
							<input type="submit" class="formButtonSubmit" id="btnSave" value="保存" hidefocus="true"/>
							<input type="button" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus="true" />
						</div>
					</form>
						
    	</div>
    </div>
  </body>
</html>