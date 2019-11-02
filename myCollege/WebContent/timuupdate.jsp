<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>题库更新</title>
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
	<form name="form1" method="post" action="updateTiMuMethod"
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
							<a id="HyperLink1" href="findTiMuType?currentPage=1">返回</a> &nbsp;
						</div></td>
				</tr>
			</table>

			<table width="800" height="450" border="1" align="center"
				bordercolor="#666666">
				<tr>
					<td valign="top" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><table
							width="100%%" border="0">
							<tr bgcolor="#CCFFCC">
								<td colspan="2"><div align="center">修改题型信息</div></td>
							</tr>

							<tr class="font">
								<td width="43%" height="30"><div align="right">
										<span id="Label5">题目编号：</span>&nbsp;
									</div></td>
								<td width="57%" height="30"><span id="Label6">${tiMu.tId}</span>
								  <input type="hidden" id="tId" name="tId" value="${tiMu.tId}"/>
								</td>
							</tr>
							<tr class="font">
								<td height="30"><div align="right">
										<span id="Label1">题目所处问卷编号：</span>
									</div></td>
								<td height="30"><input name="wjId" type="text"
									value="${tiMu.wjId }" id="wjId" /></td>
							</tr>
							<tr class="font">
								<td height="30"><div align="right">
										<span id="Label2">题目对应答案的编号：</span>
									</div></td>
								<td height="30"><input name="xxId" type="text"
									value="${tiMu.xxId }" id="xxId" /></td>
							</tr>
							<tr class="font">
								<td height="30"><div align="right">
										<span id="Label3">题目类型：</span>
									</div></td>
								<td height="30"><input name="wjType" type="text"
									value="${tiMu.wjType }" id="wjType" /></td>
							</tr>
							<tr class="font">
								<td height="30"><div align="right">
										<span id="Label4">题目内容：</span>
									</div></td>
								<td height="30"><input name="tInner" type="text"
									value="${tiMu.tInner }" id="tInner" /></td>
							</tr>
							<tr class="font">
								<td height="30"><div align="right">
										<span id="Label4">题目备注：</span>
									</div></td>
								<td height="30"><input name="tBeiZhu" type="text"
									value="${tiMu.tBeiZhu }" id="tBeiZhu" /></td>
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

		<script type="text/javascript">
		<!--
			var Page_ValidationActive = false;
			if (typeof (ValidatorOnLoad) == "function") {
				ValidatorOnLoad();
			}

			function ValidatorOnSubmit() {
				if (Page_ValidationActive) {
					return ValidatorCommonOnSubmit();
				} else {
					return true;
				}
			}
		// -->
		</script>
	</form>
</body>
</html>
