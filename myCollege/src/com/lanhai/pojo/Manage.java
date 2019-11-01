package com.lanhai.pojo;

public class Manage {

	//π‹¿Ì‘±
	
	private Integer manageId;
	
	private String manageName;
	
	private String managePassword;
	
	private String manageQuanXian;

	public Manage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manage(Integer manageId, String manageName, String managePassword, String manageQuanXian) {
		super();
		this.manageId = manageId;
		this.manageName = manageName;
		this.managePassword = managePassword;
		this.manageQuanXian = manageQuanXian;
	}

	@Override
	public String toString() {
		return "Manage [manageId=" + manageId + ", manageName=" + manageName + ", managePassword=" + managePassword
				+ ", manageQuanXian=" + manageQuanXian + "]";
	}

	public Manage(String manageName, String managePassword, String manageQuanXian) {
		super();
		this.manageName = manageName;
		this.managePassword = managePassword;
		this.manageQuanXian = manageQuanXian;
	}

	public Integer getManageId() {
		return manageId;
	}

	public void setManageId(Integer manageId) {
		this.manageId = manageId;
	}

	public String getManageName() {
		return manageName;
	}

	public void setManageName(String manageName) {
		this.manageName = manageName;
	}

	public String getManagePassword() {
		return managePassword;
	}

	public void setManagePassword(String managePassword) {
		this.managePassword = managePassword;
	}

	public String getManageQuanXian() {
		return manageQuanXian;
	}

	public void setManageQuanXian(String manageQuanXian) {
		this.manageQuanXian = manageQuanXian;
	}
	
	
	
}
