<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="CSS/styles.css" type="text/css"></link>
  </head>
  <body background="img/timg (4).jpg">
    <div align="center">
<span id="title">添加学生信息</span><br>
<form name="add" action="AddServlet" method="post">
<div><label for="username">学&nbsp;&nbsp;&nbsp;号：</label><input type="text" class="myinput" id="student_id" name="student_id" value=""  /></div>
<div><label>姓&nbsp;&nbsp;&nbsp;名：</label><input type="text" class="myinput" id="student_name" name="student_name" value=""/></div>
<div><label>性&nbsp;&nbsp;&nbsp;别：</label><input type="radio" name="student_sex" value="男" <c:if test="">checked="checked"</c:if>>男
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="student_sex" value="女" <c:if test="">checked="checked"</c:if>>女</div>
<div><label>&nbsp;出生日期：</label><input type="text" class="myinput" id="student_birthday" name="student_birthday" value=""/></div> 
<div><label>系&nbsp;&nbsp;&nbsp;别：</label><input type="text" id="student_dept" name="student_dept" class="myinput" value=""/></div> 
<div><label>专&nbsp;&nbsp;&nbsp;业：</label><input type="text" id="student_major" name="student_major" class="myinput" value=""/></div> 
<div><label>&nbsp;&nbsp;班级号：</label><input type="text" id="student_classid" name="student_classid" class="myinput" value=""/></div> 
<br/>
<div><input type="submit" class="mybutton"  name="btnAdd" value="添加"  /><input type="submit" class="mybutton"  name="btnAdd" value="取消"  /></div>
</form> 
</div>
</body>
</html>
