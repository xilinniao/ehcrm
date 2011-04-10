<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>test</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/slide.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/product.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />

<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/jquery.easyslider.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.autocomplete.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/dialog.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
jQuery(document).ready(function() {
	//搜索自动补全
	var $goodsKeyword = $('#goodsKeyword');
	if($goodsKeyword.size()>0){
		$goodsKeyword.autocomplete({
			useCache:false,
			url:shop_constant.base+"/front/ajax.xhtml?method=autoSuggestSearch",
			showResult: function(value, data) {
	            return '<b>' + value + '</b>';
	        }
		});
	}
});
//-->
</script>
</head>

<body>
<p id="de"></p>
<input type="text" id="goodsKeyword" name="goodsKeyword" value="" autocomplete="off" onkeydown="javascript:if(event.keyCode==13) search('key');">

</body>
</html>