<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/cartitems.css" rel="stylesheet" type="text/css">
<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/dialog.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
function clearCart(){
   if(confirm('确定清空购物车吗？')){
		$.cookie('cartitems',null,{path:shop_constant.cookie_path});
   }
}

$.addCartItem = function(goodsid, quantity) {
	var goods_obj = $('#goods_id_'+goodsid);
	var newCnt = parseInt(goods_obj.val())+quantity;
	if(newCnt==0){
		removeProductOnShoppingCart(goodsid);
		return false;
	}
	
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
		message:'修改数量成功',
		totalQuantity:'',
		totalPrice:''
	}
	
	//$.message({type: "warn", content: data.message});	
	goods_obj.val(newCnt);
	$.flushcartitems(true);
}
function changeCnt(goodsId,add_cnt){
	$.addCartItem(goodsId,add_cnt);
}

function removeProductOnShoppingCart(goodsid){
	if(confirm('确认不购买该商品')){
		var cart_items = $.cookie('cartitems');
		if(cart_items!=null){
			var tmps = cart_items.split(",");
			var is_replace = false;//是否替换
			var new_cartitems = jQuery.grep(tmps,function(value,i) {
				var values = value.split("=");
				return goodsid!=values[0];
			});
			if(new_cartitems.length==0){
				$.cookie('cartitems',null,{path:shop_constant.cookie_path});
			}else{
				$.cookie('cartitems',new_cartitems,{expires:shop_constant.cookie_days,path:shop_constant.cookie_path});	
			}			
		}
	}
}

function gotoCheckOut(){
	if(!$.memberVerify()){
		$.showLoginWindow('<%=path %>/front/order.xhtml?method=checkout');
	}else{
		document.location.href = '<%=path %>/front/order.xhtml?method=checkout';
	}
}

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
					   			<a target="_blank" href="<%=path %>/product/${b.goodsId }.html" >
					   				<img src="${b.imagea }">
					   			</a>
					   		</div>
					   		<span>
					   			<a target="_blank" href="<%=path %>/product/${b.goodsId }.html">
					   				${b.goodsName }
					   			</a>
					   		</span>
					   	</td>
					   <td><span class="price">￥${b.discountPrice }</span></td>
					   <td>0</td>
					   <td>					   
					   	<a href="#none" title="减一" onclick="changeCnt('${b.goodsId }',-1)" style="margin-right:2px;">
					   		<img style="display:inline" src="<%=path %>/resources/front/images/bag_close.gif" border="none"/>
					   	</a>
					   	<input type="text" id="goods_id_${b.goodsId }" name="txtChange334965" maxlength="4" style="width:30px" onkeydown="if(event.keyCode == 13) event.returnValue = false" value="${b.cnt }" onfocus="changeTxtOnFocus(this);" onblur="changeProductCount('${b.goodsId }',this);">
					   	<a href="#none" title="加一" onclick="changeCnt('${b.goodsId }',1)" style="margin-left:2px;">
					   		<img style="display:inline" src="<%=path %>/resources/front/images/bag_open.gif" border="none"/>
					   	</a>
					   </td>
					   <td><a href="#none" id="btn_del_${b.goodsId }" onclick="removeProductOnShoppingCart('${b.goodsId }')">删除</a></td>
					</tr>
					</c:forEach>									
					<tr>
					    <td class="align_Right Tfoot" colspan="7" style="height:30px">重量总计：kg&nbsp;&nbsp;&nbsp;原始金额：￥元 - 可使用积分：<br>
					    <span style="font-size:14px"><b>商品总金额(不含运费)：<span class="price" id="cartBottom_price">￥</span>元</b></span></td>
					 </tr>
					</tbody></table>
    		</div><!-- end of productList -->
    		
    		<ul class="cart_op" style="margin-bottom:0px;">
    					    
				<li class="li2"><a href="#none" onclick="this.blur();clearCart()">清空购物车</a></li>
								 
				<li class="li3">
					<div id="submit_info">
					</div>
					<div id="submit_btn" style="text-align:right">				
			        	<a id="continueBuyBtn" href="<%=homeUrl %>">继续购物</a>
			        	<a id="gotoOrderInfo" href="#none" onclick="gotoCheckOut()">去结算</a>
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