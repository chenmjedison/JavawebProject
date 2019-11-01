package com.lanhai.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class WenJuan {

	private String wjId;
	private String wjName;
	//问卷包含的题目数
	private Integer wjNum;
	private String wjType;
	
	private String wjBeiZhu;
	
	//问卷发布人
	private String wjAuthor;
	
	//问卷发布时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date wjTime;

	public WenJuan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WenJuan(String wjId, String wjName, Integer wjNum, String wjType, String wjBeiZhu, String wjAuthor,
			Date wjTime) {
		super();
		this.wjId = wjId;
		this.wjName = wjName;
		this.wjNum = wjNum;
		this.wjType = wjType;
		this.wjBeiZhu = wjBeiZhu;
		this.wjAuthor = wjAuthor;
		this.wjTime = wjTime;
	}

	public WenJuan(String wjId, String wjName, Integer wjNum, String wjType, String wjBeiZhu) {
		super();
		this.wjId = wjId;
		this.wjName = wjName;
		this.wjNum = wjNum;
		this.wjType = wjType;
		this.wjBeiZhu = wjBeiZhu;
	}

	@Override
	public String toString() {
		return "WenJuan [wjId=" + wjId + ", wjName=" + wjName + ", wjNum=" + wjNum + ", wjType=" + wjType
				+ ", wjBeiZhu=" + wjBeiZhu + ", wjAuthor=" + wjAuthor + ", wjTime=" + wjTime + "]";
	}

	public String getWjId() {
		return wjId;
	}

	public void setWjId(String wjId) {
		this.wjId = wjId;
	}

	public String getwjName() {
		return wjName;
	}

	public void setwjName(String wjName) {
		this.wjName = wjName;
	}

	public Integer getWjNum() {
		return wjNum;
	}

	public void setWjNum(Integer wjNum) {
		this.wjNum = wjNum;
	}

	public String getWjType() {
		return wjType;
	}

	public void setWjType(String wjType) {
		this.wjType = wjType;
	}

	public String getWjBeiZhu() {
		return wjBeiZhu;
	}

	public void setWjBeiZhu(String wjBeiZhu) {
		this.wjBeiZhu = wjBeiZhu;
	}

	public String getWjAuthor() {
		return wjAuthor;
	}

	public void setWjAuthor(String wjAuthor) {
		this.wjAuthor = wjAuthor;
	}

	public Date getWjTime() {
		return wjTime;
	}

	public void setWjTime(Date wjTime) {
		this.wjTime = wjTime;
	}

	
	
}
