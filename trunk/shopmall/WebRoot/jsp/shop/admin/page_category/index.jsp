<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<%@include file="/common/head.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>商品管理</title>
</head>
<frameset id="mainFrameset" name="mainFrameset" cols="200,6,*" frameborder="no" border="0" framespacing="0">
	<frame id="menuFrame" name="menuFrame" src="<%=path %>/shop/admin/pageCategory.xhtml?method=category" frameborder="no" scrolling="no" noresize="noresize" />
	<frame id="middleFrame" name="middleFrame" src="<%=path %>/shop/admin/goodsInfo.xhtml?method=middle" frameborder="no" scrolling="no" noresize="noresize" />
	<!-- 
	<frame id="rightFrame" name="rightFrame" src="" frameborder="no" noresize="noresize" />
	 -->
	<frameset rows="50%,50%" frameborder="yes" border="3" framespacing="3">
	  <frame name="rightFrame" id="rightFrame">
	  <frame name="rightBottomFrame">
	</frameset>
	
</frameset>
<noframes>
	<body>
		noframes
	</body>
</noframes>
</html>