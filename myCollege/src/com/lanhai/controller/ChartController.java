package com.lanhai.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanhai.utils.ChartUtil;


@Controller
@RequestMapping(value="/chart")
public class ChartController {
	
	
	//显示柱状图
	@RequestMapping(value="/showBar3D")
	public String showBar3D(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		
		response.setContentType("text/html;charset=utf-8");//设置服务器响应客户端的内容的格式和编码
		
		HttpSession session=request.getSession(); //获取session
		
		
		PrintWriter pw=response.getWriter();//打印输出流 (写的方法  write)
		
		//jfreechart-3278084056632649744.png
		String fileName=ChartUtil.createBarChart(session, pw);//就是一张png图片的文件名
		//String fileName=ChartUtil.createPieDataset(session, pw);
		
		//请求在web.xml文件中配置的servlet(DisplayChart)的路径 (传递了一个参数给这个Servlet，需要显示的文件名)
		String filePath = request.getContextPath() + "/chart/DisplayChart?filename=" + fileName;		

		System.out.println(filePath);
		
		model.addAttribute("filePath", filePath);
		
		return "xiashitu2";//跳转到 jfreechartTest.jsp页面
	}

}
