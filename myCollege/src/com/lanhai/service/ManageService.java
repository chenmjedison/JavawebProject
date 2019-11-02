package com.lanhai.service;

import com.github.pagehelper.PageInfo;
import com.lanhai.pojo.Manage;


public interface ManageService {

	//添加员工
		public void saveManage(Manage manage);
		
		//查询所有
		public PageInfo<Manage> findAllManageByPage(Integer currentPage);
		
		//根据员工名查询
		public Manage findManageByName(String manageName);
		
		
		
		//动态更新
		public void updateManage(Manage manage);
		
		//根据id 删除员工
		public int deleteManageById(Integer manageId);
		
		//根据员工名 模糊查询
		public PageInfo<Manage> findManageLikeName(String manageName,Integer currentPage);
		
		//验证登录
		public Manage checkManageNameAndPwd(String manageName,String managePassword);
		
		//根据员工id查询
		public Manage findManageById(Integer id);
	
}
