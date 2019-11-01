<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>使用response对象设置响应的状态码</title>
    
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
  <h2>状态选择器</h2>
    <ul>
    <li><a href="status200.jsp">OK状态</a></li>
    <li><a href="status404.jsp">请求的资源不存在</a></li>
    <li><a href="status408.jsp">请求超时</a></li>
    <li><a href="status500.jsp">内部服务器错误</a></li>
    </ul>
  </body>
</html>
