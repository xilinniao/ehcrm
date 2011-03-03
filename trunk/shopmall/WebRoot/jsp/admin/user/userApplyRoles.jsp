<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<%@include file="/common/headA.jsp"%>
<title><%=projName %></title>

<%@include file="/common/headB.jsp"%>
	<link type="text/css" rel="stylesheet" href="<%=path %>/resources/js/plugin/jstree/themes/default/style.css">
	<link type="text/css" rel="stylesheet" href="<%=path %>/resources/js/plugin/datepicker/date_input.css">
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jquery.loadmask.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/jquery.form.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/validator/jquery.metadata.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/validator/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=path %>/resources/js/plugin/datepicker/jquery.date_input.js"></script>
	
		
    <script type="text/javascript">
	<!--
	var saveform_validator;
	$(document).ready(function(){
		$('#btnSave').click(function(){
    		$('body').mask("正在保存数据,请稍候...");
			$('#saveform').ajaxSubmit({
				success:ajaxMaskSuccess,
				error:ajaxError
			});
    	});
    	$("#msg_info").hide();
    	<c:forEach items="${checkRoleIds}" var="b">
    	$("#roleId_${b}").attr("checked",true);
    	</c:forEach>
	});
	//-->
	</script>
    <%@include file="/common/headC.jsp"%>
    
    <div class="box">
		<h2 class="box-header">权限资料</h2>		
		<div class="box-content form-table">
		<div class="notification note-info" id="msg_info"></div>	
		<div><button id="btnSave" class="classy"><span>保存</span></button></div>
		<form action="<%=path%>/admin/user.do?method=onUserApplyRoles" id="saveform" name="saveform" method="post">
			<input type="hidden" name="userId" id="userId" value="${user.userId }"/>
	  
			<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ext">
			  <tr>
			    <th class="center">选择</th>
			    <th class="center">角色</th>
			  </tr>
			  <c:forEach items="${roleList}" var="b">
			  <tr>
			    <td class="center"><input type="checkbox" name="roleId" id="roleId_${b.roleId }" value="${b.roleId }"></td>
			    <td class="left">${b.parent.roleName }->${b.roleName }</td>
			  </tr>
			  </c:forEach>
			</table>	
			</form>
		</div>
	</div>
  </body>
</html>