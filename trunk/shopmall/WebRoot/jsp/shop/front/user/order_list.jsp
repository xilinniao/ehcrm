<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title>抚州网上购物商城</title>
<link href="<%=path %>/resources/front/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/resources/front/css/usercenter.css" rel="stylesheet" type="text/css" />

<%@include file="/jsp/shop/front/common/head.jsp"%>
<script src="<%=path %>/resources/front/js/jquery.pager.js" type="text/javascript"></script>
<script src="<%=path %>/resources/front/js/base.js" type="text/javascript"></script>

<script type="text/javascript">
<!--
$(document).ready(function() {
	
});
//-->
</script>
</head>
<body id="index">
<%@include file="/jsp/shop/front/common/top.jsp"%>
	
<!-- 正文开始 -->
<div class="w main">
	<%@include file="/jsp/shop/front/user/user_nav.jsp"%><!-- 左边导航条 -->
	
	<div class="uc_right">
          	<div class="o-mt"><h2>订单列表</h2></div>
             <table class="userTable" bordercolor="#AACCEE" border="1" width="100%">
                 <tbody>
                  <tr>
                      <th>订单编号</th>
                      <th>下单时间</th>
                      <th>收货人</th>
                      <th>支付方式</th>
                      <th>订单状态</th>
                      <th>操作</th>
                  </tr>
                 
                  <c:forEach items="${page.result}" var="b">
                  <tr>
                      <td>${b.orderNo }</td>
                      <td>${b.orderTime }</td>
                      <td>${b.revicedName }</td>
                      <td>货到付款</td>
                      <td>${b.orderStatus }</td>
                      <td><a target="_blank" href="${b.orderId }">查看</a></td>
                  </tr>
                  </c:forEach>                 
                  
             	</tbody>
             </table>
  		<div class="clr5"></div>
         <div class="pagerBar">			
			<script type="text/javascript">
			$().ready( function() {
				$.gotoPage = function(id) {
					document.location.href="user.xhtml?method=orderList&pageNo="+id;
				}
				$("#pager").pager({
					pagenumber: ${page.pageNo},
					pagecount: ${page.totalPageCount},
					buttonClickCallback: $.gotoPage
				});
			})
			</script>
			<span id="pager"></span>
		</div>
	</div><!-- end of uc_middle -->
	
</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>