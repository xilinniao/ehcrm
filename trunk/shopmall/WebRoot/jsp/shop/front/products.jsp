<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/slide.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/products.css" rel="stylesheet" type="text/css" />

<style type="text/css">

</style> 
<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.pager.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>

</head>
<body id="index">
<%@include file="/jsp/shop/front/common/top.jsp"%>

<!-- 正文开始 -->
<div class="w main">

<div class="m" id="i-right">
	<div id="hotsale">
		<div class="mt"><h2>热卖推荐</h2></div>
		<div class="mc list-h">
			<dl>
				<dt><a target="_blank" href="http://www.360buy.com/product/359366.html"><img src="http://img11.360buyimg.com/n4/4524/c52c2552-8f48-47e3-857b-aac5c72a98e1.jpg" width="100" height="100" alt="华硕K42EI48JZ（i5-480M+HD6470M+Win7）送包鼠耳机!"></a></dt>
				<dd>
					<div class="p-name"><a target="_blank" href="http://www.360buy.com/product/359366.html">华硕K42EI48JZ（i5-480M+HD6470M+Win7）送包鼠耳机!<font color="#ff6600">正版win7,开机即用,现在购买送原装包鼠和飞利浦耳机,性价比首选!!</font></a></div>
					<div class="p-price">特价：<img src="http://price.360buy.com/gp359366,1.png" onerror="this.src='http://www.360buy.com/images/no2.gif'"></div>
					<div class="btns"><a target="_blank" href="http://jd2008.360buy.com/purchase/InitCart.aspx?pid=359366&amp;pcount=1&amp;ptype=1">立即抢购</a></div>
				</dd>
			</dl>
			<dl>
				<dt><a target="_blank" href="http://www.360buy.com/product/359366.html"><img src="http://img11.360buyimg.com/n4/4524/c52c2552-8f48-47e3-857b-aac5c72a98e1.jpg" width="100" height="100" alt="华硕K42EI48JZ（i5-480M+HD6470M+Win7）送包鼠耳机!"></a></dt>
				<dd>
					<div class="p-name"><a target="_blank" href="http://www.360buy.com/product/359366.html">华硕K42EI48JZ（i5-480M+HD6470M+Win7）送包鼠耳机!<font color="#ff6600">正版win7,开机即用,现在购买送原装包鼠和飞利浦耳机,性价比首选!!</font></a></div>
					<div class="p-price">特价：<img src="http://price.360buy.com/gp359366,1.png" onerror="this.src='http://www.360buy.com/images/no2.gif'"></div>
					<div class="btns"><a target="_blank" href="http://jd2008.360buy.com/purchase/InitCart.aspx?pid=359366&amp;pcount=1&amp;ptype=1">立即抢购</a></div>
				</dd>
			</dl>
			<dl>
				<dt><a target="_blank" href="http://www.360buy.com/product/292258.html"><img src="http://img13.360buyimg.com/n4/835/bf52c140-d9ed-43aa-9fbc-962d01bf37c9.jpg" width="100" height="100" alt="价格不是问题！惠普G42" 14.0英寸笔记本电脑（i3-370="" 2g="" 500g="" 512独显="" dvd刻录="" 无线="" win7）=""></a></dt>
				<dd>
					<div class="p-name"><a target="_blank" href="http://www.360buy.com/product/292258.html">价格不是问题！惠普G42 14.0英寸笔记本电脑（i3-370 2G 500G 512独显 DVD刻录 无线 Win7）<font color="#ff6600">彪悍的价格无需解释 直降500 疯狂促销中~~~~</font></a></div>
					<div class="p-price">特价：<img src="http://price.360buy.com/gp292258,1.png" onerror="this.src='http://www.360buy.com/images/no2.gif'"></div>
					<div class="btns"><a target="_blank" href="http://jd2008.360buy.com/purchase/InitCart.aspx?pid=292258&amp;pcount=1&amp;ptype=1">立即抢购</a></div>
				</dd>
			</dl>
		</div>		
	</div>
	<div id="market" clstag="thirdtype|keycount|thirdtype|market"></div>
</div>

		<span class="clr10"></span>
		
			<div id="filter">
                <div class="fore item">排序&nbsp;</div>
                <ul class="item tab">
                	<li class="curr"><a href="737-738-751-0-0-0-0-0-0-0-1-1-1.html">销量</a><span></span></li>
                	<li><b></b><a href="737-738-751-0-0-0-0-0-0-0-1-3-1.html">价格</a><span></span></li>
                	<li><a href="737-738-751-0-0-0-0-0-0-0-1-4-1.html">好评度</a><span></span></li>
                	<li><a href="737-738-751-0-0-0-0-0-0-0-1-5-1.html">上架时间</a><span></span></li>
                </ul>
                <div class="pagin pagin-m fr"><span class="text">${page.pageNo }/${page.totalPageCount }</span>
                <c:choose>
                	<c:when test="${page.hasPreviousPage}"><a class="prev" href="#none">上一页<b></b></a></c:when>
                	<c:otherwise><span class="prev-disabled">上一页<b></b></span></c:otherwise>
                </c:choose>
                
                <c:choose>
                	<c:when test="${page.hasNextPage}"><a class="next" href="#none">下一页<b></b></a></c:when>
                	<c:otherwise><span class="next-disabled">下一页<b></b></span></c:otherwise>
                </c:choose>
                </div>
                
                <span class="clr"></span>
                
                <div class="extra"><div class="total fr"><span>共<strong>${page.totalCount }</strong>个商品</span></div><span class="clr"></span></div>
			</div>

		<span class="clr5"></span>		
		<div id="plist">
 				<ul class="list-h">
					<c:forEach items="${productList}" var="b">
	                <li>
					<div class="p-img"><a target="_blank" href="/product/${b.goodsId }.html"><img src="${b.imageD }" width="160" height="160"></a></div>
					<div class="p-name"><a target="_blank" title="${b.name }" href="/product/${b.goodsId }.html">${b.name }</a></div>
					<div class="p-price">直销价：<strong>￥${b.discountPriceStr }</strong></div>					
					</li>
					</c:forEach>
				</ul>
		</div><!-- end of hotprod -->
		<span class="clr clr5"></span>
		
		<div class="pagerBar">
			
			<script type="text/javascript">
			$().ready( function() {
				$.gotoPage = function(id) {
					var new_url = '<%=path%>/front/category.xhtml?method=products&categoryId=${qry.categoryId}&curr=${param.curr}';
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
	
</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>