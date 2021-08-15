<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie a[] = request.getCookies();
	
%>
<h1>
<%
	if(a!=null){
		for(int i=0;i<a.length;i++){
			String n=a[i].getName();
			String v=a[i].getValue();
			out.println(n+"="+v+"<br/>");
		}
	}


%>

</h1>
</body>
</html>