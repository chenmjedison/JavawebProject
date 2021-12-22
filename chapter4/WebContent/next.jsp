<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
您的年龄是：<%=request.getParameter("age") %>岁<br/>
您的访问权限是：<%=request.getParameter("access") %>!
</body>
</html>