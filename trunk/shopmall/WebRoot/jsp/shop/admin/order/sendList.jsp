<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="com.eh.base.util.HtmlTag" %>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>
	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/list.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
	<script src="<%=path %>/resources/common/js/base.js" type="text/javascript"></script>
	<script src="<%=path %>/resources/common/js/jquery.pager.js" type="text/javascript"></script>
<script type="text/javascript">
	function gotoEdit(orderId){
		$('#edit_orderId').val(orderId);
		$('#editForm').submit();
	}
	
	$().ready( function() {
		$('#orderStatus').val('${qry.orderStatus}');
	});
</script>

  </head>
  <body class="list">
  
  	<form id="editForm" name="editForm" method="post" action="<%=path %>/shop/admin/orders.xhtml?method=send">
	<input type="hidden" name="orderId" id="edit_orderId" value=""/>
	<input type="hidden" name="qryHex" value="${qry.qryHex}"/>
	</form>

  	<div class="listBar">
		<h1><span class="icon">&nbsp;</span>待发货订单列表&nbsp;<span class="pageInfo">总记录数: ${page.totalCount}(共${page.totalPageCount}页)</span></h1>
	</div>
	
	<div class="body">
		<form id="listForm" action="<%=path %>/shop/admin/orders.xhtml?method=sendList" method="post">
		<div class="operateBar">
			<table border="0" cellspacing="0" cellpadding="0" class="qryTable">
			<tr>
				<td>
					<label>订单编号</label><input type="text" name="orderNo" value="${qry.orderNo }" size="15">
					<label>下单时间</label><input type="text" name="orderDateFrom" id="orderDateFrom" value="${qry.orderDateFrom }" size="10">-
					<input type="text" name="orderDateTo" id="orderDateTo" value="${qry.orderDateTo }" size="10">
				</td>
			</tr>
			<tr>
				<td>
					<label>订单状态</label><select type="text" name="orderStatus" id="orderStatus" class="formSelectS">
						<option value="">全部</option>
						<option value="0">客户已下单</option>
						<option value="3">订单已锁定</option>
					</select>			
					<%=Constants.pageSizeHtml%>
					<input type="button" id="searchButton" class="formButton" value="查询">
				</td>
			</tr>
			</table>			
		</div>
		
			
		<table class="listTable" id="listTable">
				<tr>
					<th nowrap>订单号</th>
					<th nowrap>下单时间</th>
					<th nowrap>下单客户</th>
					<th nowrap>收件人</th>
					<th nowrap>联系电话</th>
					<th nowrap>送货地址</th>
					<th nowrap>订单金额</th>
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
					<td>${b.revicedAddr }</td>
					<td>${b.orderMoney }</td>
					<td>${b.orderStatusStr }</td>
					<td><a href='#none' onclick="gotoEdit('${b.orderId }')" title='发货'>[发货]</a></td>
				</tr>
				</c:forEach>				
		</table>
		<div class="pagerBar">
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