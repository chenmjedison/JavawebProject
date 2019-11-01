<%@ page language="java" import="java.util.*" pageEncoding="utf-8" import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    
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
  <h1>你客户端发送的http请求头包含信息如下</h1>
  <%
  Enumeration<String> headers=request.getHeaderNames();
  while(headers.hasMoreElements()){
  String headerName=headers.nextElement();
  String headerValue=request.getHeader(headerName);
   %>
   <b><%=headerName %></b>:<%=headerValue %><br/>
   <%
   }
   %>
    This is my JSP page. <br>
  </body>
</html>
