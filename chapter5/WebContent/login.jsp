<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>自动登录测试</title>
    
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
    <% Cookie a[]=request.getCookies();
    if(a!=null){
    	for(int i=0;i<a.length;i++){
    		if(a[i].getName().equals("user")){
    		String user=a[i].getValue();
    		session.setAttribute("user",user);
    		response.sendRedirect("zy.jsp");
    		return;
    		}
    	}
    }
     %>
     <form action="dealLogin.jsp" method="post">
    	 用户名：<input type="text" name="user"/></P>
     	密码：<input type="text" name="pw"/></p>
     	不保存用户名：<input type="radio" name="ch" value="0" checked><p/>
     	保存用户名：
     	<input type="radio" name="ch" value="60"/>一分钟
     	<input type="radio" name="ch" value="3600"/>一小时
     	<input type="radio" name="ch" value="86400"/>一天
     	<input type="radio" name="ch" value="604800"/>一周
     	<input type="radio" name="ch" value="2592000"/>一月
     	<input type="radio" name="ch" value="31536000"/>一年<p/>
     	<input type="submit" value="登录">
     	<input type="reset" value="重置">
     </form>
  </body>
</html>
