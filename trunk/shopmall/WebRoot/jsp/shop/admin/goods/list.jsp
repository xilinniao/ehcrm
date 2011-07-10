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
	<script type="text/javascript">
		$(document).ready(function(){
			$('#treeNo').val('${qry.treeNo}');
		});
	</script>
  </head>
  <body class="list">
  	<div class="listBar">
		<h1><span class="icon">&nbsp;</span>商品列表&nbsp;<span class="pageInfo">总记录数: ${page.totalCount}(共${page.totalPageCount}页)</span</h1>
	</div>
	

	
	<div class="body">
		<form id="listForm" action="<%=path %>/shop/admin/goodsInfo.xhtml?method=goodsList" method="post">
		<div class="operateBar">
			<label>商品分类</label>
			
			<select name="treeNo" id="treeNo" class="formSelect">
				<c:forEach items="${goodsCategoryList}" var="b">
				<option value="${b.treeNo}">${b.categoryNameFormate}</option>
				</c:forEach>
			</select>			
			
			<label>商品名称:</label>
			<input type="text" name="goodsName" id="goodsName" class="formTextS" value="${qry.goodsName }">
			<label>每页显示:</label>
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
			<input type="button" id="searchButton" class="formButton" value="查询">
			<input type="button" class="formButton" onclick="location.href='goodsInfo.xhtml?method=add'" value="新增商品">
		</div>
	
		<table class="listTable">
				<tr>
					    <th nowrap>商品名称</th>
					    <th nowrap>商品编号</th>
					    <th nowrap>所属分类</th>
					    <th nowrap>市场价</th>
					    <th nowrap>商城价</th>
					    <th nowrap>操作</th>
				</tr>
				<c:forEach items="${page.result}" var="b">
				<tr>
					<td>${b.goodsName }</td>
					<td>${b.goodNo }</td>
					<td>${b.category.categoryName }</td>
					<td>${b.marketPrice }</td>
					<td>${b.discountPrice }</td>
					<td><a href='<%=path %>/shop/admin/goodsInfo.xhtml?method=editGoods&goodsId=${b.goodsId }' title='编辑'>[编辑]</a>&nbsp;<a href='<%=path %>/product/${b.goodsId}.html' target="_blank" title='浏览'>[浏览]</a></td>
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