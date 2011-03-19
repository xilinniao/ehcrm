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
		//加载表格		
		mainTable = $('#id_mainTable').dataTable({
			"bAutoWidth" : true,
	 		"bProcessing": true,
	 		"bServerSide": true,
	 		"bSort":false,
	 		"bFilter":false,
	 		"bInfo": true,
			"oLanguage":oLanguage_cn,
			"sPaginationType": "full_numbers",
			"sAjaxSource": "<%=path%>/shop/admin/pageCategory.do?method=list",
			"fnServerData": function ( sSource, aoData, fnCallback ) {					
				$.ajax( {
					"dataType": 'json',
					"type": "POST", 
					"url": sSource,
					"data": aoData, 
					"success": fnCallback
				} );
			}
		});
	});
	
	
	//-->
	</script>

  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>首页分类</h1>
	</div>
	
	<div class="operateBar">
		<input type="button" class="addButton" onclick="location.href='pageCategory.do?method=add'" value="新增分类">
	</div>
	
	<div class="box column-center">
		<div class="box-content padding-zero " style="display: block; ">
			<table class="display stylized" id="id_mainTable">
				<thead class="table-header">
					<tr>
						<th><input type="checkbox"></th>
						<th nowrap>分类名称</th>
						<th nowrap>操作</th>
					</tr>
				</thead>							
			</table>
		</div>
    </div>
  </body>
</html>