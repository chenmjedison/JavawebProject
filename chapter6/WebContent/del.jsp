<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");
String sql = "delete from bookinfo where id = ?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setInt(1, Integer.parseInt(id));
int result = pstmt.executeUpdate();
String msg = "删除失败，单击确定跳转到图书列表页！";
if(result==1){
	msg = "删除成功，单击确定跳转到图书列表页！";
}
pstmt.close();
con.close();
%>

</body>
<script type="text/javascript">window.open("<%=msg%>")</script>
<%
	response.setHeader("Refresh", "1;url=index.jsp");

%>
</html>