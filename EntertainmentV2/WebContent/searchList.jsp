<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分类搜索</title>
</head>
<body>
	<center>
		<h2>分类搜索</h2>
		<c:set var="url" value="${pageContext.request.contextPath}/us/search"></c:set>
		<form action="${url}" method="post">
			请选择类别:
		<select name="type">
			<option value="" <c:if test="${empty param.type}">selected</c:if>>全部类别</option>
			<option value="1" <c:if test="${param.type==1}">selected</c:if>>图片</option>
			<option value="2" <c:if test="${param.type==2}">selected</c:if>>Flash</option>
			<option value="3" <c:if test="${param.type==3}">selected</c:if>>音乐</option>
			<option value="4" <c:if test="${param.type==4}">selected</c:if>>小视频</option>
			<option value="5" <c:if test="${param.type==5}">selected</c:if>>其他</option>
		</select>
		请输入关键字:
		<input type="text" name="name" value="${param.name}"/>
		<input type="submit" value="查看"/>
		</form>
		<c:forEach var="file" items="${pageBean.data}">
			<table border width="70%">
				<tr>
					<td bgcolor="#CCCCCC" width="15%">文件说明</td>
					<td width="45%"><a href="${pageContext.request.contextPath}/dls?id=${file.id}">${file.name}</a></td>
					<td bgcolor="#CCCCCC" width="15%">文件大小</td>
					<td>${file.size}字节</td>
				</tr>
				<tr>
					<td bgcolor="#CCCCCC" width="15%">更新日期</td>
					<td width="45%">${file.lastModified}</td>
					<td bgcolor="#CCCCCC" width="15%">下载次数</td>
					<td>${file.hits}</td>
				</tr>
				<tr>
					<td bgcolor="#CCCCCC" width="15%">详细描述</td>
					<td colspan="3">${file.description}</td>
				</tr>
			</table>
		<p>
		</c:forEach>
		每页 ${pageBean.pageSize}行 共${pageBean.totalRows}行 页数${pageBean.curPage}/${pageBean.totalPages}
		<c:choose>
			<c:when test="${pageBean.curPage==1}">首页 上一页</c:when>
			<c:otherwise>
				<a href="${url}?page=1&type=${param.type}">首页</a>
				<a href="${url}?page=${pageBean.curPage-1}&type=${param.type}">上一页</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${pageBean.curPage>=pageBean.totalPages}">下一页 尾页</c:when>
			<c:otherwise>
				<a href="${url}?page=${pageBean.curPage+1}&type=${param.type}">下一页</a>
				<a href="${url}?page=${pageBean.totalPages}&type=${param.type}">尾页</a>
			</c:otherwise>
		</c:choose>
	</center>
</body>
</html>