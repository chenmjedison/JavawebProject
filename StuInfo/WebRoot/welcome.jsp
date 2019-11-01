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
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body style="text-align:center" background="img/timg.jpg">
  <span  id="title">欢迎进入学生信息管理系统</span><br>
  <a href="login.jsp">欢迎进入登录界面</a><br>
  <div align="buttom"><p1 >信息工程系   软件1141 <br>
  陈明剑
  </p1></div>
  
  <font color="#548641">&copy;版权所有</font>
  </body>
</html>
