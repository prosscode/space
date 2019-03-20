package com.space.service;

import com.space.entity.CommodityCategory;
import com.space.entity.DocumentInfo;
import com.space.exception.PageEntity;

import java.util.List;

public interface DocumentService {
    /** 查询文档*/
    public List<DocumentInfo> getByIds( String[] documentIds);
    /** 删除文档*/
    public int deleteByIds( String[] documentIds);
    /** 添加文档*/
    public  DocumentInfo add( DocumentInfo documentInfo);
}

