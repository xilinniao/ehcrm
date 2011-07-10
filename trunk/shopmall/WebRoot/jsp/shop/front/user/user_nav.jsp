<%@ page contentType="text/html; charset=utf-8"%>
<div id="usernav">
    <h2>用户中心</h2>
    <div class="left_box1">
	<h3>交易管理</h3>
    <ul class="margin_b6">
    	<li><a href="user.xhtml">用户中心</a></li>
        <li><a href="user.xhtml?method=orderList">订单列表</a></li>
		<li><a href="">我的团购</a></li>
        <li><div><a href="">评价/晒单</a></div></li>
    </ul>
	
	<h3>个人信息管理</h3>
    <ul class="margin_b6">
    	<li><div><a href="user.xhtml?method=profile">个人资料</a></div></li>
        <li><a href="user.xhtml?method=addressList">常用地址</a></li>
        <!--<li><a href="">短&nbsp;消&nbsp;息</a></li>-->
        <li><a href="<%=path%>/front/login.xhtml?method=changePwd">修改密码</a></li>
    </ul>
    <h3>服务中心</h3>
    <ul class="margin_b6">
        <li><a href="user.xhtml?method=qaList">购买咨询</a></li>
        <li><a href="#">我的评价</a></li>
        <!--
        <li><a href="Repairs.aspx">售后服务</a></li>
        <li><a href="user_jubao.aspx">我的举报</a></li>
        -->
    </ul>
</div>
</div>
