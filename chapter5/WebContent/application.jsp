<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>网页访问计数</title>
</head>
<body>
<%
	int num;
	if(application.getAttribute("num")==null){
		num=0;
	}else{
		num=((Integer)application.getAttribute("num")).intValue();
	}
	num++;
	application.setAttribute("num", num);

%>
<h1>这个网页被浏览了<%=num %>次</h1>
</body>
</html>