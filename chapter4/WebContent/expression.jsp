<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>表达式的使用</title>
</head>
<body>
<%!long i=0; %>
<%!String name="王红"; %>
<%!public String sayHello(String who){
	return "你好，"+who+"!";
}
%>
<%
	i++;
%>
<%--表达式的使用 --%>
<h2 align="center">
	<%=sayHello(name) %><br/>	
您是本站的第<%=i %>位访客.
</h2>
</body>
</html>