<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%@ page pageEncoding="utf-8"%>
<%
	String age=request.getParameter("age");
	String access=null;
	if(Integer.parseInt(age)>=18){
		access="OK";
	}else{
		access="NO";
	}

%>
<jsp:forward page="next.jsp">
	<jsp:param value="<%=access %>" name="access"/>
</jsp:forward>
</body>
</html>