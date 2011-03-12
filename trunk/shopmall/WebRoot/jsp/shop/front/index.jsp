<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/skin.css" rel="stylesheet" type="text/css" />
<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/jquery.tools.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
	jQuery(document).ready(function() {
		/* ---------- SliderScrollable ---------- */
    	var $sliderScrollable = $("#sliderScrollable");
	    if ($sliderScrollable.size() > 0) {
	        $sliderScrollable.scrollable({
	            circular: true,
	            speed: 500
	        }).autoscroll({
	            autoplay: true,
	            interval: 4000
	        }).navigator();
	    }
	    
	    
	});
//-->
</script>
</head>
<body id="index">
<!-- 顶部信息 -->
<div id="shortcut">
	<div class="w">
		<div class="collect" clstag="homepage|keycount|homepage|favorite"><b></b><a href="javascript:void(0)" onclick="addToFavorite()">收藏京东商城</a></div>
		<ul>
			<li class="fore1" id="loginfo">zhoucailun！欢迎来到京东商城！<span><a href="javascript:login();">[请登录]</a>，新用户？<a href="javascript:regist();" class="link-regist">[免费注册]</a></span></li>
			<li class="fore2"><a href="http://jd2008.360buy.com/JdHome/OrderList.aspx">我的订单</a></li>
			<li><a href="http://jd2008.360buy.com/user_home.aspx">我的京东</a></li>
			<li><a href="http://diy.360buy.com/" target="_blank">装机大师</a></li>
			<li><a href="http://market.360buy.com/giftcard/" target="_blank">礼品卡</a></li>
			<li><a href="http://market.360buy.com/giftcard/company/default.aspx" target="_blank">企业客户</a></li>
			<li class="sub">
			<dl>
				<dt><b></b><a href="http://www.360buy.com/help/" target="_blank">帮助中心</a></dt>
				<dd>
					<div><a href="http://jd2008.360buy.com/JdHome/OrderList.aspx">订单中心</a></div>
					<div><a href="http://jd2008.360buy.com/Repairs.aspx" target="_blank">返修中心</a></div>
					<div><a href="http://jd2008.360buy.com/complaint.aspx">投诉中心</a></div>
				</dd>
			</dl></li>
		</ul>
		<span class="clr"></span>
	</div>
</div>
<!-- 顶部信息结束 -->

<div class="w" id="header">
	<div id="logo">
		<a href="http://www.360buy.com/">
			<img src="<%=path %>/resources/front/images/logo.gif" alt="京东商城" width="251" height="46">
		</a>
	</div>
	<!-- 导航开始 -->
	<div id="nav">
		<div id="nav-index" clstag="homepage|keycount|homepage|home">
			<a href="http://www.360buy.com/">首页</a>
		</div>
		<div id="nav-extra">
			<ul>
				<li id="nav-pop" class="fore" clstag="homepage|keycount|homepage|pop">
					<a href="http://mall.360buy.com/">品牌直销</a>
					<b></b>
				</li>
				<li id="nav-tuan" clstag="homepage|keycount|homepage|tuan">
					<a href="http://tuan.360buy.com/">团购</a>
				</li>
				<li id="nav-auction" clstag="homepage|keycount|homepage|auction">
					<a href="http://auction.360buy.com/">夺宝岛</a>
				</li>
				<li id="nav-read" clstag="homepage|keycount|homepage|read">
					<a href="http://read.360buy.com/">在线读书</a>
				</li>
				<li id="nav-club" clstag="homepage|keycount|homepage|club">
					<a href="http://club.360buy.com/">京东社区</a>
				</li>
				<li id="nav-category" clstag="homepage|keycount|homepage|allsort">
					<a href="http://www.360buy.com/allSort.aspx">全部分类</a><b></b>
				</li>
			</ul>
			<div class="corner"></div>
		</div>
	</div>
	<span class="clr"></span>
	<!-- end of 导航开始 -->
	
	<!-- 搜索开始 -->
	<div id="o-search">
		<div class="allsort">
		</div>		
		<div id="search" class="form">
			<div id="i-search">
				<input type="text" id="key" value="" autocomplete="off" onkeydown="javascript:if(event.keyCode==13) search('key');">
				<ul id="tie" class="hide"></ul>
			</div>
			<input type="submit" value="搜&nbsp;索" id="btn-search" onclick="search('key');return false;">
		</div>
		<div id="hotwords">
			<strong>热门搜索：</strong>
			<a href="http://search.360buy.com/Search?keyword=华硕笔记本" target="_blank">华硕笔记本</a>
			<a href="http://search.360buy.com/Search?keyword=优恩" target="_blank">优恩</a>
			<a href="http://search.360buy.com/Search?keyword=吸油烟机" target="_blank">吸油烟机</a>
			<a href="http://search.360buy.com/Search?keyword=折叠自行车" target="_blank">折叠自行车</a>
			<a href="http://search.360buy.com/Search?keyword=纽曼GPS" target="_blank">纽曼GPS</a>
			<a href="http://search.360buy.com/Search?keyword=DELL笔记本" target="_blank">DELL笔记本</a>
			<a href="http://search.360buy.com/Search?keyword=方正笔记本" target="_blank">方正笔记本</a>
			<a href="http://search.360buy.com/Search?keyword=%B7%BD%D5%FD%B1%CA%BC%C7%B1%BE" target="_blank">方正笔记本</a>
			<a href="http://search.360buy.com/Search?keyword=%CF%A3%BD%DD%D2%C6%B6%AF%D3%B2%C5%CC&amp;cid=693&amp;page=1" target="_blank">希捷移动硬盘</a>
		</div>
		<ul id="mycart">
			<li class="fore1" id="i-mycart" load="true">
				<a href="http://jd2008.360buy.com/purchase/shoppingcart.aspx">购物车<b id="mycart-amount">0</b>件</a>
				<div id="o-mycart-list" class="hide" style="display: none; ">
					<div id="mycart-list">
						<div class="norecode ac">您的购物车中暂无商品，赶快选择心爱的商品吧！</div>
					</div>
				</div>
			</li>
			<li class="fore2">
				<a href="http://jd2008.360buy.com/purchase/ShoppingCart.aspx">去结算</a>
			</li>
		</ul>
	</div>
	<!-- 搜索结束 -->
</div>
<!-- 头部结束 -->

<!-- 正文开始 -->
<div class="w main">
	<div class="left">
		<!-- 品牌开始 -->
		<div class="m" id="brand" clstag="homepage|keycount|homepage|brand">
			<div class="mt">
				<h2>热门店铺</h2>
			</div>
			<div class="mc">
                   <ul>
                   <li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36209&amp;cus=9_501_7360_10809_10809000&amp;url=http://market.360buy.com/zhuanmai/hp/index.aspx?_mvsrc=430_5221_36209&amp;_mvcam=9_501_7360_10809_10809000&amp;_mven=c2c27e9e8a"><img width="88" height="31" src="http://img14.360buyimg.com/da/20110228/88_31_cuHtmr.jpg" alt="惠普"></a></li><li><a target="_blank" href="http://market.360buy.com/zhuanmai/joyoung/index.aspx"><img width="88" height="31" src="http://img13.360buyimg.com/da/20110228/88_31_kjWzso.jpg" alt="九阳"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36210&amp;cus=9_501_7361_10810_10810000&amp;url=http://market.360buy.com/zhuanmai/hpnotebook/index.aspx?_mvsrc=430_5221_36210&amp;_mvcam=9_501_7361_10810_10810000&amp;_mven=7d9eedac72"><img width="88" height="31" src="http://img10.360buyimg.com/da/20110228/88_31_Qeuzio.jpg" alt="惠普电脑"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36217&amp;cus=9_501_7368_10817_10817000&amp;url=http://market.360buy.com/zhuanmai/lenovo/index.aspx?_mvsrc=430_5221_36217&amp;_mvcam=9_501_7368_10817_10817000&amp;_mven=6bab0535eb"><img width="88" height="31" src="http://img11.360buyimg.com/da/20110228/88_31_VjKbZr.jpg" alt="联想"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36211&amp;cus=9_501_7362_10811_10811000&amp;url=http://market.360buy.com/zhuanmai/acer/index.aspx?_mvsrc=430_5221_36211&amp;_mvcam=9_501_7362_10811_10811000&amp;_mven=6503cf7ac1"><img width="88" height="31" src="http://img11.360buyimg.com/da/20110228/88_31_ANpmDk.jpg" alt="ACER"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36218&amp;cus=9_501_7369_10818_10818000&amp;url=http://market.360buy.com/zhuanmai/fujitsu/index.aspx?_mvsrc=430_5221_36218&amp;_mvcam=9_501_7369_10818_10818000&amp;_mven=23ace95e36"><img width="88" height="31" src="http://img10.360buyimg.com/da/20110228/88_31_ZXJZMd.jpg" alt="富士通"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36216&amp;cus=9_501_7367_10816_10816000&amp;url=http://market.360buy.com/zhuanmai/asus/index.aspx?_mvsrc=430_5221_36216&amp;_mvcam=9_501_7367_10816_10816000&amp;_mven=7f8e1a1c9c"><img width="88" height="31" src="http://img10.360buyimg.com/da/20110228/88_31_mzJTgq.jpg" alt="华硕"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36219&amp;cus=9_501_7370_10819_10819000&amp;url=http://market.360buy.com/zhuanmai/thinkpad/index.aspx?_mvsrc=430_5221_36219&amp;_mvcam=9_501_7370_10819_10819000&amp;_mven=589b30bd52"><img width="88" height="31" src="http://img12.360buyimg.com/da/20110228/88_31_fbwfqq.jpg" alt="THINKPAD"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36212&amp;cus=9_501_7363_10812_10812000&amp;url=http://market.360buy.com/zhuanmai/Dlink/index.aspx?_mvsrc=430_5221_36212&amp;_mvcam=9_501_7363_10812_10812000&amp;_mven=7c35334c46"><img width="88" height="31" src="http://img10.360buyimg.com/da/20110228/88_31_dGEUWI.jpg" alt="D-LINK"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36213&amp;cus=9_501_7364_10813_10813000&amp;url=http://market.360buy.com/zhuanmai/seagate/index.aspx?_mvsrc=430_5221_36213&amp;_mvcam=9_501_7364_10813_10813000&amp;_mven=46432c5102"><img width="88" height="31" src="http://img11.360buyimg.com/da/20110228/88_31_OEnyXa.jpg" alt="希捷"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36220&amp;cus=9_501_7371_10820_10820000&amp;url=http://market.360buy.com/zhuanmai/founder/index.aspx?_mvsrc=430_5221_36220&amp;_mvcam=9_501_7371_10820_10820000&amp;_mven=568e5588dc"><img width="88" height="31" src="http://img12.360buyimg.com/da/20110228/88_31_CwbzFj.jpg" alt="方正"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36214&amp;cus=9_501_7365_10814_10814000&amp;url=http://market.360buy.com/zhuanmai/weibao/index.aspx?_mvsrc=430_5221_36214&amp;_mvcam=9_501_7365_10814_10814000&amp;_mven=8fe2f82fc3"><img width="88" height="31" src="http://img11.360buyimg.com/da/20110228/88_31_BKvspG.jpg" alt="威宝"></a></li><li><a target="_blank" href="http://market.360buy.com/zhuanmai/yinglun/index.aspx"><img width="88" height="31" src="http://img14.360buyimg.com/da/20110228/88_31_otimYU.jpg" alt="JUSTYLE"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36221&amp;cus=9_501_7372_10821_10821000&amp;url=http://market.360buy.com/zhuanmai/hivi/index.aspx?_mvsrc=430_5221_36221&amp;_mvcam=9_501_7372_10821_10821000&amp;_mven=9159446789"><img width="88" height="31" src="http://img10.360buyimg.com/da/20110228/87_31_WhNdff.jpg" alt="惠威"></a></li><li><a target="_blank" href="http://market.360buy.com/zhuanmai/supor/index.aspx"><img width="88" height="31" src="http://img13.360buyimg.com/da/20110228/88_32_lLWUhr.jpg" alt="苏泊尔"></a></li><li><a target="_blank" href="http://market.360buy.com/zhuanmai/alcatel/index.aspx"><img width="88" height="31" src="http://img10.360buyimg.com/da/20110301/102_34_LsAlim.jpg" alt="阿尔卡特"></a></li>
                   <li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36209&amp;cus=9_501_7360_10809_10809000&amp;url=http://market.360buy.com/zhuanmai/hp/index.aspx?_mvsrc=430_5221_36209&amp;_mvcam=9_501_7360_10809_10809000&amp;_mven=c2c27e9e8a"><img width="88" height="31" src="http://img14.360buyimg.com/da/20110228/88_31_cuHtmr.jpg" alt="惠普"></a></li><li><a target="_blank" href="http://market.360buy.com/zhuanmai/joyoung/index.aspx"><img width="88" height="31" src="http://img13.360buyimg.com/da/20110228/88_31_kjWzso.jpg" alt="九阳"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36210&amp;cus=9_501_7361_10810_10810000&amp;url=http://market.360buy.com/zhuanmai/hpnotebook/index.aspx?_mvsrc=430_5221_36210&amp;_mvcam=9_501_7361_10810_10810000&amp;_mven=7d9eedac72"><img width="88" height="31" src="http://img10.360buyimg.com/da/20110228/88_31_Qeuzio.jpg" alt="惠普电脑"></a></li>
                   </ul>

                   <div class="extra"><a href="http://www.360buy.com/brand.aspx">更多&gt;&gt;</a></div>
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
		
		<div class="m" id="madding">
				<div class="mt">
					<h2>疯狂抢购</h2>
					<div class="extra"></div>
				</div>				
				<div class="mc">
					<ul class="p-list">
		                <li>
						<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000102803.html"><img src="http://img13.360buyimg.com/n3/9244/7994d47c-5826-4775-a170-9e29f72e3da4.jpg" width="130" height="130" alt="爱慕文胸" app="image:product"></a></div>
						<div class="p-name"><a target="_blank" title="爱慕文胸" href="http://www.360buy.com/product/1000102803.html">爱慕文胸<font color="#ff6600">打造性感丰满曲线!</font></a></div>
						<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000102803,2.png"></strong></div>
						
						</li>
						<li>
						<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000115800.html"><img src="http://img10.360buyimg.com/n3/5983/66b4b2ad-9528-45b9-b379-e7794f598134.jpg" width="130" height="130" alt="裂帛 无袖背心连衣裙" app="image:product"></a></div>
						<div class="p-name"><a target="_blank" title="裂帛 无袖背心连衣裙" href="http://www.360buy.com/product/1000115800.html">裂帛 无袖背心连衣裙</a></div>
						<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000115800,2.png"></strong></div>
						
						</li>
						<li>
						<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000125639.html"><img src="http://img14.360buyimg.com/n3/8886/2fd711e8-c7eb-482d-9384-319d5291d367.jpg" width="130" height="130" alt="ZIMMUR100%桑蚕丝连衣裙" app="image:product"></a></div>
						<div class="p-name"><a target="_blank" title="ZIMMUR100%桑蚕丝连衣裙" href="http://www.360buy.com/product/1000125639.html">ZIMMUR100%桑蚕丝连衣裙</a></div>
						<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000125639,2.png"></strong></div>
						
						</li>
						<li>
						<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000125400.html"><img src="http://img10.360buyimg.com/n3/7993/deb701b0-6ad4-4130-bf2d-1d1f266446a3.jpg" width="130" height="130" alt="O.SA  短袖缎面雪纺衬衫" app="image:product"></a></div>
						<div class="p-name"><a target="_blank" title="O.SA  短袖缎面雪纺衬衫" href="http://www.360buy.com/product/1000125400.html">O.SA  短袖缎面雪纺衬衫</a></div>
						<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000125400,2.png"></strong></div>
						
						</li>
						<li>
						<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000125808.html"><img src="http://img13.360buyimg.com/n3/9457/d3e27ef9-5aa3-42d1-809b-f8c27eb233ed.jpg" width="130" height="130" alt="韩都衣舍  蝙蝠袖针织衫" app="image:product"></a></div>
						<div class="p-name"><a target="_blank" title="韩都衣舍  蝙蝠袖针织衫" href="http://www.360buy.com/product/1000125808.html">韩都衣舍  蝙蝠袖针织衫</a></div>
						<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000125808,2.png"></strong></div>
						
						</li>
						<li>
						<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000135035.html"><img src="http://img10.360buyimg.com/n3/7777/e867406d-5080-4210-a60f-5206b63f42de.jpg" width="130" height="130" alt="艾米  真丝大围巾" app="image:product"></a></div>
						<div class="p-name"><a target="_blank" title="艾米  真丝大围巾" href="http://www.360buy.com/product/1000135035.html">艾米  真丝大围巾</a></div>
						<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000135035,2.png"></strong></div>				
						</li>
						<li>
						<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000135035.html"><img src="http://img10.360buyimg.com/n3/7777/e867406d-5080-4210-a60f-5206b63f42de.jpg" width="130" height="130" alt="艾米  真丝大围巾" app="image:product"></a></div>
						<div class="p-name"><a target="_blank" title="艾米  真丝大围巾" href="http://www.360buy.com/product/1000135035.html">艾米  真丝大围巾</a></div>
						<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000135035,2.png"></strong></div>				
						</li>
						<li>
						<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000135035.html"><img src="http://img10.360buyimg.com/n3/7777/e867406d-5080-4210-a60f-5206b63f42de.jpg" width="130" height="130" alt="艾米  真丝大围巾" app="image:product"></a></div>
						<div class="p-name"><a target="_blank" title="艾米  真丝大围巾" href="http://www.360buy.com/product/1000135035.html">艾米  真丝大围巾</a></div>
						<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000135035,2.png"></strong></div>				
						</li>
					</ul>
				</div>
		</div><!-- end of madding -->
		<span class="clr5"></span>
		
		<div class="m" id="hotprod" clstag="homepage|keycount|homepage|newpros">
				<div class="mt">
					<h2>热卖商品</h2>
					<div class="extra"><a href="special.aspx?id=2&amp;cid=0">更多&gt;&gt;</a></div>
				</div>
				<ul class="p-list">
	                <li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000102803.html"><img src="http://img13.360buyimg.com/n3/9244/7994d47c-5826-4775-a170-9e29f72e3da4.jpg" width="130" height="130" alt="爱慕文胸" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="爱慕文胸" href="http://www.360buy.com/product/1000102803.html">爱慕文胸<font color="#ff6600">打造性感丰满曲线!</font></a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000102803,2.png"></strong></div>
					
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000115800.html"><img src="http://img10.360buyimg.com/n3/5983/66b4b2ad-9528-45b9-b379-e7794f598134.jpg" width="130" height="130" alt="裂帛 无袖背心连衣裙" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="裂帛 无袖背心连衣裙" href="http://www.360buy.com/product/1000115800.html">裂帛 无袖背心连衣裙</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000115800,2.png"></strong></div>
					
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000125639.html"><img src="http://img14.360buyimg.com/n3/8886/2fd711e8-c7eb-482d-9384-319d5291d367.jpg" width="130" height="130" alt="ZIMMUR100%桑蚕丝连衣裙" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="ZIMMUR100%桑蚕丝连衣裙" href="http://www.360buy.com/product/1000125639.html">ZIMMUR100%桑蚕丝连衣裙</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000125639,2.png"></strong></div>
					
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000125400.html"><img src="http://img10.360buyimg.com/n3/7993/deb701b0-6ad4-4130-bf2d-1d1f266446a3.jpg" width="130" height="130" alt="O.SA  短袖缎面雪纺衬衫" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="O.SA  短袖缎面雪纺衬衫" href="http://www.360buy.com/product/1000125400.html">O.SA  短袖缎面雪纺衬衫</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000125400,2.png"></strong></div>
					
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000125808.html"><img src="http://img13.360buyimg.com/n3/9457/d3e27ef9-5aa3-42d1-809b-f8c27eb233ed.jpg" width="130" height="130" alt="韩都衣舍  蝙蝠袖针织衫" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="韩都衣舍  蝙蝠袖针织衫" href="http://www.360buy.com/product/1000125808.html">韩都衣舍  蝙蝠袖针织衫</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000125808,2.png"></strong></div>
					
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000135035.html"><img src="http://img10.360buyimg.com/n3/7777/e867406d-5080-4210-a60f-5206b63f42de.jpg" width="130" height="130" alt="艾米  真丝大围巾" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="艾米  真丝大围巾" href="http://www.360buy.com/product/1000135035.html">艾米  真丝大围巾</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000135035,2.png"></strong></div>				
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000135035.html"><img src="http://img10.360buyimg.com/n3/7777/e867406d-5080-4210-a60f-5206b63f42de.jpg" width="130" height="130" alt="艾米  真丝大围巾" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="艾米  真丝大围巾" href="http://www.360buy.com/product/1000135035.html">艾米  真丝大围巾</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000135035,2.png"></strong></div>				
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000135035.html"><img src="http://img10.360buyimg.com/n3/7777/e867406d-5080-4210-a60f-5206b63f42de.jpg" width="130" height="130" alt="艾米  真丝大围巾" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="艾米  真丝大围巾" href="http://www.360buy.com/product/1000135035.html">艾米  真丝大围巾</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000135035,2.png"></strong></div>				
					</li>
				</ul>
		</div><!-- end of hotprod -->
		<span class="clr clr5"></span>
		
		<div class="m" id="newpros" clstag="homepage|keycount|homepage|newpros">
				<div class="mt">
					<h2>新品上架</h2>
					<div class="extra"><a href="special.aspx?id=2&amp;cid=0">更多&gt;&gt;</a></div>
				</div>
				<ul class="p-list">
	                <li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000102803.html"><img src="http://img13.360buyimg.com/n3/9244/7994d47c-5826-4775-a170-9e29f72e3da4.jpg" width="130" height="130" alt="爱慕文胸" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="爱慕文胸" href="http://www.360buy.com/product/1000102803.html">爱慕文胸<font color="#ff6600">打造性感丰满曲线!</font></a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000102803,2.png"></strong></div>
					
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000115800.html"><img src="http://img10.360buyimg.com/n3/5983/66b4b2ad-9528-45b9-b379-e7794f598134.jpg" width="130" height="130" alt="裂帛 无袖背心连衣裙" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="裂帛 无袖背心连衣裙" href="http://www.360buy.com/product/1000115800.html">裂帛 无袖背心连衣裙</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000115800,2.png"></strong></div>
					
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000125639.html"><img src="http://img14.360buyimg.com/n3/8886/2fd711e8-c7eb-482d-9384-319d5291d367.jpg" width="130" height="130" alt="ZIMMUR100%桑蚕丝连衣裙" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="ZIMMUR100%桑蚕丝连衣裙" href="http://www.360buy.com/product/1000125639.html">ZIMMUR100%桑蚕丝连衣裙</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000125639,2.png"></strong></div>
					
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000125400.html"><img src="http://img10.360buyimg.com/n3/7993/deb701b0-6ad4-4130-bf2d-1d1f266446a3.jpg" width="130" height="130" alt="O.SA  短袖缎面雪纺衬衫" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="O.SA  短袖缎面雪纺衬衫" href="http://www.360buy.com/product/1000125400.html">O.SA  短袖缎面雪纺衬衫</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000125400,2.png"></strong></div>
					
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000125808.html"><img src="http://img13.360buyimg.com/n3/9457/d3e27ef9-5aa3-42d1-809b-f8c27eb233ed.jpg" width="130" height="130" alt="韩都衣舍  蝙蝠袖针织衫" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="韩都衣舍  蝙蝠袖针织衫" href="http://www.360buy.com/product/1000125808.html">韩都衣舍  蝙蝠袖针织衫</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000125808,2.png"></strong></div>
					
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000135035.html"><img src="http://img10.360buyimg.com/n3/7777/e867406d-5080-4210-a60f-5206b63f42de.jpg" width="130" height="130" alt="艾米  真丝大围巾" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="艾米  真丝大围巾" href="http://www.360buy.com/product/1000135035.html">艾米  真丝大围巾</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000135035,2.png"></strong></div>				
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000135035.html"><img src="http://img10.360buyimg.com/n3/7777/e867406d-5080-4210-a60f-5206b63f42de.jpg" width="130" height="130" alt="艾米  真丝大围巾" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="艾米  真丝大围巾" href="http://www.360buy.com/product/1000135035.html">艾米  真丝大围巾</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000135035,2.png"></strong></div>				
					</li>
					<li>
					<div class="p-img"><a target="_blank" href="http://www.360buy.com/product/1000135035.html"><img src="http://img10.360buyimg.com/n3/7777/e867406d-5080-4210-a60f-5206b63f42de.jpg" width="130" height="130" alt="艾米  真丝大围巾" app="image:product"></a></div>
					<div class="p-name"><a target="_blank" title="艾米  真丝大围巾" href="http://www.360buy.com/product/1000135035.html">艾米  真丝大围巾</a></div>
					<div class="p-price">京东价：<strong><img app="image:price" onerror="this.src='http://www.360buy.com/images/no2.gif'" src="http://price.360buy.com/gp1000135035,2.png"></strong></div>				
					</li>
				</ul>
		</div><!-- end of newpros -->
		<span class="clr clr5"></span>		
	</div><!-- end of right -->
	
</div><!-- end of 正文 -->
<div class="clr"></div>

<!-- footer -->
<div class="w">
	<div id="service">
		<dl class="fore1">
			<dt><b></b><strong>购物指南</strong></dt>
			<dd>
				<div class="item">·<a href="http://www.360buy.com/help/flow.aspx" target="_blank">购物流程</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/member.aspx" target="_blank">会员介绍</a></div>
			    <div class="item">·<a href="http://www.360buy.com/help/order.aspx" target="_blank">订单状态</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/faq.aspx" target="_blank">常见问题</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/helectronic.aspx" target="_blank">大家电</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/callcenter.aspx" target="_blank">联系客服</a></div>
			</dd>
		</dl>
		<dl class="fore2">
			<dt><b></b><strong>配送方式</strong></dt>
			<dd>
				<div class="item">·<a href="http://www.360buy.com/help/ziti.aspx" target="_blank">上门自提</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/kdexpress.aspx" target="_blank">快递运输</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/ems.aspx" target="_blank">特快专递（EMS）</a></div>
				<div class="item">·<a href="http://market.360buy.com/giftcard/index.html#one5" target="_blank">如何送礼</a></div>
			</dd>
		</dl>
		<dl class="fore3">
			<dt><b></b><strong>支付方式</strong></dt>
			<dd>
				<div class="item">·<a href="http://www.360buy.com/help/cod.aspx" target="_blank">货到付款</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/onlinepay.aspx" target="_blank">在线支付</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/dividedpay.aspx" target="_blank">分期付款</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/postage.aspx" target="_blank">邮局汇款</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/transfer.aspx" target="_blank">公司转账</a></div>
			</dd>
		</dl>
		<dl class="fore4">
			<dt><b></b><strong>售后服务</strong></dt>
			<dd>
				<div class="item">·<a href="http://www.360buy.com/help/return_policy.aspx" target="_blank">退换货政策</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/return_flow.aspx" target="_blank">退换货流程</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/price.aspx" target="_blank">价格保护</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/refundment.aspx" target="_blank">退款说明</a></div>
				<div class="item">·<a href="http://jd2008.360buy.com/Repairs.aspx" target="_blank">返修申请</a></div>
				<div class="item">·<a href="http://jd2008.360buy.com/user_refundment.aspx" target="_blank">退款申请</a></div>
			</dd>
		</dl>
		<dl class="fore5">
			<dt><b></b><strong>特色服务</strong></dt>
			<dd>
				<div class="item">·<a href="http://www.360buy.com/help/bid.aspx" target="_blank">夺宝岛</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/diy.aspx" target="_blank">DIY装机</a></div>
				<div class="item">·<a href="http://market.360buy.com/hd/yanbao090702/ind.html" target="_blank">延保服务</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/elec_godown.aspx" target="_blank">家电下乡</a></div>
				<div class="item">·<a href="http://market.360buy.com/giftcard/index.html" target="_blank">京东礼品卡</a></div>
				<div class="item">·<a href="http://www.360buy.com/help/oldnew.aspx" target="_blank">家电以旧换新</a></div>
			</dd>

		</dl>
		<div class="clr"></div>
		
	</div>
</div><!-- end of foot -->


<div class="w" id="footer">
	<div class="flinks">
		<a href="http://www.360buy.com/intro/about.aspx" target="_blank">关于我们</a>|
		<a href="http://www.360buy.com/contact/" target="_blank">联系我们</a>|
		<a href="http://www.360buy.com/intro/job.aspx" target="_blank">人才招聘</a>|
		<a href="http://www.360buy.com/contact/joinin.aspx" target="_blank">商家入驻</a>|
		<a href="http://www.360buy.com/intro/service.aspx" target="_blank">广告服务</a>|
		<a href="http://app.360buy.com/" target="_blank">移动终端</a>|
		<a href="http://club.360buy.com/links.aspx" target="_blank">友情链接</a>|
		<a href="http://cps.360buy.com/" target="_blank">销售联盟</a>
	</div>
	<div class="copyright">
		北京市公安局海淀分局备案编号：1101081681&nbsp;&nbsp;京ICP证070359号&nbsp;&nbsp;
		<a href="http://misc.360buyimg.com/skin/df/i/com/f_music.jpg" target="_blank">音像制品经营许可证苏宿批005 号</a>
		<br>Copyright©2010-2011&nbsp;&nbsp;0794buy抚州网上购物商城&nbsp;版权所有
	</div>	
</div>

</body>
</html>