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
	
	<div id="uc_content">
          <div class="uc_list">
			<h3>地址列表</h3>
			
			 <c:if test="${msg!=null}">
			 	
			 </c:if>
             <table class="Table" bordercolor="#AACCEE" border="1" width="100%">
                 <tbody>
                  <tr>
                      <th>姓名</th>
                      <th>送货地址</th>
                      <th>联系电话</th>
                      <th>电子邮件</th>
                      <th>操作</th>
                  </tr>
                 
                  <c:forEach items="${addrList}" var="b">
                  <tr>
                      <td>${b.revicedName }</td>
                      <td>${b.revicedAddr }</td>
                      <td>${b.revicedMobile }</td>
                      <td>${b.revicedEmail }</td>
                      <td><a href="<%=path%>/front/user.xhtml?method=editAddress&addrId=${b.addrId }">修改</a></td>
                  </tr>
                  </c:forEach>                 
                  
             	</tbody>
             </table>
         </div>
        
	</div><!-- end of uc_middle -->
	
</div><!-- end of 正文 -->
<div class="clr5"></div>

<%@include file="/jsp/shop/front/common/footer.jsp"%>
</body>
</html>