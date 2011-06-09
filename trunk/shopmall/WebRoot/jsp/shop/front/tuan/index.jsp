<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %>,${shop.shopName }</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/tuan.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/tuan2.css" rel="stylesheet" type="text/css" />
<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/dialog.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.pager.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
//-->
</script>
</head>
<body id="index">
<%@include file="/jsp/shop/front/common/top.jsp"%>

<!-- 正文开始 -->


<div class="n_big_box">
	

	
	
    <div class="n_content_box" style="margin-bottom:15px;">
    	
		<div class="n_pagin_box">
		   <!--
		    <div style="float:left;">
				 排序:
				  <a class="chalook" href="javascript:void(0)" onclick="resetIndex('default')" style="color:#fff;background:#CD1A01"> 智能</a>
				  | <a class="chalook" href="javascript:void(0)" onclick="resetIndex('time')"> 最新</a>
				  | <a class="chalook" href="javascript:void(0)" onclick="resetIndex('rate')"> 最具人气</a>
			</div>-->
				<div class="pagerBar">				
					<script type="text/javascript">
					$().ready( function() {
						$.gotoPage = function(id) {
							var new_url = '<%=path%>/front/tuan.xhtml?method=index';
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
		

		
		<div class="n_content_form">
			<div class="n_content_line"></div>
			<ul class="n_pro_box">
				
				<c:forEach items="${tuanList}" var="b">
				<li>
				<a name="deal_120870"></a>
				<div class="n_pic">
					<a href="<%=path%>/front/tuan.xhtml?method=detail&tuanId=${b.tuanId}" target="_blank"><img width="250px" height="250px" src="${b.imageUrl}"></a>
					<div class="n_pprice">
							<!--
							<div class="n_pprabc">
								<span class="n_red">56</span>人购买
							</div>
							-->
							<div class="n_price_1">原价: <del style="font-family:Arial; font-size:14px;">${b.priceStr}元</del> 折扣: <span class="orange" style="font-weight:bold; font-size:14px;">${b.discountRate}</span>折</div>
					</div>
				</div>
				<a href="<%=path%>/front/tuan.xhtml?method=detail&tuanId=${b.tuanId}" target="_blank">
					<div class="n_button">
						<span class="n_pr"><span class="units">¥</span>${b.discountPriceStr}</span>
					</div>
				</a>
				<h2 style="clear:both"><a href="<%=path%>/front/tuan.xhtml?method=detail&tuanId=${b.tuanId}" target="_blank" class="short_title">${b.topicName}</a></h2>
				</li>
				</c:forEach>
																			
			</ul>
		</div>
		

		 <div class="n_pagin_box">
		    <!--
		    <div style="float:left;">
				 排序:
				  <a class="chalook" href="javascript:void(0)" onclick="resetIndex('default')" style="color:#fff;background:#CD1A01"> 智能</a>
				  | <a class="chalook" href="javascript:void(0)" onclick="resetIndex('time')"> 最新</a>
				  | <a class="chalook" href="javascript:void(0)" onclick="resetIndex('rate')"> 最具人气</a>
			</div>
			-->
			<div class="pagerBar">				
					<script type="text/javascript">
					$().ready( function() {
						$.gotoPage = function(id) {
							var new_url = '<%=path%>/front/tuan.xhtml?method=index';
							new_url=new_url+'&pageNo='+id;
							document.location.href=new_url;
						}
						
						$('a.prev').click(function(){
							$.gotoPage(${page.pageNo-1});
						});
						
						$('a.next').click(function(){
							$.gotoPage(${page.pageNo+1});
						});
						
						$("#pagerb").pager({
							pagenumber: ${page.pageNo},
							pagecount: ${page.totalPageCount},
							buttonClickCallback: $.gotoPage
						});
					})
					</script>
					<span id="pagerb"></span>
				</div>
		</div>

    </div>
</div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>