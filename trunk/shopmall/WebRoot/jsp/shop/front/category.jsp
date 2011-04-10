<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/skin.css" rel="stylesheet" type="text/css" />

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
	<div class="left">
		<!-- 品牌开始 -->
		<div class="m" id="sortlist">
				<div class="mt">
					<h2>电脑、软件、办公</h2>
				</div>
				<div class="mc">
                    <div class="item current"><h3><b></b><a href="http://www.360buy.com/products/670-671-000.html">电脑整机</a></h3><ul><li><a href="http://www.360buy.com/products/670-671-672-0-0-0-0-0-0-0-1-1-1.html">笔记本</a></li><li><a href="http://www.360buy.com/products/670-671-1105-0-0-0-0-0-0-0-1-1-1.html">上网本</a></li><li><a href="http://www.360buy.com/products/670-671-2694-0-0-0-0-0-0-0-1-1-1.html">平板电脑</a></li><li><a href="http://www.360buy.com/products/670-671-673-0-0-0-0-0-0-0-1-1-1.html">台式机</a></li><li><a href="http://www.360buy.com/products/670-671-674-0-0-0-0-0-0-0-1-1-1.html">服务器</a></li><li><a href="http://www.360buy.com/products/670-671-675-0-0-0-0-0-0-0-1-1-1.html">笔记本配件</a></li></ul></div><div class="item current"><h3><b></b><a href="http://www.360buy.com/products/670-677-000.html">电脑配件</a></h3><ul><li><a href="http://www.360buy.com/products/670-677-678-0-0-0-0-0-0-0-1-1-1.html">CPU</a></li><li><a href="http://www.360buy.com/products/670-677-681-0-0-0-0-0-0-0-1-1-1.html">主板</a></li><li><a href="http://www.360buy.com/products/670-677-679-0-0-0-0-0-0-0-1-1-1.html">显卡</a></li><li><a href="http://www.360buy.com/products/670-677-683-0-0-0-0-0-0-0-1-1-1.html">硬盘</a></li><li><a href="http://www.360buy.com/products/670-677-680-0-0-0-0-0-0-0-1-1-1.html">内存</a></li><li><a href="http://www.360buy.com/products/670-677-687-0-0-0-0-0-0-0-1-1-1.html">机箱</a></li><li><a href="http://www.360buy.com/products/670-677-691-0-0-0-0-0-0-0-1-1-1.html">电源</a></li><li><a href="http://www.360buy.com/products/670-677-688-0-0-0-0-0-0-0-1-1-1.html">显示器</a></li><li><a href="http://www.360buy.com/products/670-677-684-0-0-0-0-0-0-0-1-1-1.html">刻录机/光驱</a></li><li><a href="http://www.360buy.com/products/670-677-685-0-0-0-0-0-0-0-1-1-1.html">声卡</a></li><li><a href="http://www.360buy.com/products/670-677-2683-0-0-0-0-0-0-0-1-1-1.html">扩展卡</a></li><li><a href="http://www.360buy.com/products/670-677-682-0-0-0-0-0-0-0-1-1-1.html">散热器</a></li></ul></div><div class="item current"><h3><b></b><a href="http://www.360buy.com/products/670-686-000.html">外设产品</a></h3><ul><li><a href="http://www.360buy.com/products/670-686-690-0-0-0-0-0-0-0-1-1-1.html">鼠标</a></li><li><a href="http://www.360buy.com/products/670-686-689-0-0-0-0-0-0-0-1-1-1.html">键盘</a></li><li><a href="http://www.360buy.com/products/670-686-693-0-0-0-0-0-0-0-1-1-1.html">移动硬盘</a></li><li><a href="http://www.360buy.com/products/670-686-694-0-0-0-0-0-0-0-1-1-1.html">U盘</a></li><li><a href="http://www.360buy.com/products/670-686-692-0-0-0-0-0-0-0-1-1-1.html">摄像头</a></li><li><a href="http://www.360buy.com/products/670-686-695-0-0-0-0-0-0-0-1-1-1.html">外置盒</a></li><li><a href="http://www.360buy.com/products/670-686-696-0-0-0-0-0-0-0-1-1-1.html">游戏设备</a></li><li><a href="http://www.360buy.com/products/670-686-697-0-0-0-0-0-0-0-1-1-1.html">电视盒</a></li><li><a href="http://www.360buy.com/products/670-686-698-0-0-0-0-0-0-0-1-1-1.html">手写板</a></li><li><a href="http://www.360buy.com/products/670-686-826-0-0-0-0-0-0-0-1-1-1.html">鼠标垫</a></li><li><a href="http://www.360buy.com/products/670-686-1047-0-0-0-0-0-0-0-1-1-1.html">插座</a></li><li><a href="http://www.360buy.com/products/670-686-1048-0-0-0-0-0-0-0-1-1-1.html">UPS电源</a></li><li><a href="http://www.360buy.com/products/670-686-1049-0-0-0-0-0-0-0-1-1-1.html">线缆</a></li><li><a href="http://www.360buy.com/products/670-686-1050-0-0-0-0-0-0-0-1-1-1.html">电脑工具</a></li><li><a href="http://www.360buy.com/products/670-686-1051-0-0-0-0-0-0-0-1-1-1.html">电脑清洁</a></li></ul></div><div class="item current"><h3><b></b><a href="http://www.360buy.com/products/670-699-000.html">网络产品</a></h3><ul><li><a href="http://www.360buy.com/products/670-699-700-0-0-0-0-0-0-0-1-1-1.html">路由器</a></li><li><a href="http://www.360buy.com/products/670-699-701-0-0-0-0-0-0-0-1-1-1.html">网卡</a></li><li><a href="http://www.360buy.com/products/670-699-702-0-0-0-0-0-0-0-1-1-1.html">交换机</a></li><li><a href="http://www.360buy.com/products/670-699-983-0-0-0-0-0-0-0-1-1-1.html">网络存储</a></li><li><a href="http://www.360buy.com/products/670-699-1098-0-0-0-0-0-0-0-1-1-1.html">3G上网</a></li></ul></div><div class="item current"><h3><b></b><a href="http://www.360buy.com/products/670-716-000.html">办公设备</a></h3><ul><li><a href="http://www.360buy.com/products/670-716-717-0-0-0-0-0-0-0-1-1-1.html">打印机</a></li><li><a href="http://www.360buy.com/products/670-716-720-0-0-0-0-0-0-0-1-1-1.html">一体机</a></li><li><a href="http://www.360buy.com/products/670-716-722-0-0-0-0-0-0-0-1-1-1.html">投影机</a></li><li><a href="http://www.360buy.com/products/670-716-719-0-0-0-0-0-0-0-1-1-1.html">复合机</a></li><li><a href="http://www.360buy.com/products/670-716-718-0-0-0-0-0-0-0-1-1-1.html">传真机</a></li><li><a href="http://www.360buy.com/products/670-716-721-0-0-0-0-0-0-0-1-1-1.html">扫描仪</a></li><li><a href="http://www.360buy.com/products/670-716-723-0-0-0-0-0-0-0-1-1-1.html">碎纸机</a></li><li><a href="http://www.360buy.com/products/670-716-724-0-0-0-0-0-0-0-1-1-1.html">考勤机</a></li><li><a href="http://www.360buy.com/products/670-716-725-0-0-0-0-0-0-0-1-1-1.html">点钞机</a></li><li><a href="http://www.360buy.com/products/670-716-726-0-0-0-0-0-0-0-1-1-1.html">塑封机</a></li><li><a href="http://www.360buy.com/products/670-716-727-0-0-0-0-0-0-0-1-1-1.html">电子白板</a></li><li><a href="http://www.360buy.com/products/670-716-728-0-0-0-0-0-0-0-1-1-1.html">计算器</a></li><li><a href="http://www.360buy.com/products/670-716-1229-0-0-0-0-0-0-0-1-1-1.html">激光笔</a></li></ul></div><div class="item current"><h3><b></b><a href="http://www.360buy.com/products/670-729-000.html">办公耗材</a></h3><ul><li><a href="http://www.360buy.com/products/670-729-731-0-0-0-0-0-0-0-1-1-1.html">墨盒</a></li><li><a href="http://www.360buy.com/products/670-729-730-0-0-0-0-0-0-0-1-1-1.html">硒鼓</a></li><li><a href="http://www.360buy.com/products/670-729-732-0-0-0-0-0-0-0-1-1-1.html">墨粉</a></li><li><a href="http://www.360buy.com/products/670-729-733-0-0-0-0-0-0-0-1-1-1.html">色带</a></li><li><a href="http://www.360buy.com/products/670-729-734-0-0-0-0-0-0-0-1-1-1.html">刻录碟片</a></li><li><a href="http://www.360buy.com/products/670-729-735-0-0-0-0-0-0-0-1-1-1.html">光盘包/笔</a></li><li><a href="http://www.360buy.com/products/670-729-736-0-0-0-0-0-0-0-1-1-1.html">纸类</a></li></ul></div><div class="item current"><h3><b></b><a href="http://www.360buy.com/products/670-703-000.html">电脑软件</a></h3><ul><li><a href="http://www.360buy.com/products/670-703-1009-0-0-0-0-0-0-0-1-1-1.html">京东服务</a></li><li><a href="http://www.360buy.com/products/670-703-704-0-0-0-0-0-0-0-1-1-1.html">系统软件</a></li><li><a href="http://www.360buy.com/products/670-703-705-0-0-0-0-0-0-0-1-1-1.html">杀毒软件</a></li><li><a href="http://www.360buy.com/products/670-703-706-0-0-0-0-0-0-0-1-1-1.html">游戏软件</a></li><li><a href="http://www.360buy.com/products/670-703-707-0-0-0-0-0-0-0-1-1-1.html">办公软件</a></li><li><a href="http://www.360buy.com/products/670-703-709-0-0-0-0-0-0-0-1-1-1.html">教育软件</a></li><li><a href="http://www.360buy.com/products/670-703-970-0-0-0-0-0-0-0-1-1-1.html">工具软件</a></li></ul></div>
				</div>
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
		<div class="slider">
			<div id="sliderScrollable" class="scrollable">
				<div class="items">
					<div>
						<img src="http://www.shopxx.cn/upload/banner1.jpg" />
					</div>
					<div>
						<img src="http://www.shopxx.cn/upload/banner2.jpg" />
					</div>
					<div>
						<img src="http://www.shopxx.cn/upload/banner3.jpg" />
					</div>
				</div>
				<div class="navi"></div>				
			</div>
		</div><!-- end of slider -->
		<span class="clr5"></span>
		
		<c:forEach items="${categoryGoodsList}" var="b">
		<div class="hotprod">
				<div class="mt">
					<h2>${b.categoryName }</h2>
					<div class="extra"><a href="special.aspx?id=2&amp;cid=0">更多&gt;&gt;</a></div>
				</div>
				<ul class="p-list">
					<c:forEach items="${b.goodsList}" var="bb">
	                <li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000102803.html"><img src="${bb.imageUrl }" width="130" height="130" alt="爱慕文胸" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="爱慕文胸" href="http://www.360buy.com/product/1000102803.html">${bb.goodsName }</a></div>
					<div class="p-price">抚州价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000102803,2.png"></strong></div>					
					</li>
					</c:forEach>
				</ul>
		</div><!-- end of hotprod -->
		<span class="clr clr5"></span>
		</c:forEach>
			
	</div><!-- end of right -->
	
</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>