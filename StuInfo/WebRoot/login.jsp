<%@ page language="java" import="java.util.*,bean.UserDAO" pageEncoding="utf-8"%>
<jsp:useBean class="bean.UserDAO" id="userbean">
<jsp:setProperty name="userbean" property="*" />
</jsp:useBean>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/styles.css">

	<%--
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		//if (username != null && username.equals("zhangsan") && pwd != null && pwd.equals("123456"))
		//    response.sendRedirect("success.jsp"); 
		boolean b = new UserBean().checkLogin(username, pwd);
		if (b) 
			response.sendRedirect("success.jsp"); 

	--%>
  </head>
  <body style="text-align:center" background="img/timg (2).jpg">
  <span id="title">登录页面</span><br>
    <form name="login" action="LoginServlet" method="post">
    <div><label>用户名：</label><input type="text" id="username" name="username" class="myinput"/></div>
    <div><label>密&nbsp;码：</label><input type="password" name="pwd" class="myinput"/></div>
        <div><input type="reset" class="mybutton" value="重置"/>
    <input type="submit" class="mybutton" value="登录"/></div><br>
              还没有注册？<a href="register.jsp">立即注册</a>
    </form>
  </body>
</html>
