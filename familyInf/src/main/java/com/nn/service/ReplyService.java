package com.nn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nn.bean.Reply;
import com.nn.bean.ReplyExample;
import com.nn.bean.User;
import com.nn.dao.ReplyMapper;
import com.nn.utils.MyTools;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyMapper replyMapper;

	public boolean add(Reply reply, User sysUser) {
		
		try {
			reply.setReplyId(MyTools.getDateR());					//id
			reply.setCreatetime(MyTools.getTime());					//时间
			reply.setCreator(sysUser.getName());			//人
			replyMapper.insertSelective(reply);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}

	public boolean del(String replyId) {
		try {
			replyMapper.deleteByPrimaryKey(replyId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}

	public boolean update(Reply reply) {
		try {
			replyMapper.updateByPrimaryKeySelective(reply);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}

	public Object get(String replyId) {		
		return replyMapper.selectByPrimaryKey(replyId);
	}
	
	

	public List<Reply> list(Reply reply) {
		String creator = reply.getCreator();
		String actId = reply.getActId();		
		ReplyExample example = new ReplyExample();
		ReplyExample.Criteria criteria = example.createCriteria();		
		if(creator!=null && !"".equals(creator)){
			criteria.andCreatorEqualTo(creator);
		}		
		if(actId!=null && !"".equals(actId)){
			criteria.andActIdEqualTo(actId);
		}		
		return replyMapper.selectByExample(example);
	}

	
}
