<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
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
  
    您的姓名是：<%=request.getParameter("name") %><br/>
您的姓名是：<%=request.getParameter("pw") %><br/>
您的职业是：<%=request.getParameter("career") %><br/>
您的电话号码：<%=request.getParameter("telephone") %><br/>
您的电子邮箱：<%=request.getParameter("email") %><br/>
<%
String[] fav=request.getParameterValues("fav");
if(fav!=null){
out.print("你的兴趣爱好有：");
for(String f:fav)
{
out.print(f);
}
out.println("<br/>");
}
 %>
 你的自我简介：<%=request.getParameter("intro")%>
  </body>
</html>
