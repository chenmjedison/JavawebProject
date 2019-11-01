package com.nn.dao;

import com.nn.bean.File;
import com.nn.bean.FileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileMapper {
    long countByExample(FileExample example);

    int deleteByExample(FileExample example);

    int deleteByPrimaryKey(String fileid);

    int insert(File record);

    int insertSelective(File record);

    List<File> selectByExample(FileExample example);

    File selectByPrimaryKey(String fileid);

    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}