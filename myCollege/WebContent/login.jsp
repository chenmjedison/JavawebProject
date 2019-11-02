<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head><title>
	用户登录
</title><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><style type="text/css">
<!--
body {
	background-image: url(Img/back.jpg);
}
.style1 {font-size: 13px}
-->
</style></head>
<body>
    
<div>
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="" />
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="" />
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKMTYxOTE4NjkyMmRkTHYCYgJQo0Ucow8zDaPS+Q+xSGQ=" />
</div>








    <div>
      <table width="800" align="center" >
        <tr>
          <td bgcolor="#FFFFFF"><div align="center"><img src="Img/666.jpg" width="481" height="73" /></div></td>
        </tr>
        <tr>
          <td bgcolor="#D7D6F8">&nbsp;
         </td>
        </tr>
      </table>
    
    <table width="800" height="450" align="center" >
        <tr>
          <td bgcolor="#CCCCCC"><table width="100%" bgcolor="#FFFFFF" >
            <tr>
              <td width="60%" height="450" background="Img/login.jpg">&nbsp; &nbsp; &nbsp;
              <span style="color:red;">${msg }</span>
             <form action="loginMethod" method="post">
                <table width="100%" >
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
                    <td style="width: 298px"><div align="right"></div></td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td style="width: 298px"><div align="right" class="style1">
                        <span id="Label2" style="display:inline-block;width:48px;">帐号:</span>&nbsp;</div></td>
                    <td>&nbsp;<input name="userName" type="text" id="userName" style="width:118px;" />
                  </tr>
                  <tr>
                    <td style="width: 298px"><div align="right">
                        &nbsp;</div></td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td style="width: 298px"><div align="right" class="style1">
                        <span id="Label3" style="display:inline-block;width:46px;">密码:</span>&nbsp;</div></td>
                    <td>&nbsp;<input name="userPassword" type="password" id="userPassword" style="width:118px;" />
                  </tr>
                  <tr>
                    <td style="width: 298px"><div align="right">
                        &nbsp;</div></td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td style="width: 298px"><div align="right" class="style1">
                        <span id="Label3" style="display:inline-block;width:46px;">身份:</span>&nbsp;</div></td>
                    <td>&nbsp;<select name="qx_name"  id="qx_name" style="width:118px;" >
                     <option value="普通用户">普通用户</option>
                     <option value="管理员">管理员</option>
                     <option value="超级管理员">超级管理员</option>
                     
                    </select>
                  </tr>
                  <tr>
                    <td style="width: 298px">&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td style="width: 298px">&nbsp;</td>
                    <td>&nbsp;<input type="submit" name="Button1" value="登录"  id="Button1" />&nbsp;&nbsp;
                    <a href="register.jsp"><input type="button" name="Button2" value="注册"  id="Button1" /></a></td>
                 
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
                </form>
                </td>
            </tr>
          </table></td>
        </tr>
      </table>
    </div>
    


<div>

	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWBALrgPYIAuzRsusGAuzR9tkMAoznisYGh7vHkGfT0WPt77ftwpSTeDATCqQ=" />
</div>


        
</body>
</html>