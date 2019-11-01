package com.nn.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nn.bean.Said;
import com.nn.bean.User;
import com.nn.service.CommentService;
import com.nn.service.SaidService;
import com.nn.utils.Msg;

@Controller
@RequestMapping("said")
public class SaidController extends BaseController {
	@Autowired
	private SaidService saidService;
	@Autowired
	private CommentService commentService;
		
		//通过经纬度获取地址，对象
	
		
		public  String getlongitudeLatitude(String longitudeLatitude) throws IOException{
			String longitude = longitudeLatitude.substring(25,longitudeLatitude.length()-1);
			String Latitude  = longitudeLatitude.substring(7, 18);
			
			String url="http://api.map.baidu.com/geocoder/v2/?callback=renderReverse&location="+longitude+","+Latitude+"&output=json&pois=1&ak=f9jNGIKTZxMFhpjykse3wsGmpx6p5HHY&qq-pf-to=pcqq.group";
			Document doc = Jsoup.connect(url).ignoreContentType(true).get();			
			String data = doc.getElementsByTag("body").get(0).text();
			data = data.substring(29, data.length()-1);//截取返回结果
			JSONObject json = JSONObject.fromObject(data);//将返回结果转化为json对象
			String result = json.getString("result");//获取json结果中的result数据，并转化为字符串
			JSONObject jsonResult = JSONObject.fromObject(result);
			return jsonResult.getString("formatted_address");
		}
		//通过经纬度获取地址，列表
		public  List<String> getLongitudeLatitude(String longitudeLatitude) throws IOException {
			String longitude = longitudeLatitude.substring(25,longitudeLatitude.length()-1);
			String Latitude  = longitudeLatitude.substring(7, 18);
			System.err.println(Latitude);
			String url="http://api.map.baidu.com/geocoder/v2/?callback=renderReverse&location="+longitude+","+Latitude+"&output=json&pois=1&ak=f9jNGIKTZxMFhpjykse3wsGmpx6p5HHY&qq-pf-to=pcqq.group";
			System.err.println(url);
			Document doc = Jsoup.connect(url).ignoreContentType(true).get();
			String data = doc.getElementsByTag("body").get(0).text();
			data = data.substring(29, data.length()-1);//截取返回结果
			JSONObject json = JSONObject.fromObject(data);//将返回结果转化为json对象	
			String result = json.getString("result");//获取json结果中的result数据，并转化为字符串
			JSONObject jsonResult = JSONObject.fromObject(result);
			String pois = jsonResult.getString("pois");
			JSONArray poisArray = JSONArray.fromObject(pois);
			List<String> listAddress = new ArrayList<String>();
			for(int i=0;i<poisArray.size();i++){
				System.out.println(poisArray.getJSONObject(i).getString("addr"));//打印出地址
				listAddress.add(poisArray.getJSONObject(i).getString("addr"));
			}
			return listAddress;
		}
		
		//获取地址1
		@RequestMapping("addr1")
		@ResponseBody
		public Msg addr1(String longitudeLatitude) throws IOException{
			return Msg.success().add("result", getlongitudeLatitude(longitudeLatitude));			
		}		
		
		//获取地址2
		@RequestMapping("addr2")
		@ResponseBody
		public Msg addr2(String longitudeLatitude) throws IOException{
			return Msg.success().add("result", getLongitudeLatitude(longitudeLatitude));			
		}		
		
		//添加
		@RequestMapping("add")
		@ResponseBody
		public Msg Add(Said said,HttpServletRequest request,MultipartHttpServletRequest mRequest,String longitudeLatitude,String addr) throws IOException{			
			User user = getCurrentUser(request);			
			StringBuilder str = new StringBuilder();
			String saidContent = request.getParameter("saidContent");
			for(int i=0;i<10;i++){
				List<MultipartFile> file = mRequest.getFiles("file"+i);
				if(file.size()>0){
					for(MultipartFile mf:file){
						if(mf!=null && !mf.isEmpty()){
							//获取文件名
							String filename = mf.getOriginalFilename();
							//extensionName后缀名
							String extensionName = filename.substring(filename.lastIndexOf(".")+1);
							//新的图片文件名
							String newfilename = String.valueOf(System.currentTimeMillis())+"."+extensionName;
							String sqlPath;
							sqlPath = "http://192.168.0.106:8088/img/"+newfilename;
							str.append(sqlPath).append("+");				
							try {						
								saveFile(newfilename, file);						
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}					
						}		
					}				
				}				
			}	
			
			said.setPictureUrl(str.toString());
			said.setSaidContent(saidContent);		
			if(saidService.addSaid(said,user,longitudeLatitude,addr)){
				return Msg.success().add("result", "success");
			}else{
				return Msg.fail().add("result", "faulier");
			}
		}
		
		
		 private void saveFile(String newFileName, List<MultipartFile> file) {
		        // 根据配置文件获取服务器图片存放路径
			 	//本地服务目录
			 	String saveFilePath = "C:/my/apache-tomcat-7.0.57/webapps/img";
		        /* 构建文件目录 */
		        File fileDir = new File(saveFilePath);
		        
		        for(MultipartFile ff:file){
		        	if (!fileDir.exists()) {
			            fileDir.mkdirs();
			        }
			        try {
			            FileOutputStream out = new FileOutputStream(saveFilePath + "/"
			                    + newFileName);
			            // 写入文件
			            out.write(ff.getBytes());
			            out.flush();
			            out.close();
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
		        }       

		    }
		
		//修改
		@RequestMapping("update")
		@ResponseBody
		public Msg Update(Said said){
			if(saidService.updateSaid(said)){
				return Msg.success().add("result", "success");
			}else{
				return Msg.fail().add("result", "faulier");
			}
		}
		//列表
		@RequestMapping("list")
		@ResponseBody
		public Msg listSaid(Said said,HttpServletRequest request){
			User user = getCurrentUser(request);	
			
			return Msg.success().add("result", saidService.list(said,user));
		}
		//查询
		@RequestMapping("get")
		@ResponseBody
		public Msg getSaid(String saidId){
			return Msg.success().add("result", saidService.getSaid(saidId));
		}	
		//上传文件
		@RequestMapping("upload")
		@ResponseBody
		public String upload(MultipartFile file) {
		    try {
		    if (file.isEmpty()) {
		        return "文件为空";
		    }
		    // 获取文件名
		    String fileName = file.getOriginalFilename();
		    // 获取文件的后缀名
		    String suffixName = fileName.substring(fileName.lastIndexOf("."));

		    // 设置文件存储路径
		    String filePath = "D://filetest//";
		    String path = filePath + fileName;

		    File dest = new File(path);
		    // 检测是否存在目录
		    if (!dest.getParentFile().exists()) {
		        dest.getParentFile().mkdirs();// 新建文件夹
		    }
		    file.transferTo(dest);// 文件写入
		    return "上传成功";
		    } catch (IllegalStateException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    return "上传失败";
		}

		//删除
//		@RequestMapping("delete")
//		@ResponseBody
//		public Msg Delete(String saidId,HttpServletRequest request){
//			User user = getCurrentUser(request);
//			if(saidService.deleteSaid(saidId,user)){
//				return Msg.success().add("result", "success");
//			}else{
//				return Msg.fail().add("result", "faulier");
//			}
//		}
		
}
