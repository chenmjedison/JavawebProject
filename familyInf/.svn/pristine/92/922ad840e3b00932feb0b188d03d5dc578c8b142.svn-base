package com.nn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nn.bean.Festival;
import com.nn.service.FestivalService;
import com.nn.utils.Msg;

@Controller
@RequestMapping("festival")
public class FestivalController {
	
	@Autowired
	private FestivalService festivalService;
	
	//添加
		@RequestMapping("add")
		@ResponseBody
		public Msg Add(Festival festival){
			if(festivalService.add(festival)){
				return Msg.success().add("result", "success");
			}else{
				return Msg.fail().add("result", "faulier");
			}
			
		}
		
		//删除
		@RequestMapping("delete")
		@ResponseBody
		public Msg Delete(String festivalId){
			if(festivalService.delete(festivalId)){
				return Msg.success().add("result", "success");
			}else{
				return Msg.fail().add("result", "faulier");
			}
		}
		
		//修改
		@RequestMapping("update")
		@ResponseBody
		public Msg Upadet(Festival festival){
			if(festivalService.update(festival)){
				return Msg.success().add("result", "success");
			}else{
				return Msg.fail().add("result", "faulier");
			}
		}
		
		//根据ID查询
		@RequestMapping("get")
		@ResponseBody
		public Msg Get(String festivalId){
			Festival festival = festivalService.get(festivalId);
			return Msg.success().add("result", festival);
		}
		
		//查看列表
		@RequestMapping("list")
		@ResponseBody
		public Msg userList(Festival festival){
			List<Festival> festivals = festivalService.list(festival);
			return Msg.success().add("result", festivals);
		}
		
	}
