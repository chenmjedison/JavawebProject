<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head><title>
	无标题页
</title><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><style type="text/css">
<!--
body {
	background-image: url(Img/back.jpg);
}
.style1 {font-size: 13px}
-->
</style></head>
<body>
    <form name="form1" method="post" action="Manage.aspx" id="form1">
<div>
</div>

    <div>
      <table width="80%" align="center" >
        <tr>
          <td colspan="8" bgcolor="#FFFFFF"><div align="center"><img src="Img/systemManage.jpg" width="514" height="85" /></div></td>
        </tr>
        <tr class="style1">
          <td width="13%" bordercolor="#D9D8F5" bgcolor="#D9D8F5" style="height: 18px">&nbsp;<a id="HyperLink1" href="findAllWenJuanByPage?currentPage=1" style="display:inline-block;width:62px;">问卷管理</a></td>
        <td width="13%" bordercolor="#D9D8F5" bgcolor="#D9D8F5" style="height: 18px">&nbsp;<a id="HyperLink2" href="findTiMuByPage?currentPage=1" style="display:inline-block;width:69px;">题库管理</a></td>
          <td width="13%" bordercolor="#D9D8F5" bgcolor="#D9D8F5" style="height: 18px">&nbsp;<a id="HyperLink3" href="findAllWenJuanShow?currentPage=1" style="display:inline-block;width:73px;">问卷生成</a></td>
          <td width="13%" bordercolor="#D9D8F5" bgcolor="#D9D8F5" style="height: 18px">&nbsp;<a id="HyperLink4" href="findAllPingLun?currentPage=1" style="display:inline-block;width:74px;">评论管理</a></td>
          <td width="13%" bordercolor="#D9D8F5" bgcolor="#D9D8F5" style="height: 18px">&nbsp;<a id="HyperLink5" href="findAllUserByPage?currentPage=1" style="display:inline-block;width:72px;">用户管理</a></td>
          <td width="12%" bordercolor="#D9D8F5" bgcolor="#D9D8F5" style="height: 18px">&nbsp;<a id="HyperLink6" href="findAllManageByPage?currentPage=1" style="display:inline-block;width:71px;">管理员管理</a></td>
          <td width="11%" bordercolor="#D9D8F5" bgcolor="#D9D8F5" style="height: 18px"><div align="right">
              <a  name="Button1"  id="Button1" style="background-color:RoyalBlue;" href="closeMethod">安全退出</a>&nbsp;</div></td>
        </tr>
        <tr>
          <td colspan="8" bgcolor="#CCCCCC"><table width="100%" height="450" bgcolor="#FFFFFF" >
            <tr>
              <td width="60%" bgcolor="#CCFFCC" style="height: 21px">&nbsp;</td>
              <td width="40%" bgcolor="#CCFFCC" style="height: 21px">&nbsp;</td>
            </tr>
            <tr>
              <td colspan="2"><img src="Img/manage.jpg" width="1100" height="550" /></td>
            </tr>
          </table></td>
        </tr>
      </table>
      <p>&nbsp;</p>
      </div>
    
<div>

	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWAgKt8OJ/AoznisYGG3kt0XCHfhp/d7EGaQSGl+mcr9M=" />
</div></form>
</body>
</html>
