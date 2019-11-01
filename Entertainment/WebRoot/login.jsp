<<<<<<< HEAD
=======
<<<<<<< HEAD:EntertainmentV2/WebContent/login.jsp
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员登录</title>
</head>
<body>
	<div align="center">
	    <h1>管理员登录</h1>
	    <form action="LoginServlet" method="post">
		   	 用户名：<input type="text" name="username"><br/>
		   	 密     码：<input type="password" name="password"><br/>
		   	 <input type="submit" value="登录"/>
		   	 <input type="reset" value="重置"/>
	    </form>
    </div>
</body>
=======
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	    <h1>用户登录</h1>
	    <form action="login.jsp" method="post">
		   	 用户名：<input type="text" name="name"><br/>
		   	 密 码：<input type="password" name="pw"><br/>
		   	 <input type="submit" value="登录"/>
		   	 <input type="reset" value="重置"/>
	    </form>
    </div>
</body>
<<<<<<< HEAD
=======
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec:Entertainment/WebRoot/login.jsp
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
</html>