<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录处理</title>
    
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
    request.setCharacterEncoding("UTF-8");
    String name=request.getParameter("name");
    String pw=request.getParameter("pw");
    if(name!=null&&pw!=null&&name.equals("admin")&&pw.equals("123"))
    {
    session.setAttribute("loginUserName", name);
    response.sendRedirect("success.jsp");
    }
    else{
    out.println("<h3>用户名或密码错误，5秒后返回<a href=\"login.html\">登录页面</a>!</h3>");
    response.setHeader("Refresh", "5;url=login.html");
    }
     %>
  </body>
</html>
