package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StudentDAO;
import bean.UserDAO;

public class DeleteServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteServlet() {
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

		doPost(request, response);
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
		response.setContentType("text/tml");
		response.setCharacterEncoding("utf-8");
		
		//从JSP（输入）获取请求的信息
		String id = request.getParameter("student_id");
		System.out.println("id="+id);
		
		//调用业务逻辑方法
		StudentDAO s = new StudentDAO(); 
		boolean b = s.deleteStudentByID(id);
		HttpSession s1 = request.getSession();
		//根据执行的结果进行处理
		if (b == true) {
			//request.setAttribute("username", username);
			//RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			//rd.forward(request, response);

			s1.setAttribute("msg", "删除成功！");	
		}
		else 
		{
			s1.setAttribute("msg", "删除失败！");	
		}
		response.sendRedirect("InfoServlet");
	
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
