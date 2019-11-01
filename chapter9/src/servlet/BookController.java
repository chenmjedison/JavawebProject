package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
/**
 * Servlet implementation class BookController
 */
@WebServlet("*.book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String url = request.getServletPath();
		System.out.println(url);
		if(url.equals("/index.book")){
			Book book = new Book();
			request.setAttribute("books", book.getAllbooks());
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}else if(url.equals("/add.book")){
			String bookname = request.getParameter("bookname");
			String author = request.getParameter("author");
			String press = request.getParameter("press");
			String price = request.getParameter("price");
			Book book = new Book();
			book.setBookname(bookname);
			book.setAuthor(author);
			book.setPress(press);
			book.setPrice(price);
			int r = book.addBook();
			if(r==1){
				request.getRequestDispatcher("success.html").forward(request, response);
			}else{
				request.getRequestDispatcher("failure.html").forward(request, response);
			}
			
		}else if(url.equals("/edit.book")){
			String id = request.getParameter("id");
			Book book = new Book();
			book.setId(id);
			request.setAttribute("bookinfo", book.getBook());
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			
		}else if(url.equals("/edit_do.book")){
			String id = request.getParameter("id");
			String bookname = request.getParameter("bookname");
			String author = request.getParameter("author");
			String press = request.getParameter("press");
			String price = request.getParameter("price");
			Book book = new Book();
			book.setId(id);
			book.setBookname(bookname);
			book.setAuthor(author);
			book.setPress(press);
			book.setPrice(price);
			int r = book.updateBook();
			if(r==1){
				request.getRequestDispatcher("success.html").forward(request, response);
			}else{
				request.getRequestDispatcher("failure.html").forward(request, response);
			}
		}else if(url.equals("/del.book")){
			String id = request.getParameter("id");
			Book book = new Book();
			book.setId(id);
			int r = book.delBook();
			if(r==1){
				request.getRequestDispatcher("success.html").forward(request, response);
			}else{
				request.getRequestDispatcher("failure.html").forward(request, response);
			}
		}
	}

}
