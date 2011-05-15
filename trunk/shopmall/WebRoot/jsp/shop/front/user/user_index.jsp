<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/usercenter.css" rel="stylesheet" type="text/css" />

<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/jquery.tools.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/jquery.tmpl.min.js" type="text/javascript"></script>
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
		$(".tab_content").hide(); //Hide all tab content
		$('#detail'+'_'+$("ul.tab li").index($(this))).fadeIn();
		return false;
	});
});
//-->
</script>
</head>
<body id="index">
<%@include file="/jsp/shop/front/common/top.jsp"%>


	
<!-- 正文开始 -->
<div class="w main">
	<%@include file="/jsp/shop/front/user/user_nav.jsp"%><!-- 左边导航条 -->
	
	<div id="uc_middle">
		<div id="uc_info" class="clearfix">
			<div class="myhead">
				<div class="pic">
					<img width="73" height="73" src="http://img36.ddimg.cn/imghead/23/27/9955414716116-1_e.png" title="我的头像">
				</div>
			</div>
			
			<div class="info"> 
	         	<p class="name">欢迎，zhoucl<span> <a href="http://customer.dangdang.com/profile/">编辑个人档案</a></span></p>         
	         	<ul class="area1 clearfix">
	         		<li>会员级别：
	         			<a target="_blank" href="http://support.dangdang.com/helpcenter/api_cms/helpcenter/question_sort/2238/180312.shtml#4">普通会员</a>
	         		</li>
	         		<li class="listr">&nbsp;&nbsp;&nbsp;  </li>
	         		<li>一年内消费：<span>￥400.50</span></li>
	         		<li class="listr">再消费<span>￥1187.50</span>&nbsp;即可晋级为<a target="_blank" href="http://support.dangdang.com/helpcenter/api_cms/helpcenter/question_sort/2238/180312.shtml#2">金卡会员</a></li>
	         		<li>账户余额：<span>￥0.00</span></li>
	         		<li class="listr">礼品卡：<span>￥0.00</span></li>
	         		<li>累计消费：<span>￥400.50</span></li>
	         		<li class="listr">账户积分：<span>1109</span> (<a href="http://my.dangdang.com/memberpoints/points_change.aspx">兑换礼品</a>)</li>
	         	</ul>	         

			</div>
		</div><!-- end of uc_info -->
		
		
		<div id="order_info" class="Tip_Buy">
			<h3>订单列表</h3>
             <table class="Table" bordercolor="#AACCEE" border="1" width="100%">
                 <tbody>
                  <tr>
                      <th>订单编号</th>
                      <th>下单时间</th>
                      <th>收货人</th>
                      <th>支付方式</th>
                      <th>订单状态</th>
                      <th>操作</th>
                  </tr>
                 
                  <tr>
                      <td>44112666</td>
                      <td>2011-3-11 22:01:00</td>
                      <td>周才伦</td>
                      <td>货到付款</td>
                      <td>完成</td>
                      <td><a target="_blank" href="JdHome/OrderInfo.aspx?orderid=44112666">查看</a></td>
                  </tr>                        
                  <tr>
                      <td colspan="6">
                          <span class="float_Right"><a href="http://jd2008.360buy.com/jdhome/orderlist.aspx">更多商品&gt;&gt;</a></span>
                      </td>
                  </tr>
             	</tbody>
             </table>
         </div>
         
         <div id="pj_info" class="Tip_Buy">
			<h3>待评价商品<em>(100%送积分哦)</em></h3>
             <table class="Table" bordercolor="#AACCEE" border="1" width="100%">
                 <tbody>
                  <tr>
                      <th>订单编号</th>
                      <th>下单时间</th>
                      <th>收货人</th>
                      <th>支付方式</th>
                      <th>订单状态</th>
                      <th>操作</th>
                  </tr>                 
                  <tr>
                      <td>44112666</td>
                      <td>2011-3-11 22:01:00</td>
                      <td>周才伦</td>
                      <td>货到付款</td>
                      <td>完成</td>
                      <td><a target="_blank" href="JdHome/OrderInfo.aspx?orderid=44112666">查看</a></td>
                  </tr>                        
                  <tr>
                      <td colspan="6">
                          <span class="float_Right"><a href="http://jd2008.360buy.com/jdhome/orderlist.aspx">更多商品&gt;&gt;</a></span>
                      </td>
                  </tr>
             	</tbody>
             </table>
         </div>
                
	</div><!-- end of uc_middle -->
	
</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>