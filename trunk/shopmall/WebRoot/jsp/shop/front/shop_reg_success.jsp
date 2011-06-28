<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/cust_reg.css" rel="stylesheet" type="text/css" />

<style type="text/css">

</style> 
<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/jquery.tools.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.tmpl.min.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>

</head>
<body id="index">
<%@include file="/jsp/shop/front/common/top.jsp"%>

<!-- 正文开始 -->
<div class="w main">
	
<div class="w" id="entry">
	<div class="mt">
		<h2>用户登录</h2>
		<b></b>
	</div>
	<div class="mc" style="padding-top:20px;">		
		
		<div id="succeed" class="flk13">
                <h3>
                恭喜，店铺注册成功。</h3>
                您注册的店铺名为<b>${reg.shopName}</b>.<br>  
                您登录的用户名为<b>${reg.userCode}</b>.<br>
                您现在可以：
                <a href="<%=path %>/index.html">去商城首页</a>&nbsp;
                <a href="<%=path %>/front/shoplogin.xhtml?method=login">管理我的店铺</a>
                <s></s>
            </div>	
			
		
		<span class="clr"></span>
			
	</div>
	<!--[if !ie]>mc end<![endif]-->
</div>


</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>