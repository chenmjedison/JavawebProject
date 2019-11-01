package bean;

import java.sql.*;

import bean.DBManager;

public class UserDAO {
	String username;
	String pwd;
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	/**********************************************
	 * 该方法验证登录的用户名和密码是否正确
	 * @param username：用户名
	 * @param password：密码
	 * @return：是否有效用户
	 *********************************************/
	public boolean checkLogin(String username, String pwd) {
		boolean b = false; 
		Connection conn = null;
		Statement  st = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConn();
			//st = conn.createStatement();
			//String sql = "select * from User_Table where user_name ='" + username +"' and user_password = '" + pwd + "'";
		    String sql = "select * from User_Table where username = ? and pwd = ?";
			System.out.println(sql);
			prst = conn.prepareStatement(sql);
			prst.setString(1, username);
			prst.setString(2,pwd);

		     //rs = st.executeQuery(sql);
			rs = prst.executeQuery();
		     
		     if (rs.next()) 
		    	 b = true;
		     else
		    	 b = false; 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		    	try {rs.close();} catch (SQLException e) {} 
		    	try {prst.close();} catch (SQLException e) {} 
		    	try {conn.close();} catch (SQLException e) {} 
	    }
		
		/*if (username != null && username.equals("zhangsan") && pwd != null && pwd.equals("123456"))
			b = true;
		else 
			b = false;
			*/
		return b; 
			
	}
	
	/**********************************************
	 * 该方法添加新的注册用户
	 * @param username：用户名
	 * @param password：密码
	 * @param sex：用户名
	 * @param email：电子邮箱
	 * @param info：基本信息
	 * @return：是否注册用户添加成功
	 *********************************************/
	public boolean register(String username, String password,String sex, String email, String info) {
		boolean b = false; 
		Connection conn = null;
		PreparedStatement prst = null; 
		ResultSet rs = null; 
		
	    try {
	
			conn = DBManager.getConn();
			String sql = "insert into User_Table values(?,?,?,?,?)" ;
			prst = conn.prepareStatement(sql);
			prst.setString(1, username);
			prst.setString(2, password);
			prst.setString(3,sex);
			prst.setString(4,email);
			prst.setString(5,info);

			//System.out.println(sql);
            int i  = prst.executeUpdate();
            if (i > 0){
            	 
            	   b = true; 
            }
      
		} 
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    finally {
	    	try {prst.close();} catch (SQLException e) {} 
	    	try {conn.close();} catch (SQLException e) {} 
	    }
		
		return b;
		
	}

}
