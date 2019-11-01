<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head><title>
	题目添加
</title><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><style type="text/css">
.font{font-size:13px;}
<!--
body {
	background-image: url();
	background-color: #C4F4EE;
}
-->
</style>

<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	  
	   $("#wjType").blur(function(){
		   $("#nameTip").remove();
		   var typeValue=$("#wjType").val();
		   
		   if(typeValue==null ||typeValue==""){
			   
			   $("#typeTd").append("<span id='nameTip' style='color:red'>类型不能为空</span>");
			   $("#Button1").attr("disabled","disabled");
		   }else{
			   
			   $("#typeTd").append("<span id='nameTip'  style='color:green'>可以使用</span>");
		        $("#Button1").removeAttr("disabled");
			   
		   }
		   
	   });
	   
});
   

</script>




</head>
<body>
    <form name="form1" method="post" action="AddTiMuMethod"  id="form1">
<div>
<input type="hidden" name="__EVENTTARGET" id="__EVENTTARGET" value="" />
<input type="hidden" name="__EVENTARGUMENT" id="__EVENTARGUMENT" value="" />
<input type="hidden" name="__LASTFOCUS" id="__LASTFOCUS" value="" />
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKMTc5MTY2OTc1Mg9kFgICAw9kFgICBQ8QDxYGHg1EYXRhVGV4dEZpZWxkBQROQU1FHg5EYXRhVmFsdWVGaWVsZAUCSUQeC18hRGF0YUJvdW5kZ2QQFQcJ5Y2V6YCJ6aKYCeWkmumAiemimAnliKTmlq3popgJ6L6o5p6Q6aKYCeeugOetlOmimAnor7TmmI7popgG6Kej6YeKFQcBMQEyATMBNAE1ATYBOBQrAwdnZ2dnZ2dnFgFmZGRG+FYrQhDMUdDxxq1avPYwlovdZQ==" />
</div>






    <div>
      <table width="800"  border="0" align="center">
        <tr>
          <td bgcolor="#FFFFFF"><img src="Img/tkgl.jpg" width="485" height="66" /></td>
        </tr>
        <tr>
          <td bgcolor="#CCCCCC"><div align="right" class="font">
              <a id="HyperLink1" href="findTiMuByPage?currentPage=1">返回</a>
&nbsp;</div></td>
        </tr>
      </table>
    
      <table width="800" height="450"  border="1" align="center" bordercolor="#666666" bgcolor="#FFFFFF">
        <tr>
          <td valign="top" bordercolor="#FFFFFF"><table width="100%%"  border="0">
            <tr bgcolor="#CCFFCC">
              <td colspan="2"><div align="center">添加题目信息</div></td>
            </tr>
            <tr>
              <td width="42%" height="30"><div align="right"></div></td>
              <td width="58%" height="30">&nbsp;</td>
            </tr>
             <tr class="font">
              <td height="30"><div align="right">
                  <span id="Label1"></span></div></td>
              <td height="30" id="typeTd" >&nbsp;<input type="hidden"name="xxId" id="xxId" />
	          </td>


                  
            </tr>
            <tr class="font">
              <td height="30"><div align="right">
                  <span id="Label1">题目类型：</span></div></td>
              <td height="30" id="typeTd" >&nbsp;<input type="text"name="wjType" id="wjType" />
	          </td>


                  
            </tr>
            <tr class="font">
              <td height="30" valign="top"><div align="right">
                <span id="Label2">题目内容：</span></div></td>
              <td height="30">&nbsp;<textarea name="tInner" rows="2" cols="20" id="tInner" style="height:71px;width:266px;"></textarea>
                 </td>
            </tr>
            <tr class="font">
              <td height="30"><div align="right">
                  <span id="Label3">题目备注：</span></div></td>
              <td height="30">&nbsp;<input name="tBeiZhu" type="text" id="tBeiZhu" /></td>
            </tr>
            <tr class="font">
              <td style="height: 30px"><div align="right">
                  &nbsp;</div></td>
              <td style="height: 30px">&nbsp;</td>
            </tr>
            <tr class="font">
              <td style="height: 30px"><div align="right"></div></td>
              <td style="height: 30px">&nbsp;<input type="submit" name="Button1" value="确定添加"  id="Button1" />
              </td>
            </tr>
            <tr>
              <td style="height: 30px"><div align="right"></div></td>
              <td style="height: 30px">&nbsp;</td>
            </tr>
            <tr>
              <td style="height: 30px"><div align="right"></div></td>
              <td style="height: 30px">&nbsp;</td>
            </tr>
            <tr>
              <td style="height: 30px"><div align="right"></div></td>
              <td style="height: 30px">&nbsp;</td>
            </tr>
          </table></td>
        </tr>
      </table>
      </div>
    


<div>

	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWDAKzl/rUCAKd5I/lCgKSi6WLBgKTi6WLBgKQi6WLBgKRi6WLBgKWi6WLBgKXi6WLBgKFi6WLBgLs0bLrBgLs0fbZDAKM54rGBjlBOJ6GYovh6gySha6NrN4gx/jL" />
</div>

<script type="text/javascript">
<!--
var Page_ValidationActive = false;
if (typeof(ValidatorOnLoad) == "function") {
    ValidatorOnLoad();
}

function ValidatorOnSubmit() {
    if (Page_ValidationActive) {
        return ValidatorCommonOnSubmit();
    }
    else {
        return true;
    }
}
// -->
</script>
        </form>
</body>
</html>
