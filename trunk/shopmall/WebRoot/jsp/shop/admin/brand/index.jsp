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
			"sAjaxSource": "<%=path%>/shop/admin/brandInfo.xhtml?method=list",
			"fnServerData": function ( sSource, aoData, fnCallback ) {
				aoData.push( { 
					"name":"name",
					"value":$("#name").val()
					});		
				$.ajax( {
					"dataType": 'json',
					"type": "POST", 
					"url": sSource,
					"data": aoData, 
					"success": fnCallback
				} );
			}
		});
		
		//处理查询
		$('#btnSearchSubmit').click(function(){
			mainTable.fnDraw();
		});
	});
	
	
	//-->
	</script>

  </head>
  <body class="input">
  	<div class="inputBar">
		<h1><span class="icon">&nbsp;</span>商品管理</h1>
	</div>
	
	<div class="operateBar">
		<input type="button" class="addButton" onclick="location.href='brandInfo.xhtml?method=add'" value="新增品牌">
	</div>
	
	<div class="box column-center">
		<div class="box-content padding-zero " style="display: block; ">
			<table border="0" cellspacing="0" cellpadding="0" class="inputTable tabContent" style="display: table;">
				  <tbody>	
				  <tr>
				    <th>品牌名称</th>
					<td><input type="text" id="name" class="formText" name="name" size="15">
					&nbsp;
					<input type="button" class="formButtonSubmit" id="btnSearchSubmit" value="查 询" hidefocus="true"/></td>
				  </tr>
				  </tbody>
			</table>
			<table class="display stylized" id="id_mainTable">
				<thead class="table-header">
					<tr>
							<th><input type="checkbox"></th>
						    <th nowrap>品牌名称</th>
						    <th nowrap>网址</th>
						    <th nowrap>排序</th>
						    <th nowrap>操作</th>
					</tr>
				</thead>							
			</table>
		</div>
    </div>
  </body>
</html>