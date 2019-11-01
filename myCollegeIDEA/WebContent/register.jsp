<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
<!--
body {
	background-image: url(Img/back.jpg);
}

.style1 {
	font-size: 13px
}
-->
</style>
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#userName")
				.blur(
						function() {
							$("#nameTip").remove();
							var nameValue = $("#userName").val();
							if (nameValue != null && nameValue != "") {
								//发送ajax请求 根据用户名去用户表中查询用户是否存在
								$
										.post(
												"checkUserMethod",
												{
													"userName" : nameValue
												},
												function(data) {
													if (data == null) {
														alert("可以使用");
														$("#nameTD")
																.append(
																		"<span id='nameTip' style='font-size: 10px;color:green;'>可以使用</span>");

													} else {
														alert("用户已经存在，不能注册");
														$("#nameTD")
																.append(
																		"<span id='nameTip'  style='font-size: 10px;color:red;'>用户已经存在,不能注册</span>");
													}
												}, "json");
							}
						});
	});
	
	
</script>

</head>
<body>

	<div>
		<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="" />
		<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT"
			value="" /> <input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE"
			value="/wEPDwUKMTYxOTE4NjkyMmRkTHYCYgJQo0Ucow8zDaPS+Q+xSGQ=" />
	</div>






	<div>
		<table width="800" align="center">
			<tr>
				<td bgcolor="#FFFFFF"><div align="center">
						<img src="Img/666.jpg" width="481" height="73" />
					</div></td>
			</tr>
			<tr>
				<td bgcolor="#D7D6F8">&nbsp; <a id="HyperLink1"
					href="login.jsp"><span class="style1">返回</span></a></td>
			</tr>
		</table>

		<form action="addUserMethod" method="post">
			<table width="800" height="450" align="center">
				<tr>
					<td bgcolor="#CCCCCC"><table width="100%" bgcolor="#FFFFFF">
							<tr>
								<td width="60%" height="450" background="Img/login.jpg">&nbsp;
									&nbsp; &nbsp; <span>${sessionScope.register_error_info }</span>



									<table width="100%">
										<tr>
											<td style="width: 298px">&nbsp;</td>
											<td width="452">&nbsp;</td>
										</tr>
										<tr>
											<td style="width: 298px">&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td style="width: 298px">&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td style="display: inline-block; width: 48px;"><div
													align="right"></div></td>
											<td>&nbsp;</td>
										</tr>

										<tr>
											<td style="width: 298px"><div align="right"
													class="style1">
													<span id="Label2"
														style="display: inline-block; width: 100px;"
														placeholder="请输入账号...">帐号：</span>&nbsp;
												</div></td>
											<td id="nameTD">&nbsp;<input name="userName" type="text"
												id="userName" style="width: 118px;" />
											</td>
										</tr>

										<tr>
											<td style="width: 298px"><div align="right"
													class="style1">
													<span id="Label3"
														style="display: inline-block; width: 100px;">密码：</span>&nbsp;
												</div></td>
											<td>&nbsp;<input name="userPassword" type="password"
												id="userPassword" style="width: 118px;" />
											</td>
										</tr>

										<tr>
											<td style="width: 298px"><div align="right"
													class="style1">
													<span id="Label3"
														style="display: inline-block; width: 100px;">性别：</span>&nbsp;
												</div></td>
											<td>&nbsp;男<input name="userSex" type="radio" id="userSex" value="男"
												 />女<input name="userSex" type="radio" id="userSex" value="女"
												 />
											</td>
										</tr>
										<tr>
											<td style="width: 298px"><div align="right"
													class="style1">
													<span id="Label3"
														style="display: inline-block; width: 100px;">电话号码：</span>&nbsp;
												</div></td>
											<td>&nbsp;<input name="userPhone" type="text"
												id="userPhone" style="width: 118px;"
												placeholder="请输入电话号码..." />
											</td>
										</tr>

										<tr>
											<td style="width: 298px"><div align="right"
													class="style1">
													<span id="Label3"
														style="display: inline-block; width: 100px;">用户地址：</span>&nbsp;
												</div></td>
											<td>&nbsp;<input name="userAddress" type="text"
												id="userAddress" style="width: 118px;"
												placeholder="请输入用户地址.." />
											</td>
										</tr>
										<tr>
											<td style="width: 298px"><div align="right"
													class="style1">
													<span id="Label3"
														style="display: inline-block; width: 100px;">用户身份：</span>&nbsp;
												</div></td>
											<td>&nbsp;<input type="text" name="qx_name" id="qx_name"
												style="width: 118px;" value="普通用户" readonly="readonly" />
											</td>
										</tr>


										<tr>
											<td style="width: 298px">&nbsp;</td>
											<td>&nbsp;<input type="submit" value="注册" /></td>
										</tr>
										<tr>
											<td style="width: 298px">&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td style="width: 298px">&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td style="width: 298px">&nbsp;</td>
											<td>&nbsp;</td>
										</tr>
									</table>
								</td>

							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>