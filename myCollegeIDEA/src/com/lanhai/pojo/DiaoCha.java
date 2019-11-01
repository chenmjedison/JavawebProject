package com.lanhai.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DiaoCha {

	//调查表
	private Integer plId;
	private String userName;
	
	private String wjId;
	
	
	//评论信息
	private String plInner;
	//评论时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date plTime;
	public DiaoCha() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiaoCha(Integer plId, String userName, String wjId, String plInner, Date plTime) {
		super();
		this.plId = plId;
		this.userName = userName;
		this.wjId = wjId;
		this.plInner = plInner;
		this.plTime = plTime;
	}
	@Override
	public String toString() {
		return "DiaoCha [plId=" + plId + ", userName=" + userName + ", wjId=" + wjId + ", plInner=" + plInner
				+ ", plTime=" + plTime + "]";
	}
	public DiaoCha(String userName, String wjId, String plInner, Date plTime) {
		super();
		this.userName = userName;
		this.wjId = wjId;
		this.plInner = plInner;
		this.plTime = plTime;
	}
	public Integer getPlId() {
		return plId;
	}
	public void setPlId(Integer plId) {
		this.plId = plId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getWjId() {
		return wjId;
	}
	public void setWjId(String wjId) {
		this.wjId = wjId;
	}
	public String getPlInner() {
		return plInner;
	}
	public void setPlInner(String plInner) {
		this.plInner = plInner;
	}
	public Date getPlTime() {
		return plTime;
	}
	public void setPlTime(Date plTime) {
		this.plTime = plTime;
	}
	
	
	
}
