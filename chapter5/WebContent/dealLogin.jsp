<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dealLogin.jsp' starting page</title>
    
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
    <% String user=request.getParameter("user");
    	String pw=request.getParameter("pw");
    	if(user!=null&&pw!=null&&user.equals("zhangsan")&&pw.equals("123")){
    		session.setAttribute("user", user);
    		String ch=request.getParameter("ch");
    		if(ch!=null){
    			int time=Integer.parseInt(ch);
    			if(time>0){
    				Cookie c=new Cookie("user",user);
    				c.setMaxAge(time);
    				response.addCookie(c);
    				}
    			}
    			response.sendRedirect("zy.jsp");
    			}else{
    			response.sendRedirect("login.jsp");
    		}
    
     %>
  </body>
</html>
