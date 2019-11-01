package com.lanhai.pojo;

public class TiMu {

	//问卷题目
	//题目编号
	private Integer tId;

	//问卷编号
	private String wjId;
	//选项 id
	private Integer xxId;
	//题目类型
	private String wjType;
	//题目内容
	private String tInner;
	private String tBeiZhu;
	public TiMu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TiMu(Integer tId, String wjId, Integer xxId, String wjType, String tInner, String tBeiZhu) {
		super();
		this.tId = tId;
		this.wjId = wjId;
		this.xxId = xxId;
		this.wjType = wjType;
		this.tInner = tInner;
		this.tBeiZhu = tBeiZhu;
	}
	public TiMu(String wjId, Integer xxId, String wjType, String tInner, String tBeiZhu) {
		super();
		this.wjId = wjId;
		this.xxId = xxId;
		this.wjType = wjType;
		this.tInner = tInner;
		this.tBeiZhu = tBeiZhu;
	}
	@Override
	public String toString() {
		return "TiMu [tId=" + tId + ", wjId=" + wjId + ", xxId=" + xxId + ", wjType=" + wjType + ", tInner=" + tInner
				+ ", tBeiZhu=" + tBeiZhu + "]";
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public String getWjId() {
		return wjId;
	}
	public void setWjId(String wjId) {
		this.wjId = wjId;
	}
	public Integer getXxId() {
		return xxId;
	}
	public void setXxId(Integer xxId) {
		this.xxId = xxId;
	}
	public String getWjType() {
		return wjType;
	}
	public void setWjType(String wjType) {
		this.wjType = wjType;
	}
	public String gettInner() {
		return tInner;
	}
	public void settInner(String tInner) {
		this.tInner = tInner;
	}
	public String gettBeiZhu() {
		return tBeiZhu;
	}
	public void settBeiZhu(String tBeiZhu) {
		this.tBeiZhu = tBeiZhu;
	}
	
	
	
	
	
	
	
	
	
	
}
