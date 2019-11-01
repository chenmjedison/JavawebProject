<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'session.jsp' starting page</title>
    
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
    会话ID:<%=session.getId() %><br/>
    是否新会话:<%=session.isNew() %><br/>
    设置和获取新属性:<%session.setAttribute("用户", "管理员"); %>
    用户名=<%=session.getAttribute("用户名") %><br/>
    绘画持续时间(s):<%=session.getMaxInactiveInterval() %><br/>
    <%session.setMaxInactiveInterval(300); %>
    修改后的绘画持续时间:<%=session.getMaxInactiveInterval() %><br/>
    <%
    Date creationTime=new Date(session.getCreationTime());
    Date accessedTime=new Date(session.getLastAccessedTime());
     %>
     绘画创建时间:<%=creationTime.toLocaleString() %><br/>
     最后一次访问时间:<%=accessedTime.toLocaleString() %>
     <%
     session.invalidate();
      %>
  </body>
</html>
