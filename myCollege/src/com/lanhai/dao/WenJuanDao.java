package com.lanhai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.WenJuan;
import com.lanhai.pojo.WenJuanXX;

public interface WenJuanDao {
	
	
	//添加问卷
	@Insert("insert into tb_wj(wjId,wjName,wjNum,wjType,wjBeiZhu,wjAuthor,wjTime) "
			+ "values(#{wjId},#{wjName},#{wjNum},#{wjType},#{wjBeiZhu},#{wjAuthor},#{wjTime} )")
	public void saveWenJuan(WenJuan wenJuan);
	
	//查询所有
	@Select("select * from tb_wj")
	public List<WenJuan> findAllWenJuan();
	
	//查询所有类型的问卷
	@Select("select * from tb_wj group by wjType")
	public List<WenJuan> findAllTypeWenJuan();
	
	//根据id查询问卷
	@Select("select * from tb_wj where wjId=#{wjId}")
	public WenJuan findWenJuanById(@Param("wjId") String wjId);
	
	//根据id 删除问卷
	@Delete("delete from tb_wj where wjId=#{wjId}")
	public int deleteWenJuanById(String wjId);
	
	//模糊查询
	@Select("select * from tb_wj where wjName like concat('%',#{wjName},'%') ")
	public List<WenJuan> findWenJuanLikeName(@Param("wjName") String wjName);

	
	//根据问卷类型查询问卷
	@Select("select distinct *　form tb_wj where wjType=#{wjType}")
	public List<WenJuan> findWenJuanType(@Param("wjType") String wjType);
	
	//根据问卷id 查询相应的题目
	@Select("select * from tb_t where wjId=#{wjId}")
	public List<TiMu> findTiMuByWenJuan(@Param("wjId") String wjId);
	
	//根据问卷类型查找问卷
	@Select("select * from tb_wj where wjType=#{wjType}")
	public List<WenJuan> findWenJuanByType(@Param("wjType") String wjType);
	

}
