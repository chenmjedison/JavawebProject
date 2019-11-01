package com.lanhai.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lanhai.pojo.Manage;
import com.lanhai.service.ManageService;
@Controller
public class ManageController {
	
	
	@Autowired
	private ManageService manageService;
	
	
	
	
	public void setManageService(ManageService manageService) {
		this.manageService = manageService;
	}

		// 添加员工
		@RequestMapping(value = "/addManageMethod", method = RequestMethod.POST)
		public String addManageMethod(@ModelAttribute Manage manage, Model model) {
			System.out.println(manage);
			manageService.saveManage(manage);
			return "redirect:findAllManageByPage?currentPage=1";
		}

		// 登录验证

		// 根据员工名查询员工进行验证
		// 员工是否存在
		@RequestMapping(value = "/checkmanageMethod")
		@ResponseBody
		//对网页传来的ajax数据自动转换
		public Manage checkManageMethod(String manageName) {
			return manageService.findManageByName(manageName);
			
		}

		
		
		//根据员工名进行模糊查询
		@RequestMapping(value="/findManageLikeName")
		public String findManageLikeName(String checkName,int currentPage,Model model){
			System.out.println("我是员工模糊查询额方法"+checkName+"----"+currentPage);
			PageInfo<Manage> pageInfo=manageService.findManageLikeName(checkName, currentPage);
			model.addAttribute("pageInfo", pageInfo);
			System.out.println("我是员工模糊查询的方法");
			System.out.println("搜索关键字"+checkName);
			model.addAttribute("url", "findmanageLikeName?checkName="+checkName);
			return "managelist";
		}
		
		//根据id进行删除
		@RequestMapping(value="/deleteManageById")
		public String deleteManageById(Integer manageId){
			int a=manageService.deleteManageById(manageId);
			System.out.println("我是删除方法  I的值"+a);
			return "redirect:findAllManageByPage?currentPage=1";
		}
		
		//根据id查询员工
		@RequestMapping(value="/findManageById")
		public String findManageById(Integer manageId,Model model){
			Manage manage=manageService.findManageById(manageId);
			model.addAttribute("manage", manage);
			return "manageupdate";
		}
		//根据id 进行修改员工
		@RequestMapping(value="/updateManageMethod")
		public String updateManageMethod(@ModelAttribute Manage manage,Model model){
			manageService.updateManage(manage);
			return "redirect:findAllManageByPage?currentPage=1";
		}
		
		//分页查询所有
		@RequestMapping(value="/findAllManageByPage")
		public String findAllManageByPage(Integer currentPage,Model model){
			System.out.println("我是分页查询员工的方法");
			PageInfo<Manage> pageInfo=manageService.findAllManageByPage(currentPage);
			System.out.println("查询的为结果为："+pageInfo);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("url", "findAllManageByPage");
			return "managelist";
		}

}
