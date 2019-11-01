<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户更新</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
.font {
	font-size: 13px;
}

<!--
body {
	background-image: url();
	background-color: #C4F4EE;
}
-->
</style>
</head>
<body>
	<form name="form1" method="post" action="updateUserMethod"
		 id="form1">
		<div>
			
		</div>






		<div>
			<table width="800" border="0" align="center">
				<tr>
					<td bgcolor="#FFFFFF"><img src="Img/txgl.jpg" width="485"
						height="66" /></td>
				</tr>
				<tr>
					<td bgcolor="#CCCCCC"><div align="right" class="font">
							<a id="HyperLink1" href="findAllUserByPage?currentPage=1">返回</a> &nbsp;
						</div></td>
				</tr>
			</table>

			<table width="800" height="450" border="1" align="center"
				bordercolor="#666666">
				<tr>
					<td valign="top" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><table
							width="100%%" border="0">
							<tr bgcolor="#CCFFCC">
								<td colspan="2"><div align="center">修改用户信息</div></td>
							</tr>

							<tr class="font">
								<td width="43%" height="30"><div align="right">
										<span id="Label5">用户编号：</span>&nbsp;
									</div></td>
								<td width="57%" height="30"><span id="Label6">${user.userId}</span></td>
							</tr>
							<tr class="font">
								<td height="30"><div align="right">
										<span id="Label1">用户名：</span>
									</div></td>
								<td height="30"><input name="userName" type="text"
									value="${user.userName }" id="userName" /></td>
							</tr>
							<tr class="font">
								<td height="30"><div align="right">
										<span id="Label2">用户密码：</span>
									</div></td>
								<td height="30"><input name="userPassword" type="password"
									value="${user.userPassword }" id="userPassword" readonly="readonly"/></td>
							</tr>
							<tr class="font">
								<td height="30"><div align="right">
										<span id="Label3">用户性别：</span>
									</div></td>
								<td height="30"><input name="userSex" type="text"
									value="${user.userSex }" id="userSex" /></td>
							</tr>
							<tr class="font">
								<td height="30"><div align="right">
										<span id="Label4">用户手机号码：</span>
									</div></td>
								<td height="30"><input name="userPhone" type="text"
									value="${user.userPhone }" id="userPhone" /></td>
							</tr>
							<tr class="font">
								<td height="30"><div align="right">
										<span id="Label4">用户地址：</span>
									</div></td>
								<td height="30"><input name="userAddress" type="text"
									value="${user.userAddress }" id="userAddress" /></td>
							</tr>
							<tr class="font">
								<td height="30"><div align="right">
										<span id="Label4">用户权限：</span>
									</div></td>
								<td height="30"><input name="qx_name" type="text"
									value="${user.qx_name }" id="qx_name" readonly="readonly"/></td>
							</tr>
							<tr>
								<td height="30"><div align="right"></div></td>
								<td height="30"><input type="submit" name="Button1"
									value="确　定"
									
									id="Button1" /></td>
							</tr>
							<tr>
								<td height="30"><div align="right"></div></td>
								<td height="30">&nbsp;</td>
							</tr>
							<tr>
								<td height="30"><div align="right"></div></td>
								<td height="30">&nbsp;</td>
							</tr>
						</table></td>
				</tr>
			</table>
		</div>





		<div>

			<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION"
				value="/wEWBwL0+4SSBgLs0bLrBgKNi6WLBgKSi6WLBgLs0fbZDALs0Yq1BQKM54rGBlVUC0aZ59Pr0FlFup6jXxb8bWaM" />
		</div>


	</form>
</body>
</html>
