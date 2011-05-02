<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>
	<link href="<%=path %>/resources/common/css/base.css" rel="stylesheet" type="text/css" />
	<link href="<%=path %>/resources/admin/css/input.css" rel="stylesheet" type="text/css" />
	<%@include file="/jsp/shop/common/head.jsp"%>
	<link type="text/css" rel="stylesheet" href="<%=path %>/resources/js/plugin/jstree/themes/default/style.css">
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.jstree.js"></script>
	<script src="<%=path %>/resources/common/js/base.js" type="text/javascript"></script>
    <script type="text/javascript">
	<!--
	$(document).ready(function(){
		$("#goodscat_tree").jstree({
			"ui" : {
				"select_limit" : 1,
				"select_multiple_modifier" : "alt",
				"selected_parent_close" : "select_parent"
			},
			"html_data" : {
				"ajax" : {
					"url" : "<%=path%>/shop/admin/siteCategory.xhtml?method=getXmlTree"
				}
			},
			"plugins" : [ "themes","ui","html_data"]
		}).bind("select_node.jstree", function(e, data) {
			var categoryId = $("#goodscat_tree").jstree("get_selected").attr("id").substr(3);
			var rightFrame = window.parent.window.document.getElementById("rightFrame");
			rightFrame.src="<%=path %>/shop/admin/pageCategory.xhtml?method=list&categoryId="+categoryId;
		});
	});
	
	
	//-->
	</script>

  </head>
  <body class="input">
	<!-- 
	<div class="operateBar">
		<input type="button" class="addButton" onclick="location.href='goodsInfo.xhtml?method=add'" value="新增商品">
		<input type="button" class="addButton" id="getProductByCategory" value="京东商品">
	</div>
	 -->
	 
	<div class="box">
		<h2 class="box-header">商品分类列表</h2>
		<div class="box-content" id="goodscat_tree" style="display: block;"></div>
	</div>
  </body>
</html>