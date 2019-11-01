<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>使用out对象输出变色表格</title>
    
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
  <table width="50%" align="center">
  <% int i=0;
  while (i<10)
  {
  i++;
  if(i%2==0){
  out.println("<tr bgcolor=\"#00ff00\">");
  }
  else
  {
  out.println("<tr bgcolor=\"#0000ff\">");
  }
  out.println("<td>当前行数："+i+"</td>");
  out.println("</tr>");
  }
  
  %>
  
  
  </table>
    This is my JSP page. <br>
  </body>
</html>
