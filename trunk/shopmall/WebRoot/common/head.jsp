<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="/WEB-INF/tld/c.tld" prefix="c" %>
<%@ page import="com.eh.base.util.Constants" %>
<%
String path = request.getContextPath();
if("/".equals(path)){
    path = "";
}
String projName = "抚州直销商城";
String homeUrl = path.equals("")?"/":path ;
%>