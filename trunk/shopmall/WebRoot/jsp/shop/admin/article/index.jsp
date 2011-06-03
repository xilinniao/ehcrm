<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>
	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/list.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
	<script src="<%=path %>/resources/common/js/base.js" type="text/javascript"></script>
    <script type="text/javascript">
	<!--
	$(document).ready(function(){
	});
	//-->
	</script>

  </head>
  <body class="list">
	<div class="listBar">
		<h1><span class="icon">&nbsp;</span>文章内容管理&nbsp;<span class="pageInfo">总记录数: ${page.totalCount}(共${page.totalPageCount}页)</span></h1>
	</div>

	<div class="body">
		<form id="listForm" action="<%=path%>/shop/admin/article.xhtml?method=index" method="post">
		<div class="operateBar">
			<label>分类名称:</label>
			<input type="text" name="name" class="formText" value="${qry.name }">
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
			<input type="button" id="searchButton" class="addButton" value="查 询"><input type="button" class="addButton" onclick="location.href='article.xhtml?method=add'" value="新增文章">
		</div>
		
	
		<table class="listTable" id="listTable">
				<tr>
						<th nowrap>所属分类</th>
						<th nowrap>标题</th>
						<th nowrap>是否发布</th>
						<th nowrap>是否推荐</th>
						<th nowrap>是否置顶</th>
						<th nowrap>排序号</th>
						<th nowrap>操作</th>
				</tr>
				<c:forEach items="${page.result}" var="b">
				<tr>
					<td>${b.category.categoryName }</td>
					<td>${b.title }</td>
					<td>${b.isPublic }</td>
					<td>${b.isRecommend }</td>
					<td>${b.isTop }</td>
					<td>${b.orderNum }</td>
					<td><a href='article.xhtml?method=edit&articleId=${b.articleId }' title='编辑'>[编辑]</a>&nbsp;</td>
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