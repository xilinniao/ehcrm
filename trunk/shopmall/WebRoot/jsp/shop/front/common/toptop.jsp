<%@ page contentType="text/html; charset=utf-8"%>
<!-- 顶部信息 -->
<div id="shortcut">
	<div class="w">
		<ul>
			<li class="fore1" id="loginfo"><span id="shortcut_user_name"></span>
				<span id="shortcut_login_regist">
					<a id="shortcut_login" href="javascript:void(0);">[登录]</a>
					<a id="shortcut_regist" href="<%=path%>/front/common/custreg.html" class="link-regist">[免费注册]</a>
					<a id="shortcut_logout" href="javascript:void(0);" class="link-regist">[退出]</a>
				</span>
			</li>
			<li class="fore2"><a href="#none" onclick="$.gotoOrderList()">我的订单</a></li>
			<li><a href="#none" onclick="$.gotoUserCenter()">用户中心</a></li>
			<li><a href="<%=path%>/help/topic-joinus.html">商铺加盟</a></li>
			<li><a href="<%=path%>/help/topic-linkus.html">联系我们</a></li>
			<li><a href="<%=path%>/help/main-index.html">帮助中心</a></li>
			<li class="hottel">客服热线:<span>0794-12345678</span></li>
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