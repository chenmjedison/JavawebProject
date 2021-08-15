<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登陆成功</title>
</head>
<%@ include file="check.jsp" %>
<%@ include file="head.jsp" %>
<body>
<%
	out.println("<h3>欢迎"+name+",登陆成功!<h3>");
%>
</body>
</html>