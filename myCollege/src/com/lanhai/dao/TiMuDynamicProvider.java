package com.lanhai.dao;

import org.apache.ibatis.jdbc.SQL;

import com.lanhai.pojo.TiMu;


public class TiMuDynamicProvider {

	// 动态插入新用户
		public String insertTiMu(final TiMu tiMu) {
			return new SQL() {
				{
				
					INSERT_INTO("tb_t");
				
					if (tiMu.getWjId()!=null && !"".equals(tiMu.getWjId())) {
						VALUES("wjId", "#{wjId}");
					}
					if (tiMu.getXxId()!=null && !"".equals(tiMu.getXxId())) {
						VALUES("xxId", "#{xxId}");
					}
					if (tiMu.getWjType()!=null && !"".equals(tiMu.getWjType())) {
						VALUES("wjType", "#{wjType}");
					}
					if (tiMu.gettInner()!=null && !"".equals(tiMu.gettInner())) {
						VALUES("tInner", "#{tInner}");
					}
					if (tiMu.gettBeiZhu()!=null && !"".equals(tiMu.gettBeiZhu())) {
						VALUES("tBeiZhu", "#{tBeiZhu}");
					}
				
					
				}
			}.toString();
		}
		public String updateTiMu(final TiMu tiMu) {
			return new SQL() {
				{
				
					UPDATE("tb_t");
					
					if (tiMu.getWjId()!=null && !"".equals(tiMu.getWjId())) {
						SET("wjId=#{wjId}");
					}
					if (tiMu.getXxId()!=null && !"".equals(tiMu.getXxId())) {
						SET("xxId=#{xxId}");
					}
					if (tiMu.getWjType()!=null && !"".equals(tiMu.getWjType())) {
						SET("wjType=#{wjType}");
					}
					if (tiMu.gettInner()!=null && !"".equals(tiMu.gettInner())) {
						SET("tInner=#{tInner}");
					}
					if (tiMu.gettBeiZhu()!=null && !"".equals(tiMu.gettBeiZhu())) {
						SET("tBeiZhu=#{tBeiZhu}");
					}
					WHERE("tId=#{tId}");
				
					
				}
			}.toString();
		}

}
