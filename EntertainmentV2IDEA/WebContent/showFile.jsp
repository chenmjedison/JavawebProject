<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>文件详细信息</title>
</head>
<body>
	<center>
		<h2>文件详细信息</h2>
		<table border width="70%">
			<tr>
				<td bgcolor="#CCCCCC" width="15%">文件说明</td>
				<td width="45%">${file.name}</td>
				<td bgcolor="#CCCCCC" width="15%">文件大小</td>
				<td>${file.size}字节</td>
			</tr>
			<tr>
				<td bgcolor="#CCCCCC" width="15%">更新日期</td>
				<td width="45%">${file.lastModified}</td>
				<td bgcolor="#CCCCCC" width="15%">详细描述</td>
				<td colspan="3">${file.description}</td>		
			</tr>
			<tr>
				<td colspan="4" align="center"><a href="${pageContext.request.contextPath}/dls?id=${file.id}">下载</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/us/top">返回</a></td>
			</tr>
		</table>
	</center>
</body>
</html>