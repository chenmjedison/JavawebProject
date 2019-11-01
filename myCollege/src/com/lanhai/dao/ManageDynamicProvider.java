package com.lanhai.dao;

import org.apache.ibatis.jdbc.SQL;

import com.lanhai.pojo.Manage;

public class ManageDynamicProvider {
	
	public String updateManage(final Manage manage) { 
		return new SQL() {
			{
			
				UPDATE("tb_manage");
				
				if (manage.getManageName()!=null && !"".equals(manage.getManageName())) {
					SET("manageName=#{manageName}");
				}
				if (manage.getManagePassword()!=null && !"".equals(manage.getManagePassword())) {
					SET("managePassword=#{managePassword}");
				}
				if (manage.getManageQuanXian()!=null && !"".equals(manage.getManageQuanXian())) {
					SET("manageSex=#{manageSex}");
				}
				
				WHERE("manageId=#{manageId}");
			
				
			}
		}.toString();
	}

}
