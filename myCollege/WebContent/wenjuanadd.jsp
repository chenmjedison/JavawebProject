
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>问卷的生成</title>
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

<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
  function bianhao() {
	  wj=document.getElementById("wjId");
	  var a=Math.ceil(Math.random()*100000);
	  var b="lanhai";
	  wj.value=a+b;
	  
	  
	  
	  
	  
}

</script>
</head>
<body>
	<form name="form1" method="post" action="addWenJuan"
		 id="form1">
		<div>
			
		</div>








		<div>
			<table width="800" border="0" align="center">
				<tr>
					<td bgcolor="#FFFFFF"><img src="Img/txgl.jpg" width="450"
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
					<td width="22%" align="center" valign="top" bgcolor="#CCCCCC"><table
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
						</table></td>
					<td width="78%" valign="top"><table width="100%%" border="0">
							<tr>
								<td bgcolor="#CCFFCC" style="height: 20px"><div
										align="left">问卷浏览</div></td>
							</tr>
							<tr>
								<td>
									<div align="right" class="font">
										
										<div>
											<table cellspacing="0" cellpadding="4" border="0"
												id="GridView1"
												style="color: #333333; width: 100%; border-collapse: collapse;">


												<tr>
													<td class="font" style="width: 580px; text-align: right">&nbsp;
														<span id="Label1" style="font-size: Small;"></span>
														<div>
															<table cellspacing="0" cellpadding="4" border="0"
																id="theme_table"
																style="color: #333333; width: 100%; border-collapse: collapse; font: center">

																<tr
																	style="color: black; background-color: write; font-weight: bold;">
																	<th align="center" scope="col" width="10%">问卷ID</th>
																	<th align="center" scope="col" width="10%">问卷名</th>
																	<th align="center" scope="col" width="10%">问卷数目</th>
																	<th align="center" scope="col" width="10%">问卷类型</th>
																	<th align="center" scope="col" width="13%">问卷备注</th>
																	<th align="center" scope="col" width="10%">问卷作者</th>
																	<th align="center" scope="col" width="15%">问卷发布时间</th>
																	
																</tr>
																<c:forEach items="${pageInfo.list }" var="wenJuan">
																	<tr
																		style="color: black; background-color: write; font-weight: bold;">
																		<td align="center">${wenJuan.wjId}</td>
																		<td align="center">${wenJuan.wjName}</td>
																		<td align="center">${wenJuan.wjNum}</td>
																		<td align="center">${wenJuan.wjType}</td>
																		<td align="center">${wenJuan.wjBeiZhu}</td>
																		<td align="center">${wenJuan.wjAuthor}</td>
																		<td align="center">${wenJuan.wjTime}</td>
																		



																	</tr>

																</c:forEach>
																<tr>
																	<td colspan="7" align="right"><page:pager
																			url="${url}" totalPage="${pageInfo.lastPage}"
																			currentPage="${pageInfo.pageNum}" /></td>
																</tr>
															</table>
														</div> &nbsp;&nbsp;
										</div>
								</td>
							</tr>
							<tr>
								<td bgcolor="#CCFFCC"><span id="Label4"
									style="display: inline-block; width: 558px;">问卷定义(请按照要求生成问卷)</span>
								</td>
							</tr>
							<tr>
								<td style="height: 21px">
									<div align="center" class="font">
										<input type="button" name="Button1" value="生成试卷编号"
											id="Button1" style="width: 87px;" onclick="bianhao()"/> <input name="wjId"
											type="text"  id="wjId" />
									</div>
								</td>
							</tr>
							<tr>
								<td style="height: 22px">
									<div align="center" class="font">

										<div>
											<table cellspacing="1" cellpadding="3" border="0"
												id="GridView2"
												style="background-color: White; border-color: White; border-width: 2px; border-style: Ridge; width: 319px;">
												<tr
													style="color: #E7E7FF; background-color: #4A3C8C; font-weight: bold;">
													<th align="center" scope="col" style="width: 70px;">属性</th>
													<th align="left" scope="col">要求</th>
												</tr>
												<tr style="color: Black; background-color: #DEDFDE;">
													<td align="center" style="width: 70px;">问卷名称：</td>
													<td align="left"><input
														name="wjName" type="text"
														id="wjName" style="width: 128px;" />&nbsp;
														&nbsp;

													</td>
												</tr>
												<tr style="color: Black; background-color: #DEDFDE;">
													<td align="center" style="width: 120px;">问卷题目的数量：</td>
													<td align="left"><input
														name="wjNum" type="text"
														id="wjNum" style="width: 128px;" />&nbsp;
														&nbsp;

													</td>
												</tr>
												<tr style="color: Black; background-color: #DEDFDE;">
													<td align="center" style="width: 120px;">问卷类型</td>
													<td align="left"><select
														name="wjType" 
														id="wjType" style="width: 128px;" >
														<c:forEach items="${tiMuList}" var="wenJuan">
														   <option value="${wenJuan.wjType}">${wenJuan.wjType}</option>
														</c:forEach>
														</select>

													</td>
												</tr>
												<tr style="color: Black; background-color: #DEDFDE;">
													<td align="center" style="width: 120px;">问卷备注：</td>
													<td align="left"><input
														name="wjBeiZhu" type="text"
														id="wjBeiZhu" style="width: 128px;"  />&nbsp;
														&nbsp;

													</td>
												</tr>
												<tr style="color: Black; background-color: #DEDFDE;">
													
													<td align="left"><input
														name="wjAuthor" type="hidden"
														id="wjAuthor" style="width: 128px;"value="${sessionScope.manage.manageName }" />&nbsp;
														&nbsp;

													</td>
													<td align="left"><input
														name="wjTime" type="hidden"
														id="wjTime" style="width: 128px;" />&nbsp;
														&nbsp;

													</td>
												</tr>
											</table>
										</div>
									</div>
								</td>
							</tr>
							
							<tr>
								<td style="height: 21px"><div align="center">
										<input type="submit" name="Button2" value="提交问卷"
											id="Button2" style="width: 68px;" /> &nbsp;
									</div></td>
							</tr>
							<tr>
								<td><div align="center">&nbsp;</div></td>
							</tr>
						</table></td>
				</tr>
			</table>
		</div>





		<div>

			<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION"
				value="/wEWCAK1pYWNCALKhd6PCwK1g9XiCAL4wL+mAwKTyLP9DAKM54rGBgLs0fbZDAK7q7GGCICJntsvKtU+fwVbzxVCOAUmMxUW" />
		</div>


	</form>
</body>
</html>
