<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
	<center>
	<h2>您本次购买的物品有：</h2>
	<%
	request.setCharacterEncoding("UTF-8");
	String[] commodity = (String [])session.getAttribute("commodity");
		for(String a:commodity)
			out.print(a+" ");
	
	%>
	
	<h2>您的购物车里面有：</h2>
	
	<a href="list.jsp">返回商店</a>
	
	
	</center>
</body>
</html>