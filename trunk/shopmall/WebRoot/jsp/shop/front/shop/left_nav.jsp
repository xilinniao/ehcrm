<%@ page contentType="text/html; charset=utf-8"%>
	<div class="l_sidebar">
	<!-- 商铺基本信息 -->
	<div class="shop_bisc_info">
		<div class="s_t">
			<h1>${shop.shopName }</h1>
		</div>
		<!--
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
		<div class="described liveness">活&nbsp;&nbsp;跃&nbsp;&nbsp;度：<span class="st_numst_nst_ust_m"></span></div>
		<div class="bot_line"></div>
		-->
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
							<th style="padding:5px 0px;">联系电话：</th>
							<td><div class="tel">${shop.linkerMobile }</div></td>
						</tr>
						
						<tr>
							<th>在线客服：</th>
							<td>
								<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=294144892&amp;site=qq&amp;menu=yes">
									<img border="0" src="http://wpa.qq.com/pa?p=2:294144892:47" alt="给我发消息" title="给我发消息"></a>
								</td>
						</tr>
						</tbody>
					</table>
				</div>
				
				<!--
				<div class="bot_line"></div>
				<div class="os_link" style="position:relative;">
					<a class="go_s_h" href="<%=path %>/shopinfo/index-${shop.shopId}.html" target="_self" title="店铺首页"></a>
					<a class="s_fav addFavorite" href="javascript:;" title="收藏该店铺"></a>
				</div>
				-->
				
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
					<li class="c_n">
						<a href="http://shop.360hqb.com/21331/categories.html?cat_id=3779" target="_self" title="华硕">华硕</a>
					</li>
					<li class="c_n">
						<a href="http://shop.360hqb.com/21331/categories.html?cat_id=3779" target="_self" title="华硕">华硕</a>
					</li>
					<li class="c_n">
						<a href="http://shop.360hqb.com/21331/categories.html?cat_id=3779" target="_self" title="华硕">华硕</a>
					</li>
					<li class="c_2">
						<a href="http://shop.360hqb.com/21743/categories.html?cat_id=5688" target="_self" title="松下数码摄像机">松下数码摄像机</a>
					</li>
					<li class="c_n">
						<a href="http://shop.360hqb.com/21331/categories.html?cat_id=3779" target="_self" title="华硕">华硕</a>
					</li>
					<li class="c_n">
						<a href="http://shop.360hqb.com/21331/categories.html?cat_id=3779" target="_self" title="华硕">华硕</a>
					</li>
					<li class="c_n">
						<a href="http://shop.360hqb.com/21331/categories.html?cat_id=3779" target="_self" title="华硕">华硕</a>
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
				<div class="i_nav i_nav_f">
					<div class="por_img">
						<a href="http://item.360hqb.com/109817.html" target="_blank" title="AP-161原装车载MP3 车载音乐播放器 正品车用mp3 含充电器 特价">
						<img alt="AP-161原装车载MP3 车载音乐播放器 正品车用mp3 含充电器 特价" src="http://resource.360hqb.com/thumbs/product/41/ca/41ca0a6f0728fd132b658cb32bb04cc4.50.jpg"></a>
					</div>
					<div class="r_it">
						<div class="pr_name">
							<a href="http://item.360hqb.com/109817.html" target="_blank" title="AP-161原装车载MP3 车载音乐播放器 正品车用mp3 含充电器 特价">AP-161原装车载MP3 车载音乐播...</a>
						</div>
						<div class="pr_price"><span class="rmb">￥</span>89.00</div>
					</div>
				</div>
				
			</div>
	</div><!-- end of left -->