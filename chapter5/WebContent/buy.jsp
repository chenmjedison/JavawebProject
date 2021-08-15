<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<%@ include file="check.jsp" %>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String goods = request.getParameter("goods");
	if(goods==null){
		response.sendRedirect("sessionCartSuccess.jsp");
	}else{
		ArrayList<String> carts = (ArrayList<String>)session.getAttribute("carts");
		if(carts==null){
			carts=null;
		}
		carts.add(goods);
		session.setAttribute("carts", carts);
		response.sendRedirect("cart.jsp");
	}

%>
</body>
</html>