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



<<<<<<< HEAD
	// 注锟斤拷
=======
	// ע��
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	@RequestMapping(value = "/addUserMethod", method = RequestMethod.POST)
	public String addUserMethod(@ModelAttribute User user, Model model) {
		System.out.println(user);
		userService.saveUser(user);
		return "login";
	}

<<<<<<< HEAD
	// 锟斤拷录锟斤拷证

	// 锟斤拷锟斤拷锟矫伙拷锟斤拷锟斤拷询锟矫伙拷锟斤拷锟斤拷锟斤拷证
	// 锟矫伙拷锟角凤拷锟斤拷锟�
	@RequestMapping(value = "/checkUserMethod")
	@ResponseBody
	//锟斤拷锟斤拷页锟斤拷锟斤拷锟斤拷ajax锟斤拷锟斤拷锟皆讹拷转锟斤拷
=======
	// ��¼��֤

	// �����û�����ѯ�û�������֤
	// �û��Ƿ����
	@RequestMapping(value = "/checkUserMethod")
	@ResponseBody
	//����ҳ������ajax�����Զ�ת��
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public User checkUserMethod(String userName) {
		return userService.findUserByName(userName);
		
	}

	
	
	
<<<<<<< HEAD
	//锟斤拷锟斤拷锟矫伙拷锟斤拷锟斤拷锟斤拷模锟斤拷锟斤拷询
=======
	//�����û�������ģ����ѯ
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	@RequestMapping(value="/findUserLikeName")
	public String findUserLikeName(String checkName,int currentPage,Model model){
		PageInfo<User> pageInfo=userService.findUserLikeName(checkName, currentPage);
		model.addAttribute("pageInfo", pageInfo);
<<<<<<< HEAD
		System.out.println("锟斤拷锟斤拷锟矫伙拷模锟斤拷锟斤拷询锟侥凤拷锟斤拷");
		System.out.println("锟斤拷锟斤拷锟截硷拷锟斤拷"+checkName);
=======
		System.out.println("�����û�ģ����ѯ�ķ���");
		System.out.println("�����ؼ���"+checkName);
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
		model.addAttribute("url", "findUserLikeName?checkName="+checkName);
		return "userlist";
	}
	
<<<<<<< HEAD
	//锟斤拷锟斤拷id锟斤拷锟斤拷删锟斤拷
	@RequestMapping(value="/deleteUserById")
	public String deleteUserById(Integer userId){
		int a=userService.deleteUserById(userId);
		System.out.println("锟斤拷锟斤拷删锟斤拷锟斤拷锟斤拷  I锟斤拷值"+a);
		return "redirect:findAllUserByPage?currentPage=1";
	}
	
	//锟斤拷锟斤拷id锟斤拷询锟矫伙拷
=======
	//����id����ɾ��
	@RequestMapping(value="/deleteUserById")
	public String deleteUserById(Integer userId){
		int a=userService.deleteUserById(userId);
		System.out.println("����ɾ������  I��ֵ"+a);
		return "redirect:findAllUserByPage?currentPage=1";
	}
	
	//����id��ѯ�û�
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	@RequestMapping(value="/findUserById")
	public String findUserById(Integer userId,Model model){
		User user=userService.findUserById(userId);
		model.addAttribute("user", user);
		return "userupdate";
	}
<<<<<<< HEAD
	//锟斤拷锟斤拷id 锟斤拷锟斤拷锟睫革拷锟矫伙拷
=======
	//����id �����޸��û�
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	@RequestMapping(value="/updateUserMethod")
	public String updateUserMethod(@ModelAttribute User user,Model model){
		userService.updateUser(user);
		return "redirect:findAllUserByPage?currentPage=1";
	}
	
<<<<<<< HEAD
	//锟斤拷页锟斤拷询锟斤拷锟斤拷
=======
	//��ҳ��ѯ����
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	@RequestMapping(value="/findAllUserByPage")
	public String findAllUserByPage(Integer currentPage,Model model){
		PageInfo<User> pageInfo=userService.findAllUserByPage(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "findAllUserByPage");
		return "userlist";
	}
	

	
<<<<<<< HEAD
	//锟介看锟斤拷锟斤拷锟斤拷息
=======
	//�鿴������Ϣ
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	@RequestMapping(value="/updateUserIndexMethod")
	public String updateUserIndexMethod(HttpSession session,Model model){
		
		return "findAllWenJuanIndex?currentPage=1";
	}
	
<<<<<<< HEAD
	//锟斤拷全锟剿筹拷
=======
	//��ȫ�˳�
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	@RequestMapping(value="/closeMethod")
	public String closeMethod(HttpSession session){
		session.removeAttribute("user");
		session.removeAttribute("manage");
		return "login";
	}
	
	
<<<<<<< HEAD
	//锟斤拷录转锟斤拷
	@RequestMapping(value="/loginMethod")
	public String loginMethod(String userName,String userPassword,String qx_name,HttpSession session,Model model){
		System.out.println("----------------锟斤拷锟角碉拷录锟斤拷锟斤拷");
		if("锟斤拷通锟矫伙拷".equals(qx_name)){
			System.out.println("-----锟剿猴拷为"+userName+"--锟斤拷锟斤拷为"+userPassword+"--权锟斤拷"+qx_name);
			User user = userService.checkUserNameAndPwd(userName, userPassword);
			System.out.println("----user-----");
			if(user!=null){
				System.out.println("user锟斤拷为锟斤拷--------------------");
				session.setAttribute("user", user);
				return "redirect:/findAllWenJuanIndex?currentPage=1";
			}
			System.out.println("user为锟斤拷");
			model.addAttribute("msg", "锟斤拷录锟斤拷锟斤拷锟斤拷锟诫不匹锟斤拷");
=======
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
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec

			return "login";
		}
		
<<<<<<< HEAD
		else if("锟斤拷锟斤拷员".equals(qx_name)){
=======
		else if("����Ա".equals(qx_name)){
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
			Manage manage = manageService.checkManageNameAndPwd(userName, userPassword);
			if(manage!=null){
				session.setAttribute("manage", manage);
				return "manage";
			}
<<<<<<< HEAD
			model.addAttribute("msg", "锟斤拷录锟斤拷锟斤拷锟斤拷锟诫不匹锟斤拷");
=======
			model.addAttribute("msg", "��¼�������벻ƥ��");
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec

			return "login";
			
		}else{
			Manage manage1 = manageService.checkManageNameAndPwd(userName, userPassword);
			if(manage1!=null){
				session.setAttribute("manage1",manage1 );
				return "manage1";
			}
<<<<<<< HEAD
			model.addAttribute("msg", "锟斤拷录锟斤拷锟斤拷锟斤拷锟诫不匹锟斤拷");

			return "redirect:/findAllWenJuanIndex?currentPage=1";
		}
		
=======
			model.addAttribute("msg", "��¼�������벻ƥ��");

			return "login";
		}
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	}
	
	

}
