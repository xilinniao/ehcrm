<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %>,${shop.shopName }</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/shop.css" rel="stylesheet" type="text/css" />
<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/jquery.pager.js" type="text/javascript"></script>
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
	    	<li class="sel"><a href="<%=path %>/shopinfo/index-${shop.shopId}.html" target="_top" title="${shop.shopName}"><span>店铺首页</span></a></li>
	        <li><a href="<%=path %>/front/shop.xhtml?method=introduce&shopId=${shop.shopId}" target="_top" title="${shop.shopName}介绍"><span>店铺介绍</span></a></li>
	        <!--
	        <li><a href="http://shop.360hqb.com/21743/credit.html" title="烟雨蒙蒙三月天店铺的信誉评价" target="_top"><span>信誉评价</span></a></li>
	        -->
	    </ul>
	</div>
	
	<div class="blank_10px"></div>
	<div class="shop_norm_l_nav">
	
	<%@include file="/jsp/shop/front/shop/left_nav.jsp"%>
								
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
					<!--
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
					-->
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
					<div class="pagerBar">			
					<script type="text/javascript">
					$().ready( function() {
						$.gotoPage = function(id) {
							var new_url = '<%=path%>/front/shop.xhtml?method=index&shopId=${shop.shopId}&curr=${param.curr}';
							new_url=new_url+'&pageNo='+id;
							document.location.href=new_url;
						}
						
						$('a.prev').click(function(){
							$.gotoPage(${page.pageNo-1});
						});
						
						$('a.next').click(function(){
							$.gotoPage(${page.pageNo+1});
						});
						
						$("#pager").pager({
							pagenumber: ${page.pageNo},
							pagecount: ${page.totalPageCount},
							buttonClickCallback: $.gotoPage
						});
					})
					</script>
					<span id="pager"></span>
				</div>
			</div>

								
	</div><!-- end of shop_norm_l_nav -->

</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>