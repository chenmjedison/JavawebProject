package bean;

import java.sql.*;

public class DBManager {
	public static Connection getConn() {
		/*final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		final String connStr = "jdbc:sqlserver://localhost:1433;DatabaseName=StuInfo";
		final String user ="root";
		final String pass = "root";*/
		/*final String sql = "com.microsoft.sqlserver.jdbc.SQLServerDriver";*/
		final String driverClass = "com.mysql.jdbc.Driver";
		/*final String datebase = "jdbc:sqlserver://localhost:1433;DatabaseName=CakeShop";*/
		final String connStr = "jdbc:mysql://localhost:3306/student?useUnicode=true&amp;characterEncoding=UTF-8";
		final String user = "root";
		final String pass = "root";
		Connection conn = null;
		
		try {
			//����SQLServer��ݿ������
			Class.forName(driverClass);
			System.out.println("数据库驱动加载成功！");
			
			//�������Ӷ���
			conn = DriverManager.getConnection(connStr,user,pass);
			System.out.println("获取数据库连接成功！");
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return conn;
	
	}

}
