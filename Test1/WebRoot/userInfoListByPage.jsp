<%@ page language="java" import="java.util.*,bean.PageBean" pageEncoding="GBK"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户信息分页显示</title>
    
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
    <h2 align="center">图书信息分页显示</h2>
    <table border="1" align="center" width="50%">
    <tr><th>序号</th><th>书名</th><th>作者</th></tr>
	<c:forEach var="user" items="${pageBean.data}" varStatus="vs">
	<tr>
		<td align="center"><c:out value="${vs.count}"></c:out></td>
		<td align="center"><c:out value="${user.bookname}"></c:out></td>
		<td align="center"><c:out value="${user.author}"></c:out></td>
		</tr>
	</c:forEach>    
    </table>
    <p align="center">
             每页${pageBean.pageSize}行
             共${pageBean.totalRows}行
             页数${pageBean.curPage}/${pageBean.totalPages}<br/>
    <c:choose>
    	<c:when test="${pageBean.curPage==1}">首页 上一页</c:when>
    	<c:otherwise>
    		<a href="UserInfoServlet?page=1">首页</a>
    		<a href="UserInfoServlet?page=${pageBean.curPage-1}">上一页</a>
    	</c:otherwise>
    </c:choose>
    <c:choose>
    	<c:when test="${pageBean.curPage==pageBean.totalPages}">下一页 尾页</c:when>
    	<c:otherwise>
    	<a href="UserInfoServlet?page=${pageBean.curPage+1}">下一页</a>
    	<a href="UserInfoServlet?page=${pageBean.totalPages}">尾页</a>
    	</c:otherwise>
    </c:choose>
    
    </p>
  </body>
</html>
