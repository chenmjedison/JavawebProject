package com.lanhai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.lanhai.pojo.Manage;

public interface ManageDao {
	
	
	//员工添加
		@Select("insert into tb_manage(manageId,manageName,managePassword,manageQuanXian) values(#{manageId},#{manageName},#{managePassword},#{manageQuanXian})")
		@Options(useGeneratedKeys=true,keyColumn="manageId",keyProperty="manageId")
		public void saveManage(Manage manage);
		
		//查询所有员工
		@Select("select * from tb_manage")
		public List<Manage> findAllManage();
		
		//根据员工名查询
		@Select("select * from tb_manage where manageName=#{manageName}")
		public Manage findManageByName(@Param("manageName") String manageName);
		
		
		
		//动态更新
		@UpdateProvider(type=ManageDynamicProvider.class,method="updateManage")
		public void updateManage(Manage manage);
		
		//根据id 查找员工
		@Select("select * from tb_manage where manageId=#{manageId}")
		public Manage findManageById(@Param("manageId") Integer manageId);
		
		//根据id删除员工
		@Delete("delete from tb_manage where manageId=#{manageId}")
		public int deleteManageById(Integer manageId);
		
		//模糊查询
		@Select("select * from tb_manage where manageName like concat('%',#{manageName},'%')")
		public List<Manage> findManageLikeName(@Param("manageName") String manageName );
		
		//验证登录
		@Select("select * from tb_manage where manageName=#{manageName} and managePassword=#{managePassword}")
		public Manage manageNameAndPassword(@Param("manageName") String manageName,@Param("managePassword") String managePassword);
		

}
