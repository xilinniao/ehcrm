<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/cust_reg.css" rel="stylesheet" type="text/css" />
<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/jquery.tools.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.cookie.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=path %>/resources/front/js/jquery.metadata.js"></script>
<script type="text/javascript" src="<%=path %>/resources/front/js/jquery.validate.js"></script>
<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var  saveform_validator = $("#loginform").validate({
			 errorClass: "validateError",
            ignore: ".ignoreValidate",
            errorPlacement: function(error, element) {
                var messagePosition = element.metadata().messagePosition;
                if("undefined" != typeof messagePosition && messagePosition != "") {
                    var $messagePosition = $(messagePosition);
                    if ($messagePosition.size() > 0) {
                        error.insertAfter($messagePosition).fadeOut(300).fadeIn(300);
                    } else {
                        error.insertAfter(element).fadeOut(300).fadeIn(300);
                    }
                } else {
                    error.insertAfter(element).fadeOut(300).fadeIn(300);
                }
            },
            submitHandler: function(form) {
                $(form).find(":submit").attr("disabled", true);
                form.submit();
            }
		});
	});
</script>
</head>
<body id="index">
<%@include file="/jsp/shop/front/common/top.jsp"%>

<!-- 正文开始 -->
<div class="w main">
	
<div class="w" id="entry">
	<div class="mt">
		<h2>商铺登录</h2>
		<b></b>
	</div>
	<div class="mc" style="padding-top:20px;">
		<form id="loginform" method="POST" action="<%=path %>/front/shoplogin.xhtml?method=onLogin">
		<div class="form">
			<div class="item">
				<span class="label">用户名：</span>
				<div class="fl">
					<input type="text" id="loginname" name="loginname" class="text {required: true}" tabindex="1" value="">
					<label id="loginname_succeed" class="blank invisible"></label>
					<span class="clr"></span>
					<label id="loginname_error"></label>
				</div>
			</div>
			<div class="item">
				<span class="label">密码：</span>
				<div class="fl">
					<input type="password" id="loginpwd" name="loginpwd" class="text {required: true}" tabindex="2">
					<label id="loginpwd_succeed" class="blank invisible"></label>					
				</div>
			</div>
						
			<c:if test="${errors!=null}">
	     	<div class="item">
	     	<span class="label">&nbsp;</span>
	     	<c:forEach items="${errors}" var="b">				     	
	     	${b}
	     	</c:forEach>
	     	</div>
	     	</c:if>

			<div class="item">
				<span class="label">&nbsp;</span>				
				<input type="submit" class="btn-img btn-entry" id="loginsubmit" value="登录" tabindex="8">
			</div>			
		</div>
		
		
		<!--[if !ie]>form end<![endif]-->

		<div id="guide">
			
		</div>
		<!--[if !ie]>guide end<![endif]-->
		
		<span class="clr"></span>
		</form>
	</div>
	<!--[if !ie]>mc end<![endif]-->
</div>


</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>