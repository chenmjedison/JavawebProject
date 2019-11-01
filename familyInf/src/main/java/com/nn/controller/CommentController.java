package com.nn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nn.bean.Comment;
import com.nn.bean.User;
import com.nn.service.CommentService;
import com.nn.utils.Msg;

@Controller
@RequestMapping("comment")
public class CommentController extends BaseController {
	@Autowired
	private CommentService commentService;
		//添加
		@RequestMapping("add")
		@ResponseBody
		public Msg AddComment(Comment comment,HttpServletRequest request){
			User user = getCurrentUser(request);
			if(commentService.addComment(comment,user)){
				return Msg.success().add("result", "success");
			}else{
				return Msg.fail().add("result", "faulier");
			}
			
		}
		//修改
		@RequestMapping("update")
		@ResponseBody
		public Msg UpdateComment(Comment comment){
			if(commentService.updateComment(comment)){
				return Msg.success().add("result", "success");
			}else{
				return Msg.fail().add("result", "faulier");
			}
		}
		//列表
		@RequestMapping("list")
		@ResponseBody
		public Msg listComment(Comment comment,String start,String end){
			return Msg.success().add("result", commentService.list(comment,start,end));
		}
		//查询
		@RequestMapping("get")
		@ResponseBody
		public Msg getComment(String commentId){
			return Msg.success().add("result", commentService.getComment(commentId));
		}
		//删除
		@RequestMapping("delete")
		@ResponseBody
		public Msg DeleteComment(String commentId){
			if(commentService.deleteComment(commentId)){
				return Msg.success().add("result", "success");
			}else{
				return Msg.fail().add("result", "faulier");
			}
		}
}
