<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>题库管理</title>
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

	function deleteTiMu(id) {
		if (confirm('确认删除?')) {
			if (id != undefined) { //如果有id则删除单个
				alert("111");
				window.location = "delTiMuMethod?tId="+id;
				alert("333");
			} else { // 把type的值设为'delete' 提交表单进行多个删除
				alert("222");
				var queryForm = document.getElementById("form");
				queryForm.method = "post";
				queryForm.action = "delAllTiMuMethod";
				queryForm.submit();
			}
		}

	}
	

</script>

</head>

<body>
	<form id="form" name="form" action="findTiMuType?currentPage=1" method="post">
		<div>
			
		</div>




		<div>
			<table width="800" border="0" align="center">
				<tr>
					<td bgcolor="#FFFFFF"><img src="Img/tkgl.jpg" width="485"
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
					<td width="1%" align="center" valign="top" bgcolor="#CCCCCC"><table
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
					<td width="99%" valign="top">

						<table width="100%%" border="0">
							<tr>
								<td bgcolor="#CCFFCC" style="width: 580px">题库浏览</td>
							</tr>
							<tr>
								<td bgcolor="#FFFFFF" class="font" style="width: 580px"><span
									id="Label2">请选择题型类别:</span> <select name="selectType"
									id="selectType">
										<c:forEach items="${tiMuList }" var="tiMu">
											<option value="${tiMu.wjType }">${tiMu.wjType }</option>
										</c:forEach>



								</select> <input type="submit" value="确认查询" /></td>
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

												<th align="center" scope="col" width="10%">题目ID</th>
												<th align="center" scope="col" width="10%">问卷ID</th>
												
												<th align="center" scope="col" width="10%">题目类型</th>
												<th align="center" scope="col" width="20%">题目内容</th>
												<th align="center" scope="col" width="18%">题目备注</th>
												<th align="center" scope="col" width="12%">操作</th>
											</tr>
											<c:forEach items="${pageInfo.list }" var="tiMu">
												<tr
													style="color: black; background-color: write; font-weight: bold;">
													<td align="center"><input type="checkbox"
														name="userId" id="userId" value="${tiMu.tId}" /></td>
													<td align="center">${tiMu.tId}</td>
													<td align="center">${tiMu.wjId}</td>
												
													<td align="center">${tiMu.wjType}</td>
													<td align="center">${tiMu.tInner}</td>
													<td align="center">${tiMu.tBeiZhu}</td>
													<td align="center"><a
														href="findTiMuByIdMethod?tId=${tiMu.tId }">修改</a> <a
														href="delTiMuMethod?tId=${tiMu.tId }" >删除</a></td>



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
									style="width: 580px; height: 21px"><div align="center"><a href="timuadd.jsp">添加题目</a></div></td>
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

