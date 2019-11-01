package com.lanhai.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lanhai.dao.TiMuDao;
import com.lanhai.pojo.DiaoCha;
import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.WenJuanXX;

public interface TiMuService {
	//添加题目
	public boolean addTiMu(TiMu tiMu);
   //分页查询题目
	public PageInfo<TiMu> findTiMuByPage(int currentPage);
	
	//查询所有 题目
	public List<TiMu> findAllTiMu();
	
	//根据id 查询单个题目
	public TiMu findTiMuById(Integer tId);
	
	//根据Id删除题目信息
	public void deleteTiMu(Integer tId);
	
	//根据题目类型查询题目信息
	public PageInfo<TiMu> findTiMuType(int pageNum,String wjType);
	
	//动态修改
	public void updateTiMu(TiMu tiMu);
	
	//问卷答案保存
	public void addWenJuanXX(WenJuanXX wenJuanXX);
	
	//往题目选项中插入选项
	public void addTiMuXX(Integer tId,String xxName);
	
	//统计用户选择的数目
	public int tongJiTiMu(Integer count,Integer tId,String xxName);
	
	//查询题目选择的次数
	public WenJuanXX findTiMuCount(Integer tId,String xxName);
	
	//添加评论
	public void addPingLun(DiaoCha diaoCha);
	
	//查询所有 
	public PageInfo<DiaoCha> findAllPingLun(Integer currentPage);
	
	//根据id删除评论
	public int deletePingLun(Integer plId);
	
	//查找所有题目类型
	public List<TiMu> findAllTypeTiMu();
	
	

}
