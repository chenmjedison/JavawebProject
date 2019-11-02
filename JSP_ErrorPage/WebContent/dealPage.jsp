<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>isErrorPage的使用</title>
</head>
<body>
<b>错误描述：</b><%=exception.toString() %></p>
<b>详细出错原因</b>
<pre>
	<%
		exception.printStackTrace(new PrintWriter(out));
	%>
</pre>
</body>
</html>