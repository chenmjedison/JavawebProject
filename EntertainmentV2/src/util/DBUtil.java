package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.PageBean;

public class DBUtil {
	private String url;
	private String password;
	private String username;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int pageSize = 3;
	private String driver;
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public PreparedStatement getPstmt() {
		return pstmt;
	}
	public void setPstmt(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	//构造方法，定义驱动链接和用户名和密码信息
	public DBUtil(){
		driver="com.mysql.jdbc.Driver";
		url="jdbc:mysql://localhost:3306/entertaiment?useUnicode=true&amp;characterEncoding=UTF-8";
		username="root";
		password="root";	
	}
	//获取连接对象
	private Connection getConnection(){
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
			System.out.println("<===数据库连接成功===>");
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	//获取语句对象
	private PreparedStatement getPrepareStatement(String sql){
		try{
			pstmt=getConnection().prepareStatement(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return pstmt;
	}
	//给pstmt的sql语句设置参数(要求参数以数组形式给出)
	private void setParams(String sql,String[] params){
		pstmt=this.getPrepareStatement(sql);
		if(params != null){
			
				for(int i=0;i<params.length;i++)
					{
					try{
						pstmt.setString(i+1, params[i]);
						}catch(SQLException e){
							e.printStackTrace();
						}
					}
			}
		System.out.println(pstmt);
	}
	//执行数据库查询操作时，将返回的结果封装到list对象中
	public List getList(String sql,String[] params){
		List list=new ArrayList();
		try{
			System.out.println("<======调用getList方法！     "+sql);
			this.setParams(sql,params);
			
			ResultSet rs=pstmt.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next()){
				Map m=new HashMap();
				for(int i=1;i<=rsmd.getColumnCount();i++){
					String colName=rsmd.getColumnName(i);
					m.put(colName, rs.getString(colName));
				}
				list.add(m);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
		
	}
	//执行数据库查询操作时，将返回的结果封装到list对象中
	public Map getMap(String sql,String[] params){
		System.out.println(params);
		List list=getList(sql,params);
		if(list.isEmpty())
		{
			
			return null;
		}
		else
			return (Map)list.get(0);//这是个啥=.=
	}
	//更新数据库时调用的update方法
	public int update(String sql,String[] params)
	{
		int recNo=0;
		try{
			setParams(sql,params);
			recNo=pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close();
		}
		return recNo;
	}
	//关闭对象
	private void close() {
		// TODO Auto-generated method stub
		try{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//执行数据库查询操作时，返回结果的记录总数
	private int getTotalRows(String sql,String[] params){
		int totalRows=0;
//		sql=sql.toLowerCase(); 这里不需要转大小写
		String countSql="";
		if(sql.indexOf("group")>=0){
			countSql="select count(*) from ("+sql+") as tempNum";
		}else{
			countSql="select count(*) as tempNum "+sql.substring(sql.indexOf("from"));
			countSql=countSql.substring(0,countSql.indexOf("limit"));
//			System.out.println(countSql);
		}
		String count=(String)getMap(countSql,params).get("tempNum");
		totalRows=Integer.parseInt(count);
		return totalRows;
	}
	public PageBean getPageBean(String sql,String[] params,int curPage){
		String newSql=sql+" limit "+(curPage-1)*pageSize+","+pageSize;
		List data=this.getList(newSql,params);
		System.out.println(data);
		PageBean pb=new PageBean();
		pb.setCurPage(curPage);
		pb.setPageSize(pageSize);
		pb.setTotalRows(getTotalRows(newSql,params));
		pb.setData(data);
		return pb;
	}

}
