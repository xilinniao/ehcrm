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
          	<div class="o-mt"><h2>购买咨询</h2></div>
			 <c:if test="${param.msg!=null}">
			 	<div class="userTipSuccess">保存成功</div>
			 </c:if>
			 
             <table class="userTable" bordercolor="#AACCEE" border="1" width="100%">
                 <tbody>
                  <tr>
                      <th>商品名称</th>
                      <th>咨询内容</th>
                      <th>咨询时间</th>
                      <th>店铺回复</th>
                      <th>回复时间</th>
                      <th>操作</th>
                  </tr>
                 
                  <c:forEach items="${qaList.result}" var="b">
                  <tr>
                      <td>${b.goods.goodsName }</td>
                      <td>${b.question }</td>
                      <td>${b.createTime }</td>
                      <td>${b.answer }</td>
                      <td>${b.answerTime }</td>
                      <td><a href="<%=path%>/front/user.xhtml?method=editQa&qaId=${b.recId }">修改</a></td>
                  </tr>
                  </c:forEach>                 
                  
             	</tbody>
             </table>
        
	</div><!-- end of uc_middle -->
	
</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>