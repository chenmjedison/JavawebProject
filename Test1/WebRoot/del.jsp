<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="book" class="bean.Book"/>
<jsp:setProperty name="book" property="id"/>
<%
	int result=book.delBook();
	String msg="删除失败，单击确定跳转到图书列表页！";
	if(result==1)
	{
	msg="删除成功，单击确定跳转到图书列表页！";
	}
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'del.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script>window.alert('<%=msg %>');</script>
<%
	response.setHeader("Refresh", "1;url=index.jsp");
 %>
  </head>
  
  <body>
<br>
  </body>
</html>
