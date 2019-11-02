package com.lanhai.pojo;

public class QuanXian {

	//È¨ÏÞ±í
	
	
	private int qxId;
	private String qxName;
	public QuanXian() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuanXian(int qxId, String qxName) {
		super();
		this.qxId = qxId;
		this.qxName = qxName;
	}
	@Override
	public String toString() {
		return "QuanXian [qxId=" + qxId + ", qxName=" + qxName + "]";
	}
	public QuanXian(String qxName) {
		super();
		this.qxName = qxName;
	}
	public int getQxId() {
		return qxId;
	}
	public void setQxId(int qxId) {
		this.qxId = qxId;
	}
	public String getQxName() {
		return qxName;
	}
	public void setQxName(String qxName) {
		this.qxName = qxName;
	}
	
	
	
	
}
