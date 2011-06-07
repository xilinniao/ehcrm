<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/usercenter.css" rel="stylesheet" type="text/css" />

<%@include file="/jsp/shop/front/common/head.jsp"%>
<script type="text/javascript" src="<%=path %>/resources/front/js/jquery.metadata.js"></script>
<script type="text/javascript" src="<%=path %>/resources/front/js/jquery.validate.js"></script>
<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>

<script type="text/javascript">
<!--
$(document).ready(function() {
	$("#addrform").validate({
			errorClass: "validateError",
            errorPlacement: function(error, element) {
                var messagePosition = element.metadata().messagePosition;
                if("undefined" != typeof messagePosition && messagePosition != "") {
                    var $messagePosition = $(messagePosition);
                    if ($messagePosition.size() > 0) {
                        error.insertAfter($messagePosition).hide().show();
                    } else {
                        error.insertAfter(element).hide().show();
                    }
                } else {
                    error.insertAfter(element).hide().show();
                }
            },
            submitHandler: function(form) {
                $(form).find(":submit").attr("disabled", true);
                form.submit();
            }
		});
});
//-->
</script>
</head>
<body id="index">
<%@include file="/jsp/shop/front/common/top.jsp"%>
	
<!-- 正文开始 -->
<div class="w main">
	<%@include file="/jsp/shop/front/user/user_nav.jsp"%><!-- 左边导航条 -->
	
	<div id="uc_content">
          <div class="uc_list">
			<h3>修改密码</h3>
			<c:if test="${errors!=null}">
			 	<div class="userTipError">
			 		<c:forEach items="${errors}" var="b">
						${b }<br>
					</c:forEach>
			 	</div>
			 </c:if>
			 
			 <c:if test="${message!=null}">
			 	<div class="userTipSuccess">
			 		<c:forEach items="${message}" var="b">
						${b }<br>
					</c:forEach>
			 	</div>
			 </c:if>
			 
            <form id="addrform" method="POST" action="<%=path%>/front/login.xhtml?method=onChangePwd">
	            <div id="userform" class="form">
	            	<div class="item">
					    <span class="label">用户名：</span>
					    <div>
						    ${frontcust.custCode}
					    </div>
				    </div>
				    
				    <div class="item">
					    <span class="label">原密码：</span>
					    <div class="fl">
						    <input type="password" class="text {required: true} valid" id="oldpwd" name="oldpwd" tabindex="2" />
						    <span class="clr"></span>    						
					    </div>
				    </div>	
				    
				    <div class="item">
					    <span class="label">新密码：</span>
					    <div class="fl">
						    <input type="password" class="text {required: true} valid" id="newpwd" name="newpwd" tabindex="3" value="" />
						    <span class="clr"></span>    						
					    </div>
				    </div>
				    
				    <div class="item">
					    <span class="label">新密码：</span>
					    <div class="fl">
						    <input type="password" class="text {required: true} valid" id="newpwdtw" name="newpwdtw" tabindex="4"/>
						    <span class="clr"></span>    						
					    </div>
				    </div>	    
				    
				    <div class="item">
					    <span class="label"></span>
					    <div class="fl">
					    <input type="submit" class="btn-img btn-submit" id="submit_save" value="修改" tabindex="5">		
					    </div>
				    </div>			    
	            </div>
           	</form>
            
         </div>
        
	</div><!-- end of uc_middle -->
	
</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>