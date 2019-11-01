<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>图书管理系统</title>
<link rel="stylesheet" href="CSS/styles.css" type="text/css">
<script type="text/javascript" src="JavaScript/book.js"></script>
</head>
<body>
		<h2 align="center">图书管理系统</h2>
		<p align="center"><a href="add.html">添加图书信息</a><p>
		<table align ="center" width="50%" border="1px">
		  <tr><th>书名</th><th>作者</th><th>出版社</th><th>价格</th><th>管理</th></tr>
		   <%
		   ArrayList books =(ArrayList)request.getAttribute("books");
		   for(Object o:books){
		   Map m=(HashMap)o;
		    %>
		  <tr>
			  <td><%=m.get("bookname") %></td>
			  <td><%=m.get("author") %></td>
			  <td><%=m.get("press") %></td>
			  <td><%=m.get("price") %></td>
			  <td><a href="edit.book?id=<%=m.get("id")%>">修改</a>&nbsp;
				  <a href="del.book?id=<%=m.get("id")%>" onclick="return confirm('确定要删除吗？')">删除</a>
			  </td>
		  </tr>
		  <%
		  } 
		  %>
	   </table>
</body>
</html>