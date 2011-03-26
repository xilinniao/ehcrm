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
		
	    
	    
		$.cookie('productId','35,36,37,38,39');
		$.cookie('productCnt','4');
		
		if($.cookie('productCnt')=='0'){
			//购物篮中没有商品
			$('#mycart-list').append("<div class=\"norecode ac\">您的购物车中暂无商品，赶快选择心爱的商品吧！</div>");
		}else{
			$('#mycart-amount').text($.cookie('productCnt'));
			var mycart_tpl_str = "<div><dl><dt class=\"p-img\"><a href=\"${url}\" target=\"_blank\"><img src=\"${image_url}\" onerror=\"this.src='/shopmall/resources/front/images/none_50.gif'\"></a></dt><dd class=\"p-name\"><a href=\"index.xhtml?method=product&productId=${goodsId}\">${goodsName}</a></dd><dd class=\"extra\"><strong>￥${discountPrice}×1</strong><br><a id=\"334965\" name=\"RemoveProduct\" href=\"#none\">删除</a></dd></dl></div>";
	    	jQuery.template("mycart_tpl", mycart_tpl_str);
			$.ajax({
				  dataType:'json',
				  type: "get",
				  url: "/shopmall/front/ajax.xhtml?method=ajaxProduct&productId="+$.cookie('productId'),
				  success: function(respText) {
				  	$.tmpl( "mycart_tpl", respText ).appendTo('#mycart-list');
				  	
				  	//计算总价格
				  }
			});
		}
		
	    //初始化头部菜单
		function megaHoverOver(){
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
			$(this).find(".sub").css({'width' :biggestRow});
			$(this).find(".row:last").css({'margin':'0'});
			
		} else { //If row does not exist...
			
			$(this).calcSubWidth();
			//Set Width
			$(this).find(".sub").css({'width' : rowWidth});
			
		}
	}
	
	function megaHoverOut(){ 
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