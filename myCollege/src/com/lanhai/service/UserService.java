package com.lanhai.service;

import com.github.pagehelper.PageInfo;
import com.lanhai.pojo.Manage;
import com.lanhai.pojo.User;

public interface UserService {

	//添加用户
	public void saveUser(User user);
	
	//查询所有
	public PageInfo<User> findAllUserByPage(Integer currentPage);
	
	//根据用户名查询
	public User findUserByName(String userName);
	
	//根据跟管理员名查询
	public Manage findManageByName(String manageName);
	
	//动态更新
	public void updateUser(User user);
	
	//根据id 删除用户
	public int deleteUserById(Integer userId);
	
	//根据用户名 模糊查询
	public PageInfo<User> findUserLikeName(String userName,Integer currentPage);
	
	//验证登录
	public User checkUserNameAndPwd(String userName,String userPassword);
	
	//根据用户id查询
	public User findUserById(Integer id);
}
