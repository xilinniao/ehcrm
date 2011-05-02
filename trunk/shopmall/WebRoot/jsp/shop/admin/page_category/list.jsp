<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>
	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/list.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
	<script src="<%=path %>/resources/common/js/base.js" type="text/javascript"></script>
	<script src="<%=path %>/resources/common/js/jquery.pager.js" type="text/javascript"></script>

  </head>
  <body class="list">
  	<div class="listBar">
		<h1><span class="icon">&nbsp;</span>${siteCategory.categoryName }栏目设置&nbsp;<span class="pageInfo">总记录数: ${page.totalCount}(共${page.totalPageCount}页)</span></h1>
	</div>
	

	
	<div class="body">
		<form id="listForm" action="<%=path %><%=path%>/shop/admin/pageCategory.xhtml?method=list" method="post">
		<input type="hidden" name="categoryId" value="${param.categoryId }" />
		<div class="operateBar">
			<input type="button" class="addButton" onclick="location.href='pageCategory.xhtml?method=add&siteCategoryId=${param.categoryId }'" value="新增区块">		
		</div>
	
		<table class="listTable" id="listTable">
				<tr>
						<th><input type="checkbox"></th>
							<th nowrap>栏目名称</th>						    
						    <th nowrap>显示数量</th>
						    <th nowrap>商品数量</th>
						    <th nowrap>是否显示</th>
						    <th nowrap>排序号</th>
						    <th nowrap>操作</th>
				</tr>
				<c:forEach items="${page.result}" var="b">
				<tr>
					<td><input type="checkbox" name="ids" value="2fe680f62eec0481012f15a0272f0114" /></td>
					<td>${b.categoryName }</td>
					<td>${b.showNum }</td>
					<td>${b.goodsCnt }</td>
					<td>${b.isShow }</td>
					<td>${b.orderNum }</td>
					<td>
					<a href='pageCategory.xhtml?method=edit&categoryId=${b.categoryId }' title='编辑'>[编辑]</a>&nbsp;
					<a href='pageCategory.xhtml?method=pageGoodsList&pageId=${b.categoryId }&categoryId=${param.categoryId }' target="rightBottomFrame" title='商品列表'>[商品列表]</a>&nbsp;
					
					</td>
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