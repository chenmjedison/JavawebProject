<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加图书信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="CSS/styles.css">
<jsp:useBean id="book" class="bean.Book"/>
<jsp:setProperty name="book" property="*"/>
<%

/*//String id=request.getParameter("id");
String bookname=request.getParameter("bookname");
String author=request.getParameter("author");
String press=request.getParameter("press");
String price=request.getParameter("price");
 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=book","sa","sasa");
 String sql="insert into bookinfo values(null,?,?,?,?)";
 PreparedStatement pstmt=con.prepareStatement(sql);
 //pstmt.setInt(1,Integer.parseInt(id));
pstmt.setString(1,bookname); 
 pstmt.setString(2,author);
 pstmt.setString(3,press);  
 pstmt.setFloat(4,Float.parseFloat(price));*/
 int result=book.addBook();
 String msg="添加失败。单击确定跳转到图书列表页！";
 if(result==1)
{
msg="添加成功。单击确定跳转到图书列表页！";
}
 %>
<script>window.alert('<%=msg%>');</script>
<%
response.setHeader("Refresh", "1;url=index.jsp");
 %>
  </head>
  
  <body>
  </body>
</html>
