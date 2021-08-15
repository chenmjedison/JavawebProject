<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<%@ include file="check.jsp" %>
<head>
<meta charset="utf-8">
<title>购物车</title>
</head>
<body>
<%@ include file="head.jsp" %>
<div align="center">
<%
ArrayList<String> carts=(ArrayList<String>)session.getAttribute("carts");
if(carts==null){
	out.println(name+"的购物车为空");
}else{
	out.println(name+"的购物车中包括：");
	for(String c:carts){
		out.print(c+"&nbsp;");
	}
	out.println();
}

%>
</div>
</body>
</html>