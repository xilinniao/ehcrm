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
	    	<li class="sel"><a href="http://shop.360hqb.com/21743/index.html" target="_top" title="烟雨蒙蒙三月天首页"><span>店铺首页</span></a></li>
	        <li><a href="http://shop.360hqb.com/21743/introduce.html" target="_top" title="烟雨蒙蒙三月天店铺介绍"><span>店铺介绍</span></a></li>
	        <li><a href="http://shop.360hqb.com/21743/credit.html" title="烟雨蒙蒙三月天店铺的信誉评价" target="_top"><span>信誉评价</span></a></li>
	    </ul>
	</div>
	
	<div class="blank_10px"></div>
	
	<div class="shop_norm_l_nav">
	<div class="l_sidebar">
	<!-- 商铺基本信息 -->
	<div class="shop_bisc_info">
		<div class="s_t">
			<h1>${shop.shopName }</h1>
		</div>
		<div class="shop_grade_comm" style="cursor:pointer;" onclick="window.location.href='http://shop.360hqb.com/21743/credit.html'">
			如实描述：<span class="star_grade_i">
				<i class="s_00"></i>
			</span>
			<em>0.0分</em>
		</div>
		<div class="shop_grade_comm" style="cursor:pointer;" onclick="window.location.href='http://shop.360hqb.com/21743/credit.html'">
			服务态度：<span class="star_grade_i">
				<i class="s_00"></i>
			</span>
			<em>0.0分</em>
		</div>
		<div class="shop_grade_comm" style="cursor:pointer;" onclick="window.location.href='http://shop.360hqb.com/21743/credit.html'">
			发货速度：<span class="star_grade_i">
				<i class="s_00"></i>
			</span>
			<em>0.0分</em>
		</div>
		<!--<div class="described liveness">活&nbsp;&nbsp;跃&nbsp;&nbsp;度：<span class="st_numst_nst_ust_m"></span></div>-->
		<div class="bot_line"></div>
		<div class="shop_status_au">认&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;证：
			<img alt="实名认证" title="实名认证" src="<%=path %>/resources/front/images/icon/rz.gif"> </div>
			<div class="bot_line"></div>
			<div class="shop_o_t_i_info">
				<table cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<th>店铺地址：</th>
							<td>${shop.shopAddr }</td>
						</tr>
						<tr>
							<th>开店时间：</th>
							<td>${shop.foundDate }</td>
						</tr>
						
						<tr>
							<th>在线客服：</th>
							<!-- Live800在线客服图标:店铺图标代码[固定型] 开始-->
							<td>
								<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=294144892&amp;site=qq&amp;menu=yes">
									<img border="0" src="http://wpa.qq.com/pa?p=2:294144892:47" alt="给我发消息" title="给我发消息"></a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="bot_line"></div>
				<div class="os_link" style="position:relative;">
					<a class="go_s_h" href="http://shop.360hqb.com/21743/index.html" target="_self" title="店铺首页"></a>
					<a class="s_fav addFavorite" href="javascript:;" title="收藏该店铺"></a>
				</div>
			</div>
			<!-- 搜索店内商品 -->
			<div class="l_gray_tit">搜索店内商品</div>
			<div class="shop_in_sch">
				<div class="f_s">
					<form name="shopSearchForm" action="http://shop.360hqb.com/21743/search.html" method="get">
					<div class="l_nav">关键字：<input class="gray_c" type="text" name="searchkey" maxlength="30" id="searchkey" value="" style="width:112px;"></div>
					<div class="l_nav">价　格：<input onblur="checkNum(price1);" class="gray_c" type="text" name="price1" id="price1" value="" style="width:44px;"> 到 <input onblur="checkNum(price2);" class="gray_c" type="text" name="price2" id="price2" value="" style="width:44px;"></div>
					<div class="b_nav">
						<input class="s_in_s_btn" type="submit" value=""></div>
					</form>
				</div>
			</div>
			<!-- 店铺商品分类 -->
			<div class="l_gray_tit">店铺商品分类</div>
			<div class="shop_pord_catalog">
				<div class="all_c">
				<a href="http://shop.360hqb.com/21743/categories.html" target="_self" title="全部商品分类">全部商品分类</a> &gt;&gt;</div>
				<ul>
					<li class="c_2">
						<a href="http://shop.360hqb.com/21743/categories.html?cat_id=5688" target="_self" title="松下数码摄像机">松下数码摄像机</a>
					</li>
					<li class="c_n">
						<a href="http://shop.360hqb.com/21331/categories.html?cat_id=3779" target="_self" title="华硕">华硕</a>
					</li>
				</ul>
			</div>
			<!-- 店铺热销商品 -->
			<div class="l_gray_tit">店铺热销商品</div>
			<div class="shop_hot_sell">
				<div class="i_nav ">
					<div class="por_img">
						<a href="http://item.360hqb.com/108335.html" target="_blank" title="太阳能IPHONE 3G   3GS   太阳能充电器 备用电源 特价冲3钻">
							<img alt="太阳能IPHONE 3G   3GS   太阳能充电器 备用电源 特价冲3钻" src="http://resource.360hqb.com/thumbs/product/bc/19/bc19ee3ec827d21651a83c040039c0f3.50.jpg"></a>
						</div>
						<div class="r_it">
							<div class="pr_name">
								<a href="http://item.360hqb.com/108335.html" target="_blank" title="太阳能IPHONE 3G   3GS   太阳能充电器 备用电源 特价冲3钻">太阳能IPHONE 3G   3GS   太阳...</a>
							</div>
							<div class="pr_price">
							<span class="rmb">￥</span>40.00</div>
						</div>
					</div>
					<div class="i_nav ">
						<div class="por_img">
							<a href="http://item.360hqb.com/109729.html" target="_blank" title="【长沙实体店】SD卡4GB金士顿正品42元">
								<img alt="【长沙实体店】SD卡4GB金士顿正品42元" src="http://resource.360hqb.com/thumbs/product/05/da/05daa88c7279583a9043daf57e504086.50.jpg"></a>
							</div>
							<div class="r_it">
								<div class="pr_name">
									<a href="http://item.360hqb.com/109729.html" target="_blank" title="【长沙实体店】SD卡4GB金士顿正品42元">【长沙实体店】SD卡4GB金士顿...</a>
								</div>
								<div class="pr_price">
								<span class="rmb">￥</span>48.00</div>
							</div>
						</div>
						<div class="i_nav ">
							<div class="por_img">
								<a href="http://item.360hqb.com/109743.html" target="_blank" title="【实体+原装正品】SHE尚伊CT120 MP5 4GB 16:9宽屏 送贴膜">
									<img alt="【实体+原装正品】SHE尚伊CT120 MP5 4GB 16:9宽屏 送贴膜" src="http://resource.360hqb.com/thumbs/product/b5/fc/b5fcf01af4f901ef4cf25b363b2b6df4.50.jpg"></a>
								</div>
								<div class="r_it">
									<div class="pr_name">
										<a href="http://item.360hqb.com/109743.html" target="_blank" title="【实体+原装正品】SHE尚伊CT120 MP5 4GB 16:9宽屏 送贴膜">【实体+原装正品】SHE尚伊CT12...</a>
									</div>
									<div class="pr_price">
									<span class="rmb">￥</span>169.00</div>
								</div>
							</div>
							<div class="i_nav ">
								<div class="por_img">
									<a href="http://item.360hqb.com/109776.html" target="_blank" title="尚伊M100 MP3 4G 纯音质mp3正品行货超长待机录音乐播放器">
										<img alt="尚伊M100 MP3 4G 纯音质mp3正品行货超长待机录音乐播放器" src="http://resource.360hqb.com/thumbs/product/ef/06/ef063d877e22c11dbfbbb7df8507e6b0.50.jpg"></a>
									</div>
									<div class="r_it">
										<div class="pr_name">
											<a href="http://item.360hqb.com/109776.html" target="_blank" title="尚伊M100 MP3 4G 纯音质mp3正品行货超长待机录音乐播放器">尚伊M100 MP3 4G 纯音质mp3正...</a>
										</div>
										<div class="pr_price">
										<span class="rmb">￥</span>92.00</div>
									</div>
								</div>
								<div class="i_nav ">
									<div class="por_img">
										<a href="http://item.360hqb.com/109777.html" target="_blank" title="尚伊CT3000HD触屏mp4正品8G行货4.3寸mp5高清触摸屏1080P fm收音">
											<img alt="尚伊CT3000HD触屏mp4正品8G行货4.3寸mp5高清触摸屏1080P fm收音" src="http://resource.360hqb.com/thumbs/product/d5/9d/d59deb083b3096384f7e732573dd4190.50.jpg"></a>
										</div>
										<div class="r_it">
											<div class="pr_name">
												<a href="http://item.360hqb.com/109777.html" target="_blank" title="尚伊CT3000HD触屏mp4正品8G行货4.3寸mp5高清触摸屏1080P fm收音">尚伊CT3000HD触屏mp4正品8G行...</a>
											</div>
											<div class="pr_price">
											<span class="rmb">￥</span>288.00</div>
										</div>
									</div>
									<div class="i_nav i_nav_f">
										<div class="por_img">
											<a href="http://item.360hqb.com/109817.html" target="_blank" title="AP-161原装车载MP3 车载音乐播放器 正品车用mp3 含充电器 特价">
												<img alt="AP-161原装车载MP3 车载音乐播放器 正品车用mp3 含充电器 特价" src="http://resource.360hqb.com/thumbs/product/41/ca/41ca0a6f0728fd132b658cb32bb04cc4.50.jpg"></a>
											</div>
											<div class="r_it">
												<div class="pr_name">
													<a href="http://item.360hqb.com/109817.html" target="_blank" title="AP-161原装车载MP3 车载音乐播放器 正品车用mp3 含充电器 特价">AP-161原装车载MP3 车载音乐播...</a>
												</div>
												<div class="pr_price">
												<span class="rmb">￥</span>89.00</div>
											</div>
										</div>
									</div>
								</div><!-- end of left -->
								
								
								
<div class="r_content">
	<!-- 店铺公告 -->
	<div class="shop_affiche_nav">
		<div class="i_l">
			<marquee behavior="scroll" direction="up" scrollamount="1" height="25" width="100%" style="margin-top:3px;">
				${shop.pubNote }
			</marquee>
			</div>
		</div>
		<div class="shop_i_l_tit">商家推荐</div>
		<div class="shop_i_prod_list">
			<div class="mall">
				<ul>
					<c:forEach items="${recommendList}" var="b">
						<li class="shop_prod_list">
							<div class="photo">
								<a href="<%=path %>/product/${b.goodsId }.html">
									<img src="${b.imageD }"></a>
									<div style="display: none;" class="tm_layer">
										<div class="tm_bg"></div>
										<div class="tm_text">
											<a href="javascript:;" class="gm fl">立即购买</a>
											<a href="javascript:;" class="jr fr">添加收藏</a>
										</div>
									</div>
								</div>
								<h3 class="summary">
									<a href="<%=path %>/product/${b.goodsId }.html">${b.name }</a>
								</h3>
								<div class="attribute">
									<em>${b.discountPriceStr }</em>
								</div>
							</li>
						</c:forEach>
						
						
												</ul>
												<div class="cl"></div>
											</div>
										</div>
										<div class="shop_i_l_tit">
											<div class="t_tit">全部商品</div>
											<div class="p_x_nav">
												<ul>
													<li class="t">排序：</li>
													<li class="ord_by_xl ">
														<a title="点击按照销量（销量由高到低）重新排序" href="/22618/index.html?sort=sale"></a>
													</li>
													<li class="ord_by_price ">
														<a title="点击按照价格（价格由低到高）重新排序" href="/22618/index.html?sort=price&amp;up=ASC"></a>
													</li>
												</ul>
												<div class="cl"></div>
											</div>
										</div>
										<div class="shop_i_prod_list_l">
											<div class="mall">
												<ul>
													<c:forEach items="${productList}" var="b">
													<li class="shop_prod_list">
														<div class="photo">
															<a href="<%=path %>/product/${b.goodsId }.html">
																<img src="${b.imageD }"></a>
																<div style="display: none;" class="tm_layer">
																	<div class="tm_bg"></div>
																	<div class="tm_text">
																		<a href="javascript:;" class="gm fl">立即购买</a>
																		<a href="javascript:;" class="jr fr">添加收藏</a>
																	</div>
																</div>
															</div>
															<h3 class="summary">
																<a href="<%=path %>/product/${b.goodsId }.html">${b.name }</a>
															</h3>
															<div class="attribute">
																<em>${b.discountPriceStr }</em>
															</div>
														</li>
													</c:forEach>													
													</ul>
													<div class="cl"></div>
												</div>
											</div>
											<div class="page">
												<div class="page_bottom">


													<span class="page_cur">1</span>
													<a href="/22618/index.html?p=2">2</a>
													<a href="/22618/index.html?p=3">3</a>
													<a href="/22618/index.html?p=4">4</a>
													<a href="/22618/index.html?p=5">5</a>
													<a href="/22618/index.html?p=6">6</a>


													<a class="page_next" href="/22618/index.html?p=2">
														<span>下一页</span>
													</a>
												<div class="cl"></div>

											</div>
										</div>
									</div>

								
	</div><!-- end of shop_norm_l_nav -->

</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>