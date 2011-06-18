<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %>,${shop.shopName }</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/shop.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/product.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/front/css/jquery.lightbox-0.5.css" media="screen" />

<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/dialog.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.lightbox-0.5.pack.js" type="text/javascript"></script>
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
		var idx = $("ul.tab li").index($(this));
		if(idx == 0){
			$(".tab_content").show();
		}else{
			$(".tab_content").hide(); //Hide all tab content
			$('#detail'+'_'+idx).fadeIn();
		}
		return false;
	});
	
	$('#product_imgages a').lightBox({		
		imageLoading: '<%=path %>/resources/front/images/lightbox-ico-loading.gif',
		imageBtnClose: '<%=path %>/resources/front/images/lightbox-btn-close.gif',
		imageBtnPrev: '<%=path %>/resources/front/images/lightbox-btn-prev.gif',
		imageBtnNext: '<%=path %>/resources/front/images/lightbox-btn-next.gif'
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
	
	$('#product_login').click(function() {
		$.showLoginWindow();
		return false;
	})
	
	$('#id_l_message_submit').click(function() {
		if($.trim($('#question').val())==''){
			$.dialog({type: "warn", content: "请输入咨询内容", width: 360, modal: true, autoCloseTime: 3000});
			return false;
		}		
		if(!$.memberVerify()){
			$.showLoginWindow();
			return false;
		}else{
			$l_message_form = $('#l_message')
			$.ajax({
				type: "POST",
				url: shop_constant.base+"/front/product.xhtml?method=onAddqa",
				dataType: "json",
				data: $l_message_form.serialize(),
				beforeSend: function() {
					$l_message_form.find("button").attr("disabled", true);
				},
				success: function(data) {
					if (data.status == "success") {
						$.dialog({type: "success", content: data.message, width: 360, modal: true, autoCloseTime: 3000});
						$('#question').val('');
					}
				},
				complete: function() {
					$l_message_form.find("button").attr("disabled", false);
				}
			});
		}
	});
	
	$('#id_l_message_clear').click(function() {
		$('#question').val('');
	});
	
	if($.memberVerify()){
		$('#show_login_area').hide();
	}
	
});

var setAmount={
    min:1,
    max:999,
    reg:function(x){
        return new RegExp("^[1-9]\\d*$").test(x);
    },
    amount:function(obj,mode){
        var x=$(obj).val();
        if (this.reg(x)){
            if (mode){
                x++;
            }else{
                x--;
            }
        }else{
            alert("请输入正确的数量！");
            $(obj).val(1);
            $(obj).focus();
        }
        return x;                       
    },
    reduce:function(obj){
        var x=this.amount(obj,false);
        if (x>=this.min){
            $(obj).val(x);
        }else{
            alert("商品数量最少为"+this.min);
            $(obj).val(1);
            $(obj).focus();
        }
    },
    add:function(obj){
        var x=this.amount(obj,true);
        if (x<=this.max){
            $(obj).val(x);
        }else{
            alert("商品数量最多为"+this.max);
            $(obj).val(999);
            $(obj).focus();
        }
    },
    modify:function(obj){
        var x=$(obj).val();
        if (x<this.min||x>this.max||!this.reg(x)){
            alert("请输入正确的数量！");
            $(obj).val(1);
            $(obj).focus();
        }
    }
}
//-->
</script>
</head>
<body id="index">
<%@include file="/jsp/shop/front/common/top.jsp"%>

<!-- 正文开始 -->
<div class="w main">
	
	<div class="shop_norm_t_opt_h_28px">
		<ul>
	    	<li><a href="<%=path %>/shopinfo/index-${shop.shopId}.html" target="_top" title="${shop.shopName}"><span>店铺首页</span></a></li>
	        <li><a href="<%=path %>/front/shop.xhtml?method=introduce&shopId=${shop.shopId}" target="_top" title="${shop.shopName}介绍"><span>店铺介绍</span></a></li>
	        <li class="sel"><a href="" title="烟雨蒙蒙三月天店铺的信誉评价" target="_top"><span>商品详情</span></a></li>
	    </ul>
	</div>
	
	<div class="blank_10px"></div>	
	<div class="shop_norm_l_nav">
	
	<%@include file="/jsp/shop/front/shop/left_nav.jsp"%>
								
	<div class="right">
	
	<div id="name">
			<h1>${product.name }</h1>
		</div>
		<div id="preview">
		    <span class="clr5"></span>
		    <div id="spec-list">
				<div style="position:relative;overflow:hidden;z-index:1;width:345px;height:400px;">
					<ul class="list-h" style="width: 345px; overflow-x: hidden; overflow-y: hidden; position: absolute; left: 0px; top: 0px; margin-top: 0px; margin-left: 0px; ">
					<ul id="product_imgages">
                       <c:forEach items="${product.imageList}" var="b">
                       <li>
                       		<div class="pi_img">
                           <a href="${b.imageF}"><img src="${b.imageB}" width="100" height="100" /></a>
                           </div>
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
							直 销 价：<span id="price" class="price">￥${product.discountPriceStr }</span>
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
							购买数量：
							<a class="reduce" title="减一" onclick="setAmount.reduce('#quantity')" href="javascript:void(0)">
								<img style="display:inline" src="<%=path %>/resources/front/images/bag_close.gif" border="none"/>
							</a>
							<input type="text" id="quantity" onkeyup="setAmount.modify('#quantity')" value="1">
							<a class="add" title="加一" onclick="setAmount.add('#quantity')" href="javascript:void(0)">
								<img style="display:inline" src="<%=path %>/resources/front/images/bag_open.gif" border="none"/>
							</a>
						</div>
						<div class="buttonArea">
							<input type="button" id="goodsButton" class="addCartItemButton" value="" hidefocus="true">
	                        <!--<input type="button" class="addFavoriteButton addFavorite {id: '402881862d25d2c9012d26d63deb0026'}" value="" hidefocus="true">-->
	                       </div>
					</div>
				</div>
			</li>
		</ul>
		
		<span class="clr10"></span>
		
		<div class="m" id="detail">
				<ul class="tab">
					<li class="curr">商品介绍<span></span></li>
					<li>商品评论<span></span></li>
					<li>商家咨询<span></span></li>
				</ul>
				<div class="tab_content" id="detail_0" style="display: none;">
						${product.goodsDesc }
				</div><!--tabcon end-->
				<div class="tab_content" id="detail_1">
					<div class="prod_ot_item_tit spzx">商品评论</div>
                   <div id="comment">
	                  	<div class="item">
							<div class="user">
								<span class="u-name">网友：yyfa2055</span>
								<span class="date-ask">2011-06-01 12:34</span>
							</div>
							<dl class="answer">
								<dd>
								<div class="content">您好！可以的，感谢您对京东的支持！祝您购物愉快！</div>
								<div class="date-answer">2011-06-01 13:22</div>
								</dd>
							</dl>
							
						</div>
						
						<div class="item odd">
							<div class="user">
								<span class="u-name">网友：yyfa2055</span>
								<span class="date-ask">2011-06-01 12:34</span>
							</div>
							<dl class="answer">
								<dd>
								<div class="content">您好！可以的，感谢您对京东的支持！祝您购物愉快！</div>
								</dd>
							</dl>
						</div><!--end of item-->
					</div>
					
					<div class="clr10"></div>
				</div><!--tabcon end-->
				<div class="tab_content" id="detail_2">
					<div class="prod_ot_item_tit spzx">商品咨询</div>
					<div id="consult">
	                  	<div class="item">
							<div class="user">
								<span class="u-name">网友：yyfa2055</span>
								<span class="date-ask">2011-06-01 12:34</span>
							</div>
							<dl class="ask">
								<dt><b></b>咨询内容：</dt>
								<dd>这个床可以拆卸吗，装在汽车后备箱内</dd>
							</dl>
							<dl class="answer">
								<dt><b></b>京东回复：</dt>
								<dd>
								<div class="content">您好！可以的，感谢您对京东的支持！祝您购物愉快！</div>
								<div class="date-answer">2011-06-01 13:22</div>
								</dd>
							</dl>
							<div id="7481813" class="useful">您对我们的回复： 
								<a name="2" href="javascript:void(0)" class="btn-pleased">满意</a> (<span>0</span>)&nbsp;&nbsp;
								<a name="4" href="javascript:void(0)" class="btn-unpleased">不满意</a> (<span>0</span>)
							</div>
						</div>
						
						<div class="item odd">
							<div class="user">
								<span class="u-name">网友：yyfa2055</span>
								<span class="date-ask">2011-06-01 12:34</span>
							</div>
							<dl class="ask">
								<dt><b></b>咨询内容：</dt>
								<dd>这个床可以拆卸吗，装在汽车后备箱内</dd>
							</dl>
							<dl class="answer">
								<dt><b></b>京东回复：</dt>
								<dd>
								<div class="content">您好！可以的，感谢您对京东的支持！祝您购物愉快！</div>
								<div class="date-answer">2011-06-01 13:22</div>
								</dd>
							</dl>
							<div id="7481813" class="useful">您对我们的回复： 
								<a name="2" href="javascript:void(0)" class="btn-pleased">满意</a> (<span>0</span>)&nbsp;&nbsp;
								<a name="4" href="javascript:void(0)" class="btn-unpleased">不满意</a> (<span>0</span>)
							</div>
						</div><!--end of item-->
					</div>
					
					<div class="clr10"></div>
					
					<div class="prod_d_l_reply spzx">
						<div class="e_info" id="show_login_area">您需要先<a href="javascript:;" title="会员登录" id="product_login">登录</a>,才能向商家提问！<a href="<%=path%>/front/common/custreg.html">免费注册</a></div>
						<div class="r_form_bar">
								<form action="<%=path %>/front/product.xhtml?method=onAddqa" id="l_message" name="l_message" method="post">
								<input type="hidden" name="goodsId" value="${product.goodsId}"/>
								<table cellpadding="0" cellspacing="0">
								<tbody>
								<tr><th>向商家提问：</th>
										<td>
												<textarea id="question" name="question"></textarea><br>
				 								<input id="id_l_message_submit" class="o_btn" type="button" value="提交">
				 								<input class="o_btn" id="id_l_message_clear" type="reset" value="清空">
										</td>
								</tr>
								</tbody></table>
								</form>
						</div>
					</div>
				</div><!--tabcon end-->
				
			</div><!-- end of detail -->
	
	</div>

								
	</div><!-- end of shop_norm_l_nav -->

</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>