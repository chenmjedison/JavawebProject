package com.nn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nn.bean.Activity;
import com.nn.bean.ActivityExample;
import com.nn.bean.User;
import com.nn.dao.ActivityMapper;
import com.nn.dao.ReplyMapper;
import com.nn.utils.MyTools;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityMapper activityMapper;
	@Autowired
	private ReplyMapper replyMapper;

	public boolean add(Activity activity,User user) {
		try {
			activity.setActivityId(MyTools.getDateR());
			activity.setCreatetime(MyTools.getTime());
			activity.setCreator(user.getName());
			activity.setYl1(user.getYl1());
			activityMapper.insertSelective(activity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Activity get(String activityId) {		
		return activityMapper.selectByPrimaryKey(activityId);
	}

	public List<Activity> list(Activity activity,User user) {
		String yl1 = user.getYl1();
		String title = activity.getTitle();
		String creator = activity.getCreator();
		String time = activity.getTime();		
		ActivityExample example = new ActivityExample();
		ActivityExample.Criteria criteria = example.createCriteria();
		
		criteria.andYl1EqualTo(yl1);				//宗族标识
		if(title!=null && !"".equals(title)){					//活动主题
			criteria.andTitleLike("%"+title+"%");
		}
		if(creator!=null && !"".equals(creator)){				//活动创建人
			criteria.andCreatorEqualTo(creator);
		}
		if(time!=null && !"".equals(time)){						//活动时间
			criteria.andTimeEqualTo(time);
		}	
		
		return activityMapper.selectByExampleWithBLOBs(example);
	}

	public List<Activity> getActByDay(String day,String afterDay) {
		ActivityExample example = new ActivityExample();
		ActivityExample.Criteria criteria = example.createCriteria();
		criteria.andTimeBetween(day, afterDay);
		List<Activity> list = activityMapper.selectByExampleWithBLOBs(example);
		return list;
	}
}
