package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.DBUtil;

public class Book implements Serializable{
	private String id;
	private String bookname;
	private String author;
	private String press;
	private String price;
	private DBUtil db=null;
	public Book(){
		db=new DBUtil();
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	public String getBookname(){
		return bookname;
	}
	public void setBookname(String bookname){
		this.bookname=bookname;
	}
	public String getAuthor(){
		return author;
	}
	public void setAuthor(String author){
		this.author=author;
	}
	public String getPress(){
		return press;
	}
	public void setPress(String press){
		this.press=press;
	}
	
	public String getPrice(){
		return price;
	}
	public void setPrice(String price){
		this.price=price;
	}
	public List getAllbooks(){
		List books=null;
		String sql="select * from bookinfo";
		books=db.getAllList(sql);
		return books;
	}
	public int addBook(){
		int result=0;
		String sql="insert into bookinfo values(?,?,?,?,?)";
		String[] params={id,bookname,author,press,price};
		result=db.update(sql, params);
		return result;
	}
	public Map getBook(){
		Map book=null;
		String sql="select * from bookinfo where id=?";
		String[] params={id};
		book=db.getMap(sql, params);
		return book;
	}
	public int updateBook(){
		int result=0;
		String sql="update bookinfo set bookname=?,author=?,press=?,price=? where id=?";
		String[] params={bookname,author,press,price,id};
		System.out.println(bookname);
		System.out.println(author);
		System.out.println(press);
		System.out.println(price);
		System.out.println(id);
		result=db.update(sql, params);
		return result;
	}
	public int delBook(){
		int result=0;
		String sql="delete from bookinfo where id=?";
		String[] params={id};
		result=db.update(sql, params);
		return result;
	}
	public PageBean getUserList(int curPage){
		String sql="select * from bookinfo";
		PageBean pb=db.getPageBean(sql,null,curPage);
		return pb;
	}
}
