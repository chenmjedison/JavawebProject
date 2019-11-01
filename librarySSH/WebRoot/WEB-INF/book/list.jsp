<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylesheet" type="text/css" href="CSS/book.css">
  </head>
  
  <body>
    <h2 align="center">图书管理系统</h2>
    <p align="center"><a href="bookAction!addBook.action">添加图书信息</a></p>
    <table align="center" width="60%" border="1">
    <tr><th>书名</th><th>作者</th><th>出版社</th><th>价格</th><th>管理</th></tr>
    <c:forEach items="${books}" var="book">
    	<tr>
    		<td>${book.bookname}</td>
    		<td>${book.author}</td>
    		<td>${book.press}</td>
    		<td>${book.price}</td>
    		<td><a href="bookAction!editBook.action?id=${book.id}">修改</a>&nbsp;
    			<a href="bookAction!deleteBook.action?id=${book.id}" onclick="return confirm('确定要删除吗？')">删除</a></td>
    	</tr>
    </c:forEach>
    </table>
  </body>
</html>
