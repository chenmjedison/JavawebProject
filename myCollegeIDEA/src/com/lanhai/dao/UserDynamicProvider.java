package com.lanhai.dao;

import org.apache.ibatis.jdbc.SQL;

import com.lanhai.pojo.User;



public class UserDynamicProvider {

	public String updateUser(final User user) {
		return new SQL() {
			{
			
				UPDATE("tb_user");
				
				if (user.getUserName()!=null && !"".equals(user.getUserName())) {
					SET("userName=#{userName}");
				}
				if (user.getUserPassword()!=null && !"".equals(user.getUserPassword())) {
					SET("userPassword=#{userPassword}");
				}
				if (user.getUserSex()!=null && !"".equals(user.getUserSex())) {
					SET("userSex=#{userSex}");
				}
				if (user.getUserPhone()!=null && !"".equals(user.getUserPhone())) {
					SET("userPhone=#{userPhone}");
				}
				if (user.getUserAddress()!=null && !"".equals(user.getUserAddress())) {
					SET("userAddress=#{userAddress}");
				}
				WHERE("userId=#{userId}");
			
				
			}
		}.toString();
	}
}
