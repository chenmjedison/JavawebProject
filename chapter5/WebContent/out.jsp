<%@ page language="java" import="java.util.*" pageEncoding="utf-8" buffer="2kb" autoFlush="false"%>
<%
out.println("你好！");
out.clear();
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>使用out对象输出数据并操作缓冲区</title>
    
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
  <%
  out.println("再次说你好！"+"<br/>");
  out.println("out对象的缓冲区大小为："+out.getBufferSize()+"字节<br/>");
  out.println("缓冲区剩余大小为："+out.getRemaining()+"字节<br/>");
  out.flush();
  for(int i=0;i<2000;i++)
  {
  out.print("A");
  }
  out.println("<br/>"+out.isAutoFlush());
  %>
   <br>
  </body>
</html>
