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
	String name = (String)session.getAttribute("loginUserName");
	if(name==null){
		out.println("<h3>请先登录再访问，5秒后返回<a href=\"login.html\">登录页面</a>!</h3>");
	response.setHeader("Refresh", "5;url=login.html");
	return;
	}

%>
</body>
</html>