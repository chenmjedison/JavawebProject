package action;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;

import service.BookinfoService;

import com.opensymphony.xwork2.ActionSupport;

import entity.Bookinfo;

public class BookinfoAction extends ActionSupport{
	private static final long serialVersionUID=1L;
	//private static Logger logger =(Logger) LoggerFactory.logger(BookinfoAction.class);
	private BookinfoService bookinfoService;
	private Bookinfo book; 
	private String id;
	private List books;
	public Bookinfo getBook(){
		return book;
	}
	public void setBook(Bookinfo book){
		this.book=book;
	}
	public List getBooks(){
		return books;
	}
	public void setBookinfoService(BookinfoService bookinfoService){
		this.bookinfoService=bookinfoService;
	}
	public void setId(String id){
		this.id=id;
	}
	public String showBooks() throws Exception{
		books=bookinfoService.getBooks();
		System.out.println("获取数据表中的所有书本信息！");
		return "list";
	}
	public String addBook() throws Exception{//准备添加书本信息
		return "add";
	}
	public String editBook() throws Exception{//准备修改书本信息
		if(id!=null){
			book=bookinfoService.getBook(new Integer(id));
			System.out.println("Action层获取到的数据"+book.getAuthor()+book.getId());
		}
		return "edit";
	}
	public String updateBook() throws Exception{
		bookinfoService.updateBook(book);
		return "success";
	}
	public String deleteBook() throws Exception{
		book=bookinfoService.getBook(new Integer(id));
		if(book!=null){
			bookinfoService.deleteBook(book);
		}
		return "success";
	}
}
