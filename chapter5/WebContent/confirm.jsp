<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<% 
	request.setCharacterEncoding("UTF-8");
	String [] commodity =request.getParameterValues("no");
	HttpSession s = request.getSession(true);
	s.setAttribute("commodity", commodity);
	%>
<script type="text/javascript">

	
</script>
<title>Insert title here</title>
</head>
<body>
	
	
	<center>
		
	
		<% 
			out.print("您确定要购买");
			for(String a:commodity)
				out.print(a+" ");
			out.print("?");
		%>
		<br/>
		<form name="confirm" action="YesServlet" method="post" >
		<input type="submit" value="是" id="yes" onclick="yes()"/>
		</form>
		<form name="confirm1" action="NoServlet" method="post" >
		<input type="submit" value="否" id="yes" onclick="yes()"/>
		</form>
		
		<a href="list.jsp">返回商店</a>
	</center>
	
	
</body>
</html>