<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��¼ҳ��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="login.action" method="post">
    <table align="center">
    <tr><td>�û�����</td>
    <td><input type="text" name="username"/></td></tr>
     <tr><td>���룺</td>
    <td><input type="password" name="password"/></td></tr>
    <tr><td colspan="2" align="center">
    <input type="submit" value="��¼"/>
    <input type="reset" value="����"/></td></tr>
    </table>
    </form>
  </body>
</html>
