package com.nn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nn.bean.Reply;
import com.nn.bean.User;
import com.nn.service.ReplyService;
import com.nn.utils.Msg;
import com.nn.utils.MyTools;

@Controller
@RequestMapping("reply")
public class ReplyController extends BaseController{
	
	@Autowired
	private ReplyService replyService;
	
	
	//添加
	@ResponseBody
	@RequestMapping("add")
	public Msg add(Reply reply,HttpServletRequest request){
		User sysUser = getCurrentUser(request);
		reply.setCreator(sysUser.getName());
		reply.setCreatetime(MyTools.getTime());
		if(replyService.add(reply, sysUser)){
			return Msg.success().add("result", "添加成功");
		}else{
			return Msg.fail().add("result", "添加失败");
		}
	}
	
	//删除
	@ResponseBody
	@RequestMapping("del")
	public Msg del(Reply reply){
		if(replyService.del(reply.getReplyId())){
			return Msg.success().add("result", "删除成功");
		}else {
			return Msg.fail().add("result", "删除失败");
		}		
	}
	
	//修改
	@ResponseBody
	@RequestMapping("update")
	public Msg update(Reply reply){
		if(replyService.update(reply)){
			return Msg.success().add("result", "修改成功");
		}else{
			return Msg.fail().add("result", "修改失败");
		}		
	}
	
	//查询
	@ResponseBody
	@RequestMapping("get")
	public Msg get(Reply reply){
		return Msg.success().add("result", replyService.get(reply.getReplyId())) ;
	}	
	
	//列表
	@ResponseBody
	@RequestMapping("list")
	public Msg list(Reply reply){		
		return Msg.success().add("result", replyService.list(reply));		
	}
	
}
