<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function buy(){
		
		
		
		
	}
	

</script>
</head>
<body>
	<center>
	<h2>商品列表</h2>
	<form method="post" action="confirm.jsp">
		  <table align="center" border="1" width="50%">
			  <tr><th width="30%">商品编号</th><th width="30%">商品名称</th><th width="30%">商品价格</th></tr>
			  <tr><td width="30%"><input type="checkbox" name="no" value="图书">1</td><td width="30%">图书</td><td width="30%">20</td></tr>
			 <tr><td width="30%"><input type="checkbox" name="no" value="CD">2</td><td width="30%">CD</td><td width="30%">10</td></tr>
			 <tr><td width="30%"><input type="checkbox" name="no" value="衣服">3</td><td width="30%">衣服</td><td width="30%">390</td></tr>
			 <tr><td width="30%"><input type="checkbox" name="no" value="玩具">4</td><td width="30%">玩具</td><td width="30%">5</td></tr>
			 <tr><td width="30%"><input type="checkbox" name="no" value="手机">5</td><td width="30%">手机</td><td width="30%">2090</td></tr>			
		  </table>
		  <input type="submit" value="购买" onclick="buy()">
	  </form>
	  </center>
</body>
</html>