<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/meta.jsp"%>
<title>错误信息</title>
<LINK href="<%=path %>/resources/css/defalut.css" type="text/css" rel="stylesheet">
</head>
<body>
<%
Exception exception = (Exception) request.getAttribute("exception");
exception.printStackTrace();
%>

<table width="100%" height="500">
<tr><td style="vertical-align:middle;">

  <table width="70%" align="center" border="0" cellspacing="0" cellpadding="0"  class="x-panel-mc ">
    <tr>
      <td class="x-panel-header">异常提示</td>
    </tr>
    <tr>
      <td class="x-table-body" style="text-align:left;padding:10px 0px 10px 0px;"><%=exception.getMessage()%>
      <%
      exception.printStackTrace(new java.io.PrintWriter(out));
       %>
      </td>
    </tr>
  </table>

  </td></tr>
</table>
</body>
</html>