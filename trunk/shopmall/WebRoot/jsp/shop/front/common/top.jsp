<%@ page contentType="text/html; charset=utf-8"%>
<!-- 顶部信息 -->

<%@include file="/jsp/shop/front/common/toptop.jsp"%>    
<script type="text/javascript">
<!--
	$(document).ready(function(){
		$('#category_${param.curr}').addClass("curr2");
	});
//-->
</script>
<div class="w" id="header">
	<div id="logo">
		<a href="<%=homeUrl %>">
			<img src="<%=path %>/resources/front/images/logo.gif" alt="抚州直销商城" width="251" height="46">
		</a>
	</div>
	<div id="topad">
		<a href="<%=homeUrl %>">
			<img src="<%=path %>/uploads/site/adcs.jpg" alt="蚕丝被厂家直销" width="485" height="49">
		</a>
	</div>
	<div class="clr"></div>
	<!-- 导航开始 -->
	<div id="nav">
     
    
    
 <%@include file="/jsp/shop/front/common/topnav.jsp"%>       
    
     
     
     
	</div>
	<span class="clr"></span>
	<!-- end of 导航开始 -->
	<!-- 搜索开始 -->
	<div id="o-search">
		<div class="allsort">
		</div>		
		<div id="search" class="form">
			<div id="i-search">
				<input type="text" id="goodsKeyword" name="goodsKeyword" value="" autocomplete="off" onkeydown="javascript:if(event.keyCode==13) search('key');">
			</div>
			
			<input type="submit" value="搜&nbsp;索" id="btn-search" onclick="search('key');return false;">
			
		</div>
		<!-- 
		<div id="hotwords">
			<strong>热门搜索：</strong>
			<a href="" target="_blank">华硕笔记本</a>
			<a href="" target="_blank">希捷移动硬盘</a>
		</div>
		 -->
		<ul id="mycart">
			<li class="fore1" id="i-mycart" load="true">
				<a href="<%=path %>/front/order.xhtml?method=shoppingcart">购物车<b id="mycart-amount">0</b>件</a>
				<div id="o-mycart-list" class="hide" style="display: none; ">
					<div id="mycart-list">
					</div>
				</div>
			</li>
			<li class="fore2">
				<a href="<%=path %>/front/order.xhtml?method=shoppingcart">去结算</a>
			</li>
		</ul>
		
	</div>
	<!-- 搜索结束 -->
</div>
<!-- 头部结束 -->