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

<<<<<<< HEAD
	@Override
=======
	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public boolean addTiMu(TiMu tiMu) {
		
		return tiMuDao.saveTiMu(tiMu);
		
	}

<<<<<<< HEAD
	@Override
	public PageInfo<TiMu> findTiMuByPage(int currentPage) {
		// Ò³ï¿½ï¿½ Ã¿Ò³ï¿½ï¿½Ê¾ï¿½Ä¸ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
				PageHelper.startPage(currentPage, 5, "tId"); // Ã¿Ò³ï¿½ï¿½Ê¾2ï¿½ï¿½

				// ï¿½ï¿½ï¿½Ã²ï¿½Ñ¯ï¿½ï¿½ï¿½ï¿½
=======
	/*@Override*/
	public PageInfo<TiMu> findTiMuByPage(int currentPage) {
		// Ò³Âë Ã¿Ò³ÏÔÊ¾µÄ¸öÊý ÅÅÐòÌõ¼þ
				PageHelper.startPage(currentPage, 5, "tId"); // Ã¿Ò³ÏÔÊ¾2Ìõ

				// µ÷ÓÃ²éÑ¯ËùÓÐ
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
				List<TiMu> timuList = tiMuDao.findAllTiMu();

				return new PageInfo<TiMu>(timuList);
	}
<<<<<<< HEAD
	
	@Override
=======

	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public TiMu findTiMuById(Integer id) {
		
		return  tiMuDao.findTiMuById(id);
	}

<<<<<<< HEAD
	@Override
=======
	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public void deleteTiMu(Integer id) {
		tiMuDao.deleteTiMuById(id);
		
	}

<<<<<<< HEAD
	@Override
=======
	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public PageInfo<TiMu> findTiMuType(int pageNum,String wjType) {
		PageHelper.startPage(pageNum,5,"tId");
		List<TiMu> tiMuList=tiMuDao.findTiMuType(wjType);
		return new PageInfo<TiMu>(tiMuList);
	}

<<<<<<< HEAD
	@Override
=======
	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public void updateTiMu(TiMu tiMu) {
		tiMuDao.updateTiMu(tiMu);
		
	}

<<<<<<< HEAD
	@Override
=======
	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public List<TiMu> findAllTiMu() {
		return tiMuDao.findAllTiMu();
		
	}

<<<<<<< HEAD
	@Override
=======
	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public void addWenJuanXX(WenJuanXX wenJuanXX) {
		// TODO Auto-generated method stub
		
	}

<<<<<<< HEAD
	@Override
=======
	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public void addTiMuXX(Integer tId, String xxName) {
		tiMuDao.addTiMuXX(tId, xxName);
		
	}

<<<<<<< HEAD
	@Override
=======
	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public int tongJiTiMu(Integer count, Integer tId, String xxName) {
		
		return tiMuDao.updateTiMuXX(count, tId, xxName);
	}

<<<<<<< HEAD
	@Override
=======
	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public WenJuanXX findTiMuCount(Integer tId, String xxName) {
		
		return tiMuDao.findTiMuCount(tId, xxName);
	}

<<<<<<< HEAD
	@Override
=======
	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public void addPingLun(DiaoCha diaoCha) {
		tiMuDao.addPingLun(diaoCha);
		
	}

<<<<<<< HEAD
	@Override
=======
	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public PageInfo<DiaoCha> findAllPingLun(Integer currentPage) {
		PageHelper.startPage(currentPage, 5, "plId");
		List<DiaoCha> pingLunList=tiMuDao.findAddPingLun();
		
		return new PageInfo<DiaoCha>(pingLunList);
	}

<<<<<<< HEAD
	@Override
=======
	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public int deletePingLun(Integer plId) {
		
		return tiMuDao.deletePingLun(plId);
	}

<<<<<<< HEAD
	@Override
=======
	/*@Override*/
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public List<TiMu> findAllTypeTiMu() {
		
		return tiMuDao.findAllTypeTiMu();
	}



}
