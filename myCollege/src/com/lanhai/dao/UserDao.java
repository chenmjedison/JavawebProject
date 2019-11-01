package com.lanhai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.lanhai.pojo.Manage;
import com.lanhai.pojo.User;

public interface UserDao {
	
	//用户注册
	@Select("insert into tb_user(userId,userName,userPassword,userSex,userPhone,userAddress,qx_name) values(#{userId},#{userName},#{userPassword},#{userSex},#{userPhone},#{userAddress},#{qx_name})")
	@Options(useGeneratedKeys=true,keyColumn="userId",keyProperty="userId")
	public void saveUser(User user);
	
	//查询所有用户
	@Select("select * from tb_user")
	public List<User> findAllUser();
	
	//根据用户名查询
	@Select("select * from tb_user where userName=#{userName}")
	public User findUserByName(@Param("userName") String userName);
	
	//根据管理员名查询
	@Select("select * from tb_manage where manageName=#{manageName}")
	public Manage findManageByName(@Param("manageName") String manageName);
	
	//动态更新
	@UpdateProvider(type=UserDynamicProvider.class,method="updateUser")
	public void updateUser(User user);
	
	//根据id 查找用户
	@Select("select * from tb_user where userId=#{userId}")
	public User findUserById(@Param("userId") Integer userId);
	
	//根据id删除用户
	@Delete("delete from tb_user where userId=#{userId}")
	public int deleteUserById(Integer userId);
	
	//模糊查询
	@Select("select * from tb_User where userName like concat('%',#{userName},'%')")
	public List<User> findUserLikeName(@Param("userName") String userName );
	
	//验证登录
	@Select("select * from tb_user where userName=#{userName} and userPassword=#{userPassword}")
	public User userNameAndPassword(@Param("userName") String userName,@Param("userPassword")String userPassword);
	
	

}
