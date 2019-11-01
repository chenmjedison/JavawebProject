<%@page import="java.sql.DriverManager" import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改图书信息</title>
<link rel="stylesheet" href="CSS/book.css" type="text/css">
<script type="text/javascript" src="JavaScript/book.js"></script>
</head>
<body>
	<%
			String id = request.getParameter("id");
			System.out.println(id);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");
			String sql = "select * from bookinfo where id =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				String bookname = rs.getString("bookname");
				String author = rs.getString("author");
				String press = rs.getString("press");
				String price = rs.getString("price");
	%>
		<h2 align="center">修改图书信息</h2>
		<form name="form1" action="edit_do.jsp" method="post" onSubmit="return check()">
		<input type="hidden" name="id" value="<%=id%>">
		<table align="center" width="50%" border="1px">
		<tr><th width="30%">书名:</th><td><input type="text" name="bookname" value="<%=bookname%>"></td></tr>
		<tr><th width="30%">作者:</th><td><input type="text" name="author" value="<%=author%>"></td></tr>
		<tr><th width="30%">出版设:</th><td><input type="text" name="press" value="<%=press%>"></td></tr>
		<tr><th width="30%">价格:</th><td><input type="text" name="price" value="<%=price%>"></td></tr>
		<tr ><th colspan="2"><input type="submit" value="修改"/><input type="reset" value="重置"/></th></tr>
	
	
	</table>
	</form>
	<%
			}
			rs.close();
			pstmt.close();
			con.close();
	%>
	
</body>
</html>