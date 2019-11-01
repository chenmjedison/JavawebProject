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
    
    <title>My JSP 'Update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="CSS/styles.css" type="text/css"></link>
  </head>
  <body background="img/timg (3).jpg">
    <div align="center">
<span id="title">更新学生信息</span><br>
<form name="update" action="UpdateStudentServlet" method="post">
<div><label for="username">学&nbsp;&nbsp;号：</label><input type="text" class="myinput" readonly id="id" name="id" value="${student.student_id}"  /></div>
<div><label>姓&nbsp;&nbsp;名：</label><input type="text" class="myinput" id="name" name="name" value="${student.student_name}"/></div>
<div><label>性&nbsp;&nbsp;别：&nbsp;&nbsp;</label><input type="radio" id = "sex" name="sex" value="男" <c:if test="${student.student_sex== '男'}">checked="checked"</c:if>>男
&nbsp;<input type="radio" id = "sex" name="sex" value="女" <c:if test="${student.student_sex== '女'}">checked="checked"</c:if>>女&nbsp;&nbsp;</div>
<div><label>出生日期：</label><input type="text" class="myinput" id="birthday" name="birthday" value="${student.student_birthday}"/></div> 
<div><label>系&nbsp;&nbsp;别：</label><input type="text" id="dept" name="dept" class="myinput" value="${student.student_dept}"/></div> 
<div><label>专&nbsp;&nbsp;业：</label><input type="text" id="major" name="major" class="myinput" value="${student.student_major}"/></div> 
<div><label>&nbsp;班级号：</label><input type="text" id="classid" name="classid" class="myinput" value="${student.student_classid}"/></div> 
<br/>
<div><input type="submit" class="mybutton"  name="btnUpdate" value="更新"  /><input type="submit" class="mybutton"  name="btnUpdate" value="取消"  /></div>
</form> 
</div>
</body>
</html>
