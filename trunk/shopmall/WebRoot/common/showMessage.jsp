<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/jsp/include/head.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><%=projectName%></title>
		<LINK href="<%=path %>/resources/css/page.css" type="text/css" rel="stylesheet">
	</head>
	<body>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20">&nbsp;</td>
  </tr>
</table>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="10" height="24"><img src="<%=path%>/resources/images/index_frame_bluetop_left.gif" width="10" height="27" /></td>
        <td background="<%=path%>/resources/images/index_frame_bluetop_center.gif">&nbsp;</td>
        <td width="35"><img src="<%=path%>/resources/images/index_frame_bluetop_right.gif" width="35" height="27" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="1" bgcolor="#4489E4"></td>
        <td bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr class="title_blue_bg">
              <td height="22" style="background-position:right;background-repeat:no-repeat;">&nbsp;<img src="<%=path%>/resources/images/icon-.jpg" width="11" height="11" hspace="10" />提示信息<span class="blue-9pt"><strong></strong></span></td>
              <td width="1"></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td></td>
            </tr>
            <tr>
              <td>
			<table width="95%" border="0" align="center" cellpadding="5" cellspacing="1" bgcolor="#CCCCCC" class="x-panel-mc">
				<tr>
					<td nowrap="nowrap" class="x-table-body-center" style="height:100px;">${msg}</td>
					</tr>
			</table>
              </td>
              <td width="1"></td>
            </tr>
        </table></td>
        <td width="1" bgcolor="#4489E4"></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="37"><img src="<%=path%>/resources/images/index_frame_bluefoot_left.gif" width="37" height="31" /></td>
        <td background="<%=path%>/resources/images/index_frame_bluefoot_center.gif">&nbsp;</td>
        <td width="9"><img src="<%=path%>/resources/images/index_frame_bluefoot_right.gif" width="9" height="31" /></td>
      </tr>
    </table></td>
  </tr>
</table>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20">&nbsp;</td>
  </tr>
</table>
	</body>
</html>