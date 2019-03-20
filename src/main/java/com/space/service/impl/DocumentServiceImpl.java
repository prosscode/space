package com.space.service.impl;

import com.space.entity.CommodityCategory;
import com.space.entity.DocumentInfo;
import com.space.exception.PageEntity;
import com.space.mapper.CommodityCategoryMapper;
import com.space.mapper.DocumentInfoMapper;
import com.space.service.CommodityCategoryService;
import com.space.service.DocumentService;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


/**
 * @describe:
 * @author: 吕涛pross
 * @date: 2019/03/01
 */
@Service
public class DocumentServiceImpl implements DocumentService{
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private DocumentInfoMapper documentInfoMapper;

    /** 查询文档*/
    @Override
    public List<DocumentInfo> getByIds( String[] documentIds){
        return    documentInfoMapper.getByIds(documentIds);
    }
    /** 删除文档*/
    @Override
    public int deleteByIds( String[] documentIds){
        if(documentIds!=null&&documentIds.length>0){
            documentInfoMapper.deleteByIds(documentIds);
        }
        return 1;
    }
    /** 添加文档*/
    @Override
    public  DocumentInfo add( DocumentInfo documentInfo){
        return  documentInfoMapper.add(documentInfo);
    }


}
