<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="java.sql.*" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改图书信息</title>
<link rel="stylesheet" href="CSS/styles.css" type="text/css">
<script type="text/javascript" src="JavaScript/book.js"></script>
</head>
<body>
<%
	HashMap bookinfo=(HashMap)request.getAttribute("bookinfo");
	if(bookinfo!=null){
%>
	<h2 align="center"> 修改图书信息</h2>
	<form name="form1" onSubmit="return check()" action="edit_do.book" method="post">
		<input type="hidden" name="id" value="<%=bookinfo.get("id") %>"/>
		<table align="center" width="30%" border="1">
		<tr><th width="30%">书名:</th><td><input type="text" name="bookname" value="<%=bookinfo.get("bookname")%>"/></td></tr>
		<tr><th >作者：</th><td><input type="text" name="author" value="<%=bookinfo.get("author")%>"/></td></tr>
		<tr><th>出版设：</th><td><input type="text" name="press" value="<%=bookinfo.get("press")%>"/></td></tr>
		<tr><th>价格：</th><td><input type="text" name="price" value="<%=bookinfo.get("price")%>"/></td></tr>
		<tr><th colspan="2"align="center"><input type="submit" value="修改"/><input type="reset" value="重置"/></th></tr>
		</table>
	</form>
<%
}
 %>
	
</body>
</html>