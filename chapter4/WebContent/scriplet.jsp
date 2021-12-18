<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import ="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>脚本段示例</title>
</head>
<body>
<h2>
	<%
		String name = "王红";
		if(Calendar.getInstance().get(Calendar.AM_PM)==Calendar.AM){
			out.println(name+",上午好！");
		}else{
			out.println(name+",下午好！");
		}
	int i=0;
	out.println("<br/>i的值是"+i);
	out.println("<br/>下面修改局部变量i的值");
	i++;
	out.println("<br/>修改后i的值是"+i);
	
	%>





</h2>
</body>
</html>