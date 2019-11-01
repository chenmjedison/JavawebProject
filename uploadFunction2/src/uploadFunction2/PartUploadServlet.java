package uploadFunction2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class PartUploadServlet
 */
@WebServlet("/PartUploadServlet")
@MultipartConfig
public class PartUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("<H3>Servlet3.0 Upload</H3>");
		out.println("<HR>");
		String desc = request.getParameter("desc");
		Part file = request.getPart("file");
		String header = file.getHeader("content-disposition");
		String filename = ((header.split(";")[2]).split("=")[1]).replaceAll("\"", "");
		String extname = filename.substring(filename.lastIndexOf('.')+1);
		String newfilename = System.currentTimeMillis()+"."+extname;
		String uploadpath = getServletContext().getRealPath("/upload");	
		try{
			File fileUpload = new File(uploadpath+File.separator+newfilename);
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
			file.write(uploadpath+File.separator+newfilename);
			out.print("1 file uploaded.<br>");
			out.print("file description:"+desc);
		}catch (IOException e){
			out.println("Unable to upload the file.<br>");
			out.println("Error: "+e.toString());
		}
	}

}
