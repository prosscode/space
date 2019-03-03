package com.space.service.impl;

import com.space.controller.CommodityController;
import com.space.entity.Commodity;
import com.space.mapper.CommodityMapper;
import com.space.service.CommodityService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/03/03
 */
public class CommodityServiceImpl implements CommodityService {

    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private CommodityMapper commodityMapper;

    /** 判断添加商品，商品名称是否存在*/
    @Override
    public int checkProductName(String productName) {
        logger.info("CommodityServiceImpl|checkProductName,productName:"+productName);
        return commodityMapper.checkProductName(productName);
    }

    @Override
    public void publishGoods(Commodity commodity) {
        try {
            logger.info("CommodityServiceImpl|publishGoods,commodity:"+commodity.toString());

        }catch (Exception e){
            logger.error("CommodityServiceImpl|publishGoods,error message:" + e.getMessage() ,e);
        }


    }
}
