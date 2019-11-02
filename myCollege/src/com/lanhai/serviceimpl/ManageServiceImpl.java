package com.lanhai.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanhai.dao.ManageDao;
import com.lanhai.pojo.Manage;
import com.lanhai.service.ManageService;
@Service("manageService")
public class ManageServiceImpl implements ManageService{

	@Autowired
	private ManageDao manageDao;
	
	
	
	

	public void setManageDao(ManageDao manageDao) {
		this.manageDao = manageDao;
	}

	@Override
	public void saveManage(Manage manage) {
		manageDao.saveManage(manage);
		
	}

	@Override
	public PageInfo<Manage> findAllManageByPage(Integer currentPage) {
		PageHelper.startPage(currentPage, 2, "manageId");
		List<Manage> manageList=manageDao.findAllManage();
		System.out.println("-------------"+manageList);
		return new PageInfo<Manage>(manageList);
	}

	@Override
	public Manage findManageByName(String manageName) {
		return manageDao.findManageByName(manageName);
	}

	@Override
	public void updateManage(Manage manage) {
		manageDao.updateManage(manage);
		
	}

	@Override
	public int deleteManageById(Integer manageId) {
		return manageDao.deleteManageById(manageId);
	}

	@Override
	public PageInfo<Manage> findManageLikeName(String manageName, Integer currentPage) {
		PageHelper.startPage(currentPage, 2, "manageId");
		List<Manage> manageList=manageDao.findManageLikeName(manageName);
		return new PageInfo<Manage>(manageList);
	}

	@Override
	public Manage checkManageNameAndPwd(String manageName, String managePassword) {
		
		return manageDao.manageNameAndPassword(manageName, managePassword);
	}

	@Override
	public Manage findManageById(Integer id) {
		
		return manageDao.findManageById(id);
	}

}
