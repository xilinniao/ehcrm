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
		<h1><span class="icon">&nbsp;</span>团购信息维护&nbsp;<span class="pageInfo">总记录数: ${page.totalCount}(共${page.totalPageCount} 页)</span></h1>
	</div>

	<div class="body">
		<form id="listForm" action="tuanInfo.xhtml?method=index" method="post">
		<div class="operateBar">
			<label>团购标题:</label><input type="text" name="topicName" class="formText" value="${qry.topicName}"}">
			
			<label>审批状态:</label>
			<select name="applyStatus" id="applyStatus">
				<option value="">
					全部
				</option>
				<option value="0">
					保存未提交
				</option>
				<option value="1">
					待审批
				</option>
				<option value="20">
					审批不通过
				</option>
				<option value="21">
					审批通过
				</option>
			</select>
						
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
			<input type="button" id="searchButton" class="addButton" value="查询">
		</div>
		
	
		<table class="listTable" id="listTable">
				<tr>
					<th nowrap>申请店铺</th>
					<th nowrap>团购标题</th>
					<th nowrap>发布状态</th>
					<th nowrap>团购开始日期</th>
					<th nowrap>团购结束日期</th>
					<th nowrap>市场价</th>
					<th nowrap>团购价</th>
					<th nowrap>最大团购量</th>							
					<th nowrap>创建时间</th>
					<th nowrap>操作</th>
				</tr>
				<c:forEach items="${page.result}" var="b">
				<tr>
					<td>${b.shopInfo.shopName}</td>
					<td>${b.topicName}</td>
					<td>${b.isPublishStr}</td>
					<td>${b.beginDateStr}</td>
					<td>${b.endDateStr}</td>
					<td>${b.priceStr}</td>
					<td>${b.discountPriceStr}</td>
					<td>${b.maxQty}</td>
					<td>${b.createTimeStr}</td>
					<td><a href='tuanInfo.xhtml?method=edit&tuanId=${b.tuanId}' title='编辑'>[编辑]</a>&nbsp;</td>
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