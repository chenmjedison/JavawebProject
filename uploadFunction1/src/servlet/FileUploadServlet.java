package servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

@WebServlet("/fileupload")
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID=1L;
	/**
	 * Constructor of the object.
	 */
	public FileUploadServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("<H3>FileUpload:Servlet Sample</H3>");
		out.println("<HR>");
		try{
			//实例化一个硬盘工厂，用来配置上传组件ServletFileUpload
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//设置缓冲区大小，这里是4KB
			factory.setSizeThreshold(4096);
			ServletFileUpload upload=new ServletFileUpload(factory);
			//设置文件最大尺寸，这里是4MB
			upload.setSizeMax(4194304);
			String uploadPath=this.getServletContext().getRealPath("/upload");
			//解析request请求
			FileItemIterator fii=upload.getItemIterator(request);//fii做什么的
			//逐条处理
			while(fii.hasNext()){
				FileItemStream fis=fii.next();
				//检查当前项目是普通表单项目还是上传文件
				if(fis.isFormField()){    //如果是普通表单项目，显示表单内容
					if("desc".equals(fis.getFieldName())){
						out.println("file description:"+fis.getFieldName()+"<br/>");
					}
				}else{
					//得到完整的文件路径
					String path=fis.getName();
					//得到去除路径的文件名
					String filename=path.substring(path.lastIndexOf("\\")+1);
					//将文件保存到web目录的upload文件夹中
					BufferedInputStream bis=new BufferedInputStream(fis.openStream());
					File file = new File(uploadPath+"\\"+filename);
					if(!file.exists()){
					    //先得到文件的上级目录，并创建上级目录，在创建文件
					    file.getParentFile().mkdir();
					    try {
					        //创建文件
					        file.createNewFile();
					    } catch (IOException e) {
					        e.printStackTrace();
					    }
					}
					BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File(uploadPath+"\\"+filename)));
					//开始把文件写到指定的上传文件夹
					Streams.copy(bis, bos, true);
					out.println(filename+"file uploaded.<br/>");
				}
			
			}
		}catch(FileUploadException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
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
