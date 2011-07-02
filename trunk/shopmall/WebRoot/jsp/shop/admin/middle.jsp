<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title></title>
<link href="<%=path %>/resources/common/css/reset.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/admin/css/header-shop.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
html, body {
	height: 100%;
	overflow: hidden;
}
-->
</style>
<script src="<%=path %>/resources/js/jquery/jquery-1.4.3.js" type="text/javascript"></script>
<script type="text/javascript">
$().ready(function() {

	var $main = $("#main");

	$main.click( function() {
		var mainFrameset = window.parent.window.document.getElementById("mainFrameset");
		if(mainFrameset.cols == "170,6,*") {
			mainFrameset.cols = "0,6,*";
			$main.removeClass("leftArrow");
			$main.addClass("rightArrow");
		} else {
			mainFrameset.cols = "170,6,*";
			$main.removeClass("rightArrow");
			$main.addClass("leftArrow");
		}
	})

})
</script>
</head><body class="middle">
	<div id="main" class="main leftArrow"></div>
</body>
</html>