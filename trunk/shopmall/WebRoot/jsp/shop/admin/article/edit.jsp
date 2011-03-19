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
		$('#categoryId').val('${entity.category.categoryId}');
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
		<h1><span class="icon">&nbsp;</span>系统管理->文章管理->编辑文章</h1>
	</div>
	 <div class="box column-center">
		<div class="box-content form-table" style="display: block; ">				
				<form action="<%=path%>/shop/admin/article.do?method=onEdit" class="validate" id="saveform" name="saveform" method="post">
					<input type="hidden" name=articleId id="articleId" value="${entity.articleId}"/>
						<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
						  <tbody>						 
						  <tr>
						    <th>文章分类</th>
							<td>
							<select name="categoryId" id="categoryId"  class="{required: true}">
							<option value="">请选择</option>
							<c:forEach items="${categoryList}" var="b">
								<option value="${b.categoryId }">${b.categoryName }</option>
							</c:forEach>							
							</select>
							</td>
						  </tr>						  
						  <tr>
						    <th>标题</th>
							<td><input type="text" name="title" class="formTextLL {required: true}" id="title" size="40" value="${entity.title}"></td>
						  </tr>
						  <tr>
						    <th>内容</th>
							<td>							
							<textarea name="content" class="wysiwyg"  style="width: 80%; height: 250px;">${entity.content }</textarea></td>
						  </tr>
						  <tr>
						    <th>是否发布</th>
							<td><input type="text" name="isPublic" class="formText {required: true}" id="isPublic" size="40" value="${entity.isPublic}"></td>
						  </tr>
						  <tr>
						    <th>是否推荐</th>
							<td><input type="text" name="isTop" class="formText {required: true}" id="isTop" size="40" value="${entity.isTop}"></td>
						  </tr>
						  <tr>
						    <th>是否置顶</th>
							<td><input type="text" name="isRecommend" class="formText {required: true}" id="isRecommend" size="40" value="${entity.isRecommend}"></td>
						  </tr>
						  <tr>
						    <th>排序号</th>
							<td><input type="text" name="orderNum" class="formText {required: true}" id="orderNum" size="40" value="${entity.orderNum}"></td>
						  </tr>
						  <tr>
						    <th>关键字</th>
							<td><input type="text" name="metaKeyWord" class="formText {required: true}" id="metaKeyWord" size="40" value="${entity.metaKeyWord}"></td>
						  </tr>
						  <tr>
						    <th>页面描述</th>
							<td><input type="text" name="metaDesc" class="formText {required: true}" id="metaDesc" size="40" value="${entity.metaDesc}"></td>
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