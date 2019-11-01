package com.nn.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nn.bean.File;
import com.nn.bean.Relation;
import com.nn.bean.User;
import com.nn.service.FileService;
import com.nn.utils.Msg;

@Controller
@RequestMapping("file")
public class FileController extends BaseController{
	@Autowired
	private FileService fileService;
	// 添加
	@RequestMapping("add")
	@ResponseBody
	public Msg AddFile(MultipartFile files) {
		String result = upload(files);
		if(result.equals("上传成功")){
			Msg.success().add("uploadStatus", "上传成功");
		}
		if (fileService.addFile(files)) {
			return Msg.success().add("result", "success");
		} else {
			return Msg.fail().add("result", "failure");
		}

	}
	// 根据ID查询
	@RequestMapping("get")
	@ResponseBody
	public Msg GetFile(String userId) {
		File file = fileService.getFile(userId);
		return Msg.success().add("result", file);
	}
	// 查看列表
	@RequestMapping("list")
	@ResponseBody
	public Msg fileList(File File) {
		List<File> files = fileService.listFile(File);
		return Msg.success().add("result", files);
	}
	//上传文件
	//上传文件
	@RequestMapping("upload")
	@ResponseBody
	public String upload(MultipartFile multiFile) {
	    try {
			    if (multiFile.isEmpty()) {
			        return "文件为空";
			    	}
			    // 获取文件名
			    String fileName = multiFile.getOriginalFilename();
			    // 获取文件的后缀名
			    String suffixName = fileName.substring(fileName.lastIndexOf("."));
			    // 设置文件存储路径
			    String filePath = "D://filetest//";
			    String path = filePath + fileName;
		
			    java.io.File dest = new java.io.File(path);
			    // 检测是否存在目录
			    if (!dest.getParentFile().exists()) {
			        dest.getParentFile().mkdirs();// 新建文件夹
			    }
			    multiFile.transferTo(dest);// 文件写入
			    return "上传成功";
	    	} catch (IllegalStateException e) {
	    		e.printStackTrace();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	return "上传失败";
		}
}
