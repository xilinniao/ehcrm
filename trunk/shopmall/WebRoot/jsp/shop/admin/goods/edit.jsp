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
	$(document).ready(function(){
		$('#brandId').val('${info.brandInfo.brandId}');
		$('#id_shop_category').val('${info.category.categoryId}');
		$('#isRecommend').val('${info.isRecommend}');
		$('#id_upload_ajax_tip').hide();
		
		
		//加载验证框架
		saveform_validator = $("form.validate").validate({
			errorClass: "validateError",
			ignore: ".ignoreValidate",
			focusInvalid: true,
			errorPlacement:defaultErrorPlacement,
			submitHandler:defaultSubmitHandler
		});
    	
    	/*$('#btnSave').click(function(){
    		if (saveform_validator.form()) {
				$('#saveform').submit();
			}
    	});*/
    	
    	$('#site_category_select').click(function(){
			$.colorbox({
				href:'<%=path%>/shop/admin/siteCategory.xhtml?method=selectCategory',
				iframe:true,
				width:"500",
				height:"90%"
			});
    	});
    	
    	$('#btnAddNewSub').click(function(){
    		var idx = $('#goods_sub').find('tbody > tr').size();
    		$('#goods_sub').find('tbody').append('<tr><td><input type="hidden" name="sub_id" id="sub_id_'+idx+'" value="">规格：<input type="text" name="goodsSubName" id="goodsSubName_'+idx+'" class="formTextS {required: true}">&nbsp;&nbsp;市场价：<input type="text" name="marketPrice" id="marketPrice_'+idx+'" class="formTextSS {required: true}">&nbsp;&nbsp;商城售价:<input type="text" name="discountPrice" id="discountPrice_'+idx+'" class="formTextSS {required: true}">&nbsp;&nbsp;库存:<input type="text" name="leavesCount" id="leavesCount_'+idx+'" class="formTextSS {required: true}" value="${b.leavesCount }"></td></tr>');
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
							$('#goods_images').prepend('<li><input type="hidden" name="imagesId" value="'+data.imagesId+'"/><img src="'+data.urld+'"></li>');
						}
					}
				})
				return false;
			}else{
				alert('请选择上传图片');
			}
		});
	});
	
	//-->
	</script>

  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>商品管理->商品信息设置</h1>
	</div>
	 <div class="box column-center">
		<div class="box-content form-table" style="display: block; ">
			<%@include file="/jsp/shop/admin/goods/form.jsp"%>
    	</div>
    </div>
  </body>
</html>