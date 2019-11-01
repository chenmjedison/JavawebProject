<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <base href="<%=basePath%>">
    
    <title>图书管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet"  href="CSS/styles.css">
	<style type="text/css">
	td{align:center;}
	</style>
	
  </head>
  
  <body background="img/timg (1).jpg">
	  <h2 align="center">图书管理系统</h2>
	  <p align="center"><a href="add.html">添加图书信息</a><p>
	  <jsp:useBean id="book" class="bean.Book" />
	  <table align ="center" width="50%">
		  <tr><th>书名</th><th>作者</th><th>出版社</th><th>价格</th><th>管理</th></tr>
		   <%
		   ArrayList books =(ArrayList)book.getAllbooks();
		   for(Object o:books){
		   Map m=(HashMap)o;
		    %>
		  <tr>
			  <td><%=m.get("bookname") %></td>
			  <td><%=m.get("author") %></td>
			  <td><%=m.get("press") %></td>
			  <td><%=m.get("price") %></td>
			  <td><a href="edit.jsp?id=<%=m.get("id")%>">修改</a>&nbsp;
				  <a href="del.jsp?id=<%=m.get("id")%>" onclick="return confirm('确定要删除吗？')">删除</a>
			  </td>
		  </tr>
		  <%
		  } 
		  %>
	   </table>
     <br>
  </body>
</html>
