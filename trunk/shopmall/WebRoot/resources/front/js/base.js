// 添加收藏夹
function addFavorite(url, title) {
	if (document.all) {
		window.external.addFavorite(url, title);
	} else if (window.sidebar) {
		window.sidebar.addPanel(title, url, "");
	}
}

shop_constant = {
	base: "",
	currencySign: "￥",
	currencyUnit: "元",
	priceScale: "2",
	priceRoundType: "roundHalfUp",
	orderScale: "2",
	orderRoundType: "roundHalfUp"
};

// 浮点数加法运算
function floatAdd(arg1, arg2) {
	var r1, r2, m;
	try{
		r1 = arg1.toString().split(".")[1].length;
	} catch(e) {
		r1 = 0;
	}
	try {
		r2 = arg2.toString().split(".")[1].length;
	} catch(e) {
		r2 = 0;
	}
	m = Math.pow(10, Math.max(r1, r2));
	return (arg1 * m + arg2 * m) / m;
}

// 浮点数减法运算
function floatSub(arg1, arg2) {
	var r1, r2, m, n;
	try {
		r1 = arg1.toString().split(".")[1].length;
	} catch(e) {
		r1 = 0
	}
	try {
		r2 = arg2.toString().split(".")[1].length;
	} catch(e) {
		r2 = 0
	}
	m = Math.pow(10, Math.max(r1, r2));
	n = (r1 >= r2) ? r1 : r2;
	return ((arg1 * m - arg2 * m) / m).toFixed(n);
}

// 浮点数乘法运算
function floatMul(arg1, arg2) {
	var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
	try {
		m += s1.split(".")[1].length;
	} catch(e) {}
	try {
		m += s2.split(".")[1].length;
	} catch(e) {}
	return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
}

// 浮点数除法运算
function floatDiv(arg1, arg2) {
	var t1 = 0, t2 = 0, r1, r2;    
	try {
		t1 = arg1.toString().split(".")[1].length;
	} catch(e) {}
	try {
		t2 = arg2.toString().split(".")[1].length;
	} catch(e) {}
	with(Math) {
		r1 = Number(arg1.toString().replace(".", ""));
		r2 = Number(arg2.toString().replace(".", ""));
		return (r1 / r2) * pow(10, t2 - t1);
	}
}

// 设置数值精度
function setScale(value, scale, roundingMode) {
	if (roundingMode.toLowerCase() == "roundhalfup") {
		return (Math.round(value * Math.pow(10, scale)) / Math.pow(10, scale)).toFixed(scale);
	} else if (roundingMode.toLowerCase() == "roundup") {
		return (Math.ceil(value * Math.pow(10, scale)) / Math.pow(10, scale)).toFixed(scale);
	} else {
		return (Math.floor(value * Math.pow(10, scale)) / Math.pow(10, scale)).toFixed(scale);
	}
}

// 格式化商品价格货币
function priceCurrencyFormat(price) {
	price = setScale(price, shop_constant.priceScale, shop_constant.priceRoundType);
	return shop_constant.currencySign + price;
}

// 格式化商品价格货币（包含货币单位）
function priceUnitCurrencyFormat(price) {
	price = setScale(price, shop_constant.priceScale, shop_constant.priceRoundType);
	return shop_constant.currencySign + price + shop_constant.currencyUnit;
}

// 格式化订单金额货币
function orderCurrencyFormat(price) {
	price = setScale(price, shop_constant.orderScale, shop_constant.orderRoundType);
	return shop_constant.currencySign + price;
}

// 格式化订单金额货币（包含货币单位）
function orderUnitCurrencyFormat(price) {
	price = setScale(price, shop_constant.orderScale, shop_constant.orderRoundType);
	return shop_constant.currencySign + price + shop_constant.currencyUnit;
}

function defaultErrorPlacement(error, element) {
	var messagePosition = element.metadata().messagePosition;
	if("undefined" != typeof messagePosition && messagePosition != "") {
		var $messagePosition = $(messagePosition);
		if ($messagePosition.size() > 0) {
			error.insertAfter($messagePosition).fadeOut(300).fadeIn(300);
		} else {
			error.insertAfter(element).fadeOut(300).fadeIn(300);
		}
	} else {
		error.insertAfter(element).fadeOut(300).fadeIn(300);
	}
}
function defaultSubmitHandler(form) {
	$(form).find(":submit").attr("disabled", true);
	form.submit();
}

function defaultBeforeSubmit(){
	$(".formButtonSubmit").each(function(){
		$(this).attr("disabled", true);
	});
}

function enableAllSubmit(){
	$(".formButtonSubmit").each(function(){
		$(this).attr("disabled", false);
	});
}

function defaultErrorHandler(xhr, ajaxOptions, thrownError){
	alert('xhr请求失败,thrownError:'+thrownError);
}
function cnlength(str){
    return str.replace(/[^\x00-\xff]/gi,'oo').length;
}
jQuery(document).ready(function() {
		/* ---------- SliderScrollable ---------- */
    	/*var $sliderScrollable = $("#sliderScrollable");
	    if ($sliderScrollable.size() > 0) {
	        $sliderScrollable.scrollable({
	            circular: true,
	            speed: 500
	        }).autoscroll({
	            autoplay: true,
	            interval: 4000
	        }).navigator();
	    }*/
	    
	     //初始化购物车
	    $('#i-mycart').hover(function(){
	    		$('#o-mycart-list').show();
	    	},function(){
	    		$('#o-mycart-list').hide();
	    	}
	    );
		
	    
	    //set demo cookie
	    if($('#mycart-list').length>0){
			$.cookie('cart_product','35=1,36=2,37=3,38=4,39=5');
			var cart_product = $.cookie('cart_product');
			var cartAmount=cart_product.split(",").length;
			$('#mycart-amount').text(cartAmount);
			
			if(cartAmount=='0'){
				//购物篮中没有商品
				$('#mycart-list').append("<div class=\"norecode ac\">您的购物车中暂无商品，赶快选择心爱的商品吧！</div>");
			}else{
				$('#mycart-amount').text(cartAmount);
				var mycart_tpl = "<div><dl><dt class=\"p-img\"><a href=\"#{url}\" target=\"_blank\"><img src=\"#{image_url}\" onerror=\"this.src='/shopmall/resources/front/images/none_50.gif'\"></a></dt><dd class=\"p-name\"><a href=\"index.xhtml?method=product&productId=#{goodsId}\">#{goodsName}</a></dd><dd class=\"extra\"><strong>￥#{discountPrice}×#{cnt}</strong></dd></dl></div>";
				$.ajax({
					  dataType:'json',
					  type: "get",
					  url: "/shopmall/front/ajax.xhtml?method=ajaxProduct&productId="+cart_product,
					  success: function(respText) {
					  	  var sum_rmb = 0;
						  $.each(respText, function(i, item){
						  	$('#mycart-list').append($.tpl(mycart_tpl, item));
						  	sum_rmb = floatAdd(sum_rmb,floatMul(item.discountPrice,item.cnt));
						  });
					  	  //计算总价格
					  	  //alert(sum_rmb);
					  }
				});
			}
		}
		
	//初始化头部菜单
	function megaHoverOver(){
		$(this).find("a:first").addClass("curr");
		$(this).find(".sub").stop().fadeTo('fast', 1).show();
			
		//Calculate width of all ul's
		(function($) {
			jQuery.fn.calcSubWidth = function() {
				rowWidth = 500;
				//Calculate row
				/*$(this).find("dl").each(function() {					
					rowWidth += $(this).width(); 
				});	*/
			};
		})(jQuery);
		
		(function($) {
			jQuery.fn.calcSubLeft = function() {
				//rowWidth = 500;
				//Calculate row
				/*$(this).find("dl").each(function() {					
					rowWidth += $(this).width(); 
				});	*/
				rowLeft = 0;
				///寻找原点
				var x = 43.5 -250;
				if(($(this).position().left+x)<0){
					//超左边界
					rowLeft = 0-$(this).position().left;
				}else if(($(this).position().left+293.5)>980){
					//超右边界
					rowLeft = 980-$(this).position().left-43.5-500;
				}else{
					rowLeft = x;
				}
				/*if(($(this).position().left)<500){
					rowLeft = 0-$(this).position().left;
				}else{
					rowLeft = 980-$(this).position().left-500-87;
				}*/
			};
		})(jQuery);
		
		if ( $(this).find(".row").length > 0 ) { //If row exists...
			var biggestRow = 0;	
			//Calculate each row
			$(this).find(".row").each(function() {					   
				$(this).calcSubWidth();
				//Find biggest row
				if(rowWidth > biggestRow) {
					biggestRow = rowWidth;
				}
			});
			//Set width
			//$(this).find(".sub").css({'width' :biggestRow}).css({'top':27}).css({'left':-500});
			//$(this).find(".sub").css({'left' :0});
			//top: 27px; left: -10px;
			
			$(this).find(".row:last").css({'margin':'0'});
			
		} else { //If row does not exist...
			
			$(this).calcSubWidth();
			$(this).calcSubLeft();
			//alert(rowLeft);
			//Set Width
			$(this).find(".sub").css({'width' : rowWidth,'left':rowLeft});
			var position = $(this).position();
			$("p#test").text( "left: " + position.left + ", top: " + position.top );
		}
	}
	
	function megaHoverOut(){ 
	  $(this).find("a:first").removeClass("curr");
	  $(this).find(".sub").stop().fadeTo('fast', 0, function() {
		  $(this).hide();
	  });
	}
 
 
	var config = {    
		 sensitivity: 2, // number = sensitivity threshold (must be 1 or higher)    
		 interval: 50, // number = milliseconds for onMouseOver polling interval    
		 over: megaHoverOver, // function = onMouseOver callback (REQUIRED)    
		 timeout: 50, // number = milliseconds delay before onMouseOut    
		 out: megaHoverOut // function = onMouseOut callback (REQUIRED)    
	};
 
	$("ul#topnav li .sub").css({'opacity':'0'});
	$("ul#topnav li").hoverIntent(config);
	
	
});