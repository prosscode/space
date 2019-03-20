package com.space.service.impl;

import com.space.entity.PartsellSetInfo;
import com.space.mapper.PartsellSetInfoMapper;
import com.space.service.PartsellSetInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @describe: 分销设置
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Service
public class PartsellSetInfoServiceImpl implements PartsellSetInfoService {
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private PartsellSetInfoMapper partsellSetInfoMapper;

    @Override
    public PartsellSetInfo save(PartsellSetInfo partsellSetInfo){
        if(partsellSetInfo.getId()>0){
            partsellSetInfoMapper.update(partsellSetInfo);
        }
        else {
           int indetityId=  partsellSetInfoMapper.add(partsellSetInfo);
            partsellSetInfo.setId(indetityId);
        }
        return  partsellSetInfo;
    }
    @Override
    public  PartsellSetInfo getInfoById(Integer id){
        return  partsellSetInfoMapper.getInfoById(id);
    }
    @Override
    public  PartsellSetInfo  getInfoByShopId(Integer shopId){
        return  partsellSetInfoMapper.getInfoByShopId(shopId);
    }
}
