<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/slide.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/product.css" rel="stylesheet" type="text/css" />

<style type="text/css">

</style> 
<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/jquery.easyslider.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.tmpl.min.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>

</head>
<body id="index">
<%@include file="/jsp/shop/front/common/top.jsp"%>

<!-- 正文开始 -->
<div class="w main">
	<div class="left">
		<!-- 品牌开始 -->
		<div class="m" id="sortlist">
				<!-- 
				<div class="mt"><h2>电脑、软件、办公</h2></div>
				<div class="mc">
                    <div class="item current">
                    <h3><b></b><a href="http://www.360buy.com/products/670-671-000.html">电脑整机</a></h3>
                    <ul>
                    <li><a href="http://www.360buy.com/products/670-671-672-0-0-0-0-0-0-0-1-1-1.html">笔记本</a></li>
                    <li><a href="http://www.360buy.com/products/670-671-1105-0-0-0-0-0-0-0-1-1-1.html">上网本</a></li>
                    <li><a href="http://www.360buy.com/products/670-671-2694-0-0-0-0-0-0-0-1-1-1.html">平板电脑</a></li>
                    <li><a href="http://www.360buy.com/products/670-671-673-0-0-0-0-0-0-0-1-1-1.html">台式机</a></li>
                    <li><a href="http://www.360buy.com/products/670-671-674-0-0-0-0-0-0-0-1-1-1.html">服务器</a></li>
                    <li><a href="http://www.360buy.com/products/670-671-675-0-0-0-0-0-0-0-1-1-1.html">笔记本配件</a></li>
                    </ul>
                    </div>
				</div>
				 -->
				 ${categoryList }
			</div><!-- 品牌结束 -->
		
		<div id="advertiseleft">
			<ul>
				<li>
					<a target="_blank" href="dd">
						<img src="http://img11.360buyimg.com/da/20110307/211_90_rMuKtq.jpg" width="211" height="90">
					</a>
				</li>
				<li>
					<a target="_blank" href="dd">
						<img src="http://img12.360buyimg.com/da/20110308/211_90_zlRMxu.jpg" width="211" height="90">
					</a>
				</li>
				<li>
					<a target="_blank" href="dd">
						<img src="http://img14.360buyimg.com/da/20110311/211_90_NrVlGu.gif" width="211" height="90">
					</a>
				</li>
		</div><!-- advertiseleft -->
		<span class="clr5"></span>
		
		<div class="m rank" id="rank537" style="display: block; ">
			<div class="mt">
				<h2>销量排行榜</h2>
			</div>
			<div class="mc">
				<ul>
					<li class="fore">
						<span>1</span>
						<div class="p-img">
							<a href="/product/141195.html">
							<img src="http://img10.360buyimg.com/n5/3348/db8d172d-62d1-4a9d-9b0a-297d96ea3a65.jpg" alt="安睡宝单人新羽高弹枕" width="50" height="50">
							</a>
						</div>
						<div class="p-name">
							<a title="安睡宝单人新羽高弹枕" href="/product/141195.html">
								安睡宝单人新羽高弹枕<font color="#ff6600">便宜！品牌！质量保证！</font>
							</a>
						</div>
						<div class="p-price">
							<strong>￥75.00</strong>
						</div>
					</li>
					<li class="fore">
						<span>2</span>
						<div class="p-img">
							<a href="/product/141195.html">
							<img src="http://img10.360buyimg.com/n5/833/17d078c1-5c6b-478e-b193-490f2bdd15a9.jpg" alt="安睡宝单人新羽高弹枕" width="50" height="50">
							</a>
						</div>
						<div class="p-name">
							<a title="安睡宝单人新羽高弹枕" href="/product/141195.html">
								安睡宝单人新羽高弹枕<font color="#ff6600">便宜！品牌！质量保证！</font>
							</a>
						</div>
						<div class="p-price">
							<strong>￥75.00</strong>
						</div>
					</li>
					<li class="fore">
						<span>3</span>
						<div class="p-img">
							<a href="/product/141195.html">
							<img src="http://img10.360buyimg.com/n5/809/5dfc9f42-d2a1-43d5-a368-20086f5d3926.jpg" alt="安睡宝单人新羽高弹枕" width="50" height="50">
							</a>
						</div>
						<div class="p-name">
							<a title="安睡宝单人新羽高弹枕" href="/product/141195.html">
								安睡宝单人新羽高弹枕<font color="#ff6600">便宜！品牌！质量保证！</font>
							</a>
						</div>
						<div class="p-price">
							<strong>￥75.00</strong>
						</div>
					</li>
					<li class="fore">
						<span>4</span>
						<div class="p-img">
							<a href="/product/141195.html">
							<img src="http://img10.360buyimg.com/n5/3348/db8d172d-62d1-4a9d-9b0a-297d96ea3a65.jpg" alt="安睡宝单人新羽高弹枕" width="50" height="50">
							</a>
						</div>
						<div class="p-name">
							<a title="安睡宝单人新羽高弹枕" href="/product/141195.html">
								安睡宝单人新羽高弹枕<font color="#ff6600">便宜！品牌！质量保证！</font>
							</a>
						</div>
						<div class="p-price">
							<strong>￥75.00</strong>
						</div>
					</li>
					<li class="fore">
						<span>5</span>
						<div class="p-img">
							<a href="/product/141195.html">
							<img src="http://img10.360buyimg.com/n5/833/17d078c1-5c6b-478e-b193-490f2bdd15a9.jpg" alt="安睡宝单人新羽高弹枕" width="50" height="50">
							</a>
						</div>
						<div class="p-name">
							<a title="安睡宝单人新羽高弹枕" href="/product/141195.html">
								安睡宝单人新羽高弹枕<font color="#ff6600">便宜！品牌！质量保证！</font>
							</a>
						</div>
						<div class="p-price">
							<strong>￥75.00</strong>
						</div>
					</li>
					<li class="fore">
						<span>6</span>
						<div class="p-img">
							<a href="/product/141195.html">
							<img src="http://img10.360buyimg.com/n5/809/5dfc9f42-d2a1-43d5-a368-20086f5d3926.jpg" alt="安睡宝单人新羽高弹枕" width="50" height="50">
							</a>
						</div>
						<div class="p-name">
							<a title="安睡宝单人新羽高弹枕" href="/product/141195.html">
								安睡宝单人新羽高弹枕<font color="#ff6600">便宜！品牌！质量保证！</font>
							</a>
						</div>
						<div class="p-price">
							<strong>￥75.00</strong>
						</div>
					</li>
				</ul>
			</div>			
		</div><!-- end of rank537 -->
	</div><!-- end of left -->
	
	<div class="right">
		<div id="slidercontain">
			<div id="slider">
				<ul>
					<li><a href="http://templatica.com/preview/27"><img src="http://www.shopxx.cn/upload/banner1.jpg" alt="Css Template Preview" /></a></li>
					<li><a href="http://templatica.com/preview/27"><img src="http://www.shopxx.cn/upload/banner2.jpg" alt="Css Template Preview" /></a></li>
					<li><a href="http://templatica.com/preview/27"><img src="http://www.shopxx.cn/upload/banner3.jpg" alt="Css Template Preview" /></a></li>
					<li><a href="http://templatica.com/preview/27"><img src="http://www.shopxx.cn/upload/banner1.jpg" alt="Css Template Preview" /></a></li>
					<li><a href="http://templatica.com/preview/27"><img src="http://www.shopxx.cn/upload/banner2.jpg" alt="Css Template Preview" /></a></li>
					<li><a href="http://templatica.com/preview/27"><img src="http://www.shopxx.cn/upload/banner3.jpg" alt="Css Template Preview" /></a></li>
					<li><a href="http://templatica.com/preview/27"><img src="http://www.shopxx.cn/upload/banner1.jpg" alt="Css Template Preview" /></a></li>
					<li><a href="http://templatica.com/preview/27"><img src="http://www.shopxx.cn/upload/banner2.jpg" alt="Css Template Preview" /></a></li>
					<li><a href="http://templatica.com/preview/27"><img src="http://www.shopxx.cn/upload/banner3.jpg" alt="Css Template Preview" /></a></li>
				</ul>
			</div>
		</div><!-- end of slidercontain -->
		<span class="clr5"></span>
		
		<div class="hotprod">
				<div class="mt">
					<h2>${b.categoryName }</h2>
					<div class="extra"><a href="special.aspx?id=2&amp;cid=0">更多&gt;&gt;</a></div>
				</div>
				<ul class="p-list">
					<c:forEach items="${productList}" var="b">
	                <li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000102803.html"><img src="${b.imageD }" width="130" height="130" alt="爱慕文胸" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="${b.name }" href="/product/${b.goodId }.html">${b.name }</a></div>
					<div class="p-price">抚州价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000102803,2.png"></strong></div>					
					</li>
					</c:forEach>
				</ul>
		</div><!-- end of hotprod -->
		<span class="clr clr5"></span>
			
	</div><!-- end of right -->
	
</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>