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
		<h1><span class="icon">&nbsp;</span>客户评论&nbsp;<span class="pageInfo">总记录数: ${page.totalCount}(共${page.totalPageCount} 页)</span></h1>
	</div>

	<div class="body">
		<form id="listForm" action="goodsRemark.xhtml?method=index" method="post">
		<div class="operateBar">
							<label>客户名称</label><input type="text" name="custName" class="formText" value="${qry.custName}"}">
							<label>所属商品</label><input type="text" name="goodsId" class="formText" value="${qry.goodsId}"}">
						
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
			<input type="button" id="searchButton" class="searchButton" value="">&nbsp;
			<input type="button" class="addButton" onclick="location.href='goodsRemark.xhtml?method=add'" value="新增客户评论">
		</div>
		
	
		<table class="listTable" id="listTable">
				<tr>
							<th nowrap></th>
							<th nowrap>客户编号</th>
							<th nowrap>客户名称</th>
							<th nowrap>所属商品</th>
							<th nowrap>客户评价</th>
							<th nowrap>描述相符得分</th>
							<th nowrap>服务相符得分</th>
							<th nowrap>发货速度得分</th>
							<th nowrap>评论时间</th>
						<th nowrap>操作</th>
				</tr>
				<c:forEach items="${page.result}" var="b">
				<tr>
						<td>${b.recId}</td>
						<td>${b.custId}</td>
						<td>${b.custName}</td>
						<td>${b.goodsId}</td>
						<td>${b.content}</td>
						<td>${b.descSocre}</td>
						<td>${b.serviceScore}</td>
						<td>${b.speedScore}</td>
						<td>${b.createTime}</td>
					<td><a href='goodsRemark.xhtml?method=edit&recId=${b.recId}' title='编辑'>[编辑]</a>&nbsp;</td>
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
			<input type="hidden" name="pageNo" id="pageNo" value=" ${page.pageNo}" />
		</div>
		</form>
    </div>

  </body>
</html>