package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StudentDAO;

/**
 * Servlet implementation class UpdateStudentSevlet
 */
@WebServlet("/UpdateStudentSevlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		
		//获得请求参数
	 
	   String ID=request.getParameter("id");
  	   String name=request.getParameter("name");
  	   String sex=request.getParameter("sex");
  	   String birthday=request.getParameter("birthday");
  	   String dept=request.getParameter("dept");
  	   String major=request.getParameter("major");
  	   String classid=request.getParameter("classid");
		
  	 System.out.println(ID);
        //定义转发页面
		String forward = null;
        

		
	   StudentDAO sdao = new StudentDAO();
		boolean b = sdao.update(ID,name,sex,birthday,dept,major,classid);
		HttpSession s1 = request.getSession();
		//根据执行的结果进行处理
		
		if (b == true) {
			//request.setAttribute("username", username);
			//RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			//rd.forward(request, response);

			s1.setAttribute("msg", "修改成功！");
			response.sendRedirect("InfoServlet");
		}
		else 
		{
			//s1.setAttribute("msg", "修改失败！");
			response.sendRedirect("Update.jsp");
		}
	}

}
