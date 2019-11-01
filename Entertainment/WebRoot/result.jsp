<<<<<<< HEAD
=======
<<<<<<< HEAD:EntertainmentV2/WebContent/result.jsp
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>返回结果</title>
</head>
	<body>
	<%
	request.setCharacterEncoding("utf-8");
	%>
		${requestScope.result}
		<a href="${pageContext.request.contextPath}/as/list">返回</a>
	</body>
=======
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	${requestScope.result}
	<a href="${pageContext.request.contextPath}/as/list">返回</a>
</body>
<<<<<<< HEAD
=======
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec:Entertainment/WebRoot/result.jsp
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
</html>