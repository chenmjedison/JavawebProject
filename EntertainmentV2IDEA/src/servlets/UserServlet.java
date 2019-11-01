package servlets;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import util.PageBean;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/us/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String requestPath = request.getRequestURI();
		int i = requestPath.lastIndexOf('/');
		String path = requestPath.substring(i);
		RequestDispatcher rd = null;
		//����ģ�Ͳ����
		UserService us = new UserService();
		if(path.equals("/listAll")){
			//�����ļ���ʾ���ܣ�����ҳ����
			//���Ҫ��ʵ��ҳ��
			String page = request.getParameter("page");
			int curPage = 0;
			//û�л��pageֵ�Ĵ���
			if(page == null || page.length()<1){
				curPage = 1;
			}else{
				curPage = Integer.parseInt(page);
				}
			PageBean pageBean = us.listAll(curPage);
			request.setAttribute("pageBean", pageBean);
			rd = request.getRequestDispatcher("/listAll.jsp");
			rd.forward(request, response);
		}else if(path.equals("/top")){
			//���а����ʾ�������ļ���ߵ�ǰ10λ
			List top = us.topList();
			request.setAttribute("top", top);
			rd = request.getRequestDispatcher("/topList.jsp");
			rd.forward(request, response);
		}else if(path.equals("/show")){
			//��ʾ�����ļ��ľ�����Ϣ
			String id = request.getParameter("id");
			Map file = us.getById(id);
			request.setAttribute("file", file);
			rd.forward(request, response);
		}else if(path.equals("/sort")){
			//������ʾ������ҳ����
			String type = request.getParameter("type");
			//�����ļ���ʾ���ܣ�����ҳ����
			//���Ҫ��ʾ��ҳ��
			String page = request.getParameter("page");
			//��ǰ��ҳ��
			int curPage = 0;
			//û�л��pageֵ�Ĵ���
			if(page == null || page.length() <1){
				curPage = 1;
			}else{
				curPage = Integer.parseInt(page);
			}
			PageBean pageBean = us.listSort(type, curPage);
			request.setAttribute("pageBean", pageBean);
			rd = request.getRequestDispatcher("/sortList.jsp");
			rd.forward(request, response);
		}else if(path.equals("/search")){
			//��������������ҳ���ܡ���������Ϊ���+�ļ�˵���еĹؼ���
			String type = request.getParameter("type");
			String name = request.getParameter("name");
			//���Ҫ��ʾ��ҳ��
			String page = request.getParameter("page");
			//��ǰ��ҳ��
			int curPage = 1;
			//û�л�ȡpageֵ�Ĵ���
			if(page == null||page.length()<1){
				curPage = 1;
			}else{
				curPage = Integer.parseInt(page);
			}
			PageBean pageBean = us.Search(type, name, curPage);
			request.setAttribute("pageBean", pageBean);
			rd = request.getRequestDispatcher("/searchList.jsp");
			rd.forward(request, response);
		}
	}

}
