<%@page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改图书信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<script type="text/javascript" src="JavaScript/book.js"></script>
  </head>
  <body>
    <c:if test="${!empty book}">
    <h2 align="center">修改图书信息</h2>
	    <form name="form1" onSubmit="return check()" action="bookAction!updateBook.action" method="post">
	    	<input type="hidden" name="book.id" value="${book.id}">
			<table align="center" width="30%" border="1">
			    <tr><th width="30%">书名：</th><td><input type="text" name="book.bookname" value="${book.bookname}"></td></tr>
			    <tr><th width="30%">作者：</th><td><input type="text" name="book.author" value="${book.author}"></td></tr>
			    <tr><th width="30%">出版社：</th><td><input type="text" name="book.press" value="${book.press}"></td></tr>
			    <tr><th width="30%">价格：</th><td><input type="text" name="book.price" value="${book.price}"></td></tr>
			    <tr><th colspan="2"><input type="submit" value="修改"><input type="reset" value="重置"></th></tr>
		    </table>
	    </form>
     </c:if>
  </body>
</html>
