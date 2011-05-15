// 添加收藏夹
function addFavorite(url, title) {
	if (document.all) {
		window.external.addFavorite(url, title);
	} else if (window.sidebar) {
		window.sidebar.addPanel(title, url, "");
	}
}

/**
 * cookie_days cookie保存天数
 **/
shop_constant = {
	sysName: "抚州直销商城",
	base: "",
	currencySign: "￥",
	currencyUnit: "元",
	priceScale: "2",
	priceRoundType: "roundHalfUp",
	orderScale: "2",
	orderRoundType: "roundHalfUp",
	cookie_days: 60,
	cookie_path:'/'
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
	//检验是否登录
	$.memberVerify = function () {
		if($.cookie("memberUsername") != null) {
			var booleanStatus = false;
			$.ajax({
				type: "POST",
				url: shop_constant.base + "/front/ajax.xhtml?method=ajaxCheckLogin",
				dataType: "json",
				async: false,
				success: function(data) {
					if (data.status) {
						booleanStatus = true;
					}
				}
			});
			return booleanStatus;
		} else {
			return false;
		}
	}
	
	//初始化top信息
	var $header = $('#shortcut');
	if ($header.size() > 0) {
		var $shortcut_user_name = $('#shortcut_user_name');
		var $shortcut_login = $('#shortcut_login');
		var $shortcut_regist = $('#shortcut_regist');
		var $shortcut_logout = $('#shortcut_logout');
		
		$.flushHeaderInfo = function () {		
			if($.cookie("memberUsername") != null) {
				$shortcut_user_name.text($.cookie("memberUsername")+",欢迎来到"+shop_constant.sysName);
				$shortcut_login.hide();
				$shortcut_regist.hide();
				$shortcut_logout.show();
			}else{
				$shortcut_user_name.text("欢迎来到"+shop_constant.sysName+",你还没有登录")
				$shortcut_login.show();
				$shortcut_regist.show();
				$shortcut_logout.hide();
			}
		}
		
		$.flushHeaderInfo();
		$shortcut_login.click( function() {
			$.showLoginWindow();
			return false;
		})
		
		$shortcut_logout.click( function() {
			$.ajax({
				type: "POST",
				url: shop_constant.base+"/front/login.xhtml?method=onLogout",
				dataType: "json",
				success: function(data) {
					if (data.status == "success") {
						$.message({type: data.status, content: data.message});
						$.flushHeaderInfo();
					}
				}
			});
		});
						
		//登录窗口
		$.showLoginWindow = function (redirectUrl) {
			var loginWindowHtml = '<form id="loginWindowForm"><table><tr><th>用户名: </th><td><input type="text" id="loginname" name="loginname" class="formText" /></td></tr><tr><th>密&nbsp;&nbsp;&nbsp;码: </th><td><input type="password" id="loginpwd" name="loginpwd" class="formText" /></td></tr><tr><th>&nbsp;</th><td><span class="warnIcon">&nbsp;</span><a href="/shop/member!passwordRecover.action">忘记了密码? 点击找回!</a></td></tr></table></form>';
			
			$.dialog({title: "会员登录", content: loginWindowHtml, ok: "登 录", cancel: "取 消", id: "loginWindow", className: "loginWindow", width: 420, okCallback: login, modal: true});
			
			var $loginWindowForm = $("#loginWindowForm");
			var $loginname = $("#loginname");
			var $loginpwd = $("#loginpwd");
			
			function login() {
				if ($.trim($loginname.val()) == "") {
					$loginname.focus();
					$.message({type: "warn", content: "请输入用户名!"});
					return false;
				}
				if ($.trim($loginpwd.val()) == "") {
					$loginpwd.focus();
					$.message({type: "warn", content: "请输入密码!"});
					return false;
				}
				
				$.ajax({
					type: "POST",
					url: shop_constant.base+"/front/login.xhtml?method=onLogin",
					dataType: "json",
					data: $loginWindowForm.serialize(),
					beforeSend: function() {
						$loginWindowForm.find("button").attr("disabled", true);
					},
					success: function(data) {
						if (data.status == "success") {
							$.flushHeaderInfo();
							$.closeDialog("loginWindow");
						}
						$.message({type: data.status, content: data.message});
						if(redirectUrl != null) {
							location.href = redirectUrl;
						}
					},
					complete: function() {
						$loginWindowForm.find("button").attr("disabled", false);
						$loginWindowCaptcha.val("");
						loginWindowCaptchaImageRefresh();
					}
				});
				return false;
			}
		}
	}
	
	//搜索自动补全
	var $goodsKeyword = $('#goodsKeyword');
	if($goodsKeyword.size()>0){
		$goodsKeyword.autocomplete({
			url:shop_constant.base+"/front/ajax.xhtml?method=autoSuggestSearch",
			showResult: function(value, data) {
	            return '<span style="color:red">' + value + '</span>';
	        }
		});
		//$goodsKeyword.autocomplete({data: [ ['apple', 1], ['apricot', 2], ['pear', 3], ['prume', 4]]});
	}
	
	
		
	    //http://www.webdeveloperjuice.com/demos/jquery/simple-slide.html#
	    //http://cssglobe.com/lab/easyslider1.7/01.html
	    if($("#slider").size()>0){
	    	$("#slider").easySlider({
				auto: true,
				pause:5000,
				speed:0, 
				controlsFade: true,
				numeric: true,
				continuous:true
			});
	    }  
	    
	    /**
	     * needclr 是否需要清除购物篮
	     **/
	   	$.flushcartitems=function(needclr){
	   		if(needclr){$('#mycart-list').empty()};
	   		var cart_items = $.cookie('cartitems');
			if(cart_items==null){
				//购物篮中没有商品
				$('#mycart-amount').text('0');
				$('#mycart-list').append("<div class=\"norecode ac\">您的购物车中暂无商品，赶快选择心爱的商品吧！</div>");
			}else{
				var cartAmount=cart_items.split(",").length;
				$('#mycart-amount').text(cartAmount);
				var mycart_tpl = "<div><dl><dt class=\"p-img\"><a href=\""+shop_constant.base+"/product/#{subGoodsId}.html\" target=\"_blank\"><img src=\"#{imagea}\" width=\"50\" height=\"50\"></a></dt><dd class=\"p-name\"><a href=\""+shop_constant.base+"/product/#{subGoodsId}.html\">#{goodsName}</a></dd><dd class=\"extra\"><strong>￥#{discountPrice}×#{cnt}</strong></dd></dl></div>";
				$.ajax({
					  dataType:'json',
					  type: "get",
					  url: shop_constant.base+"/front/ajax.xhtml?method=ajaxProduct&productId="+cart_items,
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
	    //初始化购物车
	    if($('#mycart-list').length>0){
			//初始化购物车
		    $('#i-mycart').hover(function(){
		    		$('#o-mycart-list').show();
		    	},function(){
		    		$('#o-mycart-list').hide();
		    	}
		    );
		    $.flushcartitems(false);
		}
		
		/** 历史记录 */
		var $goodsHistory = $("#goodsHistory");
		if ($goodsHistory.size() > 0) {
			var historyproduct = $.cookie('goodsHistoryList');
			var history_tpl = "<li class=\"fore\"><div class=\"p-img\"><a href=\""+shop_constant.base+"/product/#{subGoodsId}.html\"><img src=\"#{imagea}\" width=\"50\" height=\"50\"></a></div><div class=\"p-name\"><a href=\""+shop_constant.base+"/product/#{subGoodsId}.html\">#{goodsName}</a></div></li>";
			$.ajax({
				  dataType:'json',
				  type: "get",
				  url: shop_constant.base+"/front/ajax.xhtml?method=ajaxProduct&productId="+historyproduct,
				  success: function(respText) {
				  	  var sum_rmb = 0;
					  $.each(respText, function(i, item){
					  	//alert(item.imageUrl);
					  	$('#ul_goodsHistory').append($.tpl(history_tpl, item));
					  	sum_rmb = floatAdd(sum_rmb,floatMul(item.discountPrice,item.cnt));
					  });
				  }
			});
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
			//$("p#test").text( "left: " + position.left + ", top: " + position.top );
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