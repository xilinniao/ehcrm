<%@ page contentType="text/html; charset=utf-8"%>
<%@include file="/common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=path %>/resources/css/default.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
}
.error {
padding:8px 10px 8px 50px;
}
-->
</style>
<script  language="JavaScript">    
<!--    
javascript:window.history.forward(1);    
//-->    
</script>  

<title><%=projName %></title>
<script type="text/javascript">
    if(self != top){
	   top.location = this.location;
	}
    function loginOk(){
		if(document.loginForm.userCode.value==''){
			alert('请输入用户名');
			return;
		}
		if(document.loginForm.password.value==''){
			alert('请输入密码');
			return;
		}
       document.loginForm.submit();
    }
    function setNextFocus(obj){
        if(event.keyCode==13){ 
            obj.focus();
        }
    }
</script>
</head>

<body background="<%=path %>/resources/images/sys/login_bg.jpg" style="background-repeat:no-repeat;background-position:top">
<table width="776" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="120"><br /></td>
  </tr>
</table>
<table width="776" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="226"><img src="<%=path %>/resources/images/sys/login_left_pic.jpg" width="226" height="285" /></td>
    <td valign="top" background="<%=path %>/resources/images/sys/login_center.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="57"><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td class="black-15pt" style="text-align:left;">欢迎进入<%=projName %></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td height="225">
          <form action="<%=path %>/admin/login.xhtml" name="loginForm" method="post">
          <input type="hidden" name="method" value="login"/>
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="150"><table width="70%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="20%" height="37">用户名：</td>
                  <td style="text-align:left;"><input type="text" name="userCode" class="textbox" style="width:200px;height:17px;" onkeypress="setNextFocus(loginForm.password);"/></td>
                  <td width="20%">&nbsp;</td>
                </tr>
                <tr>
                  <td height="37">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                  <td style="text-align:left;"><input type="password" name="password" class="textbox" style="width:200px;height:17px;" onkeypress="setNextFocus(loginForm.loginIn);"/></td>
                  <td>&nbsp;</td>
                </tr>
                <!-- 
                <tr>
                  <td height="37">验证码：</td>
                  <td style="text-align:left;">
                  	<input type="text" name="verifyCode" id="verifyCode" class="textbox" style="width:50px;height:17px;" desc="验证码" allowEmpty="false" maxLen="4" minLen="4" onkeypress="setNextFocus(loginForm.Submit);" />
                  </td>
                  <td>&nbsp;</td>
                </tr>
                -->                
                <tr>
                  <td height="45">&nbsp;</td>
                  <td style="text-align:left;">
				  <c:if test="${error!=null}">
				  <div class="error">${error }</div>
				  </c:if>
				  <input name="loginIn" type="button" class="button" value="登 录" onclick="loginOk();" /></td>
                  <td>&nbsp;</td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="50" align="right" valign="bottom"></td>
            </tr>            
          </table>
          </form>
        </td>
      </tr>
    </table></td>
    <td width="29"><img src="<%=path %>/resources/images/sys/login_right.gif" width="29" height="285" /></td>
  </tr>
</table>
<table width="776" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="232" height="25">&nbsp;</td>
  </tr>
  <tr>
    <td align="center"></td>
  </tr>
</table>

</body>
</html>