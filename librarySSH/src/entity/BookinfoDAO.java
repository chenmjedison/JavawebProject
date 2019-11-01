package entity;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BookinfoDAO extends HibernateDaoSupport{
	//删除一条表记录
	public void delete(Bookinfo bi){
		getHibernateTemplate().delete(bi);
	}
	//按照ID查找book表的一条记录
	public Bookinfo findById(Integer id){
		Bookinfo bi = (Bookinfo) getHibernateTemplate().get("entity.Bookinfo", id);
		System.out.println("按照ID查找book表的一条记录" + bi.getId());
		return bi;
	}
	//查询book表的所有记录
	public List findAll() throws Exception{
		String sql="from Bookinfo";//这里的Bookinfo不要用小写的b,数据出不来
		List list = getHibernateTemplate().find(sql, null);
		System.out.println("获取list数据");
		return list;	
	}
	//更新或插入book表的一条记录
	public void saveOrUpdate(Bookinfo bi){
		getHibernateTemplate().saveOrUpdate(bi);
	}
}
