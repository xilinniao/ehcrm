<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <%@include file="/common/meta.jsp"%>
    <title><%=projName %></title>
    <link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/header.css" rel="stylesheet" type="text/css" />
	<LINK rel="stylesheet" href="<%=path %>/resources/js/plugin/superfish/superfish.css" type="text/css" />
    <SCRIPT type="text/javascript" src="<%=path %>/resources/js/jquery/jquery-1.4.3.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="<%=path %>/resources/js/jdmenu/jquery.dimensions.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="<%=path %>/resources/js/jdmenu/jquery.positionBy.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="<%=path %>/resources/js/jdmenu/jquery.bgiframe.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="<%=path %>/resources/js/plugin/superfish/hoverIntent.js"></SCRIPT>
	<SCRIPT type="text/javascript" src="<%=path %>/resources/js/plugin/superfish/superfish.js"></SCRIPT>	
	<script type="text/javascript">
		/*function frameSize () {
			$("#mainFrame").css({ height: $(document).height()-$('#header-container').height() + "px" ,width:'100%'});
		}*/
		
		$(document).ready(function() {
		  	//frameSize ();
		  	jQuery('ul.sf-menu').superfish().find('li > ul > li').click(function(){
		  		jQuery('ul.sf-menu').hideSuperfishUl();
		  	});
		  	/*$(window).resize(function () {
				frameSize ();
			});*/
			
			function fixHeight () {
		       	var headerHeight = $("#header-container").height();
		       	$("#mainFrame").css({"height":(($(window).height() - 10) - headerHeight) + 'px',width:'100%'});
	       	}
	        
			$(window).resize(function () {
	        		fixHeight();
	       	}).resize();
		});
	</script>
  </head>
  
  <body class="header">
  
  	<div id="header-container" class="body">
		<!-- <div class="headerLogo"></div> -->
		<div class="headerTop">
			<div class="headerLink">
				<span class="welcome">
					<strong></strong>&nbsp;${userinfo.user.userName},您好!
				</span>
				<!-- <a href="admin!index.action" target="mainFrame">后台首页</a>|
            	<a href="" target="_blank">技术支持</a>|
                <a href="" target="_blank">购买咨询</a>|
                <a href="" target="_blank">关于我们</a>|
                <a href="" target="_blank">联系我们</a>
                 -->
			</div>
		</div>
		<div class="headerBottom">
			<div class="headerMenu">
				<div class="menuLeft"></div>
	            ${userinfo.menuStr }
	            <div class="menuRight"></div>
			</div>
			
			
			<div class="userInfo">
				<a href="admin_profile!edit.action" target="mainFrame">
					<span class="profileIcon">&nbsp;</span>个人资料
				</a>
				<a href="<%=path %>/admin/login.xhtml?method=logout" target="_top">
					<span class="logoutIcon">&nbsp;</span>退出&nbsp
				</a>
			</div>
		</div>
	</div>
	
	<iframe id="mainFrame" name="mainFrame" src="<%=path %>/jsp/admin/dashboard.jsp" frameborder="0" marginwidth="0" marginheight="0"></iframe>
	
  </body>
</html>