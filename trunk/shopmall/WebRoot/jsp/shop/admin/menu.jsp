<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/help.css" rel="stylesheet" type="text/css" />

<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>

</head>
<body id="index">

<!-- 正文开始 -->
<div class="w main">
<!-- 帮助导航开始 -->
<div class="helpMainLeft">
	<div class="helpLeftTitle">
		退出
	</div>
	<div class="helpLeftMenu">
		<div class="helpLeftBar">
			<span>店铺信息设置</span>
		</div>
		<ul class="helpLeftGroup">
			<li><a href="<%=path%>/shop/admin/shopInfo.xhtml?method=editShop" target="mainFrame">店铺基本信息</a></li>
			<li><a href="<%=path%>/shop/admin/brandInfo.xhtml?method=index" target="mainFrame">品牌管理</a></li>
			<!--<li><a href="<%=path%>/shop/admin/indexCategory.xhtml" target="mainFrame">首页分类设置</a></li>-->
			<li><a href="<%=path%>/shop/admin/tuanApply.xhtml" target="mainFrame">团购申请</a></li>
		</ul>
		<div class="helpLeftBar">
			<span>商品管理</span>
		</div>
		<ul class="helpLeftGroup">
			<li id="id_90"><a href="/shop/admin/goodsCategory.xhtml?method=index" target="mainFrame">商品分类</a></li>			
			<li id="id_91"><a href="/shop/admin/goodsInfo.xhtml?method=goodsList" target="mainFrame">商品管理</a></li>			
			<li id="id_94"><a href="/shop/admin/goodsRemark.xhtml" target="mainFrame">商品评论</a></li>			
			<li id="id_95"><a href="/shop/admin/goodsQa.xhtml" target="mainFrame">商品咨询</a></li>
		</ul>
		<div class="helpLeftBar">
			<span>订单管理</span>
		</div>
		<ul class="helpLeftGroup">
			<li id="id_99"><a href="0" target="mainFrame">订单列表</a></li>
			<li id="id_100"><a href="0" target="mainFrame">发货单</a></li>
			<li id="id_101"><a href="0" target="mainFrame">退货单</a></li>
			<li id="id_102"><a href="/shop/admin/orders.xhtml?method=list&orderstatus=0,1" target="mainFrame">订单查询</a></li>
			<li id="id_113"><a href="0" target="mainFrame">代送货申请</a></li>
		</ul>
		
		
		<div class="helpLeftBar">
			<span>系统操作</span>
		</div>
		<ul class="helpLeftGroup">
			<li>
				<a href="<%=path%>/help/topic-linkus.html">修改密码</a>
			</li>
			<li>
				<a href="<%=path%>/help/topic-linkus.html">退出</a>
			</li>
		</ul>
	</div>
</div>
<!-- 帮助导航结束 -->

<!-- end of helpMainLeft -->

</div><!-- end of 正文 -->
<div class="clr5"></div>
</body>
</html>