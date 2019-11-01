<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@page import="org.jfree.chart.plot.PlotOrientation"%>
<%@page import="org.jfree.chart.ChartFactory"%>
<%@page import="org.jfree.chart.JFreeChart"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>问卷题目展示</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
.font {
	font-size: 13px;
}

<!--
body {
	background-image: url(Img/xiao01.jpg);
}
-->
</style>
</head>
<body>


	<form name="form1" method="post" action="saveTiMuXX" id="form1">
		<div></div>

		<div>
			<table width="800" border="0" align="center" bgcolor="#FFFFFF">
				<tr>
					<td style="width: 100%"><div align="center">
							<img src="Img/zxks.jpg" width="481" height="73" />
						</div></td>
				</tr>

				<tr>
					<td class="font" style="height: 21px; width: 100%;">&nbsp;
						<div>
							<table cellspacing="0" cellpadding="4" border="0" id="GridView1"
								style="color: #333333; width: 100%; border-collapse: collapse;">
								<tr
									style="color: White; background-color: #1C5E55; font-weight: bold;">
									<th scope="col"><span id="GridView1_ctl01_Label5">问卷调查</span>
									</th>
									<td><input type="hidden" id="wjId" name="wjId"
										value="${wjId }" /> <input type="hidden" id="userName"
										name="userName" value="${sessionScope.user.userName }" /></td>

								</tr>


							</table>

						</div>
					</td>

				</tr>
				<%
					int i = 0;
				%>
				<c:forEach items="${tiMuList}" var="tiMu">
					<%
						i++;
					%>

					<%
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();

							dataset.addValue(Math.round(Math.random()*100), "xiba", "A");
							dataset.addValue(Math.round(Math.random()*100), "xiba", "B");
							dataset.addValue(Math.round(Math.random()*100), "xiba", "C");
							dataset.addValue(Math.round(Math.random()*100), "xiba", "D");

							JFreeChart chart = ChartFactory.createBarChart3D("Choose", "shepi", "Num", dataset,
									PlotOrientation.VERTICAL, false, false, false);
							String filename = ServletUtilities.saveChartAsJPEG(chart, 300, 200, null, session);

							String graphURL = request.getContextPath() + "/chart/DisplayChart?filename=" + filename;
					%>

					<tr>
						<td style="width: 100%"><span id="GridView1_ctl02_Label1"><%=i%>.</span>
							<span id="GridView1_ctl02_Label2">${tiMu.tInner}</span> <span
							id="GridView1_ctl02_Label3"></span> <span
							id="GridView1_ctl02_Label4"></span></td>
					</tr>
					<tr>

						<td style="width: 400px"><input id="a<%=i%>" type="radio"
							name="a<%=i%>" value="A" /><label>A</label><br />
							<input id="a<%=i%>" type="radio" name="a<%=i%>" value="B" /><label>B</label><br />
							<input id="a<%=i%>" type="radio" name="a<%=i%>" value="C" /><label>C</label><br />
							<input id="a<%=i%>" type="radio" name="a<%=i%>" value="D" /><label>D</label><br /></td>
						<td style="width: 400px">
							<div float="left">
								<img src="<%=graphURL%>" width=300 height=200 border=0
									usemap="#<%=filename%>">
							</div>
						</td>
					</tr>

					<input type="hidden" name="sum" id="">
					<tr>
						<td class="font"
							style="height: 21px; width: 100%; background-color: #FFFFFF"><div></div></td>
					</tr>
				</c:forEach>
				<tr>
					<td>评论：</td>
				</tr>
				<tr>
					<td style="width: 800px"><textarea rows="5" cols="20"
							style="width: 800px" id="pingLun" name="pingLun"></textarea></td>
				</tr>
				<tr>
					<td>

						<p>
							<input type="submit" value="确定" />
						</p>
					</td>
				</tr>
				<%-- <tr>
												<td colspan="7" align="right"><page:pager url="${url}"
														totalPage="${pageInfo.lastPage}"
														currentPage="${pageInfo.pageNum}" /></td>
											</tr> --%>
			</table>
		</div>



	</form>
</body>
</html>
