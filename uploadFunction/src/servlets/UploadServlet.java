package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.File;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID=1L;
	/**
	 * Constructor of the object.
	 */
	public UploadServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("<H3>jspSmartUpload:Servlet Sample</H3>");
		out.println("<HR>");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		SmartUpload mySmartUpload=new SmartUpload();
		
		int count=0;  //�ϴ��ļ�����
		try{
			
			mySmartUpload.initialize(this.getServletConfig(),request,response);
			//����ÿ���ϴ��ļ�����󳤶�
			mySmartUpload.setMaxFileSize(50*1024*1024);
			mySmartUpload.setAllowedFilesList("doc,txt");
			//�趨�����ϴ����ļ�(ͨ����չ������)������doc��TXT�ļ�
			mySmartUpload.upload();
			//����ϴ����ļ�
			com.jspsmart.upload.File myfile=mySmartUpload.getFiles().getFile(0);
			String filename=myfile.getFileName();
			String path = getServletContext().getRealPath("/upload")+java.io.File.separator+filename;
			
			java.io.File fileUpload = new java.io.File(path);
				if(!fileUpload.exists()){
				    //先得到文件的上级目录，并创建上级目录，在创建文件
					fileUpload.getParentFile().mkdir();
				    try {
				        //创建文件
				    	fileUpload.createNewFile();
				    } catch (IOException e) {
				        e.printStackTrace();
				    }
				}
			System.out.println(filename);
			//�����ļ���Ŀ¼
			mySmartUpload.getFiles().getFile(0).saveAs(path);
			count++;
			//����ļ���������Ϣ
			Request re=mySmartUpload.getRequest();
			String desc=re.getParameter("desc");
			out.println(count+"file uploaded.<br>");
			out.println("file description:"+desc);
		}catch(Exception e){
			out.println("Unable to upload the file.<br>");
			out.println("Error:"+e.toString());
		}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
