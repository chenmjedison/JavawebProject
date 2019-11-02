package com.lanhai.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.WenJuan;
import com.lanhai.service.TiMuService;
import com.lanhai.service.WenJuanService;

@Controller
public class WenJuanController {
	
	@Autowired
	private WenJuanService wenJuanService;
	
	@Autowired
	private TiMuService tiMuService;

	public void setWenJuanService(WenJuanService wenJuanService) {
		this.wenJuanService = wenJuanService;
	}
	
	
	
	public void setTiMuService(TiMuService tiMuService) {
		this.tiMuService = tiMuService;
	}


	//跳到主界面
	//分页查询
	@RequestMapping(value="/findAllWenJuanIndex")
	public String findAllWenJuanIndex(Integer currentPage,Model model){
		PageInfo<WenJuan> pageInfo=wenJuanService.findAllWenJuanByPage(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		System.out.println("--我是分页查询--");
		
		List<WenJuan> wenJuanList=wenJuanService.findAllTypeWenJuan();
		
		System.out.println("我是主页的类型--------"+wenJuanList);
		model.addAttribute("wenJuanList", wenJuanList);
		model.addAttribute("url", "findAllWenJuanIndex");
		return "index";
	}
	
	//调到主页，根据问卷名 模糊查询
	@RequestMapping(value="/findWenJuanByNameIndex")
	public String findWenJuanByNameIndex(String wjName,int currentPage,Model model){
		PageInfo<WenJuan> pageInfo=wenJuanService.findWenJuanLikeName(wjName, currentPage);
		System.out.println("我是模糊查询的方法");
		System.out.println("查询的结果为"+pageInfo);
		
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "findWenJuanByNameIndex?wjName="+wjName);
		
		List<WenJuan> wenJuanList=wenJuanService.findAllTypeWenJuan();
		model.addAttribute("wenJuanList", wenJuanList);
	
		return "index";
	}

	//分页查询所有   
	//跳转至问卷主界面
	@RequestMapping(value="/findAllWenJuanByPage")
	public String findAllWenJuanByPage(Integer currentPage,Model model){
		PageInfo<WenJuan> pageInfo=wenJuanService.findAllWenJuanByPage(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		System.out.println("--我是分页查询--");
		
		
		return "wenjuanlist";
	}
	
	//跳到主页面
	//根据类型查询问卷
	@RequestMapping(value="/findAllTypeWenJuan")
	public String findAllTypeWenJuan(Integer currentPage,String wjType,Model model){
		PageInfo<WenJuan> pageInfo=wenJuanService.findWenJuanByType(currentPage, wjType);
		System.out.println("我是类型查询问卷的方法-----------------------");
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "findAllTypeWenJuan?wjType="+wjType);
		
		List<WenJuan> wenJuanList=wenJuanService.findAllTypeWenJuan();
		model.addAttribute("wenJuanList", wenJuanList);
		return "index";
	}
	
	//问卷添加界面
	//show
	
	@RequestMapping(value="/findAllWenJuanShow")
	public String findAllWenJuanShow(Integer currentPage,Model model){
		PageInfo<WenJuan> pageInfo=wenJuanService.findAllWenJuanByPage(currentPage);
		model.addAttribute("pageInfo", pageInfo);
		
		System.out.println("--------------"+pageInfo);
		System.out.println("--我是分页show--");
		
		List<TiMu> tiMuList=tiMuService.findAllTypeTiMu();
		model.addAttribute("tiMuList", tiMuList);
		
		model.addAttribute("url", "findAllWenJuanShow");
		return "wenjuanadd";
	}
	
	
	
	//处理id  删除问卷
	@RequestMapping(value="/deleteWenJuanMethod")
	public String deleteWenJuanMethod(String wjId){
		System.out.println("我是删除问卷的方法-------"+wjId);
		int i=wenJuanService.deleteWenjuan(wjId);
		System.out.println("影响的行数为："+i);
		return "redirect:findAllWenJuanByPage?currentPage=1";
	}
	
	//删除选中的所有问卷
	@RequestMapping(value="/delAllWenJuanMethod")
	public String delAllWenJuanMethod(String[] wjId){
		System.out.println("获取的问卷id值为"+wjId);
		for(String id:wjId){
			wenJuanService.deleteWenjuan(id);
		}
		return "redirect:findAllWenJuanByPage?currentPage=1";
	}
	
	//添加问卷
	@RequestMapping(value="/addWenJuan")
	public String addWenJuan(@ModelAttribute WenJuan wenJuan,Model model){
		
		System.out.println("我是添加问卷的方法"+wenJuan);
		System.out.println("获取到设置的问卷的题目数量为："+wenJuan.getWjNum());
			List<TiMu> tiMuList=tiMuService.findAllTiMu();
			int i=0;
			for (TiMu tiMu : tiMuList) {
				/*System.out.println("-------------------------------");
				System.out.println("我wenjuan----"+wenJuan.getWjType());
				System.out.println("我timu----"+tiMu.getWjType());
				System.out.println("我timu 获取问卷编号--- "+tiMu.getWjId());
				System.out.println("----------------------------------");*/
				if(wenJuan.getWjType().equals(tiMu.getWjType())){
					System.out.println("mmuuuuuuuu");
					if(tiMu.getWjId()  == null || "".equals(tiMu.getWjId()) && i<wenJuan.getWjNum()){
						System.out.println("就问你题目有id么----------------"+tiMu);
						System.out.println("-----------wenjuanId--"+wenJuan.getWjId());
						tiMu.setWjId(wenJuan.getWjId());
						
						tiMuService.updateTiMu(tiMu);
						i++;
						
					}
					
				}
			}
			System.out.println("问卷的题目数量为：-------"+i);
			
		
		wenJuan.setWjTime(new Date());
		wenJuanService.addWenJuan(wenJuan);
		
		return "redirect:findAllWenJuanByPage?currentPage=1";
	}
	
	//模糊查询
	@RequestMapping(value="/findWenJuanLikeName")
	public String findWenJuanLikeName(String wjName,int currentPage,Model model){
		PageInfo<WenJuan> pageInfo=wenJuanService.findWenJuanLikeName(wjName, currentPage);
		System.out.println("我是模糊查询的方法");
		System.out.println("查询的结果为"+pageInfo);
		
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "findWenJuanLikeName?wjName="+wjName);
		
		return "wenjuanlist";
	}
	
	//根据问卷显示相应的题目
	@RequestMapping(value="/findTiMuByWenJuan")
	public String findTiMuByWenJuan(Integer currentPage,String  wjId,Model model){
		
		System.out.println("问卷编号："+wjId+"---currentpage"+currentPage);
		PageInfo<TiMu> pageInfo=wenJuanService.findTiMuByWenJuan(wjId, currentPage);
		System.out.println("我是显示相应题目的方法"+pageInfo);
		
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("wjId", wjId);
		model.addAttribute("url","findTiMuByWenJuan?wjId="+wjId );
		//List<TiMu> tiMuList=wenJuanService.findAllTiMuByWenJuan(wjId);
		//System.out.println("-------------------------------------"+tiMuList);
		//model.addAttribute("tiMuList", tiMuList);
		return "timushow";
	}
	
	
	

}
