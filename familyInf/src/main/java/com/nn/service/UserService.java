package com.nn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nn.bean.Cwdy;
import com.nn.bean.CwdyExample;
import com.nn.bean.Cwgs;
import com.nn.bean.CwgsExample;
import com.nn.bean.Relation;
import com.nn.bean.RelationExample;
import com.nn.bean.User;
import com.nn.bean.UserExample;
import com.nn.dao.CwdyMapper;
import com.nn.dao.CwgsMapper;
import com.nn.dao.RelationMapper;
import com.nn.dao.UserMapper;
import com.nn.utils.MyTools;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CwgsMapper cwgsMapper;
	@Autowired
	private RelationMapper relationMapper;
	@Autowired
	private CwdyMapper cwdyMapper;
	
	public boolean addUser(User user, Relation relation) {
		try {
			String id = MyTools.getDateR();
			user.setUserid(id);
			String yl1 = MyTools.getDateR();
			
			String user1 = relation.getUser1();
			if(user1 != null && !"".equals(user1)){
				User selectByPrimaryKey = userMapper.selectByPrimaryKey(user1);
				user.setYl1(selectByPrimaryKey.getYl1());
				userMapper.insertSelective(user);
				relation.setUser2(id);
				addRelation(relation);
			}else{
				user.setYl1(yl1);
				userMapper.insertSelective(user);
			}
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(String userId) {
		try {
			userMapper.deleteByPrimaryKey(userId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(User user) {
		try {
			userMapper.updateByPrimaryKeySelective(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public User getUser(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public boolean addRelation(Relation r) {
		try {
			RelationExample example = new RelationExample();
			RelationExample.Criteria criteria = example.createCriteria();
			criteria.andUser1EqualTo(r.getUser1());
			List<Relation> list = relationMapper.selectByExample(example); // 参照人的所有关系
			User user = userMapper.selectByPrimaryKey(r.getUser1());
			String u2 = r.getUser2(); // 被创建的人

			String u1 = r.getUser1(); // 被创建的人的参照人

			String cw2 = r.getUser2cw(); // 参照人对被创建人的称呼
			String cw1 = ""; // 被创建人对参照人的称呼

			String sex = user.getSex();

			if (sex.equals("男")) {
				switch (cw2) {
				case "爸爸":
					cw1 = "儿子";
					break;
				case "妈妈":
					cw1 = "儿子";
					break;
				case "姐姐":
					cw1 = "弟弟";
					break;
				case "妹妹":
					cw1 = "哥哥";
					break;
				case "哥哥":
					cw1 = "弟弟";
					break;
				case "弟弟":
					cw1 = "哥哥";
					break;
				case "儿子":
					cw1 = "爸爸";
					break;
				case "女儿":
					cw1 = "爸爸";
					break;
				case "老婆":
					cw1 = "老公";
					break;
				}
			} else {
				switch (cw2) {
				case "爸爸":
					cw1 = "女儿";
					break;
				case "妈妈":
					cw1 = "女儿";
					break;
				case "姐姐":
					cw1 = "妹妹";
					break;
				case "妹妹":
					cw1 = "姐姐";
					break;
				case "哥哥":
					cw1 = "妹妹";
					break;
				case "弟弟":
					cw1 = "姐姐";
					break;
				case "儿子":
					cw1 = "妈妈";
					break;
				case "女儿":
					cw1 = "妈妈";
					break;
				case "老公":
					cw1 = "老婆";
					break;
				}
			}

			Relation relation3 = new Relation(); // 参照人对被创建人的关系
			relation3.setRelationId(MyTools.getDateR());
			relation3.setUser1(u2);
			relation3.setUser2(u1);
			relation3.setGuanxi("1");
			if(cw1.equals("爸爸") || cw1.equals("妈妈")){
				relation3.setYl1("1");
			}else if(cw1.equals("儿子") || cw1.equals("女儿")){
				relation3.setYl1("-1");
			}else {
				relation3.setYl1("0");
			}
			relation3.setUser1cw(cw2);
			relation3.setUser2cw(cw1);
			relationMapper.insertSelective(relation3);

			Relation relation4 = new Relation(); // 被创建人对参照人的关系
			relation4.setRelationId(MyTools.getDateR());
			relation4.setUser1(u1);
			relation4.setUser2(u2);
			relation4.setGuanxi("1");
			if(cw2.equals("爸爸") || cw2.equals("妈妈")){
				relation4.setYl1("1");
			}else if(cw2.equals("儿子") || cw2.equals("女儿")){
				relation4.setYl1("-1");
			}else {
				relation4.setYl1("0");
			}
			relation4.setUser1cw(cw1);
			relation4.setUser2cw(cw2);
			relationMapper.insertSelective(relation4);

			if (list.size() > 0) {
				for (Relation relation : list) {
					String uu2 = relation.getUser2(); // 参照人关系表的关系人
					String uu2cw = relation.getUser2cw(); // 参照人对关系表的关系人的称呼
					String uu1cw = relation.getUser1cw(); // 关系表的关系人对参照人的称呼

					Cwgs gxr = gxr(uu1cw, cw2); // 要添加的关系表称呼1

					if(!"".equals(gxr) && gxr != null) {
						String cwcw2 = gxr.getGuanxi3();
						User ur1 = userMapper.selectByPrimaryKey(u2); // 参照人的信息
						User ur2 = userMapper.selectByPrimaryKey(uu2); // 被创建人的信息
						String birthday1 = ur1.getBirthday();
						String birthday2 = ur2.getBirthday();

						//姐妹
						if (cwcw2.equals("姐妹")) {
							int result = birthday1.compareTo(birthday2);
							if (result > 0) {
								cwcw2 = "妹妹";
							} else {
								cwcw2 = "姐姐";
							}
						}
						
						//姨表姐妹
						if (cwcw2.equals("姨表姐妹")) {
							int result = birthday1.compareTo(birthday2);
							if (result > 0) {
								cwcw2 = "姨表妹";
							} else {
								cwcw2 = "姨表姐";
							}
						} 
						
						//姑表姐妹
						if (cwcw2.equals("姑表姐妹")) {
							int result = birthday1.compareTo(birthday2);
							if (result > 0) {
								cwcw2 = "姑表妹";
							} else {
								cwcw2 = "姑表姐";
							}
						}
						//舅表姐妹
						if (cwcw2.equals("舅表姐妹")) {
							int result = birthday1.compareTo(birthday2);
							if (result > 0) {
								cwcw2 = "舅表妹";
							} else {
								cwcw2 = "舅表姐";
							}
						}
						
						//堂姐妹
						if (cwcw2.equals("堂姐妹")) {
							int result = birthday1.compareTo(birthday2);
							if (result > 0) {
								cwcw2 = "堂妹";
							} else {
								cwcw2 = "堂姐";
							}
						}
						
						// 兄弟
						if (cwcw2.equals("兄弟")) {
							int result = birthday1.compareTo(birthday2);
							if (result > 0) {
								cwcw2 = "弟弟";
							} else {
								cwcw2 = "哥哥";
							}
						}
						
						//姨表兄弟
						if (cwcw2.equals("姨表兄弟")) {
							int result = birthday1.compareTo(birthday2);
							if (result > 0) {
								cwcw2 = "姨表弟";
							} else {
								cwcw2 = "姨表哥";
							}
						}

						//姑表兄弟
						if (cwcw2.equals("姑表兄弟")) {
							int result = birthday1.compareTo(birthday2);
							if (result > 0) {
								cwcw2 = "姑表弟";
							} else {
								cwcw2 = "姑表哥";
							}
						}

						//舅表兄弟
						if (cwcw2.equals("舅表兄弟")) {
							int result = birthday1.compareTo(birthday2);
							if (result > 0) {
								cwcw2 = "舅表弟";
							} else {
								cwcw2 = "舅表哥";
							}
						}

						//堂兄弟
						if (cwcw2.equals("堂兄弟")) {
							int result = birthday1.compareTo(birthday2);
							if (result > 0) {
								cwcw2 = "堂弟";
							} else {
								cwcw2 = "堂哥";
							}
						}

						// 叔伯
						if (cwcw2.equals("叔伯")) {
							String birthday = getBirthday(uu2, "爸爸");
							int result = birthday1.compareTo(birthday);
							if (result > 0) {
								cwcw2 = "叔叔";
							} else {
								cwcw2 = "伯伯";
							}
						}
						
						// 舅子
						if (cwcw2.equals("舅子")) {
							String birthday = getBirthday(uu2, "老婆");
							int result = birthday1.compareTo(birthday);
							if (result > 0) {
								cwcw2 = "小舅子";
							} else {
								cwcw2 = "大舅子";
							}
						}

						// 姨子
						if (cwcw2.equals("姨子")) {
							String birthday = getBirthday(uu2, "老婆");
							int result = birthday1.compareTo(birthday);
							if (result > 0) {
								cwcw2 = "小姨子";
							} else {
								cwcw2 = "大姨子";
							}
						}

						// 嫂子弟妹
						if (cwcw2.equals("嫂子弟妹")) {
							String birthday = getBirthday(u2, "老公");
							int result = birthday2.compareTo(birthday);
							if (result > 0) {
								cwcw2 = "嫂子";
							} else {
								cwcw2 = "弟妹";
							}
						}
						
						//姐夫妹夫
						if (cwcw2.equals("姐夫妹夫")) {
							String birthday = getBirthday(u2, "老婆");
							int result = birthday2.compareTo(birthday);
							if (result > 0) {
								cwcw2 = "姐夫";
							} else {
								cwcw2 = "妹夫";
							}
						}
						
						//大小姑子
						if (cwcw2.equals("大小姑子")) {
							String birthday = getBirthday(uu2, "老公");
							int result = birthday1.compareTo(birthday);
							if (result > 0) {
								cwcw2 = "小姑子";
							} else {
								cwcw2 = "大姑子";
							}
						}
						
						//叔伯子
						if (cwcw2.equals("叔伯子")) {
							String birthday = getBirthday(uu2, "老公");
							int result = birthday1.compareTo(birthday);
							if (result > 0) {
								cwcw2 = "小叔子";
							} else {
								cwcw2 = "大伯子";
							}
						}
						
						String sex2 = ur2.getSex();
						Cwdy fgx = fgx(cwcw2,sex2); // 要添加的关系表称呼2
						String cwcw1 = fgx.getCwdy2();
						String dengji = fgx.getYl2();
						int i = Integer.parseInt(gxr.getYl1());
						
						Relation relation2 = new Relation();
						relation2.setRelationId(MyTools.getDateR());
						relation2.setUser1(u2);
						relation2.setUser2(uu2);
						if("1".equals(dengji)){
							relation2.setGuanxi(dengji);
						}
						if(i<0){
							String abs = Math.abs(i)+"";
							relation2.setYl1(abs);
						}else if(i == 0){
							relation2.setYl1(i+"");
						}else {
							int q=-i;
							relation2.setYl1(q+"");
						}
						relation2.setUser1cw(cwcw2);
						relation2.setUser2cw(cwcw1);
						relationMapper.insertSelective(relation2);

						Relation relation5 = new Relation();
						relation5.setRelationId(MyTools.getDateR());
						relation5.setUser1(uu2);
						relation5.setUser2(u2);
						if("1".equals(dengji)){
							relation5.setGuanxi(dengji);
						}
						relation5.setYl1(i+"");
						relation5.setUser1cw(cwcw1);
						relation5.setUser2cw(cwcw2);
						relationMapper.insertSelective(relation5);
					}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Cwgs gxr(String gx1,String gx2) {
		CwgsExample example = new CwgsExample();
		CwgsExample.Criteria criteria = example.createCriteria();
		criteria.andGuanxi1EqualTo(gx1);
		criteria.andGuanxi2EqualTo(gx2);
		List<Cwgs> list = cwgsMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}else {
			return null;
		}
		
	}
	
	
	public Cwdy fgx(String cw,String sex) {
		CwdyExample example = new CwdyExample();
		CwdyExample.Criteria criteria = example.createCriteria();
		criteria.andCwdy1EqualTo(cw);
		criteria.andYl1EqualTo(sex);
		List<Cwdy> list = cwdyMapper.selectByExample(example);
		return list.get(0);
	}

	public List<User> listUser(User user) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		String name = user.getName();
		if(name != null && !"".equals(name)){
			criteria.andNameLike("%"+name+"%");
		}
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

	public String getBirthday(String id,String chengw){
		RelationExample example = new RelationExample();
		RelationExample.Criteria criteria = example.createCriteria();
		criteria.andUser1EqualTo(id);
		criteria.andUser2cwEqualTo(chengw);
		List<Relation> selectByExample = relationMapper.selectByExample(example);
		String user2 = selectByExample.get(0).getUser2();
		User user = userMapper.selectByPrimaryKey(user2);
		return user.getBirthday();
	}

	//登录
	public User getUser(User user) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andPasswordEqualTo(user.getPassword());
		criteria.andPhoneEqualTo(user.getPhone());
		List<User> list = userMapper.selectByExample(example);
		if(list.size() != 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	public List<User> getUserByBirth(String day,String afterDay) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andBirthdayBetween(day, afterDay);
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

	public List<User> selectByYl(String yl1) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andYl1EqualTo(yl1);
		List<User> list = userMapper.selectByExample(example);
		return list;
	}

	/*//获取到指定用户的一级关系
	public List<User> getRelation(String id) {
		RelationExample example = new RelationExample();
		RelationExample.Criteria criteria = example.createCriteria();
		criteria.andGuanxiEqualTo("1");
		criteria.andUser1EqualTo(id);
		List<Relation> relations = relationMapper.selectByExample(example);
		List<User> users = new ArrayList<User>();
		for (Relation relation : relations) {
			String userId = relation.getUser2();
			String cw = relation.getUser2cw();
			User user = userMapper.selectByPrimaryKey(userId);
			user.setCw(cw);
			users.add(user);
		}
		return users;
	}
*/
}
