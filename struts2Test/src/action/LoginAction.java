package action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	private String username;
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception{
		if("zhangsan".equals(username)&&"1".equals(password)){
			System.out.println("AAA");
			return "success";
		}else{
			return "error";
		}
	}
	
}
