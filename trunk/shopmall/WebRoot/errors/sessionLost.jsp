<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.util.Enumeration" %>
<title><%=projName %></title>

	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/resources/admin/css/datatables.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
<link href="${base}/template/admin/css/message.css" rel="stylesheet" type="text/css" />
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
						<c:choose>
							<c:when test="${errorMessages!=null}">
								${msgStr}
							</c:when>
							<c:otherwise>您的操作已成功!</c:otherwise>
						</c:choose>	
					</span>
				</div>
				<input type="submit" class="formButton" value="确  定" hidefocus="true" />
			</div>
			<div class="boxBottom"></div>
		</div>
	</div>
</body>
</html>