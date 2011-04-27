<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>中间窗体</title>
<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/admin/css/middle.css" rel="stylesheet" type="text/css" />
<script src="<%=path %>/resources/js/jquery/jquery-1.4.3.js" type="text/javascript"></script>
<script type="text/javascript">
$().ready(function() {
	$(".main").click( function() {
		var mainFrameset = window.parent.window.document.getElementById("mainFrameset");
		if(mainFrameset.cols == "200,6,*") {
			mainFrameset.cols = "0,6,*";
			$(".main").removeClass("leftArrow");
			$(".main").addClass("rightArrow");
		} else {
			mainFrameset.cols = "200,6,*";
			$(".main").removeClass("rightArrow");
			$(".main").addClass("leftArrow");
		}
	})

})
</script>
</head>
<body class="middle">
	<div class="main leftArrow"></div>
</body>
</html>