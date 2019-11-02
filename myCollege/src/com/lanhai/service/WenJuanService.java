package com.lanhai.service;

import java.util.List;



import com.github.pagehelper.PageInfo;
import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.WenJuan;

public interface WenJuanService {
	
	//添加问卷
	public void addWenJuan(WenJuan wenJuan);
	
	//分页查询所有问卷
	public PageInfo<WenJuan> findAllWenJuanByPage(Integer currentPage);
	
	//根据id查询问卷
	public WenJuan findWenJuanById(String wjId);
	
	//查询所有
	public List<WenJuan> findAllWenJuan();
	
	//根据类型查询问卷
	public PageInfo<WenJuan> findWenJuanType(String wjType,Integer currentPage);
	
	//模糊查询
	public PageInfo<WenJuan> findWenJuanLikeName(String wjName,Integer currentPage);
	
	//根据id 删除问卷
	public int deleteWenjuan(String wjId);
	
	//分页根据问卷id查询题目
	public PageInfo<TiMu> findTiMuByWenJuan(String wjId,Integer currentPage);
	
	//根据问卷id查询题目
	public List<TiMu> findAllTiMuByWenJuan(String wjId);
	
	//
	public List<WenJuan> findAllTypeWenJuan();
	
	public PageInfo<WenJuan> findWenJuanByType(Integer currentPage,String wjType);

}
