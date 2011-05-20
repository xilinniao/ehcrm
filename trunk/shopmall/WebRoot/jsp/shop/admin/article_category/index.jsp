<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>
	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css">
	<link href="<%=path %>/resources/admin/css/datatables.css" rel="stylesheet" type="text/css">
	<%@include file="/jsp/shop/common/head.jsp"%>
	<script src="<%=path %>/resources/common/js/base.js" type="text/javascript"></script>
    <script type="text/javascript">
	<!--
	var saveform_validator;
	var mainTable;
	$(document).ready(function(){
		
	});	
	//-->
	</script>

  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>文章分类管理</h1>
	</div>
	
	<div class="operateBar">
		<input type="button" class="addButton" onclick="location.href='articleCategory.xhtml?method=add'" value="新增分类">
	</div>
	
	<div class="box column-center">
		<div class="box-content padding-zero " style="display: block; ">
			<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
				  <tbody>	
				  <tr>
				    <th>分类名称</th>
					<td><input type="text" id="categoryName" class="formText" name="categoryName" size="15">
					&nbsp;
					<input type="button" class="formButtonSubmit" id="btnSearchSubmit" value="查 询" hidefocus="true"/></td>
				  </tr>
				  </tbody>
			</table>
			<table class="display stylized" id="id_mainTable">
				<thead class="table-header">
					<tr>
						<th><input type="checkbox"></th>
						<th nowrap>分类名称</th>
						<th nowrap>排序号</th>
						<th nowrap>操作</th>
					</tr>
				</thead>							
			</table>
		</div>
    </div>
  </body>
</html>