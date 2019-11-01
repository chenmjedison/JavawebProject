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
	//���췽���������������Ӻ��û�����������Ϣ
	public DBUtil(){
		driver="com.mysql.jdbc.Driver";
		url="jdbc:mysql://localhost:3306/entertainment?useUnicode=true&amp;characterEncoding=UTF-8";
		username="root";
		password="root";	
	}
	//��ȡ���Ӷ���
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
	//��ȡ������
	private PreparedStatement getPrepareStatement(String sql){
		try{
			pstmt=getConnection().prepareStatement(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return pstmt;
	}
	//��pstmt��sql������ò���(Ҫ�������������ʽ����)
	private void setParams(String sql,String[] params){
		pstmt=this.getPrepareStatement(sql);
		if(params != null){
			try{
				for(int i=0;i<params.length;i++)
					{
						pstmt.setString(i+1, params[i]);
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
	}
	//ִ�����ݿ��ѯ����ʱ�������صĽ����װ��list������
	public List getList(String sql,String[] params){
		List list=new ArrayList();
		try{
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
	//ִ�����ݿ��ѯ����ʱ�������صĽ����װ��list������
	public Map getMap(String sql,String[] params){
		List list=getList(sql,params);
		if(list.isEmpty())
		{
			return null;
		}
		else
			return (Map)list.get(0);
	}
	//�������ݿ�ʱ���õ�update����
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
	//�رն���
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
	//ִ�����ݿ��ѯ����ʱ�����ؽ���ļ�¼����
	private int getTotalRows(String sql,String[] params){
		int totalRows=0;
		sql=sql.toLowerCase();
		String countSql="";
		if(sql.indexOf("group")>=0){
			countSql="select count(*) from ("+sql+") as tempNum";
		}else{
			countSql="select count(*) as tempNum"+sql.substring(sql.indexOf("from"));
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
	
}
