<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/product.css" rel="stylesheet" type="text/css" />
<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.tmpl.min.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/dialog.js" type="text/javascript"></script>
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
	
	$.addGoodsHistory = function(goodsid){
		var historyproduct = $.cookie('goodsHistoryList');
		//alert(historyproduct);
		if(historyproduct!=null){
			var tmps = historyproduct.split(",");
			var goods_id_remove = goodsid+"=1";
			newhistoryproduct = jQuery.grep(tmps,function(value) {
				return value != goods_id_remove;
			});
			newhistoryproduct.unshift(goods_id_remove);
			if(newhistoryproduct.length>6){
				newhistoryproduct.pop();
			}
			$.cookie('goodsHistoryList',newhistoryproduct,{expires:shop_constant.cookie_days,path:shop_constant.cookie_path});
		}else{
			$.cookie('goodsHistoryList',goodsid+"=1",{expires:shop_constant.cookie_days,path:shop_constant.cookie_path});
		}
	}
	
	$.addGoodsHistory('${product.goodsId}');
	
	/** 加入到购物车 **/
	$.addCartItem = function(goodsid, quantity) {
		var reg = /^[0-9]*[1-9][0-9]*$/;
		if (!reg.test($.trim(quantity))) {
			$.dialog({type: "warn", content: "商品数量必须为正整数!", modal: true, autoCloseTime: 3000});
			return false;
		}else{
			var cart_items = $.cookie('cartitems');			
			if(cart_items!=null){
				var tmps = cart_items.split(",");
				var is_replace = false;//是否替换
				var item_qty = jQuery.grep(tmps,function(value,i) {
					var values = value.split("=");
					if(goodsid==values[0]){
						tmps[i] = goodsid+'='+(parseInt(values[1])+parseInt(quantity));
						is_replace = true;
					}
				});
				if(!is_replace){
					tmps.push(goodsid+"="+quantity);
				}
				$.cookie('cartitems',tmps,{expires:shop_constant.cookie_days,path:shop_constant.cookie_path});
			}else{
				$.cookie('cartitems',goodsid+"="+quantity,{expires:shop_constant.cookie_days,path:shop_constant.cookie_path});
			}
			
			data = {
				message:'添加至购物车成功，本次添加商品数量',
				totalQuantity:'',
				totalPrice:''
			}			
			
 			$.dialog({type: "success", content: "<span class=\"red\">" + data.message + "</span><br />商品数量: " + quantity + "件", width: 360, modal: true, autoCloseTime: 3000});
			$.flushcartitems(true);
		}
	}
	
	$quantity = $("#quantity");
	$("#goodsButton").click(function(){
		$.addCartItem('${product.goodsId}',$quantity.val());
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
		<!-- 商家信息开始 -->
		<div class="boxa">
				<div class="mt">
					<h2 class="colorred">商家信息</h2>
				</div>
				<div class="mc padding8">
                    <p>所属商家：</p>
                    <p><span class="cpyname" id="strSellerCnName"><a href="<%=path %>/shop/1.xhtml" target="_blank">${shopInfo.shopName }</a></span></p>
                    <p class="clrline"></p> 
                    <p>您好：</p>
                    <p>有任何疑问请联系我们：</p>
                    <p class="clrline"></p>
                    <p>QQ：39947134</p>
                    <p>电话：<span><b>13510492695</b></span></p>
                    <p><a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=39947134&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:39947134:42" alt="点击这里给我发消息" title="点击这里给我发消息"></a></p>
				</div>
			</div><!-- 商家信息结束-->
		
		<span class="clr5"></span>
		
		<div class="m rank" id="rank537" style="display: block; ">
			<div class="mt">
				<h2>热卖商品</h2>
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
				</ul>
			</div>			
		</div><!-- end of rank537 -->
		
		<span class="clr5"></span>
		
		<div class="m rank" id="goodsHistory">
			<div class="mt">
				<h2>最近浏览过的商品</h2>
			</div>
			<div class="mc">
				<ul id="ul_goodsHistory">
					
				</ul>
			</div>		
		</div><!-- end of goodsHistory -->
	</div><!-- end of left -->
	
	
	
	
	<div class="right">
		<div id="name">
			<h1>${product.name }</h1>
		</div>
		<div id="preview">
			<div id="spec-n1" class="jqzoom"><img src="${bigphoto }" width="350" height="350"></div>
		    <span class="clr5"></span>
		    <div id="spec-list">
				<div style="position:relative;overflow:hidden;z-index:1;width:300px;height:56px;"><ul class="list-h" style="width: 420px; overflow-x: hidden; overflow-y: hidden; position: absolute; left: 0px; top: 0px; margin-top: 0px; margin-left: 0px; ">
					<ul>
                       <c:forEach items="${imageList}" var="b">
                       <li>
                           <a href="#"><img src="${b}" width="50" height="50" /></a>
                       </li>
                       </c:forEach>
					</ul>
				</div>
			</div>
		</div><!-- end of preview -->
		
		<ul id="summary">
			<li><span>商品编号：dsd</span></li>
			<li>
			    <div class="goodsInfo">
					<div class="lefta"></div>
					<div class="righta">
						<div class="top">
							商 城 价：<span id="price" class="price">￥${product.discountPriceStr }</span>
						</div>
						<div class="bottom">
							市 场 价：<span id="marketPrice" class="marketPrice">￥${product.priceStr }</span>
						</div>
					</div>
				</div>
			</li>
			
			<li>
				<span class="clr5"></span>
				<div id="buyInfo" class="buyInfo">
						<!-- 
						<div class="buyInfoTitle">
							<span id="buyInfoTitleLeft" class="buyInfoTitleLeft">已选择：</span>
							<span id="buyInfoTitleRight" class="buyInfoTitleRight">白色&nbsp;&nbsp;</span>
							<span id="closeHighlight" class="closeHighlight" title="关闭"></span>
						</div>
						 -->
					<div class="goodsInfoContent">
							<!-- <div id="goodsSpecificationValue" class="goodsSpecificationValue">
										<dl class="image">
											<dt>
												颜色：
											</dt>
													<dd class="402881862d11cd43012d122c0784007a {goodsSpecificationValueId: '402881862d11cd43012d122c0784007a'}" title="深红色">
														<img src="/upload/201012/22d939bc0913460b80e383d2717de526.gif">
														<span title="点击取消选择"></span>
													</dd>
													<dd class="402881862d11cd43012d122c08eb0084 {goodsSpecificationValueId: '402881862d11cd43012d122c08eb0084'}" title="银白色">
														<img src="/upload/201012/498ed15bd938432592dee5b78698c8c3.gif">
														<span title="点击取消选择"></span>
													</dd>
													<dd class="402881862d11cd43012d122c09490086 {goodsSpecificationValueId: '402881862d11cd43012d122c09490086'} selected" title="白色">
														<img src="/upload/201012/dc5d5eb559d848dfad1e1e647139098d.gif">
														<span title="点击取消选择"></span>
													</dd>
										</dl>
							</div>-->
						<div class="buyCount">
							购买数量：<input type="text" id="quantity" value="1">
						</div>
						<div class="buttonArea">
							<input type="button" id="goodsButton" class="addCartItemButton" value="" hidefocus="true">
	                        <input type="button" class="addFavoriteButton addFavorite {id: '402881862d25d2c9012d26d63deb0026'}" value="" hidefocus="true">
	                       </div>
					</div>
				</div>
			</li>
		</ul>
		
		<span class="clr"></span>
		
		<div class="m" id="detail">
				<ul class="tab">
					<li class="curr">商品介绍<span></span></li>
					<li>商品评论<span></span></li>
					<li>商家问答<span></span></li>
				</ul>
				<div class="tab_content" id="detail_0" style="display: none;">
						${product.goodsDesc }
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