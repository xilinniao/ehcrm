<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %>,${shop.shopName }</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/shop.css" rel="stylesheet" type="text/css" />

<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/dialog.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
//-->
</script>
</head>
<body id="index">
<%@include file="/jsp/shop/front/common/top.jsp"%>

<!-- 正文开始 -->
<div class="w main">
	
	<div class="shop_norm_t_opt_h_28px">
		<ul>
	    	<li><a href="<%=path %>/shopinfo/index-${shop.shopId}.html" target="_top" title="${shop.shopName}"><span>店铺首页</span></a></li>
	        <li class="sel"><a href="<%=path %>/front/shop.xhtml?method=introduce&shopId=${shop.shopId}" target="_top" title="${shop.shopName}介绍"><span>店铺介绍</span></a></li>	        
	    </ul>
	</div>
	
	<div class="blank_10px"></div>

<div class="shop_introduce_i">
    <div class="shop_t_name">
        <h1>${shop.shopName}</h1>
    </div>
    
    <!--
    <div class="shop_b_infos">
        <div class="info_nav">
            <div class="t_tit">商家基本信息</div>
            <div class="l_i_i">认证情况：<span style="display:inline-block; vertical-align:middle;">
                                  <img alt="实名认证" title="实名认证" src="/misc/images/icon/rz.gif">
                                                </span></div>
            <div class="l_i_i">购物保障：<strong><i style="width:0px;"></i></strong><span>                                                </span></div>
            			            <div class="l_i_i">如实描述：<strong><i style="width:0px;"></i></strong><span><a href="http://shop.360hqb.com/21743/credit.html" target="_blank">0.0</a></span></div>
            <div class="l_i_i">服务态度：<strong><i style="width:0px;"></i></strong><span><a href="http://shop.360hqb.com/21743/credit.html" target="_blank">0.0</a></span></div>
            <div class="l_i_i">发货态度：<strong><i style="width:0px;"></i></strong><span><a href="http://shop.360hqb.com/21743/credit.html" target="_blank">0.0</a></span></div>
            <div class="l_i_i" style="height:auto;">经营范围：手机通讯&nbsp;&nbsp;数码相机&nbsp;&nbsp;</div>
            <div class="l_i_i">注册时间：2011-04-09</div>
            <div class="l_i_i">最近登录：2011-05-11</div>
        </div>
        <div class="info_nav">
            <div class="t_tit">商家联系信息</div>
                        <div class="l_i_i">联系手机：13335024018</div>
                                    <div class="l_i_i">QQ：
                                    <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=294144892&amp;site=qq&amp;menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:294144892:47" alt="点击这里给我发消息" title="点击这里给我发消息"></a>
                                </div>
                    </div>
    </div>
    -->
    <div class="des_words_con">
		${shop.shopDesc}
	</div>
</div>


</div><!-- end of 正文 -->

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>