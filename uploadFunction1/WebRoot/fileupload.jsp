<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>fileupload.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<b>文件上传----使用commons upload组件</b>
	<form action="FileUploadServlet" method="post" enctype="multipart/form-data">
		文件描述：<input type="text" name="desc" size="20" maxlength="80"/><br/>
		文件名称：<input type="file" name="file" size="20" maxlength="80"/><br/>
		<input type="submit" value="上传">
	</form>
  </body>
</html>
