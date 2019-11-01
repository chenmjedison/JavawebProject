<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<<<<<<< HEAD
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
=======
<<<<<<< HEAD:.metadata/.plugins/org.eclipse.core.resources/.history/78/70ca75c69f9400191e26a87f936594a7
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
=======
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec:Entertainment/WebRoot/listAll.jsp
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
<title>Insert title here</title>
</head>
<body>
<center>
	<h2>娱乐无极限下载中心</h2>
	<c:set Var="url" value = "${pageContext.request.contextPath}/us/listAll"></c:set>
	<c:forEach var="file" items="${pageBean.data}">
		<table border width="70%">
		<tr>
			<td bgcolor="#CCCCCC" width='15%'>文件说明</td>
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
			<td bgcolor="#CCCCCC" wdith="15%">详细描述</td>
			<td colspan="3">${file.description}</td>
		</tr>
		</table>
		<p>
	</c:forEach>
	每页${pageBean.pageSize}行 共${pageBean.totalRows}行 页数
	${pageBean.curPage}/${pageBean.totalPages}
	<c:choose>
			<c:when test="${pageBean.curPage==1}">首页 上一页</c:when>
			<c:otherwise>
				<a href = "${url}?page=1">首页</a>
				<a href = "${url}?page=${pageBean.curPage-1}">上一页</a>
			</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${pageBean.curPage>=pageBean.totalPages}">下一页  尾页</c:when>
		<c:otherwise>
			<a href="${url}?page=${pageBean.curPage+1}">下一页</a>
			<a href="${url}?page=${pageBean.total}">尾页</a>
		</c:otherwise>
	</c:choose>
</center>
</body>
</html>