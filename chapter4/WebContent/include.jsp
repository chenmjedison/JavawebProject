<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>include动作的使用</title>
</head>
<body>
<h1>include动作的使用</h1>
<jsp:include page="box.jsp">
<jsp:param value="#00ff00" name="color"/>
<jsp:param value="title" name="this is the title"/>
<jsp:param value="content" name="this is the content"/>
</jsp:include>
</body>
</html>