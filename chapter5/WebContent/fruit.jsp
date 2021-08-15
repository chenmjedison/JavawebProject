<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<%@ include file="check.jsp" %>
<head>
<meta charset="utf-8">
<title>水果店</title>
</head>
<%@ include file="head.jsp" %>

<body>
<div align="center">
<%=name %>,欢迎您选购水果！
<form action="buy.jsp" method="post">
<select name="goods">
<option value="梨">梨</option>
<option value="苹果">苹果</option>
<option value="香蕉">香蕉</option>
<option value="橘子">橘子</option>
</select>
<input type="submit" value="加入购物车"/>
</form>

</div>
<%



%>
</body>
</html>