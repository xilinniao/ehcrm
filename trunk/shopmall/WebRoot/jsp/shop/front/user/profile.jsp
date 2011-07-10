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
	
	<div class="uc_right">
          	<div class="o-mt"><h2>个人资料</h2></div>
			<c:if test="${param.msg!=null}">
			 	<div class="userTipSuccess">个人资料保存成功</div>
			 </c:if>
			 
            <form id="addrform" method="POST" action="<%=path %>/front/user.xhtml?method=onProfile">
	            <div id="userform" class="form">
	            	<div class="item">
					    <span class="label">用户名：</span>
					    <div style="margin-top:5px;">
						    ${custInfo.custCode}
					    </div>
				    </div>
				    
				    <div class="item">
					    <span class="label">姓名：</span>
					    <div class="fl">
						    <input type="text" class="text {required: true} valid" id="custName" name="custName" tabindex="2" value="${custInfo.custName}" />
						    <span class="clr"></span>    						
					    </div>
				    </div>
				    
				    <div class="item">
					    <span class="label">地址：</span>
					    <div class="fl">
						    <input type="text" class="text {required: true} valid" id="custAddr" name="custAddr" tabindex="2" value="${custInfo.custAddr}" />
						    <span class="clr"></span>    						
					    </div>
				    </div>
				    
				    <div class="item">
					    <span class="label">联系电话：</span>
					    <div class="fl">
						    <input type="text" class="text {required: true} valid" id="custMobile" name="custMobile" tabindex="3" value="${custInfo.custMobile}" />
						    <span class="clr"></span>    						
					    </div>
				    </div>
				    
				    <div class="item">
					    <span class="label">电子邮件：</span>
					    <div class="fl">
						    <input type="text" class="text {email: true} valid" id="email" name="email" tabindex="4" value="${custInfo.email}" />
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
            
        
	</div><!-- end of uc_middle -->
	
</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>