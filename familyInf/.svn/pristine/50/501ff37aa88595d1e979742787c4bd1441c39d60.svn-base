package com.nn.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nn.bean.Activity;
import com.nn.bean.User;
import com.nn.service.ActivityService;
import com.nn.service.ReplyService;
import com.nn.utils.Msg;

@Controller
@RequestMapping("activity")
public class ActivityController extends BaseController {
	@Autowired
	private ActivityService activityService;
	@Autowired
	private ReplyService replyService;

	// 增加
	@ResponseBody
	@RequestMapping("add")
	public Msg add(Activity activity,MultipartHttpServletRequest mRequest,HttpServletRequest request){	
		User user = getCurrentUser(request);
		StringBuilder str = new StringBuilder();
		String content = request.getParameter("content");
		String title = request.getParameter("title");
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
						sqlPath = "http://192.168.0.249:8080/img/"+newfilename;
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
		activity.setPhoto(str.toString());
		activity.setContent(content);
		activity.setTitle(title);
		String time = activity.getTime();
		String[] split = time.split("T");
		String timeString = split[0]+" "+split[1];
		activity.setTime(timeString);
		if(activityService.add(activity,user)){
			return Msg.success().add("result", "添加成功");
		}else{
			return Msg.fail().add("result", "添加失败");
		}
	}



 private void saveFile(String newFileName, List<MultipartFile> file) {
        // 根据配置文件获取服务器图片存放路径
	 	//本地服务目录
	 	String saveFilePath = "C:/temp/apache-tomcat-7.0.57-windows-x64/apache-tomcat-7.0.57/webapps/img";
	 	System.err.println(saveFilePath);
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

	// 查找&活动详情
	@ResponseBody
	@RequestMapping("get")
	public Msg get(HttpServletRequest request) {
		String activityId = request.getParameter("activityId"); // 获取id
		Activity activity = activityService.get(activityId); // 查询活动
		String[] split = activity.getPhoto().split("[+]");
		List<String> list = Arrays.asList(split);
		activity.setPhotos(list);
		
//		String actId = activity.getActivityId().toString();
//		Reply reply = new Reply();
//		reply.setActId(actId);
//		List<Reply> list = replyService.list(reply); // 查询回复
//		activity.setReply(list);
		return Msg.success().add("result", activity);
	}

	// 列表
	@ResponseBody
	@RequestMapping("list")
	public Msg list(Activity activity, HttpServletRequest request) {
		User user = getCurrentUser(request);
		return Msg.success()
				.add("result", activityService.list(activity, user));
	}
}
