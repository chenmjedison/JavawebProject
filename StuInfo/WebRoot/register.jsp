<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <link rel="stylesheet" href="CSS/styles.css" type="text/css"></link>
  <script language="javascript">
  		var flag1 = false; //用户名是否验证通过
  		var flag2 = false; //密码是否验证通过
  		var flag3 = false; //确认密码是否验证通过
  		var flag4 = false; // 电子邮箱是否验证通过
  		
  		//验证用户名是否有效
  		function checkUserName() {
  			var username = document.register.userName.value;
  			if (username.length < 2 || username.length > 10) {
  				document.getElementById("errName").style.display = "block";	
  				flag1 = false;
  			}
  			else {
  				document.getElementById("errName").style.display = "none";	
  				flag1 = true;
  			}
  		}
  		
  		 //验证密码是否一致
  		function checkPwd1(form1) {
  			var pwd = form1.userPwd.value;
  			var pwd1 = form1.userPwd1.value;
  			
  			if ( pwd == pwd1)  {
  				document.getElementById("errPwd1").style.display = "none";	
  				flag3 = true;
  			}
  			else {
  				document.getElementById("errPwd1").style.display = "block";	
  				flag3 = false;
  			}
  		}
  		
  		//验证电子邮箱是否有效
  		function checkEmail() {
  			var email = document.register.userEmail.value;
  			if (email.match("^[a-zA-Z][a-zA-Z0-9_\-]*@([a-zA-Z0-9\-]+\.)+[a-z]{2,3}$")) {
  				document.getElementById("errEmail").style.display = "none";	
  				flag4 = true;
  			} 
  			else {
  				document.getElementById("errEmail").style.display = "block";	
  				flag4 = false;
  			}
  		}

		//验证整个表单有效
		function checkForm() {
			if (flag1 && flag3 && flag4)
				return true;
			else 
				return false;
		
		}
  		
  
  </script>
  </head>
  <body background="img/timg.jpg">
	<div align="center">
		<span id="title">填写账户信息</span><br>
		<form name="register" action="RegisterServlet" method="post" onsubmit="return checkForm()">
		<div><label for="username">&nbsp;用户名：</label><input type="text" class="myinput" id="userName" name="userName"  onblur="checkUserName()" /><span id="errName" style="display:none;color:red;">用户名长度在2~10之间</span></div>
			<div><label>密&nbsp;&nbsp;码：</label><input type="password" class="myinput" id="userPwd" name="userPwd" onblur="checkPwd()" /><span id="errPwd" style="display:none;color:red;">密码长度在5~10之间</span></div>
			<div><label>确认密码：</label><input type="password" class="myinput" id="userPwd1" name="userPwd1"  onblur="checkPwd1(register)" /><span id="errPwd1" style="display:none;color:red;">密码不一致</span></div>
			<div><label>性&nbsp;&nbsp;别：</label><span style="width:160px;"><input type="radio" name="userSex" value="男" checked="checked">&nbsp;男&nbsp;&nbsp;&nbsp;&nbsp;
			    <input type="radio" name="userSex" value="女">女</span></div>
			<div><label>电子邮箱：</label><input type="text" class="myinput" id="userEmail" name="userEmail"  onblur="checkEmail()"/><span id="errEmail" style="display:none;color:red;">邮箱格式不正确</span></div> 
			<div><label>基本信息：</label><textarea  id="userBasicInfo" name="userBasicInfo" class="myinput" rows="5"  onblur=""></textarea></div> 
			<br/>
			<div><label></label><input type="submit" class="mybutton"  name="btnSubmit" value="立即注册"  /></div>
		</form>	
	</div>
</body>
</html>
