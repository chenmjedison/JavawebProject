package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentDAO;
import bean.StudentDTO;

public class AddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		
		//获得请求参数
		StudentDTO student=new StudentDTO();
		
		
		student.setStudent_id( request.getParameter("student_id"));
	    student.setStudent_name(request.getParameter("student_name"));
	   student.setStudent_sex(request.getParameter("student_sex"));
	    student.setStudent_birthday(request.getParameter("student_birthday"));
	    student.setStudent_dept(request.getParameter("student_dept"))  ;
	    student.setStudent_major(request.getParameter("student_major")) ;
	   student.setStudent_classid(request.getParameter("student_classid"));
	    StudentDAO s=new StudentDAO();   
	    s.addStudent(student);
	    
        //定义转发页面
		String forward = null;				        

		// 创建模型对象
		StudentDAO sdao = new StudentDAO();
		//调用模型对象的业务方法获得学生信息
	    LinkedList<StudentDTO> list = sdao.queryAllStudent();
		
		forward = "main.jsp";
		
		//把用户名写入request中,以便共享
		request.getSession().setAttribute("studentlist",list);

		response.sendRedirect(forward);
	}




}

