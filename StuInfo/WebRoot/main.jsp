<%@ page language="java" import="java.util.*,bean.StudentDTO" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
LinkedList<StudentDTO> list = (LinkedList<StudentDTO>)session.getAttribute("studentlist");  
String popup = null;
if (session.getAttribute("msg") != null) {
	popup = session.getAttribute("msg").toString();
	session.removeAttribute("msg");	
}   
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="CSS/styles.css" type="text/css"></link>
    
    <script language="javascript">
    window.onload = init;
    
    function init() {
    	var msg = '<%=popup%>';
    	if (msg != "null")
    		alert(msg);
    }
    </script>
    
    </head>

  <body background="img/timg (1).jpg">
  <%-- out.println(request.getAttribute("username"));--%>
  <c:out value="${sessionScope.username}" />
  你好！<br>
  <div align="center">
<span id="title">显示所有学生信息</span><br>
<table border="1">
	<tr>
	<td colspan="9" align=”center“>
	<a href="add.jsp">添加学生信息</a>
	</td>
	</tr>
	<tr>
		<th>学号</th>
		<th>姓名</th>
		<th>性别</th>
		<th>出生日期</th>
		<th>系别</th>
		<th>专业</th>
		<th>班级号</th>
		<th>操作</th>
		<th>操作</th>
	</tr>

	<!--<% for(StudentDTO student : list) { %>
	<tr>
		<td><%=student.getStudent_id() %></td>
		<td><%=student.getStudent_name() %></td>
		<td><%=student.getStudent_sex() %></td>
		<td><%=student.getStudent_birthday() %></td>
		<td><%=student.getStudent_dept() %></td>
		<td><%=student.getStudent_major() %></td>
		<td><%=student.getStudent_classid() %></td>	
	</tr>
	<%} %>
	-->
	<c:forEach var="student" items="${sessionScope.studentlist}">
	<tr>
		<td>${student.student_id}</td>
		<td>${student.student_name}</td>
		<td>${student.student_sex}</td>
		<td>${student.student_birthday}</td>
		<td>${student.student_dept}</td>
		<td>${student.student_major}</td>
		<td>${student.student_classid}</td>
		<td><a href="UpdateInfoServlet?student_id=${student.student_id}"">更新</a></td>
		<td><a href="DeleteServlet?student_id=${student.student_id}" onclick="return confirm('确定要删除吗？')">删除</a></td>
	</tr>
	</c:forEach>
</table>
</div>
  </body>
</html>
