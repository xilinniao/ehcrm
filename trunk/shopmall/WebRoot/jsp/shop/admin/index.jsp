<%@ page contentType="text/html; charset=utf-8"%>   
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName%>-店铺管理</title>
</head>
<frameset id="fset" name="fsetname" rows="61,*" cols="*" frameborder="NO" border="0" framespacing="0">
  <frame name="topFrame" scrolling="NO" noresize src="<%=path%>/front/shoplogin.xhtml?method=top" >
  <frameset cols="190,*" id="mainFrameset" frameborder="no" rows="*">
    <frame src="<%=path%>/front/shoplogin.xhtml?method=menu" name="leftFrame" marginwidth="0" marginheight="0">
    <frame src="<%=path%>front/shoplogin.xhtml?method=main" frameborder="no" scrolling="auto" noresize="noresize" name="mainFrame">
  </frameset>
  
</frameset>

<noframes>

<BODY>
<P>You Browse doesn't support frame!</P>
</BODY>
</noframes>

</html>