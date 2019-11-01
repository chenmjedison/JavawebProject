package com.nn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nn.bean.Comment;
import com.nn.bean.CommentExample;
import com.nn.bean.File;
import com.nn.bean.FileExample;
import com.nn.bean.Relation;
import com.nn.bean.User;
import com.nn.dao.FileMapper;
import com.nn.utils.MyTools;

@Service
public class FileService {
	
	@Autowired
	private FileMapper fileMapper;
	//添加
	public boolean addFile(MultipartFile files) {
		try {
			File file = new File();
			String id = MyTools.getDateR();
			String createTime=MyTools.getTime();
			// 获取文件名
		    String fileName = files.getOriginalFilename();
		    // 获取文件的后缀名
		    String suffixName = fileName.substring(fileName.lastIndexOf("."));
		    // 设置文件存储路径
		    String filePath = "D://filetest//";
		    String path = filePath + fileName;
		    file.setFilename(fileName);
		    file.setFiletype(suffixName);
		    file.setYl1(path);
			file.setFileid(id);
			file.setUploadtime(createTime);
			fileMapper.insertSelective(file);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//查询
	public File getFile(String fileId) {
		return fileMapper.selectByPrimaryKey(fileId);
	}
	//列表
	public List<File> listFile(File file) {
		String filename = file.getFilename();
		FileExample example = new FileExample();
		FileExample.Criteria criteria = example.createCriteria();
		/*if(createTime != null && !"".equals(createTime)){
			criteria.andCreateTimeIsNotNull();
		}
		if(start!=null&&!"".equals(start))
		{
			criteria.andCreateTimeGreaterThan(start);
		}
		if(end!=null&&!"".equals(end)){
			criteria.andCreateTimeLessThan(end);
		}*/
		if(filename != null && !"".equals(filename)){
			criteria.andFilenameEqualTo(filename);
		}
		return fileMapper.selectByExample(example);
	}
}
