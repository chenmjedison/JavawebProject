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

public class UpdateInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateInfoServlet() {
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
	    String id = request.getParameter("student_id");
		
        //定义转发页面
		String forward = null;
        

		// 创建模型对象
		StudentDAO sdao = new StudentDAO();
		//调用模型对象的业务方法获得学生信息
	    StudentDTO s = sdao.queryStudentById(id);
		
		forward = "Update.jsp";
		
		//把用户名写入request中,以便共享
		request.getSession().setAttribute("student",s);
		
		//通过分发器转发页面
		//RequestDispatcher rd = request.getRequestDispatcher(forward);
		//rd.forward(request, response);
		
		response.sendRedirect(forward);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
