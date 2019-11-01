package com.nn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nn.bean.Comment;
import com.nn.bean.CommentExample;
import com.nn.bean.Relation;
import com.nn.bean.RelationExample;
import com.nn.bean.Said;
import com.nn.bean.SaidExample;
import com.nn.bean.User;
import com.nn.bean.UserExample;
import com.nn.dao.CommentMapper;
import com.nn.dao.RelationMapper;
import com.nn.dao.SaidMapper;
import com.nn.dao.UserMapper;
import com.nn.utils.MyTools;
@Service
public class SaidService {
	
	@Autowired
	private SaidMapper saidMapper;
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private RelationMapper relationMapper;
	@Autowired
	private UserMapper userMapper;
	//添加说说
	public boolean addSaid(Said said,User user, String longitudeLatitude, String address) {
		try {
			said.setSaidId(MyTools.getDateR());
			said.setCreateTime(MyTools.getTime());
			said.setCreator(user.getName());
			said.setYl1(user.getYl1());
			said.setYl2(longitudeLatitude);			//地址
			said.setYl3(address);
			saidMapper.insertSelective(said);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//删除说说
//	public boolean deleteSaid(String saidId, User user) {
//		String yl1 = user.getYl1();
//		SaidExample example = new SaidExample();
//		SaidExample.Criteria criteria = example.createCriteria();
//		criteria.andYl1EqualTo(yl1);			//删除的时候只能删除自己的说说
//		try {
//			saidMapper.deleteByPrimaryKey(saidId);
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
	//更新说说
	public boolean updateSaid(Said said) {
		try {
			saidMapper.updateByPrimaryKeySelective(said);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//查询说说
	public Said getSaid(String saidId) {
		return saidMapper.selectByPrimaryKey(saidId);
	}
	//list查询
	public List<Said> list(Said said,User user) {


		
		SaidExample example = new SaidExample();
		SaidExample.Criteria criteria = example.createCriteria();
		criteria.andYl1EqualTo(user.getYl1());		
		example.setOrderByClause("CREATE_TIME desc");//说说时间排序		
		List<Said> list=saidMapper.selectByExample(example);//查询出好友的说说
		
	
		for(Said s : list){						//遍历出说说的每条说说评论
			List<String> li = new ArrayList<String>();
			String[] split = s.getPictureUrl().split("[+]");
			for(int i=0; i<split.length; i++){
				li.add(split[i]);
			}
			s.setPictureUrls(li);
			String saidId=s.getSaidId();
			CommentExample exampleComment = new CommentExample();
			CommentExample.Criteria criteriaComment = exampleComment.createCriteria();
			criteriaComment.andPsaididEqualTo(saidId);
			exampleComment.setOrderByClause("CREATE_TIME desc");
			List<Comment> listComment=commentMapper.selectByExample(exampleComment);
			s.setComments(listComment);//将说说下面设置评论
		}
		return list;
	}
	
}
