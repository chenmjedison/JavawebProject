<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	String bookname=request.getParameter("bookname");
	String author=request.getParameter("author");
	String press=request.getParameter("press");
	String price=request.getParameter("price");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");
	String sql = "update bookinfo set bookname=?,author=?,press=?,price=? where id=?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setString(1, bookname);
	pstmt.setString(2,author);
	pstmt.setString(3,press);
	pstmt.setString(4,price);
	pstmt.setInt(5, Integer.parseInt(id));
	int result = pstmt.executeUpdate();
	String msg = "更新失败,单击确定跳转到列表页！";
	if(result==1){
		msg="更新成功,单击确定跳转到列表页！";
	}
	pstmt.close();
	con.close();
%>

</body>
<script type="text/javascript">window.alert("<%=msg%>")</script>
<%
	response.setHeader("Refresh", "1;url=index.jsp");

%>
</html>