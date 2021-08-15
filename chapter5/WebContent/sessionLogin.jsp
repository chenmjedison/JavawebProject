<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登陆处理</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	String pw=request.getParameter("pw");
	if(name!=null&&pw!=null&&name.equals("admin")&&pw.equals("123")){
		session.setAttribute("loginUserName", name);
		response.sendRedirect("success.jsp");
	}else{
		out.println("<h3>用户名或密码错误，5秒后返回<a href=\"login.html\">登录页面</a>!</h3>");
		response.setHeader("Refresh", "5;url=login.html");
	}

%>
</body>
</html>