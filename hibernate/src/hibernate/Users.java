package hibernate;

public class Users implements java.io.Serializable{
	private static final long serialVersionUID=1L;
	private Integer id;
	private String username;
	private String password;
	private String nickname;
	public Users(){
	}
	public Users(String username,String password,String nickname){
		this.username=username;
		this.password=password;
		this.nickname=nickname;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return this.nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
