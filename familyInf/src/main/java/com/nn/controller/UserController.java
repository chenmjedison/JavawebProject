package com.nn.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gexin.rp.sdk.template.LinkTemplate;
import com.nn.bean.Activity;
import com.nn.bean.Festival;
import com.nn.bean.Relation;
import com.nn.bean.User;
import com.nn.service.ActivityService;
import com.nn.service.FestivalService;
import com.nn.service.UserService;
import com.nn.utils.GetRandem;
import com.nn.utils.Msg;
import com.nn.utils.PushUtils;
import com.nn.utils.PushtoList;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@Controller
@RequestMapping("usermsg")
@EnableScheduling
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private FestivalService festivalService;
	
	List<String> cidList = new ArrayList<String>();

	// 添加
	@RequestMapping("add")
	@ResponseBody
	public Msg Add(User user, Relation relation) {
		if (userService.addUser(user, relation)) {
			return Msg.success().add("result", "success");
		} else {
			return Msg.fail().add("result", "faulier");
		}

	}

	// 删除
	@RequestMapping("delete")
	@ResponseBody
	public Msg Delete(String userId) {
		if (userService.deleteUser(userId)) {
			return Msg.success().add("result", "success");
		} else {
			return Msg.fail().add("result", "faulier");
		}
	}

	// 修改
	@RequestMapping("update")
	@ResponseBody
	public Msg Upadet(User user) {
		if (userService.updateUser(user)) {
			return Msg.success().add("result", "success");
		} else {
			return Msg.fail().add("result", "faulier");
		}
	}

	// 根据ID查询
	@RequestMapping("get")
	@ResponseBody
	public Msg Get(String userId) {
		User user = userService.getUser(userId);
		return Msg.success().add("result", user);
	}

	// 查看列表
	@RequestMapping("list")
	@ResponseBody
	public Msg userList(User user) {
		List<User> users = userService.listUser(user);
		return Msg.success().add("result", users);
	}

	// 登录
	@RequestMapping("login")
	@ResponseBody
	public Msg login(User user, HttpServletRequest request) {
		if (user.getPhone() == null || user.getPassword() == null) {
			return Msg.fail().add("result", "用户名或密码不正确");
		}
		User loguser = userService.getUser(user);
		System.err.println(loguser);
		if (loguser == null) {
			return Msg.fail().add("result", "用户名或密码不正确");
		} else {
			String token = GetRandem.getDateR();
			Cache cache = cacheManager.getCache("data-cache");
			Element e = new Element(token, loguser);
			cache.put(e);
			return Msg.success().add("result", loguser).add("token", token);
		}
	}

	/*// 缓存cid
	@RequestMapping("save")
	@ResponseBody
	public Msg save(HttpServletRequest request, String cid, String userid) {
		Cache cache = cacheManager.getCache("data-cache");
		Element e = new Element(userid, cid);
		cache.put(e);
		return Msg.success().add("result", userid);
	}*/
	
	

	// 定时任务
	@SuppressWarnings("deprecation")
	@Scheduled(cron = "*/5 * * * * ?")
//	@Scheduled(cron = "0 0 1 * * ?")
	public void dingshi() throws InterruptedException {
		Cache cache = cacheManager.getCache("data-cache");
		
		/*if(cidList.size()>0){
			for (String str : cidList) {
				String cid = cache.get(str).getValue().toString();
				list.add(cid);
			}
		}*/
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String day = sdf.format(calendar.getTime());
		String afterDay = AfterDay(7);
		System.out.println(afterDay);
		System.out.println(day);
		
		
			List<User> birthlist = userService.getUserByBirth(day, afterDay);
			if (birthlist.size() > 0) {
				for (User user : birthlist) {
					List<String> strList = new ArrayList<String>();
					
					String yl1 = user.getYl1();
					List<User> list = userService.selectByYl(yl1);
					for (User u : list) {
						String userid = u.getUserid();
						String string = cache.get(userid).getValue().toString();
						strList.add(string);
					}
					String name = user.getName();
					String birthday = user.getBirthday();
					String content = name + "：" + name + "的生日";
					/*String pushMessage = PushtoList.pushMessage(birthday, content, strList);*/
					Thread.sleep(5000);
					/*System.out.println(pushMessage + "b");*/
				}

			} else {
				System.out.println("没人过生日");
			}

			
			List<Activity> actList = activityService.getActByDay(day, afterDay);
			if (actList.size() > 0) {
				for (Activity activity : actList) {
					List<String> strList = new ArrayList<String>();
					
					String yl1 = activity.getYl1();
					List<User> list = userService.selectByYl(yl1);
					for (User u : list) {
						String userid = u.getUserid();
						String string = cache.get(userid).getValue().toString();
						strList.add(string);
					}
					
					String co = activity.getContent();
					String creator = activity.getCreator();
					String content = creator + "：" + co;
					String time = activity.getTime();
					/*String pushMessage = PushtoList.pushMessage(time, content, strList);*/
					Thread.sleep(5000);
					/*System.out.println(pushMessage + "a");*/

				}
			} else {
				System.out.println("没人有活动");
			}


		
		List<Festival> fesList = festivalService.getFesByDay(day, afterDay);
		if (fesList.size() > 0) {
			for (Festival festival : fesList) {
				String name = festival.getFestivalname();
				String content = "系统：" + name;
				String date = festival.getDate();
				/*LinkTemplate linkTemplate = PushUtils.linkTemplateDemo(date, content);
				String sendMsg = PushUtils.sendMsg(linkTemplate);
				Thread.sleep(5000);
				System.out.println(sendMsg + "f");*/

			}
		} else {
			System.out.println("没有节日");
		}
	}

	// 获取到指定时间
	public static String AfterDay(int sum) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		calendar.add(Calendar.DATE, sum);
		String sum_days = sdf.format(calendar.getTime());
		return sum_days;
	}
}
