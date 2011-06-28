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
		<h1><span class="icon">&nbsp;</span>商品列表&nbsp;<span class="pageInfo">总记录数: ${page.totalCount}(共${page.totalPageCount}页)</span</h1>
	</div>
	

	
	<div class="body">
		<form id="listForm" action="<%=path %>/shop/admin/goodsInfo.xhtml?method=goodsList" method="post">
		<input type="hidden" name="treeNo" value="${qry.treeNo }">
		<div class="operateBar">
			<label>商品分类</label>
			<c:forEach item="${goodsCategoryList}" var="b">
			<select name="treeNo" id="treeNo" class="formSelect">
				<option value="${b.treeNo}">${b.categoryName}</option>
			</select>
			</c:forEach>
			
			<label>商品名称:</label>
			<input type="text" name="goodsName" id="goodsName" class="formText" value="${qry.goodsName }">
			<label>显示:</label>
			<select name="pageSize" id="pageSize" class="formSelectPageSize">
				<option value="20">
					20
				</option>
				<option value="50">
					50
				</option>
				<option value="100">
					100
				</option>
			</select>
			<input type="button" id="searchButton" class="searchButton" value="">				
		</div>
		
		<div class="operateBar">
			<input type="button" class="addButton" onclick="location.href='goodsInfo.xhtml?method=add'" value="新增商品">
		</div>
	
		<table class="listTable">
				<tr>
						<th><input type="checkbox"></th>
					    <th nowrap>商品名称</th>
					    <th nowrap>商品编号</th>
					    <th nowrap>所属分类</th>
					    <th nowrap>市场价</th>
					    <th nowrap>商城价</th>
					    <th nowrap>库存</th>
					    <th nowrap>操作</th>
				</tr>
				<c:forEach items="${page.result}" var="b">
				<tr>
					<td><input type="checkbox" class="allCheck" name="ids" value="2fe680f62eec0481012f15a0272f0114" /></td>
					<td>${b.goodsName }</td>
					<td>${b.goodNo }</td>
					<td>${b.category.categoryName }</td>
					<td>${b.marketPrice }</td>
					<td>${b.discountPrice }</td>
					<td></td>
					<td><a href='<%=path %>/shop/admin/goodsInfo.xhtml?method=editGoods&goodsId=${b.goodsId }' title='编辑'>[编辑]</a>&nbsp;<a href='<%=path %>/shop/admin/goodsInfo.xhtml?method=editGoods&goodsId=${b.goodsId }' title='浏览'>[浏览]</a></td>
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