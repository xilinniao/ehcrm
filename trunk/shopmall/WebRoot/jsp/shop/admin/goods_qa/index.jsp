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
		<h1><span class="icon">&nbsp;</span>客户咨询&nbsp;<span class="pageInfo">总记录数: ${page.totalCount}(共${page.totalPageCount} 页)</span></h1>
	</div>

	<div class="body">
		<form id="listForm" action="goodsQa.xhtml?method=index" method="post">
		<div class="operateBar">
						
			<label>每页显示</label>
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
			<input type="button" id="searchButton" class="formButton" value="查询">
		</div>
		
	
		<table class="listTable" id="listTable">
				<tr>
							<th nowrap>客户登录名</th>
							<th nowrap>咨询商品</th>
							<th nowrap>是否发布</th>
							<th nowrap>咨询内容</th>
							<th nowrap>店铺回答</th>
							<th nowrap>提问时间</th>
							<th nowrap>回答时间</th>
						<th nowrap>操作</th>
				</tr>
				<c:forEach items="${page.result}" var="b">
				<tr>				
						<td>${b.custInfo.custCode}</td>
						<td>${b.goods.goodsName}</td>
						<td>${b.isPublish}</td>
						<td>${b.question}</td>
						<td>${b.answer}</td>
						<td>${b.createTime}</td>
						<td>${b.answerTime}</td>
					<td><a href='goodsQa.xhtml?method=edit&recId=${b.recId}' title='回复该客户'>[回复]</a>&nbsp;</td>
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