<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tree.jsp' starting page</title>
    <link rel="stylesheet" href="dtree.css" type="text/css"/>
    <script type="text/javascript" src="dtree.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div class="dtree"></div>
   <h2>树形菜单dtree组件的例子</h2>
   <p><a href="javascript:d.openAll();">全部展开</a>|<a href="javascript:d.closeAll()">全部折叠</a></p>
   <script type="text/javascript">
	   d=new dTree('d');
	   d.add(0,-1,'我的树形菜单');
	   d.add(1,0,'节点1','tree.jsp');
	   d.add(2,0,'节点2','tree.jsp');
	   d.add(3,1,'节点1.1','tree.jsp');
	   d.add(4,0,'节点3','tree.jsp');
	   d.add(5,3,'节点1.1.1','tree.jsp');
	   d.add(6,5,'节点1.1.1.1','tree.jsp');
	   d.add(7,0,'节点4','tree.jsp');
	   d.add(8,1,'节点1.2','tree.jsp');
	   d.add(9,0,'我的相册','tree.jsp','这是我的相册','','','img/imgfolder.gif');
	   d.add(10,9,'我的生日','tree.jsp','我的生日照片');
	   d.add(11,9,'北京旅游','tree.jsp');
	   d.add(12,0,'回收站','tree.jsp','','','img/trash.gif');
	   document.write(d);
   </script>
  </body>
</html>
