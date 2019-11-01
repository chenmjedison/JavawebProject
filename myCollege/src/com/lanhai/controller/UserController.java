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
import com.lanhai.pojo.User;
import com.lanhai.service.ManageService;
import com.lanhai.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ManageService manageService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

	public void setManageService(ManageService manageService) {
		this.manageService = manageService;
	}



	// ע��
	@RequestMapping(value = "/addUserMethod", method = RequestMethod.POST)
	public String addUserMethod(@ModelAttribute User user, Model model) {
		System.out.println(user);
		userService.saveUser(user);
		return "login";
	}

	// ��¼��֤

	// �����û�����ѯ�û�������֤
	// �û��Ƿ����
	@RequestMapping(value = "/checkUserMethod")
	@ResponseBody
	//����ҳ������ajax�����Զ�ת��
	public User checkUserMethod(String userName) {
		return userService.findUserByName(userName);
		
	}

	
	
	
	//�����û�������ģ����ѯ
	@RequestMapping(value="/findUserLikeName")
	public String findUserLikeName(String checkName,int currentPage,Model model){
		PageInfo<User> pageInfo=userService.findUserLikeName(checkName, currentPage);
		model.addAttribute("pageInfo", pageInfo);
		System.out.println("�����û�ģ����ѯ�ķ���");
		System.out.println("�����ؼ���"+checkName);
		model.addAttribute("url", "findUserLikeName?checkName="+checkName);
		return "userlist";
	}
	
	//����id����ɾ��
	@RequestMapping(value="/deleteUserById")
	public String deleteUserById(Integer userId){
		int a=userService.deleteUserById(userId);
		System.out.println("����ɾ������  I��ֵ"+a);
		return "redirect:findAllUserByPage?currentPage=1";
	}
	
	//����id��ѯ�û�
	@RequestMapping(value="/findUserById")
	public String findUserById(Integer userId,Model model){
		User user=userService.findUserById(userId);
		model.addAttribute("user", user);
		return "userupdate";
	}
	//����id �����޸��û�
	@RequestMapping(value="/updateUserMethod")
	public String updateUserMethod(@ModelAttribute User user,Model model){
		userService.updateUser(user);
		return "redirect:findAllUserByPage?currentPage=1";
	}
	
	//��ҳ��ѯ����
	@RequestMapping(value="/findAllUserByPage")
	public String findAllUserByPage(Integer currentPage,Model model){
		PageInfo<User> pageInfo=userService.findAllUserByPage(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "findAllUserByPage");
		return "userlist";
	}
	

	
	//�鿴������Ϣ
	@RequestMapping(value="/updateUserIndexMethod")
	public String updateUserIndexMethod(HttpSession session,Model model){
		
		return "findAllWenJuanIndex?currentPage=1";
	}
	
	//��ȫ�˳�
	@RequestMapping(value="/closeMethod")
	public String closeMethod(HttpSession session){
		session.removeAttribute("user");
		session.removeAttribute("manage");
		return "login";
	}
	
	
	//��¼ת��
	@RequestMapping(value="/loginMethod")
	public String loginMethod(String userName,String userPassword,String qx_name,HttpSession session,Model model){
		System.out.println("----------------���ǵ�¼����");
		if("��ͨ�û�".equals(qx_name)){
			System.out.println("-----�˺�Ϊ"+userName+"--����Ϊ"+userPassword+"--Ȩ��"+qx_name);
			User user = userService.checkUserNameAndPwd(userName, userPassword);
			System.out.println("----user-----");
			if(user!=null){
				System.out.println("user��Ϊ��--------------------");
				session.setAttribute("user", user);
				return "redirect:/findAllWenJuanIndex?currentPage=1";
			}
			System.out.println("userΪ��");
			model.addAttribute("msg", "��¼�������벻ƥ��");

			return "login";
		}
		
		else if("����Ա".equals(qx_name)){
			Manage manage = manageService.checkManageNameAndPwd(userName, userPassword);
			if(manage!=null){
				session.setAttribute("manage", manage);
				return "manage";
			}
			model.addAttribute("msg", "��¼�������벻ƥ��");

			return "login";
			
		}else{
			Manage manage1 = manageService.checkManageNameAndPwd(userName, userPassword);
			if(manage1!=null){
				session.setAttribute("manage1",manage1 );
				return "manage1";
			}
			model.addAttribute("msg", "��¼�������벻ƥ��");

			return "login";
		}
	}
	
	

}
