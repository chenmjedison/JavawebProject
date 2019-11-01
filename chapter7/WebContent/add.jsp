<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%	
	request.setCharacterEncoding("utf-8");
%>
	<jsp:useBean id="book" class="bean.Book">
		<jsp:setProperty property="*" name="book"/>
	</jsp:useBean>
<%
	int result = book.addBook();
	String msg = "添加失败，单机确定跳转到图书列表页！";
	if(result == 1){
		msg = "添加成功，单机确定跳转到图书列表页！";
	}
%>
<script type="text/javascript">window.alert("<%=msg%>")</script>
<%
	response.setHeader("Refresh", "1;url=index.jsp");

%>

</body>
</html>