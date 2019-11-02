package util;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUtil {
	//存储表单信息
	private Map parameters = null;
	//存储上传文件信息
	private Map file = null;
	//最大的上传文件大小
	private long max_size = 30*1024*1024;
	public Map getFile(){
		return file;
	}
	public Map getParameters(){
		return parameters;
	}
	public void setMax_size(long max_size){
		this.max_size = max_size;
	}
	public FileUtil(){
		parameters = new HashMap();
		file = new HashMap();
	}
	//上传文件的大小
	public int upload(HttpServletRequest request,String uploadPath) throws IOException{
		//实例化一个硬盘文件用来配置上传组件ServletFileUpload
		DiskFileItemFactory diskFileItemFactory =new DiskFileItemFactory();
		//设置上传问件时用于存放临时文件的内存大小，这里是4KB，多余的部分将临时存于硬盘
		diskFileItemFactory.setSizeThreshold(4096);
		//用以上实例化上传组件
		ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
		//设置最大上传文件大小
		fileUpload.setSizeMax(max_size);
		//解决路径或者文件名乱码的问题
		fileUpload.setHeaderEncoding("UTF-8");
		List fileList = null;
		try{
			fileList = fileUpload.parseRequest(request);
		}catch(FileUploadException e){
			if(e instanceof SizeLimitExceededException){
				System.out.println("文教大小超过"+max_size+"字节");
				return 0;
			}
			e.printStackTrace();
		}
		Iterator fileItr = fileList.iterator();
		while(fileItr.hasNext()){
			FileItem fileItem = null;
			String sourceFilePath = null;
			String sourceFileName = null;
			String filePath = null;
			String fileExt = null;
			String realPath = null;
			long size = 0;
			fileItem = (FileItem) fileItr.next();
			//如果是上传文件不是表单信息
			if(!fileItem.isFormField()){
				//得到源文件的完整路径
				sourceFilePath = fileItem.getName();
				size = fileItem.getSize();
				if(!sourceFilePath.equals("")&&size!=0){
					//得到去除路径的文件名
					sourceFileName = sourceFilePath.substring(sourceFilePath.lastIndexOf("\\")+1);
					//得到文件扩展名
					fileExt = sourceFileName.substring(sourceFileName.lastIndexOf(".")+1);
					//以当前系统时间保存上传文件
					long systemTime = System.currentTimeMillis();
					filePath = uploadPath+"/"+systemTime+"."+fileExt;
					realPath = request.getServletContext().getRealPath(filePath);
					try{
						fileItem.write(new File(realPath));//�����File��ʲô
					}catch(Exception e){
						e.printStackTrace();
						return 0;
					}
					file.put("size", String.valueOf(size));
					file.put("filePath", filePath);
					file.put("fileName", sourceFileName);
				}
			}else{
				//如果不是上传文件而是表单信息，则将信息保存在parameters中
				String fieldName = fileItem.getFieldName();
				String value = fileItem.getString("UTF-8");
				parameters.put(fieldName, value);
			}
		}
		return 1;
	}
	//下载文件的方法，参数Map存储下载文件信息，，包括文件地址filepath和名称filename
	public int download(ServletContext servletContext,HttpServletResponse response,Map file) throws IOException{
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;
		try{
			response.reset();
			String filePath = (String)file.get("filePath");
			System.out.println(filePath);
			String realPath = servletContext.getRealPath(filePath);
			System.out.println(realPath);
			long fileLength = new File(realPath).length();
			response.setHeader("Content-disposition","attachment;filename ="+new String(((String)file.get("fileName")).getBytes("UTF-8"),"ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(realPath));
			
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while((bytesRead = bis.read(buff,0,buff.length))!=-1){
				bos.write(buff, 0, bytesRead);
			}
		}catch(IOException e){
			return 0;
		}finally{
			if(bis!=null)
				bis.close();
			if(bos!=null)
				bos.close();
			
		}
		return 1;
	}
	
}
