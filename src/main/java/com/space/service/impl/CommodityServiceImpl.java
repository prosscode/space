package com.space.service.impl;

import com.space.entity.Commodity;
import com.space.exception.PageEntity;
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


    /** 查询商品*/
    @Override
    public PageEntity getGoods(String productName,Integer pageNo,Integer pageSize) {
        logger.info("CommodityServiceImpl|getGoods,productName:"+productName+",pageNo:"+pageNo+",pageSize"+pageSize);
        // 查询
        List<Commodity> goods = commodityMapper.getGoods(productName,pageNo,pageSize);
        // 总数
        int goodsCount = commodityMapper.getGoodsCount(productName);
        PageEntity pageEntity = new PageEntity();
        pageEntity.setList(goods);
        pageEntity.setCount(goodsCount);
        return pageEntity;
    }

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
        int returnNum=0;
        try{
            // 取出相应的操作
            int opInt = Integer.parseInt(opNumber.get(0).toString());
            if(opInt == 0){
                // 删除商品和删除价格
                returnNum = commodityMapper.deleteProducts(productIds);
                commodityMapper.deletePrice(productIds);
            }
            if(opInt == 1){
                // 上架
                returnNum = commodityMapper.upProduct(productIds);
            }
        }catch (Exception e){
            logger.error("CommodityServiceImpl|deleteAndUpGoods,error message:" + e.getMessage() ,e);
        }
        return returnNum;
    }

    /** 更新商品*/
    @Override
    public int updateGood(Commodity commodity) {
        return commodityMapper.updateGood(commodity);
    }

    /** 删除商品时，检查商品中是否 存在上架商品*/
    @Override
    public int checkProductUp(List<Integer> productIds) {
        logger.info("CommodityServiceImpl|checkProductUp,productIds:"+productIds.toString());
        return commodityMapper.checkProductUp(productIds);
    }




}
