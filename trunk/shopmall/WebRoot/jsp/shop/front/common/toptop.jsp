<%@ page contentType="text/html; charset=utf-8"%>
<!-- 顶部信息 -->
<div id="shortcut">
	<div class="w">
		<div class="collect"><b></b><a href="#none" onclick="addFavorite('http://www.0794buy.com', '抚州购物商城')">收藏抚州直销商城</a></div>
		<ul>
			<li class="fore1" id="loginfo"><span id="shortcut_user_name"></span>
				<span id="shortcut_login_regist">
					<!-- 
					<a id="shortcut_login" href="<%=path%>/front/common/login.html">[请登录]</a>，新用户？
					 -->
					<a id="shortcut_login" href="javascript:void(0);">[请登录]</a>
					<a id="shortcut_regist" href="<%=path%>/front/common/custreg.html" class="link-regist">新用户？[免费注册]</a>
					<a id="shortcut_logout" href="javascript:void(0);" class="link-regist">[退出]</a>
				</span>
			</li>
			<li class="fore2"><a href="<%=path%>/front/user.xhtml?method=orderList">我的订单</a></li>
			<li><a href="<%=path%>/front/user.xhtml">用户中心</a></li>
			<li><a href="http://market.360buy.com/giftcard/" target="_blank">店铺申请</a></li>
			<li><a href="http://market.360buy.com/giftcard/company/default.aspx" target="_blank">商家入驻</a></li>
			<li><a href="http://market.360buy.com/giftcard/company/default.aspx" target="_blank">联系我们</a></li>
			<li><a href="<%=path%>/help/main-index.html">帮助中心</a></li>
			<!--
			<li class="sub">
			<dl>
				<dt><b></b><a href="http://www.360buy.com/help/" target="_blank">帮助中心</a></dt>
				<dd>
					<div><a href="http://jd2008.360buy.com/JdHome/OrderList.aspx">订单中心</a></div>
					<div><a href="http://jd2008.360buy.com/Repairs.aspx" target="_blank">返修中心</a></div>
					<div><a href="http://jd2008.360buy.com/complaint.aspx">投诉中心</a></div>
				</dd>
			</dl>
			</li>
			 -->
		</ul>
		<span class="clr"></span>
	</div>
</div>
<!-- 顶部信息结束 -->