package com.space.service.impl;

import com.space.entity.Commodity;
import com.space.mapper.CommodityMapper;
import com.space.service.CommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/03/03
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private CommodityMapper commodityMapper;


    /** 判断添加商品，商品名称是否存在*/
    @Override
    public int checkProductName(String productName) {
        logger.info("CommodityServiceImpl|checkProductName,productName:"+productName);
        int count = commodityMapper.checkProductName(productName);
        return count;
    }

    /**发布商品*/
    @Override
    public int addGood(Commodity commodity) {
        int addGood = 0;
        try {
            logger.info("CommodityServiceImpl|publishGoods,commodity:"+commodity.toString());
            addGood = commodityMapper.addGood(commodity);

        }catch (Exception e){
            logger.error("CommodityServiceImpl|publishGoods,error message:" + e.getMessage() ,e);
        }
        return addGood;
    }


    /**删除和上架商品*/
    @Override
    public int deleteAndUpGoods(List<Integer> productIds, List<Object> opNumber) {
        try{
            // 取出相应的操作
            int opInt = Integer.parseInt(opNumber.get(0).toString());
            if(opInt == 0){
                // 删除

            }

            if(opInt == 1){
                // 上架

            }

        }catch (Exception e){
            logger.error("CommodityServiceImpl|deleteAndUpGoods,error message:" + e.getMessage() ,e);
        }
        return 0;
    }

    /** 删除商品时，检查商品中是否 存在上架商品*/
    @Override
    public int checkProductUp(List<Integer> productIds) {
        logger.info("CommodityServiceImpl|checkProductUp,productIds:"+productIds.toString());
        return commodityMapper.checkProductUp(productIds);
    }
}
