package com.space.service.impl;

import com.space.entity.CommodityCategory;
import com.space.exception.PageEntity;
import com.space.mapper.CommodityCategoryMapper;
import com.space.service.CommodityCategoryService;
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
public class CommodityCategoryServiceImpl implements  CommodityCategoryService{
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private CommodityCategoryMapper commodityCategoryMapper;
    @Override
    public  void GetDataWithNodes(List<CommodityCategory> data,List<CommodityCategory> nodes){
        if(nodes!=null&&nodes.size()>0){
            for(CommodityCategory item : nodes){
                Integer pid =item.getId();
                //获取下一层节点
                List<CommodityCategory> nextChilds =data.stream()
                                                .filter((CommodityCategory s)->s.getParentId()==pid)
                                                 .collect(Collectors.toList());
                if(nextChilds==null)
                    nextChilds =new  ArrayList<CommodityCategory>();
                item.setChildren(nextChilds);
                GetDataWithNodes(data,item.getChildren());
            }
        }
    }
    @Override
    public  List<CommodityCategory> GetDataWithNodes(Integer shopId){
        List<CommodityCategory> data=   commodityCategoryMapper.GetData(shopId);
        CommodityCategory parent =new CommodityCategory();
        parent.setId(0);
        List<CommodityCategory> dataWithNodes =
                new ArrayList<CommodityCategory>();
        dataWithNodes.add(parent);
        this.GetDataWithNodes(data,dataWithNodes);
        return   dataWithNodes;
    }

}
