<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>问卷管理</title>
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
			if (obj[i].name == "userId") {
				obj[i].checked = true;
			}
		}
		return false;
	}
	//全部取消
	function unselectAll() {
		var obj = document.form.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "userId") {
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
				window.location = "deleteWenJuanMethod?wjId="+id;
			} else { // 把type的值设为'delete' 提交表单进行多个删除
				alert(id);
				var queryForm = document.getElementById("form");
				queryForm.method = "post";
				queryForm.action = "delAllWenJuanMethod";
				queryForm.submit();
			}
		}

	}
	

</script>

</head>

<body>
	<form id="form" name="form" action="findWenJuanLikeName?currentPage=1" method="post">
		<div>
			
		</div>




		<div>
			<table width="800" border="0" align="center">
				<tr>
					<td bgcolor="#FFFFFF"><img src="Img/txgl.jpg" width="800"
						height="66" /></td>
				</tr>
				<tr>
					<td bgcolor="#CCCCCC"><div align="right" class="font">
							<a id="HyperLink1" href="manage.jsp">返回</a> &nbsp;
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
								<td bgcolor="#CCFFCC" style="width: 580px">问卷浏览</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF" class="font" style="width: 580px"><span
									id="Label2">请输入想要查询的关键字:</span> 
									<input type="text" id="wjName"  name="wjName" />
									 <input type="submit" value="确认查询" />
									 
									 </td>
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
												<th width="10%"><a href="" class="right-font08"
													onclick="return selectAll();">全选</a>/ <a href=""
													class="right-font08" onclick="return unselectAll();">反选</a>
												</th>

												<th align="center" scope="col" width="10%">问卷ID</th>
												<th align="center" scope="col" width="10%">问卷名</th>
												<th align="center" scope="col" width="10%">问卷数目</th>
												<th align="center" scope="col" width="10%">问卷类型</th>
												<th align="center" scope="col" width="13%">问卷备注</th>
												<th align="center" scope="col" width="10%">问卷作者</th>
												<th align="center" scope="col" width="15%">问卷发布时间</th>
												<th align="center" scope="col" width="12%">操作</th>
											</tr>
											<c:forEach items="${pageInfo.list }" var="wenJuan">
												<tr
													style="color: black; background-color: write; font-weight: bold;">
													<td align="center"><input type="checkbox"
														name="userId" id="userId" value="${wenJuan.wjId}" /></td>
													<td align="center">${wenJuan.wjId}</td>
													<td align="center">${wenJuan.wjName}</td>
													<td align="center">${wenJuan.wjNum}</td>
													<td align="center">${wenJuan.wjType}</td>
													<td align="center">${wenJuan.wjBeiZhu}</td>
													<td align="center">${wenJuan.wjAuthor}</td>
													<td align="center">${wenJuan.wjTime}</td>
													<td align="center"> <a
														href="deleteWenJuanMethod?wjId=${wenJuan.wjId }" >删除</a></td>



												</tr>

											</c:forEach>
											<tr>
												<td colspan="7" align="right">
												<page:pager url="${url}"
														totalPage="${pageInfo.lastPage}"
														currentPage="${pageInfo.pageNum}" /></td>
											</tr>

										</table>


									</div>
								</td>
							</tr>
							<tr>
								<td bgcolor="#CCCCCC" class="font"
									style="width: 580px; height: 21px"><div align="center"></div></td>
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

