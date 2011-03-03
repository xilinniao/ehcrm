<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<script>
   try{
	parent.document.getElementById('bankNetId').value= "${deptInfo.deptId}";//机构ID
	}
	catch(e)
	{
	}
	try{
	parent.document.getElementById('bankNet').value= "${deptInfo.deptCode}";//机构
	}
	catch(e)
	{
	}
	try{
	parent.document.getElementById('bankNetName').value= "${deptInfo.deptName}";//机构名称
	}
	catch(e)
	{
	}
</script>