package com.space.mapper;


import com.space.entity.Commodity;
import com.space.entity.CommodityCategory;
import com.space.entity.DocumentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DocumentInfoMapper {
    /** 查询文档*/
    public List<DocumentInfo> getByIds(@Param("documentIds")String[] documentIds);
    /** 删除文档*/
    public int deleteByIds(@Param("documentIds")String[] documentIds);
    /** 添加文档*/
    public  DocumentInfo add(@Param("documentInfo")DocumentInfo documentInfo);

}
