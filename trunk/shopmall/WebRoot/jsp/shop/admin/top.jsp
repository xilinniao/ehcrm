<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title></title>
<link href="<%=path %>/resources/common/css/reset.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/admin/css/header-shop.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.header {
	margin-bottom: 7px;
	border-bottom: 3px solid #F34F04;
}
</style>
</head>
<body id="index">

<div class="header">
	<div id="logo" style="width:100%;">
		<div style="float:left;">
		<a href="<%=homeUrl %>" target="_blank">
			<img src="<%=path %>/resources/front/images/logo.gif" alt="" width="251" height="46">
		</a>
		</div>
		
		<div style="float:right;margin-right:25px;">
			<div class="headerTop">
				<div class="headerLink">
					<span class="welcome">
						${userinfo.user.userCode},您好!
					</span>
	                <a href="<%=path%>/help/topic-aboutus.html" target="_blank">关于我们</a>|
	                <a href="<%=path%>/help/topic-linkus.html" target="_blank">联系我们</a>
				</div>
			</div>
			<div class="headerBottom">
				<div class="userInfo">
					<a href="admin_profile!edit.action" target="mainFrame">
						<span class="profileIcon"></span>后台首页
					</a>
					<a href="<%=path %>/shopinfo/index-${userinfo.shopInfo.shopId}.html" target="_blank">
						<span class="profileIcon"></span>店铺预览
					</a>
					<a href="<%=path %>/front/shoplogin.xhtml?method=changepwd" target="mainFrame">
						<span class="profileIcon"></span>修改密码
					</a>
					<a href="<%=path %>/front/shoplogin.xhtml?method=onLogout">
						<span class="logoutIcon">&nbsp;</span>退出&nbsp;
					</a>
				</div>
			</div>
		</div>
	</div>

	<div class="clr"></div>
</div>


</body>
</html>