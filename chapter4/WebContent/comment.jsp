<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注释的使用</title>
</head>
<body>
<ol>
<li>HTML注释</li>
<!-- 这里是HTML格式的注释，表达式的值<%=1+2+3%> -->
<li>Java注释</li>
<%
//这里是Java语言的单行注释，下面是多行注释
/*
String a="abc";
String b="dfb";
*/
String s1="此信息会显示在Servlet中";






%>
<li>JSP注释</li>
<%--这里是开发人员专用的JSP注释 --%>
<%--
	String s2="此信息不会显示在页面源代码和Servlet中";

--%>
</ol>
</body>
</html>