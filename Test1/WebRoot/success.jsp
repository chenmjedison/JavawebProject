<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录成功</title>
    
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
    <%
    String name=(String)session.getAttribute("LoginUserName");
    if(name==null){
    out.println("<h3>请先登录再访问，5秒后返回<a href=\"login.html\">登录页面</a>!</h3>");
    response.setHeader("Refrash","5;url=login.html");
    }else
    {
    out.println("<h3>欢迎"+name+",登陆成功！");
    }
    //String name=request.getParameter("name");
    //out.println("<h3>欢迎"+name+",登陆成功！</h3>");
     %>
  </body>
</html>
