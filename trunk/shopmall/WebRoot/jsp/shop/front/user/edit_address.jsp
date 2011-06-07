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
			<h3>修改地址信息</h3>
            <form id="addrform" method="POST" action="<%=path %>/front/user.xhtml?method=onEditAddress">
            	<input type="hidden" name="addrId" value="${addr.addrId}"/>
	            <div id="userform" class="form">
	            	<div class="item">
					    <span class="label">姓名：</span>
					    <div class="fl">
						    <input type="test" class="text {required: true} valid" id="revicedName" name="revicedName" tabindex="1" value="${addr.revicedName}" />
						    <span class="clr"></span>    						
					    </div>
				    </div>
				    
				    <div class="item">
					    <span class="label">客户地址：</span>
					    <div class="fl">
						    <input type="test" class="text {required: true} valid" id="revicedAddr" name="revicedAddr" tabindex="2" value="${addr.revicedAddr}" />
						    <span class="clr"></span>    						
					    </div>
				    </div>
				    
				    <div class="item">
					    <span class="label">联系电话：</span>
					    <div class="fl">
						    <input type="test" class="text {required: true} valid" id="revicedMobile" name="revicedMobile" tabindex="3" value="${addr.revicedMobile}" />
						    <span class="clr"></span>    						
					    </div>
				    </div>
				    
				    <div class="item">
					    <span class="label">电子邮件：</span>
					    <div class="fl">
						    <input type="test" class="text {email: true} valid" id="revicedEmail" name="revicedEmail" tabindex="4" value="${addr.revicedEmail}" />
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