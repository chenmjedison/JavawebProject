package com.lanhai.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.lanhai.dao.TiMuDao;
import com.lanhai.pojo.DiaoCha;
import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.User;
import com.lanhai.pojo.WenJuanXX;
import com.lanhai.service.TiMuService;
import com.lanhai.service.WenJuanService;

@Controller  //控制层
public class TiMuController {

	@Autowired
	private TiMuService tiMuService;
	@Autowired
	private WenJuanService wenJuanService;

	public void setWenJuanService(WenJuanService wenJuanService) {
		this.wenJuanService = wenJuanService;
	}



	public void setTiMuService(TiMuService tiMuService) {
		this.tiMuService = tiMuService;
	}



     //添加题目
	@RequestMapping(value="/AddTiMuMethod",method=RequestMethod.POST)
	public String listTuMuMethod(@ModelAttribute TiMu tiMu,Model model){
		
		boolean flag=tiMuService.addTiMu(tiMu);
		System.out.println("----------"+flag);
		
		tiMuService.addTiMuXX(tiMu.gettId(),"A");
		tiMuService.addTiMuXX(tiMu.gettId(),"B");
		tiMuService.addTiMuXX(tiMu.gettId(),"C");
		tiMuService.addTiMuXX(tiMu.gettId(),"D");
		
	
		return "redirect:/findTiMuByPage?currentPage=1";
	}
	
	//分页查询所有题目信息
	@RequestMapping(value="/findTiMuByPage")
	public String findTiMuByPage(int currentPage,Model model){
		PageInfo<TiMu> pageInfo=tiMuService.findTiMuByPage(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		
		List<TiMu> tiMulist=tiMuService.findAllTypeTiMu();
		model.addAttribute("tiMuList",tiMulist );
		System.out.println("-----"+tiMulist);
		System.out.println(pageInfo);
		model.addAttribute("url", "findTiMuByPage");
		return "timulist";//跳转到题目列表
	}
	
	//处理根据id 删除题目
	@RequestMapping(value="/delTiMuMethod")
	public String deleteTiMuMethod(Integer tId){
		System.out.println("----------我是删除单个的方法"+tId);
		tiMuService.deleteTiMu(tId);
		return "redirect:findTiMuByPage?currentPage=1";
	}
	
	//删除选中的所有题目
	@RequestMapping(value="/delAllTiMuMethod")
	public String delAllTiMuMethod(Integer[] tiMuId){
	for(Integer id:tiMuId){
		tiMuService.deleteTiMu(id);
	}
		return "redirect:findTiMuByPage?currentPage=1";
	}
	
	//即进入更新界面的入口
	//根据id 查询单个用户
	@RequestMapping(value="/findTiMuByIdMethod")
	public String findTiMuByIdMethod(Integer tId,Model model){
		TiMu tiMu=tiMuService.findTiMuById(tId);
		model.addAttribute("tiMu", tiMu);
		return "timuupdate";
	}
	
	//根据id修改题目信息
	@RequestMapping(value="/updateTiMuMethod")
	public String updateTiMuMethod(@ModelAttribute TiMu tiMu,Model model){
		System.out.println("---我是update方法----------------"+tiMu);
		tiMuService.updateTiMu(tiMu);
		return "redirect:/findTiMuByPage?currentPage=1";
	}
	
	//根据题目类型查询题目
	@RequestMapping(value="/findTiMuType")
	public String findTiMuType(int currentPage,String selectType,Model model){
		PageInfo<TiMu> pageInfo=tiMuService.findTiMuType(currentPage, selectType);
		
		List<TiMu> tiMulist=tiMuService.findAllTypeTiMu();
		System.out.println("题目类型查找--------------"+tiMulist.size());
		model.addAttribute("tiMuList",tiMulist );
		model.addAttribute("pageInfo", pageInfo);
		return "timulist";
	}
	
	//id23323lanhai
	//根据问卷id查询所有的题目信息
	@RequestMapping(value="/findTiMuWenJuan")
	public String findTiMuWenJuan(String wjId,Model model){
		System.out.println("-------------------------------问卷id"+wjId);
		List<TiMu> tiMulist=wenJuanService.findAllTiMuByWenJuan(wjId);
		
		System.out.println("----------------------------"+tiMulist);
		model.addAttribute("tiMuList",tiMulist );
		model.addAttribute("wjId", wjId);
		return "timushow";
	}
	
	
	
	//根据用户做题保存 用户的选项
	@RequestMapping(value="/saveTiMuXX")
	public String saveTiMuXX(String wjId,String userName,String a1,String a2,String a3,String a4,String a5,String a6,String a7,String pingLun){
		
		    //按照,分割
		System.out.println("------我是问卷题目显示方法");
		System.out.println("用户的id----------"+userName);
		System.out.println("---"+a1+"-----"+a2+"------"+a3+"-------"+a4+"--------"+a5+"------"+a6+"------"+a7+"------------");
		String a [] ={a1,a2,a3,a4,a5,a6,a7};
		int i=0;
		List<TiMu> tiMuList=wenJuanService.findAllTiMuByWenJuan(wjId);
		System.out.println("-----------------------");
		for (TiMu tiMu : tiMuList) {
			System.out.println("------题目的id为：-----"+tiMu.gettId());
			WenJuanXX wenJuanXX=tiMuService.findTiMuCount(tiMu.gettId(), a[i]);
			System.out.println("我是用户选择的题目的次数"+wenJuanXX.getCount());
			int s=tiMuService.tongJiTiMu(wenJuanXX.getCount()+1, tiMu.gettId(), a[i]);
			System.out.println("---------------------"+s);
			i++;
		}
		
		System.out.println("------我是添加评论的方法--------");
		DiaoCha diaoCha=new DiaoCha(userName, wjId, pingLun, new Date());
		tiMuService.addPingLun(diaoCha);
		System.out.println("---------添加成功------------");
		
		return "redirect:findAllWenJuanIndex?currentPage=1";
	}
	
	
	//分页显示所有评论小小的方法
	@RequestMapping(value="/findAllPingLun")
	public String findAllPingLun(Integer currentPage,Model model){
		System.out.println("我是用来评论显示的方法-----------");
		PageInfo<DiaoCha> pageInfo=tiMuService.findAllPingLun(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		
		return "pinglunlist";
	}
	
	//分页显示所有评论  跳转到主页
	@RequestMapping(value="/findAllPingLunIndex")
	public String findAllPingLunIndex(Integer currentPage,Model model){
		System.out.println("我是用来评论显示的方法-----------");
		PageInfo<DiaoCha> pageInfo=tiMuService.findAllPingLun(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		
		return "personpinglun";
	}
	
	//删除评论的方法
	@RequestMapping(value="/deletePingLun")
	public String deletePingLun(Integer plId){
		System.out.println("---------------我是删除评论的方法");
		int i=tiMuService.deletePingLun(plId);
		return "redirect:findAllPingLun?currentPage=1";
	}
	
	
	
	
	
}
