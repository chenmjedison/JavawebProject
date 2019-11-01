package entity;

public class Bookinfo implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String bookname;
	private String author;
	private String press;
	private String price;
	public Bookinfo(){
		
	}
	public Bookinfo(String bookname,String author,String press,String price){
		this.bookname=bookname;
		this.author=author;
		this.press=press;
		this.price=price;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookname() {
		return this.bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return this.press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getPrice() {
		return this.price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
