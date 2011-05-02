<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>
	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/list.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
	<script src="<%=path %>/resources/common/js/base.js" type="text/javascript"></script>
	<script src="<%=path %>/resources/common/js/jquery.pager.js" type="text/javascript"></script>
	<script type="text/javascript">	
		function addToPage(goodsId){
			$.ajax({
				  type: "get",
				  url: '<%=path %>/shop/admin/pageCategory.xhtml?method=onAddPageGoods&pageId=${param.pageId }&goodsId='+goodsId,
				  success: function(respText) {
				  	  if(respText=='OK'){
				  	  		$.message({type: "success", content: "添加成功!"});
				  	  }else{
				  	  		$.dialog({type: "error", content: "添加失败", width: 280, modal: true, ok:'确定'});
				  	  }
				  }
			});
		}
	</script>

  </head>
  <body class="list">
  	<div class="listBar">
		<h1><span class="icon">&nbsp;</span>商品列表&nbsp;<span class="pageInfo">总记录数: ${page.totalCount}(共${page.totalPageCount}页)</span</h1>
	</div>
	
	<div class="body">
		<form id="listForm" action="<%=path %>/shop/admin/goodsInfo.xhtml?method=goodsListForPage" method="post">
		<input type="hidden" name="pageId" value="${param.pageId }">
		<div class="operateBar">
			<label>商品名称:</label>
			<input type="text" name="goodsName" id="" class="formTextS" value="${qry.goodsName }">
			<label>商品编码:</label>
			<input type="text" name="goodsNo" id="goodsNo" class="formTextS" value="${qry.goodsNo }">
			<label>每页显示:</label>
			<select name="pageSize" id="pageSize">
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
		
		<table class="listTable" id="listTable">
				<tr>
						<th><input type="checkbox"></th>
					    <th nowrap>商品名称</th>
					    <th nowrap>商品编号</th>
					    <th nowrap>所属分类</th>
					    <th nowrap>操作</th>
				</tr>
				<c:forEach items="${page.result}" var="b">
				<tr>
					<td><input type="checkbox" class="allCheck" name="ids" value="2fe680f62eec0481012f15a0272f0114" /></td>
					<td>${b.goodsName }</td>
					<td>${b.goodNo }</td>
					<td>${b.siteCategory.categoryName }</td>
					<td nowrap><a href='###' onclick="addToPage('${b.goodsId }')" title='增加到栏目商品'>[增加]</a></td>
				</tr>
				</c:forEach>				
		</table>
		<div class="pagerBar">
			<input type="button" class="deleteButton" url="order!delete.action" value="批量添加" disabled hidefocus="true" />
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
		
		<div style="height:40px;">&nbsp;</div>
		
		</form>
    </div>
  </body>
</html>