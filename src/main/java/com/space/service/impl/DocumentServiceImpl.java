package com.space.service.impl;


import com.space.entity.DocumentInfo;

import com.space.mapper.DocumentInfoMapper;

import com.space.service.DocumentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



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
    public  DocumentInfo add( DocumentInfo documentInfo) throws Exception {
          documentInfoMapper.add(documentInfo);
          return  documentInfo;
    }


}
