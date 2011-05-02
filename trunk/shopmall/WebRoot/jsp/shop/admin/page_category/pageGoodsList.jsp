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
		$().ready( function() {
			$('#add_page_goods').click(function(){
			$.colorbox({
					href:'<%=path%>/shop/admin/goodsInfo.xhtml?method=goodsListForPage&pageId=${param.pageId}&categoryId=${param.categoryId}',
					iframe:true,
					width:"600",
					height:"100%"
				});
	    	});
		})
	</script>
  </head>
  <body class="list">
	
	<div class="body">
		<form id="listForm" action="<%=path %><%=path%>/shop/admin/pageCategory.xhtml?method=pageGoodsList" method="post">
		<input type="hidden" name="categoryId" value="${param.categoryId }" />
		<div class="operateBar">
			<input type="button" class="addButton" id="add_page_goods" value="增加商品">		
		</div>
	
		<table class="listTable" id="listTable">
				<tr>
						<th><input type="checkbox"></th>
							<th nowrap>商品名称</th>						    
						    <th nowrap>所属店铺</th>
						    <th nowrap>操作</th>
				</tr>
				<c:forEach items="${goodsList}" var="b">
				<tr>
					<td><input type="checkbox" name="ids" value="2fe680f62eec0481012f15a0272f0114" /></td>
					<td>${b.goodsName }</td>
					<td>${b.shopInfo.shopName }</td>
					<td>
						<a href='pageCategory.xhtml?method=edit&recId=${b.goodsId  }' title='编辑'>[上移]</a>&nbsp;
						<a href='pageCategory.xhtml?method=edit&recId=${b.goodsId  }' title='从该分类中移除'>[删除]</a>
					</td>
				</tr>
				</c:forEach>				
		</table>
		</form>
    </div>
  </body>
</html>