<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>下载排行榜</title>
</head>
<body>
<center>
	<h2>下载排行榜</h2>
	<table border width="50%">
		<tr>
			<th width="15%" bgcolor="#CCCCCCC">排名</th>
			<th width="65%" bgcolor="#CCCCCCC">文件说明</th>
			<th width="20%" bgcolor="#CCCCCCC">下载次数</th>
		</tr>
		<c:forEach var="file" items="${top}" varStatus="vs">
			<tr>
				<td align="center" bgcolor="#CCCCCCC">${vs.count}</td>
				<td align="center"><a href="${pageContext.request.contextPath}/us/show?id=${file.id}">${file.name}</a></td>
				<td align="center">${file.hits}</td>
			</tr>
		</c:forEach>
	</table>
</center>
</body>
</html>