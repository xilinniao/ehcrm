<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.util.Enumeration" %>
<title><%=projName %></title>

	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="${base}/template/admin/css/message.css" rel="stylesheet" type="text/css" />
	<%@include file="/jsp/shop/common/head.jsp"%>
	<script type="text/javascript">
	function gotoLogin(){
		top.window.location.href = "<%=path%>/front/shoplogin.xhtml?method=login";
	}
</script>
</head>
<body class="message">
<%
	String url = (String)request.getAttribute("redirectUrl");
	out.println("<form action='"+path+url+"' method='post' name='sf'>");
	Enumeration paramsNames = request.getAttributeNames();
	while (paramsNames.hasMoreElements()) { 
        String key = (String) paramsNames.nextElement();
        int idx = key.indexOf("param_");
        if(idx >-1) {
        	String value = (String)request.getAttribute(key);
        	out.println("<input type='hidden' name='"+key.substring(6)+"' value='"+value+"'/>");
        }
	}	
%>
	<div class="body">
		<div class="messageBox">
			<div class="boxTop">
				<div class="boxTitle">提示信息&nbsp;</div>
				<a class="boxClose windowClose" href="#" hidefocus="true"></a>
			</div>
			<div class="boxMiddle">
				<div class="messageContent">
					<span class="icon success">&nbsp;</span>
					<span class="messageText">
						登录超时,请重新登录!
					</span>
				</div>
				<input type="button" class="formButton" value="重新登录" onclick="gotoLogin()" hidefocus="true" />
			</div>
			<div class="boxBottom"></div>
		</div>
	</div>
</body>
</html>