package com.lanhai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.lanhai.pojo.DiaoCha;
import com.lanhai.pojo.TiMu;
import com.lanhai.pojo.WenJuanXX;


public interface TiMuDao {

	
	@Select("select * from tb_t group by wjType")
	public List<TiMu> findAllTypeTiMu();
	
	
	//动态插入题目
<<<<<<< HEAD
	@Insert("insert into tb_t(tId,wjType,tInner,tBeiZhu) values(null,#{wjType},#{tInner},#{tBeiZhu})")
=======
	@Insert("insert into tb_t(tId,wjType,tInner,tBeiZhu) values(#{tId},#{wjType},#{tInner},#{tBeiZhu})")
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	@Options(useGeneratedKeys=true,keyColumn="tId",keyProperty="tId")
	public boolean saveTiMu(TiMu tiMu);

	
	//查询所有
	@Select("select * from tb_t")
	public List<TiMu> findAllTiMu();
	

	//动态更新
	@UpdateProvider(type=TiMuDynamicProvider.class,method="updateTiMu")
	public void updateTiMu(TiMu tiMu );
	
	//根据题目类型查找题目
	@Select("select  * from tb_t where wjType=#{wjType} ")
	public List<TiMu> findTiMuType(@Param("wjType") String wjType);
	
	//根据题目id查找题目
	@Select("select * from tb_t where tId=#{tId}")
	public TiMu findTiMuById(@Param("tId") Integer tId);
	
	//根据id删除题目
	@Delete("delete from tb_t where tId=#{tId}")
	public int deleteTiMuById(Integer tId);
	
	
	//往题目选项中插入选项
<<<<<<< HEAD
	@Insert("insert into  tb_xx(tId,xxName) values(null,#{xxName}) ")
=======
	@Insert("insert into  tb_xx(tId,xxName) values(#{tId},#{xxName}) ")
	
>>>>>>> f242a6858a772c6f67076b8f64fad359675c42ec
	public void addTiMuXX(@Param("tId") Integer tId,@Param("xxName") String xxName);
	
	//根据题目id进行修改
	@Update("update tb_xx set count=#{count} where tId=#{tId} and xxName=#{xxName}")
	public int updateTiMuXX(@Param("count") Integer count,@Param("tId") Integer tId ,@Param("xxName") String xxName);
	
	//根据题目id和xxName 查询
	@Select("select * from tb_xx where tId=#{tId} and xxName=#{xxName}")
	public WenJuanXX findTiMuCount(@Param("tId") Integer tId,@Param("xxName") String xxName);
	
	//添加评论信息
	@Insert("insert into tb_dc(plId,userName,wjId,plInner,plTime) values(#{plId},#{userName},#{wjId},#{plInner},#{plTime})")
	@Options(useGeneratedKeys=true,keyColumn="plId",keyProperty="plId")
	public void addPingLun(DiaoCha diaoCha);
	
	//查询所有的评论
	@Select("select * from tb_dc")
	public List<DiaoCha> findAddPingLun();
	
	//根据id删除评论
	@Delete("delete tb_dc where plId=#{plId}")
	public int deletePingLun(Integer plId);
	
	//根据 题目id  选项查询问卷选项次数
	
	
	
}
