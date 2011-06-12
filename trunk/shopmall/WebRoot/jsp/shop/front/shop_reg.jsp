<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %>-店铺注册</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/cust_reg.css" rel="stylesheet" type="text/css" />

<%@include file="/jsp/shop/front/common/head.jsp"%>
<script type="text/javascript" src="<%=path %>/resources/front/js/jquery.metadata.js"></script>
<script type="text/javascript" src="<%=path %>/resources/front/js/jquery.validate.js"></script>

<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>

<script type="text/javascript">
	function reloadvefifyimg(){
		$('#img_verification').attr('src','<%=path %>/verification.jpg?data='+new Date().getTime());
	}
	
	$(document).ready(function() {
		$('#ajax_regist').hide();
		$("#custregform").validate({
			errorClass: "validateErrorreg",
			focusInvalid: false,
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
                $('#ajax_regist').show();
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
	
<div class="w" id="regist">
	<div class="mt">
		<h2>注册新店铺</h2>
		<b></b>
		<span>我已经注册，现在就&nbsp;<a href="<%=path %>/index.jsp" class="flk13">管理店铺</a></span>
	</div>
	<div class="mc">
		<form id="custregform" method="POST" action="<%=path%>/front/shoplogin.xhtml?method=onShopreg">
		    <div class="form">
                <div class="item">
				    <span class="label">登录名：</span>
				    <div class="fl">
					    <input type="text" id="userCode" name="userCode" class="text {required: true,byteRangeLength: [3,15],remote: '<%=path%>/front/shoplogin.xhtml?method=checkUser', messages: {required:'请输入用户名',remote: '用户名已存在,请重新输入!'}}" tabindex="1" value="${reg.userCode }" />
					    <span class="clr"></span>                        
				    </div>
			    </div>
			    <div class="item">
				    <span class="label">密码：</span>
				    <div class="fl">
					    <input type="password" class="text {required: true,minlength: 5,messages: {required:'请输入密码'}}" id="loginPwd" name="loginPwd" tabindex="2" value="${reg.loginPwd}"/>
					    <span class="clr"></span>    						
				    </div>
			    </div>
			    <div class="item">
				    <span class="label">确认密码：</span>
				    <div class="fl">
					    <input type="password" class="text {required: true,minlength: 5,equalTo: '#loginPwd',messages: {required:'请输入确认密码',equalTo:'两次输入的密码不一致'}}" id="custPwd2" name="custPwd2" value="${reg.loginPwd}" tabindex="3">
					    <span class="clr"></span>    						
				    </div>
			    </div>
			    <div class="item">
				    <span class="label">邮箱：</span>
				    <div class="fl">
					    <input type="text" id="email" name="email" class="text {required: true,email: true,messages: {required:'请输入电子邮件'}}" tabindex="4" value="${reg.email}" />			
					    <span class="clr"></span>    					
				    </div>
			    </div>
			    <div class="item">
				    <span class="label">店铺名称：</span>
				    <div class="fl">
					    <input type="text" id="shopName" name="shopName" class="text {required: true,messages: {required:'请输入店铺名称'}}" tabindex="5" value="${reg.shopName}" />			
					    <span class="clr"></span>    					
				    </div>
			    </div>			    
			    <div class="item">
				    <span class="label">联系人：</span>
				    <div class="fl">
					    <input type="text" id="linkName" name="linkName" class="text {required: true,messages: {required:'请输入联系人'}}" tabindex="6" value="${reg.linkName}"/>			
					    <span class="clr"></span>    					
				    </div>
			    </div>
			    <div class="item">
				    <span class="label">联系电话：</span>
				    <div class="fl">
					    <input type="text" id="linkTel" name="linkTel" class="text {required: true,messages: {required:'请输入联系电话'}}" tabindex="7" value="${reg.linkTel}"/>			
					    <span class="clr"></span>    					
				    </div>
			    </div>
			    <div class="item">
				    <span class="label">地址：</span>
				    <div class="fl">
					    <input type="text" id="address" name="address" class="text" tabindex="8" value="${reg.address}"/>			
					    <span class="clr"></span>    					
				    </div>
			    </div>
			    
			    <div class="item" style="height:70px;">
				    <span class="label">验证码：</span>
				    <div class="fl">
					    <input type="text" id="authcode" name="authcode" class="text-s {required: true,rangelength:[4,4],messages: {required:'请输入验证码',rangelength:'请输入四位验证码'}}" tabindex="9" maxlength="5">
					    <br/>请输入以下验证码
					    <span class="clr"></span>                       
			    	</div>			    
			    </div>
			    
			    <div class="item">
				    <span class="label">&nbsp;</span>
				    <div class="fl">
					    <label class="img">
                          <img id="img_verification" onclick="reloadvefifyimg()" src="<%=path %>/verification.jpg?data=<%=Math.random() %>'" alt="" style="cursor:pointer;width:100px;height:30px;">
					    </label>
					    <label class="ftx23">&nbsp;看不清？
					    	<a href="#none" onclick="reloadvefifyimg()" class="flk13">换一张</a>
					    </label>
					    <span class="clr"></span>                       
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
		     	
				<div id="ajax_regist" class="ajaxTip itemA">正在提交注册信息，请稍候....</div>
		     	<div class="clr"></div>
			    <div class="item">			    	
				    <span class="label">&nbsp;</span>
				    <input type="submit" class="btn-img btn-regist" id="registsubmit" value="立即注册开店" tabindex="10">
			    </div>
		    </div>		
		</form>

		<!--[if !ie]>form end<![endif]-->
		
		
		
	</div>
	<!--[if !ie]>mc end<![endif]-->
 
</div>


</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>