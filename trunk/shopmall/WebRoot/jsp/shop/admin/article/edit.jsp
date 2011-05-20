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
		$('#isPublic').val('${entity.isPublic}');
		$('#isTop').val('${entity.isTop}');
		$('#isRecommend').val('${entity.isRecommend}');
		
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
				<form action="<%=path%>/shop/admin/article.xhtml?method=onEdit" class="validate" id="saveform" name="saveform" method="post">
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
							<td><input type="text" name="title" class="formTextLL {required: true}" id="title" value="${entity.title}"></td>
						  </tr>
						  <tr>
						    <th>内容</th>
							<td>							
							<textarea name="content" class="wysiwyg"  style="width: 80%; height: 250px;">${entity.content }</textarea></td>
						  </tr>
						  <tr>
						    <th>是否发布</th>
							<td>
							<select name="isPublic" id="isPublic" class="formText {required: true}">
								<option value="1">是</option>
								<option value="0">否</option>
							</select>
							</td>
						  </tr>
						  <tr>
						    <th>是否推荐</th>
							<td><select name="isTop" id="isTop" class="formText {required: true}">
								<option value="1">是</option>
								<option value="0">否</option>
							</select>
							</td>
						  </tr>
						  <tr>
						    <th>是否置顶</th>
							<td>
							<select name="isRecommend" id="isRecommend" class="formText {required: true}">
								<option value="1">是</option>
								<option value="0">否</option>
							</select>
							</td>
						  </tr>
						  <tr>
						    <th>排序号</th>
							<td><input type="text" name="orderNum" class="formTextSS {required: true,positiveInteger:true}" id="orderNum" value="${entity.orderNum}"></td>
						  </tr>
						  <tr>
						    <th>关键字</th>
							<td>
							<input type="text" name="metaKeyWord" class="formTextLL {required: true}" id="metaKeyWord" value="${entity.metaKeyWord}">
							<div class="userTip">关键字能更好的推广您的网站，请认真填写该项内容,多个关键字用空格分开</div>
							</td>
						  </tr>
						  <tr>
						    <th>页面描述</th>
							<td>
							<textarea name="shopDesc" class="formTextarea" id="shopDesc" style="width: 500px; height: 100px;">${entity.metaDesc }</textarea>
							<div class="userTip">页面描述能更好的推广您的网站，请认真填写该项内容</div>
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