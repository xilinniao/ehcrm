<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/resources/admin/css/datatables.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
	<link type="text/css" rel="stylesheet" href="<%=path %>/resources/js/plugin/jstree/themes/default/style.css">
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.jstree.js"></script>
	<script src="<%=path %>/resources/common/js/base.js" type="text/javascript"></script>
    <script type="text/javascript">
	<!--
	var saveform_validator;
	$(document).ready(function(){
		$('#categoryId').val('-99');
		$('#btnDelete').hide();
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
				$('#saveform').ajaxSubmit({
					beforeSubmit:defaultBeforeSubmit,
					success:function(respText){
						if(respText=='OK'){
							alert('网站分类新增成功');
							location.href='siteCategory.xhtml?method=index';
						}else{
							alert('数据保存失败');
						}					
					},
					error:function (xhr, ajaxOptions, thrownError){
						alert('xhr请求失败');
					}
				});
			}
    	});
    	
    	$('#parent_category_select').click(function(){
			$.colorbox({
				href:'<%=path%>/shop/admin/siteCategory.xhtml?method=selectCategory',
				iframe:true,
				width:"500",
				height:"90%"
			});
    	});
	});
	
	//-->
	</script>

  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>网站分类管理->新增网站分类</h1>
	</div>
	 <div class="box column-center">
		<div class="box-content form-table" style="display: block; ">
			<%@include file="/jsp/shop/admin/site_category/form.jsp"%>
    	</div>
    </div>
  </body>
</html>