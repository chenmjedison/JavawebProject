package com.lanhai.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanhai.dao.WenJuanDao;
import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.WenJuan;
import com.lanhai.service.WenJuanService;

@Service("wenJuanService")
public class WenJuanServiceImpl implements WenJuanService{
	
	@Autowired
	private WenJuanDao wenJuanDao;
	
	

	public void setWenJuanDao(WenJuanDao wenJuanDao) {
		this.wenJuanDao = wenJuanDao;
	}

	@Override
	public void addWenJuan(WenJuan wenJuan) {
		
		 wenJuanDao.saveWenJuan(wenJuan);
	}

	@Override
	public PageInfo<WenJuan> findAllWenJuanByPage(Integer currentPage) {
		PageHelper.startPage(currentPage, 2, "wjId");
		
		List<WenJuan> wenJuanList=wenJuanDao.findAllWenJuan();
		return new PageInfo<WenJuan>(wenJuanList);
	}

	@Override
	public WenJuan findWenJuanById(String wjId) {
		
		return wenJuanDao.findWenJuanById(wjId);
	}

	@Override
	public List<WenJuan> findAllWenJuan() {
		
		return wenJuanDao.findAllWenJuan();
	}

	@Override
	public PageInfo<WenJuan> findWenJuanType(String wjType,Integer currentPage) {
		PageHelper.startPage(currentPage, 2, "wjId");
		List<WenJuan> wenJuanList=wenJuanDao.findWenJuanType(wjType);
		return new PageInfo<WenJuan>(wenJuanList);
	}

	@Override
	public PageInfo<WenJuan> findWenJuanLikeName(String wjName,Integer currentPage) {
		PageHelper.startPage(currentPage, 2, "wjId");
		List<WenJuan> wenJuanList=wenJuanDao.findWenJuanLikeName(wjName);
		return new PageInfo<WenJuan>(wenJuanList);
	}

	@Override
	public int deleteWenjuan(String wjId) {
		
		return wenJuanDao.deleteWenJuanById(wjId);
	}

	@Override
	public PageInfo<TiMu> findTiMuByWenJuan(String wjId,Integer currentPage) {
		PageHelper.startPage(currentPage, 2, "tId");
		List<TiMu> tiMuList=wenJuanDao.findTiMuByWenJuan(wjId);
		return new PageInfo<TiMu>(tiMuList);
	}

	@Override
	public List<TiMu> findAllTiMuByWenJuan(String wjId) {
		return wenJuanDao.findTiMuByWenJuan(wjId);
	}

	@Override
	public List<WenJuan> findAllTypeWenJuan() {
		return wenJuanDao.findAllTypeWenJuan();
	}

	@Override
	public PageInfo<WenJuan> findWenJuanByType(Integer currentPage,String wjType) {
		PageHelper.startPage(currentPage, 2, "wjId");
		List<WenJuan> wenJuanList=wenJuanDao.findWenJuanByType(wjType);
		
		return new PageInfo<WenJuan>(wenJuanList);
	}

}
