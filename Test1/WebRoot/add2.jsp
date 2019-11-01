<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>add.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="CSS/styles.css">
    <script type="text/javascript" src="JavaScript/book.js"></script>

  </head>
  
  <body>
    <h2 align="center">添加图书信息</h2>
  <form name="form1"  action="add.jsp" method="post">
  <table align="center" width="60%" border="1" >
  <tr><th width="30%">书名：</th><td><input type="text" name="bookname"></td></tr>
  <tr><th>作者：</th><td><input type="text" name="author"></td></tr>
  <tr><th >出版设：</th><td><input type="text" name="press"></td></tr>
  <tr><th>价格：</th><td><input type="text" name="price"></td></tr>
  <tr><th colspan="2"align="center"><input type="submit" value="添加"><input type="reset" value="重置"></th></tr>
  </table>
  
  </form>
  </body>
</html>
