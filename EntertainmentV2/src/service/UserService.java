package service;

import java.util.List;
import java.util.Map;

import util.DBUtil;
import util.PageBean;

public class UserService {
	private DBUtil db = new DBUtil();
	//获取所有信息的PageBean对象
	public PageBean listAll(int curPage){
		String sql = "select * from files order by lastModified desc";
		System.out.println("<===查询listALL     "+sql);
		return db.getPageBean(sql, new String[]{}, curPage);
	}
	//获得下载次数排名前10位的信息
	public List topList(){
		String sql = "select id,name,hits from files where hits!=0 order by hits desc limit 0,10";
		return db.getList(sql, new String[]{});
	}
	//通过id获取单条数据信息
	public Map getById(String id){
		String sql = "select * from files where id = ?";
		return db.getMap(sql, new String[]{id});
	}
	//获得指定类型的数据信息的PageBean对象
	public PageBean listSort(String type,int curPage){
		String sql = null;
		if(type==null || type.equals("")){
			sql = "select * from files order by type";
			return db.getPageBean(sql, new String[]{}, curPage);
		}else{
			sql = "select * from files where type = ?";
			return db.getPageBean(sql, new String[]{type}, curPage);
		}
	}
	//获得制定类型和制定名称的数据信息的PageBean对象
	public PageBean Search(String type,String name,int curPage){
		String sql = null;
		if(type==null || type.equals("")){
			if(name == null || name.equals("")){
				sql = "select * from files order by type";
				return db.getPageBean(sql, new String[]{}, curPage);
			}else{
				sql = "select * from files where name like ?";
				return db.getPageBean(sql, new String[]{"%"+name+"%"}, curPage);
			}
		}else{
			if(name == null || name.equals("")){
				sql = "select * from files where type = ?";
				return db.getPageBean(sql, new String[]{type}, curPage);
			}else{
				sql = "select * from files where name like ? and name like ?";
				return db.getPageBean(sql, new String[]{"%"+name+"%"}, curPage);
			}
		}
	}
}
