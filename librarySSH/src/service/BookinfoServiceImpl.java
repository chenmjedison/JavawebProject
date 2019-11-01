package service;

import java.util.List;

import entity.Bookinfo;
import entity.BookinfoDAO;

public class BookinfoServiceImpl implements BookinfoService{
	private BookinfoDAO bookinfoDAO;
	public BookinfoDAO getBookinfoDAO(){
		return bookinfoDAO;
	}
	public void setBookinfoDAO(BookinfoDAO bookinfoDAO){
		this.bookinfoDAO=bookinfoDAO;
	}
	public List getBooks() throws Exception{
		System.out.println("====================>查询list列表");
		List list = bookinfoDAO.findAll();
		return list;
	}
	public void deleteBook(Bookinfo bi){
		bookinfoDAO.delete(bi);
	}
	public Bookinfo getBook(Integer id){
		System.out.println("调用getBooks接口，按照ID查找book表的一条记录1111");
		return bookinfoDAO.findById(id);
	}
	public void updateBook(Bookinfo bi){
		bookinfoDAO.saveOrUpdate(bi);
	}
}
