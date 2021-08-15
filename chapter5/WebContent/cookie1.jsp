<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie c= new Cookie("login","zhangsan");
	c.setMaxAge(60);
	response.addCookie(c);
	response.sendRedirect("cookie2.jsp");
	//response.sendRedirect(response.encodeRedirectURL("cookie2.jsp"));

%>
</body>
</html>