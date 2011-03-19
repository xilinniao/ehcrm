
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>Mega Dropdown Menu by Soh Tanaka</title> 
 
<style type="text/css"> 
body {
	margin: 0; padding: 0;
	font: normal 10px Verdana, Arial, Helvetica, sans-serif;
	background: url(http://www.sohtanaka.com/web-design/examples/mega-dropdowns/body_bg.png) repeat-x;
}
*{outline: none;}
img {border: 0;}
.container {
	width: 960px;
	padding: 0;
	margin: 0 auto;
}
#header {
	background: url(http://www.sohtanaka.com/web-design/examples/mega-dropdowns/header.jpg) no-repeat;
	width: 970px; height: 179px;
	float: left;
}
ul#topnav {
	margin: 0; padding: 0;
	float:left;
	list-style: none;
	font-size: 1.1em;
}
ul#topnav li {
	float: left;
	margin: 0; padding: 0;
	position: relative;
}
ul#topnav li a {
	float: left; 
	//text-indent: -9999px;
	height: 44px;
}
ul#topnav li:hover a, ul#topnav li a:hover {}
ul#topnav a.home {
	width: 78px; 
}
ul#topnav a.products {
	width: 117px; 
}
ul#topnav a.sale {
	background: url(http://www.sohtanaka.com/web-design/examples/mega-dropdowns/nav_sale.png) no-repeat;
	width: 124px; 
}
ul#topnav a.community {
	background: url(http://www.sohtanaka.com/web-design/examples/mega-dropdowns/nav_community.png) no-repeat;
	width: 124px; 
}
ul#topnav a.store {
	background: url(http://www.sohtanaka.com/web-design/examples/mega-dropdowns/nav_store.png) no-repeat;
	width: 141px; 
}
 
 
ul#topnav li .sub {
	position: absolute;	
	top: 44px; left: 0;
	background: #344c00 url(http://www.sohtanaka.com/web-design/examples/mega-dropdowns/sub_bg.png) repeat-x;
	padding: 20px 20px 20px;
	float: left;
	/*--Bottom right rounded corner--*/
	-moz-border-radius-bottomright: 5px;
	-khtml-border-radius-bottomright: 5px;
	-webkit-border-bottom-right-radius: 5px;
	/*--Bottom left rounded corner--*/
	-moz-border-radius-bottomleft: 5px;
	-khtml-border-radius-bottomleft: 5px;
	-webkit-border-bottom-left-radius: 5px;
	display: none;
}
ul#topnav li .row {clear: both; float: left; width: 100%; margin-bottom: 10px;}
ul#topnav li .sub ul{
	list-style: none;
	margin: 0; padding: 0;
	width: 150px;
	float: left;
}
ul#topnav .sub ul li {
	width: 100%;
	color: #fff;
}
ul#topnav .sub ul li h2 {
	padding: 0;  margin: 0;
	font-size: 1.3em;
	font-weight: normal;
}
ul#topnav .sub ul li h2 a {
	padding: 5px 0;
	background-image: none;
	color: #e8e000;
}
ul#topnav .sub ul li a {
	float: none; 
	text-indent: 0; /*--Reset text indent--*/
	height: auto;
	background: url(http://www.sohtanaka.com/web-design/examples/mega-dropdowns/navlist_arrow.png) no-repeat 5px 12px;
	padding: 7px 5px 7px 15px;
	display: block;
	text-decoration: none;
	color: #fff;
}
ul#topnav .sub ul li a:hover {color: #ddd; background-position: 5px 12px ;}
</style> 
 
</head> 
 
<body id="home"> 
<div class="container"> 
 
    <div id="header"></div> 
    <ul id="topnav"> 
    	<li> 
        	<a href="#" class="home">Home</a> 
        </li> 
        <li> 
        	<a href="#" class="products">Products</a> 
            <div class="sub"> 
            	<ul> 
                	<li><h2><a href="#">Desktop</a></h2></li> 
                	<li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                </ul> 
                <ul> 
                	<li><h2><a href="#">Laptop</a></h2></li> 
                	<li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                </ul> 
                <ul> 
                	<li><h2><a href="#">Accessories</a></h2></li> 
                	<li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                </ul> 
                <ul> 
                	<li><h2><a href="#">Accessories</a></h2></li> 
                	<li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                    <li><a href="#">Navigation Link</a></li> 
                </ul> 
                
            </div> 
        </li> 
        <li> 
        	<a href="#" class="sale">Sale</a> 
            <div class="sub"> 
            	<div class="row"> 
                    <ul style="width: 225px;"> 
                        <li><h2><a href="#">Deal of the Week</a></h2></li> 
                        <li><a href="#">Navigation Link - 2 Column</a></li> 
                        <li><a href="#">Navigation Link - 2 Column</a></li> 
                        <li><a href="#">Navigation Link - 2 Column</a></li> 
                        <li><a href="#">Navigation Link - 2 Column</a></li> 
                    </ul> 
                    <ul style="width: 225px;"> 
                        <li><h2><a href="#">Clearance Items</a></h2></li> 
                        <li><a href="#">Navigation Link - 2 Column</a></li> 
                        <li><a href="#">Navigation Link - 2 Column</a></li> 
                        <li><a href="#">Navigation Link - 2 Column</a></li> 
                        <li><a href="#">Navigation Link - 2 Column</a></li> 
                    </ul> 
                </div> 
                <div class="row"> 
                    <ul> 
                        <li><h2><a href="#">Deal of the Week</a></h2></li> 
                        <li><a href="#">Navigation Link</a></li> 
                        <li><a href="#">Navigation Link</a></li> 
                        <li><a href="#">Navigation Link</a></li> 
                        <li><a href="#">Navigation Link</a></li> 
                    </ul> 
                    <ul> 
                        <li><h2><a href="#">Clearance Items</a></h2></li> 
                        <li><a href="#">Navigation Link</a></li> 
                        <li><a href="#">Navigation Link</a></li> 
                        <li><a href="#">Navigation Link</a></li> 
                        <li><a href="#">Navigation Link</a></li> 
                    </ul> 
                    <ul> 
                        <li><h2><a href="#">Open Box Items</a></h2></li> 
                        <li><a href="#">Navigation Link</a></li> 
                        <li><a href="#">Navigation Link</a></li> 
                        <li><a href="#">Navigation Link</a></li> 
                        <li><a href="#">Navigation Link</a></li> 
                    </ul> 
                </div> 
            </div> 
        </li> 
        <li> 
        	<a href="#" class="community">Community</a> 
        </li> 
        <li> 
        	<a href="#" class="store">Store Locator</a> 
        </li> 
    </ul> 
 
</div> 
 
 
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script> 
<script type="text/javascript" src="http://www.sohtanaka.com/web-design/examples/mega-dropdowns/jquery.hoverIntent.minified.js"></script> 
<script type="text/javascript"> 
$(document).ready(function() {
	
 
	function megaHoverOver(){
		$(this).find(".sub").stop().fadeTo('fast', 1).show();
			
		//Calculate width of all ul's
		(function($) { 
			jQuery.fn.calcSubWidth = function() {
				rowWidth = 0;
				//Calculate row
				$(this).find("ul").each(function() {					
					rowWidth += $(this).width(); 
				});	
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
		 interval: 100, // number = milliseconds for onMouseOver polling interval    
		 over: megaHoverOver, // function = onMouseOver callback (REQUIRED)    
		 timeout: 500, // number = milliseconds delay before onMouseOut    
		 out: megaHoverOut // function = onMouseOut callback (REQUIRED)    
	};
 
	$("ul#topnav li .sub").css({'opacity':'0'});
	$("ul#topnav li").hoverIntent(config);
 
 
 
});
 
 
 
</script> 
 
 
</body> 
</html> 