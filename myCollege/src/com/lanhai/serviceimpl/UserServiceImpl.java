package com.lanhai.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanhai.dao.UserDao;
import com.lanhai.pojo.Manage;
import com.lanhai.pojo.User;
import com.lanhai.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser(User user) {
		 userDao.saveUser(user);
	}

	@Override
	public PageInfo<User> findAllUserByPage(Integer currentPage) {
		PageHelper.startPage(currentPage, 2, "userId");
		List<User> userList=userDao.findAllUser();
		return new PageInfo<User>(userList);
	}

	@Override
	public User findUserByName(String userName) {
		
		return userDao.findUserByName(userName);
	}

	@Override
	public Manage findManageByName(String manageName) {
		
		return userDao.findManageByName(manageName);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public int deleteUserById(Integer userId) {
		
		return userDao.deleteUserById(userId);
	}

	@Override
	public PageInfo<User> findUserLikeName(String userName,Integer currentPage) {
		PageHelper.startPage(currentPage,2, "userId");
		List<User> userList=userDao.findUserLikeName(userName);
		return new PageInfo<User>(userList);
	}

	@Override
	public User checkUserNameAndPwd(String userName, String userPassword) {
		
		if(userDao.userNameAndPassword(userName, userPassword)!=null){
			System.out.println("我是userservice方法验证");
			return userDao.userNameAndPassword(userName, userPassword);
		}
		return null;
	}

	@Override
	public User findUserById(Integer userId) {
		return userDao.findUserById(userId);
	}

	
}
