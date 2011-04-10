<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@include file="/common/meta.jsp"%>
    <title><%=projName %></title>
    <LINK rel="stylesheet" href="<%=path %>/resources/css/default.css" type="text/css">     
    <SCRIPT type="text/javascript" src="<%=path %>/resources/js/page.js"></SCRIPT>
    <SCRIPT type="text/javascript" src="<%=path %>/resources/js/jdmenu/jquery.js"></SCRIPT>
    <SCRIPT type="text/javascript" src="<%=path %>/resources/js/common.js"></SCRIPT>
    <SCRIPT type="text/javascript" src="<%=path %>/resources/js/popcalendar.js"></SCRIPT>
    <script>
    
	function init()
	{
		$("#edu").val("${entity.edu}");
	}
	window.attachEvent("onload",init);
    </script>
 </head>
  
  <body>
  <div id="nav">后台管理-&gt;人员管理-&gt;查看人员</div>
  <form action="<%=path%>/admin/user.xhtml?method=saveUser" id="saveform" name="saveform" method="post">
  <input type="hidden" name="userId" id="userId" value="${entity.userId}" />
  <table width="76%" border="0" cellspacing="0" cellpadding="0" class="ext">
  <tr>
    <th colspan="5" class="header-l">查看人员信息</th>
  </tr>

<tr>
    <td class="body-r" width="8%">姓 名</td>
	<td class="body-l" width="20%">${entity.userName}</td>
	<td class="body-r" width="8%">性 别</td>
	<td class="body-l" width="20%"><c:if test="${entity.sex!=1}">男</c:if> &nbsp; <c:if test="${entity.sex==1}">女</c:if> &nbsp;</td>
	<td width="20%" rowspan="8" class="body-c"></td>	
	</tr> 
 <tr>   
	<td class="body-r" >登录帐号</td>
	<td class="body-l" >${entity.userCode}</td>
	<td class="body-r" >登录密码</td>
	<td class="body-l" >********</td>	
  </tr> 
  
  <tr>
    <td class="body-r" >出生日期</td>
	<td class="body-l" >	
	${entity.birthday}	
	</td>
    <td class="body-r" >年 龄</td>
	<td class="body-l" >${entity.age}</td>
    </tr>
  <tr>
    <td class="body-r" >民 族</td>
	<td class="body-l" >${entity.nation}</td>
    <td class="body-r" >籍 贯</td>
	<td class="body-l" >${entity.birthPlace}</td>	
	</tr>
  <tr>
    <td class="body-r" >党 派</td>
	<td class="body-l" >${entity.faction}</td>
	<td class="body-r" >宗 教</td>
	<td class="body-l" >${entity.religion}</td>
	</tr>
  <tr>	
	<td class="body-r" >政治面貌</td>
	<td class="body-l" >${entity.political}</td>
	<td class="body-r" >类 别</td>
	<td class="body-l" >${entity.category}</td>
	</tr>
  <tr>    
    <td class="body-r" >学 历</td>
	<td class="body-l" >
	<select name="edu" id="edu" disabled=disabled>	
	<option value="3">大学</option>
	<option value="0">初中以下</option>
	<option value="1">初中</option>
	<option value="2">高中</option>
	<option value="4">硕士</option>
	<option value="5">博士</option>
	</select>
	</td>
	<td class="body-r" >专 业</td>
	<td class="body-l" >${entity.profession}</td>
	</tr>
  <tr>
    <td class="body-r" >工作单位</td>
	<td class="body-l" >${entity.workplace}</td>
	<td class="body-r" >职 务</td>
	<td class="body-l" >${entity.job}</td>
	</tr>
  
  <tr>    
	<td class="body-r" >所属组号1</td>
	<td class="body-l" colspan="4">
	${entity.group1}
	&nbsp;&nbsp;
	所属组号2
	${entity.group2}
	<input type="checkbox" name="commiFlag" value="1" <c:if test="${entity.commiFlag==1}">checked</c:if> disabled="disabled">委员 &nbsp;&nbsp;
	<input type="checkbox" name="standCommiFlag" value="1"  <c:if test="${entity.standCommiFlag==1}">checked</c:if> disabled="disabled">常委 &nbsp;&nbsp;
	</td>
  </tr>
  <tr>    	
	<td class="body-r" >所在代表团</td>
	<td class="body-l" colspan="4">
	${entity.delegation}
	&nbsp;&nbsp;
	<input type="checkbox" name="headFlag" value="1"  <c:if test="${entity.headFlag==1}">checked</c:if> disabled="disabled">团长 &nbsp;&nbsp;
    <input type="checkbox" name="secHandFlag" value="1"  <c:if test="${entity.secHandFlag==1}">checked</c:if> disabled="disabled">副团长 &nbsp;&nbsp;
    <input type="checkbox" name="chairFlag"  value="1" <c:if test="${entity.chairFlag==1}">checked</c:if> disabled="disabled">主席团成员 &nbsp;&nbsp;
	</td>	
  </tr> 
  <tr>
    <td class="body-r" >证 号</td>
	<td class="body-l" colspan="4">
	${entity.cardNo}
	&nbsp;&nbsp;
	<input type="checkbox" name="lxrrFlag" value="1" <c:if test="${entity.lxrrFlag==1}">checked</c:if> disabled="disabled">列席人员 &nbsp;&nbsp;
	<input type="checkbox" name="swlxrrFlag" value="1" <c:if test="${entity.swlxrrFlag==1}">checked</c:if> disabled="disabled">常委列席人员 &nbsp;&nbsp;     
	</td>
   </tr>    
  <tr>
    <td class="body-r" >单位地址</td>
	<td class="body-l" colspan="2">${entity.wrokAddr}</td>
	<td class="body-r" >单位邮编</td>
	<td class="body-l" >${entity.workPostCode}</td>	
  </tr>
  <tr>
    <td class="body-r" >家庭地址</td>
	<td class="body-l" colspan="2">${entity.homeAddr}</td>
	<td class="body-r" >家庭邮编</td>
	<td class="body-l" >${entity.homePostCode}</td>	
  </tr>
  <tr>
    <td class="body-r" >单位电话</td>
	<td class="body-l" >${entity.workTel}</td>
	<td class="body-r" >email</td>
	<td class="body-l" >${entity.email}</td>
	<td class="body-r" >&nbsp;</td>
  </tr>
  <tr>
    <td class="body-r" >家庭电话</td>
	<td class="body-l" >${entity.homeTel}</td>
    <td class="body-r" >手 机</td>
	<td class="body-l" >${entity.mobile}</td>	
	<td class="body-r" >&nbsp;</td>	
  </tr>  
  <tr>
    <td class="body-r" >所在机构部门</td>
	<td class="body-l" colspan="4"> 
	<input type="hidden" id="bankNetId" name="bankNetId" value="${rel.deptInfo.deptId}"/>				
	${rel.deptInfo.deptCode}
	${rel.deptInfo.deptName}
	&nbsp;&nbsp;    
	所属角色
	<input type="hidden" name="roleId" value="${rel.roleInfo.roleId}">
	${rel.roleInfo.roleName}
	
	</td>
  </tr>   
  <tr>
    <td class="body-r" >备 注</td>
	<td class="body-l" colspan="4">
	<textarea rows="5" cols="80" name="notes" disabled="disabled">${entity.notes}</textarea>
	</td>
  </tr>
  <tr>
    <td colspan="5" class="body-c"><button class="buttons" onClick="window.close();">关 闭</button></td>
  </tr>
</table>
</form>
  </body>
</html>
