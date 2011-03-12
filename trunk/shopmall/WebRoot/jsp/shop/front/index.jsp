<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>测试首页</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/skin.css" rel="stylesheet" type="text/css" />
<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/jquery.jcarousel.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
	jQuery(document).ready(function() {
		jQuery('#mycarousel').jcarousel();	
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
			<img src="http://misc.360buyimg.com/201006/skin/df/i/logo.gif" alt="京东商城" width="251" height="46">
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
                   <ul><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36209&amp;cus=9_501_7360_10809_10809000&amp;url=http://market.360buy.com/zhuanmai/hp/index.aspx?_mvsrc=430_5221_36209&amp;_mvcam=9_501_7360_10809_10809000&amp;_mven=c2c27e9e8a"><img width="88" height="31" src="http://img14.360buyimg.com/da/20110228/88_31_cuHtmr.jpg" alt="惠普"></a></li><li><a target="_blank" href="http://market.360buy.com/zhuanmai/joyoung/index.aspx"><img width="88" height="31" src="http://img13.360buyimg.com/da/20110228/88_31_kjWzso.jpg" alt="九阳"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36210&amp;cus=9_501_7361_10810_10810000&amp;url=http://market.360buy.com/zhuanmai/hpnotebook/index.aspx?_mvsrc=430_5221_36210&amp;_mvcam=9_501_7361_10810_10810000&amp;_mven=7d9eedac72"><img width="88" height="31" src="http://img10.360buyimg.com/da/20110228/88_31_Qeuzio.jpg" alt="惠普电脑"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36217&amp;cus=9_501_7368_10817_10817000&amp;url=http://market.360buy.com/zhuanmai/lenovo/index.aspx?_mvsrc=430_5221_36217&amp;_mvcam=9_501_7368_10817_10817000&amp;_mven=6bab0535eb"><img width="88" height="31" src="http://img11.360buyimg.com/da/20110228/88_31_VjKbZr.jpg" alt="联想"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36211&amp;cus=9_501_7362_10811_10811000&amp;url=http://market.360buy.com/zhuanmai/acer/index.aspx?_mvsrc=430_5221_36211&amp;_mvcam=9_501_7362_10811_10811000&amp;_mven=6503cf7ac1"><img width="88" height="31" src="http://img11.360buyimg.com/da/20110228/88_31_ANpmDk.jpg" alt="ACER"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36218&amp;cus=9_501_7369_10818_10818000&amp;url=http://market.360buy.com/zhuanmai/fujitsu/index.aspx?_mvsrc=430_5221_36218&amp;_mvcam=9_501_7369_10818_10818000&amp;_mven=23ace95e36"><img width="88" height="31" src="http://img10.360buyimg.com/da/20110228/88_31_ZXJZMd.jpg" alt="富士通"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36216&amp;cus=9_501_7367_10816_10816000&amp;url=http://market.360buy.com/zhuanmai/asus/index.aspx?_mvsrc=430_5221_36216&amp;_mvcam=9_501_7367_10816_10816000&amp;_mven=7f8e1a1c9c"><img width="88" height="31" src="http://img10.360buyimg.com/da/20110228/88_31_mzJTgq.jpg" alt="华硕"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36219&amp;cus=9_501_7370_10819_10819000&amp;url=http://market.360buy.com/zhuanmai/thinkpad/index.aspx?_mvsrc=430_5221_36219&amp;_mvcam=9_501_7370_10819_10819000&amp;_mven=589b30bd52"><img width="88" height="31" src="http://img12.360buyimg.com/da/20110228/88_31_fbwfqq.jpg" alt="THINKPAD"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36212&amp;cus=9_501_7363_10812_10812000&amp;url=http://market.360buy.com/zhuanmai/Dlink/index.aspx?_mvsrc=430_5221_36212&amp;_mvcam=9_501_7363_10812_10812000&amp;_mven=7c35334c46"><img width="88" height="31" src="http://img10.360buyimg.com/da/20110228/88_31_dGEUWI.jpg" alt="D-LINK"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36213&amp;cus=9_501_7364_10813_10813000&amp;url=http://market.360buy.com/zhuanmai/seagate/index.aspx?_mvsrc=430_5221_36213&amp;_mvcam=9_501_7364_10813_10813000&amp;_mven=46432c5102"><img width="88" height="31" src="http://img11.360buyimg.com/da/20110228/88_31_OEnyXa.jpg" alt="希捷"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36220&amp;cus=9_501_7371_10820_10820000&amp;url=http://market.360buy.com/zhuanmai/founder/index.aspx?_mvsrc=430_5221_36220&amp;_mvcam=9_501_7371_10820_10820000&amp;_mven=568e5588dc"><img width="88" height="31" src="http://img12.360buyimg.com/da/20110228/88_31_CwbzFj.jpg" alt="方正"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36214&amp;cus=9_501_7365_10814_10814000&amp;url=http://market.360buy.com/zhuanmai/weibao/index.aspx?_mvsrc=430_5221_36214&amp;_mvcam=9_501_7365_10814_10814000&amp;_mven=8fe2f82fc3"><img width="88" height="31" src="http://img11.360buyimg.com/da/20110228/88_31_BKvspG.jpg" alt="威宝"></a></li><li><a target="_blank" href="http://market.360buy.com/zhuanmai/yinglun/index.aspx"><img width="88" height="31" src="http://img14.360buyimg.com/da/20110228/88_31_otimYU.jpg" alt="JUSTYLE"></a></li><li><a target="_blank" href="http://click.mediav.com/c?type=2&amp;db=mediav&amp;pub=430_5221_36221&amp;cus=9_501_7372_10821_10821000&amp;url=http://market.360buy.com/zhuanmai/hivi/index.aspx?_mvsrc=430_5221_36221&amp;_mvcam=9_501_7372_10821_10821000&amp;_mven=9159446789"><img width="88" height="31" src="http://img10.360buyimg.com/da/20110228/87_31_WhNdff.jpg" alt="惠威"></a></li><li><a target="_blank" href="http://market.360buy.com/zhuanmai/supor/index.aspx"><img width="88" height="31" src="http://img13.360buyimg.com/da/20110228/88_32_lLWUhr.jpg" alt="苏泊尔"></a></li><li><a target="_blank" href="http://market.360buy.com/zhuanmai/alcatel/index.aspx"><img width="88" height="31" src="http://img10.360buyimg.com/da/20110301/102_34_LsAlim.jpg" alt="阿尔卡特"></a></li></ul>

                   <div class="extra"><a href="http://www.360buy.com/brand.aspx">更多&gt;&gt;</a></div>
			</div>
		</div><!-- 品牌结束 -->
	</div><!-- end of left -->
	
	<div class="right">
		<ul id="mycarousel" class="jcarousel-skin-tango"> 
		    <li><img src="http://static.flickr.com/66/199481236_dc98b5abb3_s.jpg" width="75" height="75" alt="" /></li> 
		    <li><img src="http://static.flickr.com/75/199481072_b4a0d09597_s.jpg" width="75" height="75" alt="" /></li> 
		    <li><img src="http://static.flickr.com/57/199481087_33ae73a8de_s.jpg" width="75" height="75" alt="" /></li> 
		    <li><img src="http://static.flickr.com/77/199481108_4359e6b971_s.jpg" width="75" height="75" alt="" /></li> 
		    <li><img src="http://static.flickr.com/58/199481143_3c148d9dd3_s.jpg" width="75" height="75" alt="" /></li> 
		    <li><img src="http://static.flickr.com/72/199481203_ad4cdcf109_s.jpg" width="75" height="75" alt="" /></li> 
		    <li><img src="http://static.flickr.com/58/199481218_264ce20da0_s.jpg" width="75" height="75" alt="" /></li> 
		    <li><img src="http://static.flickr.com/69/199481255_fdfe885f87_s.jpg" width="75" height="75" alt="" /></li> 
		    <li><img src="http://static.flickr.com/60/199480111_87d4cb3e38_s.jpg" width="75" height="75" alt="" /></li> 
		    <li><img src="http://static.flickr.com/70/229228324_08223b70fa_s.jpg" width="75" height="75" alt="" /></li> 
		</ul>
	</div><!-- end of middle -->
</div>

</body>
</html>