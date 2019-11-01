package util;

import java.sql.*;
import java.util.*;

import bean.PageBean;

public class DBUtil {
	private String driver;
	private String url;
	private String username;
	private String password;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private static int count=1;
	private int pageSize=3;
	public void setDriver(String driver)
	{
		this.driver=driver;
	}
	public void setUrl(String url)
	{
		this.url=url;
	}
	public void setUsername(String username)
	{
		this.username=username;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public DBUtil(){
		driver="com.mysql.jdbc.Driver";
		url="jdbc:mysql://localhost:3306/book?useUnicode=true&amp;characterEncoding=UTF-8";
		username="root";
		password="root";	
	}
	/*public DBUtil(){
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		url="jdbc:sqlserver://localhost:1433;DatabaseName=book";
		username="sa";
		password="sasa";	
	}*/
	private Connection getConnection(){
		try{
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	private PreparedStatement getPrepareStatement(String sql){
		try{
			pstmt=getConnection().prepareStatement(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return pstmt;
	}
	private void setParams(String sql,String[] params){
		pstmt=this.getPrepareStatement(sql);
		try{
			if(params!=null){
			for(int i=0;i<params.length;i++)
				{
					pstmt.setString(i+1, params[i]);
				}
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	public List getList(String sql,String[] params){
		List list=new ArrayList();
		try{
			this.setParams(sql,params);
			ResultSet rs=pstmt.executeQuery();
			System.out.println(pstmt);
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
	public List getAllList(String sql){
		List list=new ArrayList();
		try{
			this.setParamsAll(sql);
			System.out.println(pstmt);
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
	private void setParamsAll(String sql){
		pstmt=this.getPrepareStatement(sql);
		
		
	}
	public Map getMap(String sql,String[] params){
		List list=getList(sql,params);
		if(list.isEmpty())
		{
			return null;
		}
		else
			return (Map)list.get(0);
	}
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
	private int getTotalRows(String sql,String[] params){
		int totalRows=0;
		sql=sql.toLowerCase();
		String countSql="";
		if(sql.indexOf("group")>=0){
			countSql="select count(*) from ("+sql+") as tempNum";
		}else{
			countSql="select count(*) as tempNum "+sql.substring(sql.indexOf("from"));
			countSql=countSql.substring(0,countSql.indexOf("limit"));
		}
		String count=(String)getMap(countSql,params).get("tempNum");
		totalRows=Integer.parseInt(count);
		System.out.println("查询出的总行数："+count);
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
