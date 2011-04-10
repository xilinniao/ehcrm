<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@include file="/common/meta.jsp"%>
    <title><%=projName %></title>
	<style>
		a{TEXT-DECORATION:none}
		a:link{color:#0066FF}   
		a:visited{color:#0066FF}   
		a:active{color:#0066FF}   
		A.MzTreeview
		{
		  font-size: 9pt;
		  padding-left: 3px;
		}
		#Layer1 {
			position:relative;
			left:0px;
			top:0px;
			width:100%;
			height:100%;
			z-index:1;
		}
		#Layer2 {
			position:relative;
			left:0px;
			top:0px;
			width:100%;
			height:100%;
			z-index:1;
		}
	</style>
	<script language="JavaScript" src="<%=path%>/resources/js/MzTreeView10.js"></script>
	<script language="JavaScript"><!--
function onClick(id,code,name){ 
	var parent = window.opener;
	try{
	parent.xhtmlcument.getElementById('bankNetId').value= id;//机构ID
	}
	catch(e)
	{
	}
	try{
	parent.xhtmlcument.getElementById('bankNet').value= code;//机构
	}
	catch(e)
	{
	}
	try{
	parent.xhtmlcument.getElementById('bankNetName').value= name;//机构名称
	}
	catch(e)
	{
	}
 	window.close();
  }
		
		var tree = new MzTreeView("tree");
		tree.icons["property"] = "property.gif";
		tree.icons["css"] = "collection.gif";
		tree.icons["book"]  = "book.gif";
		tree.iconsExpand["book"] = "bookopen.gif";
		tree.setIconPath("<%=path%>/resources/images/tree/");
		
		<c:forEach items="${deptList}" var="b" varStatus="myVar">
		<c:if test="${myVar.index == 0}">
		tree.nodes['0_${b.deptId}'] = 'text:${b.deptName};method:onClick("${b.deptId}","${b.deptCode}","${b.deptName}")';
		</c:if>
		<c:if test="${myVar.index != 0}">
		tree.nodes['${b.parent.deptId}_${b.deptId}'] = 'text:${b.deptName};method:onClick("${b.deptId}","${b.deptCode}","${b.deptName}")';
		</c:if>
		</c:forEach>
		
		tree.setURL("#");
		tree.setTarget("Frame"); 
		
	--></script>
 </head>
  <body bgcolor="#FCFCFC" margin="10px;">
  <script language="javascript">document.write(tree.toString());</script>
  </body>
</html>