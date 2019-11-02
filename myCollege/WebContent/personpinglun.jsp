<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户评论管理</title>
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
.beijing {
	background: #E3EAEB;
}
</style>

<script type="text/javascript">
	//全部选择
	function selectAll() {

		var obj = document.form.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "manageId") {
				obj[i].checked = true;
			}
		}
		return false;
	}
	//全部取消
	function unselectAll() {
		var obj = document.form.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "manageId") {
				if (obj[i].checked == true)
					obj[i].checked = false;
				else
					obj[i].checked = true;
			}
		}
		return false;
	}

	function deleteWenJuan(id) {
		if (confirm('确认删除?')) {
			if (id != undefined) { //如果有id则删除单个
				alert("111");
				window.location = "deleteManageMethod?manageId=" + id;
				alert("333");
			} else { // 把type的值设为'delete' 提交表单进行多个删除
				alert("222");
				var queryForm = document.getElementById("form");
				queryForm.method = "post";
				queryForm.action = "delAllManageMethod";
				queryForm.submit();
			}
		}

	}
</script>

</head>

<body>
	<form id="form" name="form" action="findManageLikeName?currentPage=1"
		method="post">
		<div></div>




		<div>
			<table width="800" border="0" align="center">
				<tr>
					<td bgcolor="#FFFFFF"><img src="Img/pinglun.jpg" width="800"
						height="66" /></td>
				</tr>
				<tr>
					<td bgcolor="#CCCCCC"><div align="right" class="font">
							<a id="HyperLink1" href="findAllWenJuanIndex?currentPage=1">返回</a> &nbsp;
						</div></td>
				</tr>
			</table>

			<table width="800" height="450" border="1" align="center"
				bordercolor="#666666" bgcolor="#FFFFFF">
				<tr bordercolor="#FFFFFF">
					<td width="15%" align="center" valign="top" bgcolor="#CCCCCC"><table
							width="100%%" border="0">
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
						</table></td>
					<td width="85%" valign="top">

						<table width="100%%" border="0">
							<tr>
								<td bgcolor="#CCFFCC" style="width: 580px">评论浏览</td>
							</tr>
							<tr>
								
							</tr>
							<tr>
								<td class="font" style="width: 580px; text-align: right">&nbsp;
									<span id="Label1" style="font-size: Small;"></span>
									<div>
										<table cellspacing="0" cellpadding="4" border="0"
											id="theme_table"
											style="color: #333333; width: 100%; border-collapse: collapse; font: center">

											<tr
												style="color: black; background-color: write; font-weight: bold;">
												<th width="15%"><a href="" class="right-font08"
													onclick="return selectAll();">全选</a>/ <a href=""
													class="right-font08" onclick="return unselectAll();">反选</a>
												</th>

												<th align="center" scope="col" width="10%">评论Id</th>
												<th align="center" scope="col" width="10%">评论人</th>
												<th align="center" scope="col" width="15%">评论问卷</th>
												<th align="center" scope="col" width="15%">评论内容</th>
												<th align="center" scope="col" width="10%">评论时间</th>
											
											</tr>
											<c:forEach items="${pageInfo.list }" var="pingLun">
												<tr
													style="color: black; background-color: write; font-weight: bold;">
													<td align="center"><input type="checkbox"
														name="manageId" id="manageId" value="${pingLun.plId}" /></td>
													<td align="center">${pingLun.plId}</td>
													<td align="center">${pingLun.userName}</td>
													<td align="center">${pingLun.wjId}</td>
													<td align="center">${pingLun.plInner}</td>
													<td align="center">${pingLun.plTime}</td>

													



												</tr>

											</c:forEach>
											<tr>
												<td colspan="7" align="right"><page:pager url="${url}"
														totalPage="${pageInfo.lastPage}"
														currentPage="${pageInfo.pageNum}" /></td>
											</tr>

										</table>


									</div>
								</td>
							</tr>
							<tr>
								<td bgcolor="#CCCCCC" class="font"
									style="width: 580px; height: 21px"><div align="center">
										
									</div></td>
							</tr>
							<tr>
								<td class="font"
									style="width: 580px; height: 51px; text-align: left"><table
										width="100%%" border="0">

									</table></td>
							</tr>
							<tr>
								<td style="width: 580px">&nbsp;</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>

		<div>
	</form>
</body>
</html>

