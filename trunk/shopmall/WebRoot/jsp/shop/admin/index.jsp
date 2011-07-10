<%@ page contentType="text/html; charset=utf-8"%>   
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName%>-店铺管理</title>
</head>


<frameset id="parentFrameset" rows="57,*" cols="*" frameborder="no" border="0" framespacing="0">
	<frame id="headerFrame" name="headerFrame" src="<%=path%>/front/shoplogin.xhtml?method=top" frameborder="no" scrolling="no" noresize="noresize" />
	<frameset id="mainFrameset" name="mainFrameset" cols="170,6,*" frameborder="no" border="0" framespacing="0">
		<frame id="menuFrame" name="menuFrame" src="<%=path%>/front/shoplogin.xhtml?method=menu" frameborder="no" scrolling="no" noresize="noresize" />
		<frame id="middleFrame" name="middleFrame" src="<%=path%>/front/shoplogin.xhtml?method=middle" frameborder="no" scrolling="no" noresize="noresize" />
		<frame id="mainFrame" name="mainFrame" src="<%=path%>/front/shoplogin.xhtml?method=main" frameborder="no" noresize="noresize" />
	</frameset>
</frameset>

<noframes>
	<body>
		noframes
	</body>
</noframes>

</html>
