package com.lanhai.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanhai.dao.TiMuDao;
import com.lanhai.pojo.DiaoCha;
import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.WenJuanXX;
import com.lanhai.service.TiMuService;


@Service("tiMuService")
public class TiMuServiceImpl implements TiMuService{

	@Autowired
	private TiMuDao tiMuDao;
	
	public void setTiMuDao(TiMuDao tiMuDao) {
		this.tiMuDao = tiMuDao;
	}

	/*@Override*/
	public boolean addTiMu(TiMu tiMu) {
		
		return tiMuDao.saveTiMu(tiMu);
		
	}

	/*@Override*/
	public PageInfo<TiMu> findTiMuByPage(int currentPage) {
		// 页码 每页显示的个数 排序条件
				PageHelper.startPage(currentPage, 5, "tId"); // 每页显示2条

				// 调用查询所有
				List<TiMu> timuList = tiMuDao.findAllTiMu();

				return new PageInfo<TiMu>(timuList);
	}

	/*@Override*/
	public TiMu findTiMuById(Integer id) {
		
		return  tiMuDao.findTiMuById(id);
	}

	/*@Override*/
	public void deleteTiMu(Integer id) {
		tiMuDao.deleteTiMuById(id);
		
	}

	/*@Override*/
	public PageInfo<TiMu> findTiMuType(int pageNum,String wjType) {
		PageHelper.startPage(pageNum,5,"tId");
		List<TiMu> tiMuList=tiMuDao.findTiMuType(wjType);
		return new PageInfo<TiMu>(tiMuList);
	}

	/*@Override*/
	public void updateTiMu(TiMu tiMu) {
		tiMuDao.updateTiMu(tiMu);
		
	}

	/*@Override*/
	public List<TiMu> findAllTiMu() {
		return tiMuDao.findAllTiMu();
		
	}

	/*@Override*/
	public void addWenJuanXX(WenJuanXX wenJuanXX) {
		// TODO Auto-generated method stub
		
	}

	/*@Override*/
	public void addTiMuXX(Integer tId, String xxName) {
		tiMuDao.addTiMuXX(tId, xxName);
		
	}

	/*@Override*/
	public int tongJiTiMu(Integer count, Integer tId, String xxName) {
		
		return tiMuDao.updateTiMuXX(count, tId, xxName);
	}

	/*@Override*/
	public WenJuanXX findTiMuCount(Integer tId, String xxName) {
		
		return tiMuDao.findTiMuCount(tId, xxName);
	}

	/*@Override*/
	public void addPingLun(DiaoCha diaoCha) {
		tiMuDao.addPingLun(diaoCha);
		
	}

	/*@Override*/
	public PageInfo<DiaoCha> findAllPingLun(Integer currentPage) {
		PageHelper.startPage(currentPage, 5, "plId");
		List<DiaoCha> pingLunList=tiMuDao.findAddPingLun();
		
		return new PageInfo<DiaoCha>(pingLunList);
	}

	/*@Override*/
	public int deletePingLun(Integer plId) {
		
		return tiMuDao.deletePingLun(plId);
	}

	/*@Override*/
	public List<TiMu> findAllTypeTiMu() {
		
		return tiMuDao.findAllTypeTiMu();
	}



}
