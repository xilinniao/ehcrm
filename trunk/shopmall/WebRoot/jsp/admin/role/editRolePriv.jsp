<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

<%@include file="/common/headB.jsp"%>
	<link type="text/css" rel="stylesheet" href="<%=path %>/resources/js/plugin/jstree/themes/default/style.css">
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jquery.loadmask.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jquery.form.js"></script>
    <script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.cookie.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jstree/jquery.jstree.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/validator/jquery.metadata.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/validator/jquery.validate.js"></script>
		
    <script type="text/javascript">
	<!--
	var saveform_validator;
	$(document).ready(function(){
		$("#msg_info").hide();
		$("#menu_tree").jstree({
			"ui" : {
				"select_limit" : 2,
				"select_multiple_modifier" : "alt",
				"selected_parent_close" : "select_parent"
			},
			"html_data" : {
				"ajax" : {
					"url" : "<%=path%>/admin/menu.do?method=getXmlTree"
				}
			},
			"plugins" : [ "themes","ui","html_data","checkbox"]
		}).bind("loaded.jstree", function(e,data) {
			<c:forEach items="${checkMenuIds}" var="b">
			<c:if test="${b.leaf}">
			$("#menu_tree").jstree("check_node","#id_${b.menuId}");
			</c:if>
			</c:forEach>
		});
		
		$('#btnSavePriv').click(function(){
			var postData = "method=onEditRolePriv&roleId=${param.roleId}";
			$("#menu_tree").find(".jstree-checked,.jstree-undetermined").each(function () {
				postData+="&chkIds="+this.id.substr(3);
			});
			$('body').mask("正在保存数据,请稍候...");
			$.ajax({
				  url: '<%=path%>/admin/role.do',
				  type: 'POST',
				  data: postData,
				  success: ajaxMaskSuccess,
				  error: ajaxError
			});
		});
	});
	//-->
	</script>
    <%@include file="/common/headC.jsp"%>
    
    <div class="box">
		<h2 class="box-header">菜单列表</h2>		
		<div class="box-content">
			<button id="btnSavePriv" class="classy"><span>保存设置</span></button>
			<div id="menu_tree" style="display: block;"></div>
		</div>
	</div>
  </body>
</html>