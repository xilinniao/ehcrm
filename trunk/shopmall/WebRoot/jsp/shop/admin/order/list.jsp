<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>
	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/list.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/resources/admin/css/datatables.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
	<script src="<%=path %>/resources/common/js/base.js" type="text/javascript"></script>
	<script src="<%=path %>/resources/common/js/jquery.pager.js" type="text/javascript"></script>

  </head>
  <body class="list">
  	<div class="listBar">
		<h1><span class="icon">&nbsp;</span>订单列表&nbsp;<span class="pageInfo">总记录数: 11(共1页)</span></h1>
	</div>
	
	<div class="body">
		<form id="listForm" action="<%=path %>/shop/admin/orders.xhtml?method=list" method="post">
		<div class="operateBar">
			<label>订单编号:</label>
			<input type="text" name="orderNo" value="${qry.orderNo }" size="15">
			<label>下单时间:</label>
			<input type="text" name="orderDateFrom" id="orderDateFrom" value="${qry.orderDateFrom }" size="10">-
			<input type="text" name="orderDateTo" id="orderDateTo" value="${qry.orderDateTo }" size="10">
			<br/>
			<label>订单状态:</label>
			<select type="text" name="orderStatus" id="orderStatus">
				<option value="">全部</option>
				<option value="2">已下单</option>
				<option value="3">已确认</option>
				<option value="4">订单已送出</option>
				<option value="9">订单已完成</option>
			</select>
			
			<%=Constants.pageSizeHtml%>
			<input type="button" id="searchButton" class="formButton" value="查询">				
		</div>
		
		<table class="listTable" id="listTable" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<th nowrap>订单号</th>
					<th nowrap>下单时间</th>
					<th nowrap>客户名</th>
					<th nowrap>收件人</th>
					<th nowrap>电话</th>
					<th nowrap>金额</th>
					<th nowrap>订单状态</th>
					<th nowrap>操作</th>					
				</tr>
				<c:forEach items="${page.result}" var="b">
				<tr>
					<td>${b.orderNo }</td>
					<td>${b.orderTime }</td>
					<td>${b.custInfo.custCode }</td>
					<td>${b.revicedName }</td>
					<td>${b.revicedMobile }</td>
					<td>${b.orderMoney }</td>
					<td>${b.orderStatusStr }</td>
					<td><a href='<%=path %>/shop/admin/orders.xhtml?method=edit&orderId=${b.orderId }' title='编辑'>[编辑]</a>&nbsp;<a href='goodsInfo.xhtml?method=editGoods&goodsId=${b.orderId }' title='订单处理'>[订单处理]</a></td>
				</tr>
				</c:forEach>				
		</table>
		<div class="pagerBar">
			<input type="button" class="deleteButton" url="order!delete.action" value="删 除" disabled hidefocus="true" />
			
			<script type="text/javascript">
			$().ready( function() {			
				$("#pager").pager({
					pagenumber: ${page.pageNo},
					pagecount: ${page.totalPageCount},
					buttonClickCallback: $.gotoPage
				});
				$('#pageSize').val('${page.pageSize}');
			
			})
			</script>
			<span id="pager"></span>
			<input type="hidden" name="pageNo" id="pageNo" value="${page.pageNo}" />
			<input type="hidden" name="pager.orderBy" id="orderBy" value="${pager.orderBy}" />
			<input type="hidden" name="pager.orderType" id="order" value="${pager.orderType}" />
		</div>
		</form>
    </div>
  </body>
</html>