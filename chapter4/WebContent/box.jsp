<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	String color=request.getParameter("color");
	String title=request.getParameter("title");
	String content=request.getParameter("content");

%>
<table border="1" width="50%">
<tr bgcolor="<%=color%>">
<td>
<%=title%>
</td>
</tr>
<tr>
	<td><%=content%></td>
</tr>
</table>
</body>
</html>