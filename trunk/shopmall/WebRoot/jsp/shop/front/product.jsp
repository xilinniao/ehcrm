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
<script type="text/javascript">
<!--
$(document).ready(function() {
	//view-source:http://www.sohtanaka.com/web-design/examples/tabs/
	//$(".tab_content").hide();
	$("ul.tab li:first").addClass("curr").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content	
	//On Click Event
	$("ul.tab li").click(function() {
		$("ul.tab li").removeClass("curr"); //Remove any "active" class
		$(this).addClass("curr"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content
		$('#detail'+'_'+$("ul.tab li").index($(this))).fadeIn();
		return false;
	});
});
//-->
</script>
</head>
<body id="index">
<%@include file="/jsp/shop/front/common/top.jsp"%>

<div class="w">
	    <div class="crumb">
         <a href="http://www.360buy.com">首页</a>&nbsp;&gt;&nbsp;<a href="http://www.360buy.com/electronic.html">家用电器、汽车用品</a>&nbsp;&gt;&nbsp;<a href="http://www.360buy.com/products/737-794-000.html">大 家 电</a>&nbsp;&gt;&nbsp;<a href="http://www.360buy.com/products/737-794-798.html">平板电视</a>&nbsp;&gt;&nbsp;<a href="http://www.360buy.com/brands/798-2182.html">LG</a>&nbsp;&gt;&nbsp;<a href="http://www.360buy.com/product/277669.html">LG32LD320-CA</a>
        </div>
</div>
	
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
		<div id="name" pshowskuid="277669">
				<h1>LG 32LD320-CA 32英寸 高清液晶电视<font style="color:#ff0000" id="advertiseWord">多种影音模式，智能节电技术，观赏感受，如临现场！</font></h1>
		</div>
		<div id="preview">
				<div id="spec-n1" class="jqzoom" onclick="window.open('http://www.360buy.com/bigimage.aspx?id=177177')"><img onerror="this.src='http://www.360buy.com/images/none/none_347.gif'" src="http://img12.360buyimg.com/n1/133/85d203c9-9b4f-4530-9753-24c3480a7af3.jpg" width="350" height="350" alt="松下（Panasonic）KX-TG71CN 子母机 （石榴红）" jqimg="http://img12.360buyimg.com/n0/133/85d203c9-9b4f-4530-9753-24c3480a7af3.jpg"></div>
			    <div class="control" id="spec-left"></div>
			    <div class="control" id="spec-right"></div>
			    <div id="spec-list">
					<div style="position:relative;overflow:hidden;z-index:1;width:300px;height:56px;"><ul class="list-h" style="width: 420px; overflow-x: hidden; overflow-y: hidden; position: absolute; left: 0px; top: 0px; margin-top: 0px; margin-left: 0px; ">
                        
                        <li>
                            <img onerror="this.src='http://www.360buy.com/images/none/none_50.gif'" src="http://img12.360buyimg.com/n5/133/85d203c9-9b4f-4530-9753-24c3480a7af3.jpg" width="50" height="50" alt="松下（Panasonic）KX-TG71CN 子母机 （石榴红）" name="133/85d203c9-9b4f-4530-9753-24c3480a7af3.jpg" style="border-top-width: 1px; border-right-width: 1px; border-bottom-width: 1px; border-left-width: 1px; border-top-style: solid; border-right-style: solid; border-bottom-style: solid; border-left-style: solid; border-top-color: rgb(204, 204, 204); border-right-color: rgb(204, 204, 204); border-bottom-color: rgb(204, 204, 204); border-left-color: rgb(204, 204, 204); padding-top: 2px; padding-right: 2px; padding-bottom: 2px; padding-left: 2px; "></li>
                        
                        <li>
                            <img onerror="this.src='http://www.360buy.com/images/none/none_50.gif'" src="http://img12.360buyimg.com/n5/499/41aa7269-09d5-4967-bf75-529d68d98c98.jpg" width="50" height="50" alt="松下（Panasonic）KX-TG71CN 子母机 （石榴红）" name="499/41aa7269-09d5-4967-bf75-529d68d98c98.jpg"></li>
                        
                        <li>
                            <img onerror="this.src='http://www.360buy.com/images/none/none_50.gif'" src="http://img12.360buyimg.com/n5/2816/0474ec71-0261-4c90-975d-51e03d41ab37.jpg" width="50" height="50" alt="松下（Panasonic）KX-TG71CN 子母机 （石榴红）" name="2816/0474ec71-0261-4c90-975d-51e03d41ab37.jpg"></li>                        
                        
					</ul></div>
				</div>
			</div><!-- end of preview -->
		
		<ul id="summary">
			<li><span>商品编号：177177</span></li>
			<li>
			    <div class="fl">京&nbsp;东&nbsp;价：<strong class="price">￥6094.00</strong></div>
			    <div class="clr"></div>
			</li>
               <li class="clearfix">
   				<span class="fl">商品评分：</span>
				<div class="fl" id="star177177"><div class="star sa5">44</div><a href="http://www.360buy.com/product/177177.html#comment" class="num-comment">(已有68人评价)</a></div>
			</li>
               <li id="cx" class="hide" style="display: list-item; "><table cellpadding="0" cellspacing="0" border="0"><tbody><tr><td valign="top">促销信息：</td><td><font color="#ef0000">已优惠￥120.00</font></td></tr></tbody></table></li>     <!--促销-->
               <li id="tz" class="hide"></li>
               <li id="mfms" class="hide"></li>
               <li id="liLargess" class="clearfix hide"></li>
               <li id="nocoupon" class="hide"></li><!--不能开增值税发票-->
               <li id="service-trade" class="item hide"></li><!--以旧换新-->
		</ul>
		
		<span class="clr"></span>
		
		<div class="m" id="detail">
				<ul class="tab">
					<li class="curr">商品介绍<span></span></li>
					<li>商品评论<span></span></li>
					<li>商家问答<span></span></li>
				</ul>
				<div class="tab_content" id="detail_0" style="display: none;">
						商品内容
				</div><!--tabcon end-->
				<div class="tab_content" id="detail_1" style="display: block; ">
                   <div id="i-comment">
                   		<div class="rate">
							<strong>94%</strong> <br> 好评度 
                   		</div>
						<div class="percent">
							<dl>
								<dt>好评</dt>
								<dd class="d1">
									<div style="width: 141px;"></div>
								</dd>
								<dd class="d2">94%</dd>
							</dl>
							<dl>
								<dt>中评</dt>
								<dd class="d1">
									<div style="width: 9px;"></div>
								</dd>
								<dd class="d2"> 6%</dd> 
							</dl>
							<dl>
								<dt>差评</dt>
								<dd class="d1">
									<div style="width: 15px;"></div>
								</dd>
								<dd class="d2"> 6%</dd> 
							</dl>
						</div>
						<div class="btns"> 
							<div> 我购买过此商品</div> 
								<a href="http://club.360buy.com/Simplereview/346474.html" class="btn-comment">我要评价</a>
							<div>
								<a href="http://club.360buy.com/review/346474-1-1.html" target="_blank">查看全部评价</a>
							</div>
						</div>
					</div><!-- end of i-comment -->
					
					<div id="comment">
						<c:forEach var="x" begin="1" end="9" step="1">
						<div class="i-item">
							<div class="o-topic">
								<strong class="topic">
									这个确实不错
								</strong>
								<span class="star sa5"></span>
								<span class="date-comment">2011-03-23 23:43</span>
							</div>
							<div class="comment-content">
								<dl> 
									<dt>优点：</dt> 
									<dd> 看着很不错。</dd> 
								</dl> 
								<dl> 
									<dt>不足：</dt> 
									<dd> 底座不能升降 这点不够</dd> 
								</dl>  
								<dl> 
									<dt>使用心得：</dt> 
									<dd> 海信还是值得信赖的，呵呵&nbsp;够清晰&nbsp;够轻巧&nbsp;够犀利&nbsp;薄啊.....</dd> 
								</dl> 
							</div>
						</div><!-- end of i-item -->						
						<div class="corner tl"> </div>
						<div class="corner tr"> </div>
						<div class="corner b"> </div>
						<div class="corner bl"> </div>
						<div class="corner br"> </div>
						<div class="clr5"></div>
						</c:forEach>
						
					</div>
				</div><!--tabcon end-->
				<div class="tab_content" id="detail_2" style="display: none; ">
                  	商品咨询
				</div><!--tabcon end-->
			</div><!-- end of detail -->
			
	</div><!-- end of right -->
	
</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>