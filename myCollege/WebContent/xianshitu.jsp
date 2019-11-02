<%@page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@page import="org.jfree.chart.plot.PlotOrientation"%>
<%@page import="org.jfree.chart.ChartFactory"%>
<%@page import="org.jfree.chart.JFreeChart"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.jfree.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  DefaultCategoryDataset dataset=new DefaultCategoryDataset();

  dataset.addValue(120, "xiba", "A");
  dataset.addValue(130, "xiba", "B");
  dataset.addValue(110, "xiba", "C");
  dataset.addValue(140, "xiba", "D");
  
  JFreeChart chart=ChartFactory.createBarChart3D("Choose", "shepi",
		     "Num",
		     dataset, 
             PlotOrientation.VERTICAL ,
             false, false, false);
  String filename=ServletUtilities.saveChartAsJPEG(chart, 500, 300, null, session);
  
  String graphURL=request.getContextPath()+"/chart/DisplayChart?filename="+filename;
%>

<img src="<%=graphURL %>" width=500 height=300 border=0 usemap="#<%=filename %>" >

    <a href="chart/showBar3D">showBar3D</a>
    
    
    <img src="${filePath}"/>

</body>
</html>