<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/resources/admin/css/datatables.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
<link href="${base}/template/admin/css/message.css" rel="stylesheet" type="text/css" />
</head>
<body class="message">
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
								<c:forEach items="${errorMessages}" var="b">
								${b }<br>
								</c:forEach>
							</c:when>
							<c:otherwise>您的操作已成功!</c:otherwise>
						</c:choose>	
					</span>
				</div>
				<input type="button" class="formButton messageButton" <c:choose><c:when test="${redirectUrl!=null }">onclick="window.location.href='${redirectUrl}'"</c:when><c:otherwise>onclick="window.history.back(); return false;"</c:otherwise></c:choose>" value="确  定" hidefocus="true" />
			</div>
			<div class="boxBottom"></div>
		</div>
	</div>
</body>
</html>