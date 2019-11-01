package servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommonService;
import util.FileUtil;

/**
 * Servlet implementation class DownLoadServlet
 */
@WebServlet("/dls")
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		CommonService cs = new CommonService();
		//得到下载文件的信息，Map对象，封装了filePath和fileName的信息
		Map file = cs.getDownLoadFile(id);
		//实现文件下载动作
		FileUtil fu = new FileUtil();
		int result = fu.download(this.getServletContext(),response,file);
		//更新下载次数
		if(result == 1){
			cs.updateHits(id);
		}
	}

}
