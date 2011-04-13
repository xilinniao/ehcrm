<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/skin.css" rel="stylesheet" type="text/css" />
<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/jquery.tools.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.tmpl.min.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>
<script type="text/javascript">
<!--

//-->
</script>
</head>
<body id="index">
<%@include file="/jsp/shop/front/common/toptop.jsp"%>

<!-- 正文开始 -->
<div class="w main">

	<div id="Top1_order_step1" class="Header_cart">
		<div id="logo">
			<a href="<%=homeUrl %>">
				<img src="<%=path %>/resources/front/images/logo.gif" alt="抚州商城" width="251" height="46">
			</a>
		</div>
		<ul class="Order_cart" id="Order_cart_S1">
			<li class="step1">1.我的购物车</li>
			<li class="step2">2.填写核对订单信息</li>
			<li class="step3">3.成功提交订单</li>
		</ul>
	</div>

	<div class="List_cart">
		<h2><strong>我挑选的商品</strong></h2>
		<div class="cart_table">
			<div id="productList">					    
					<table class="Table" cellpadding="0" cellspacing="0" width="100%" id="CartTb">
					 <tbody>
					 <tr class="align_Center Thead">
					    <td width="7%" style="height:30px">商品编号</td>
					    <td>商品名称</td>
					    <td width="14%">商城价</td>
					    <td width="8%">赠送积分</td>
					    <td width="9%">商品数量</td>
					    <td width="7%">删除商品</td>
					 </tr>
					
					<c:forEach items="${productList}" var="b">
					<tr class="align_Center">
					   <td style="padding:5px 0 5px 0;">${b.goodsId }</td>
					   <td class="align_Left">
					   		<div class="p-img">
					   			<a target="_blank" href="<%=path %>/product/detail/${b.goodsId }.html" >
					   				<img src="${b.imageUrl }">
					   			</a>
					   		</div>
					   		<span>
					   			<a target="_blank" href="<%=path %>/product/detail/${b.goodsId }.html">
					   				${b.goodsName }
					   			</a>
					   		</span>
					   	</td>
					   <td><span class="price">￥${b.discountPrice }</span></td>
					   <td>0</td>
					   <td>
					   	<a href="#none" title="减一" onclick="changeBar('-','${b.goodsId }',this,'sku')" style="margin-right:2px;" >
					   		<img style="display:inline" src="<%=path %>/resources/front/images/bag_close.gif" border="none">
					   	</a>
					   	<input type="text" id="btn_cha_${b.goodsId }" name="txtChange334965" maxlength="4" style="width:30px" onkeydown="if(event.keyCode == 13) event.returnValue = false" value="${b.cnt }" onfocus="changeTxtOnFocus(this);" onblur="changeProductCount('${b.goodsId }',this);">
					   	<input type="hidden" name="hidChange334965" value="${b.cnt }">
					   	<a href="#none" title="加一" onclick="changeBar('+','${b.goodsId }',this,'sku')" style="margin-left:2px;">
					   		<img style="display:inline" src="<%=path %>/resources/front/images/bag_open.gif" border="none">
					   	</a>
					   </td>
					   <td><a href="#none" id="btn_del_${b.goodsId }" onclick="removeProductOnShoppingCart('${b.goodsId }',this)">删除</a></td>
					</tr>
					</c:forEach>									
					<tr>
					    <td class="align_Right Tfoot" colspan="7" style="height:30px">重量总计：kg&nbsp;&nbsp;&nbsp;原始金额：￥元 - 可使用积分：<br>
					    <span style="font-size:14px"><b>商品总金额(不含运费)：<span class="price" id="cartBottom_price">￥</span>元</b></span></td>
					 </tr>
					</tbody></table>
    		</div><!-- end of productList -->
    		
    		<ul class="cart_op" style="margin-bottom:0px;">
			    <!-- 
			    <li class="li4">
			    <a title="点击&quot;寄存&quot;后，京东商城将为您保存购物车内的商品，方便您随时随地去结算" alt="点击&quot;寄存&quot;后，京东商城将为您保存购物车内的商品，方便您随时随地去结算" class="btn_storage" href="#none" onclick="this.blur();saveCart();" clstag="clickcart|keycount|shoppingcartpop|savecartlink">寄存</a><a title="点击&quot;取出&quot;后，您可取出之前寄存在购物车内的商品" alt="点击&quot;取出&quot;后，您可取出之前寄存在购物车内的商品" class="btn_storage" href="#none" onclick="this.blur();GetStoreCart();" clstag="clickcart|keycount|shoppingcartpop|getsaveproduct">取出</a>    
			    </li>
			    -->
			    
				<li class="li2"><a href="#none" onclick="this.blur();clearCart()" clstag="clickcart|keycount|shoppingcartpop|clearcartlink">清空购物车</a></li>
				<!-- 
				<li class="li1"><a href="http://www.360buy.com/special.aspx?id=7&amp;price=1" target="_blank" clstag="clickcart|keycount|shoppingcartpop|coudanlink">凑单商品</a></li>
				 -->
				 
				<li class="li3">
					<div id="submit_info">
					</div>
					<div id="submit_btn" style="text-align:right">				
			        	<a id="continueBuyBtn" href="<%=homeUrl %>">继续购物</a>
			        	<a id="gotoOrderInfo" href="<%=path %>/front/order.xhtml?method=checkout">去结算</a>
					</div>
			
				</li>
			</ul><!-- end of cart_op -->			
		</div><!-- end of cart_table -->
		<div class="round"><div class="lround"></div><div class="rround"></div></div>
	</div><!-- end of list_cart-->
</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>