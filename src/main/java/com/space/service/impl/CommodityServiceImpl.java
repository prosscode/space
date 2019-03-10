package com.space.service.impl;

import com.space.entity.Commodity;
import com.space.entity.CommodityType;
import com.space.exception.PageEntity;
import com.space.mapper.CommodityMapper;
import com.space.service.CommodityService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/03/01
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private CommodityMapper commodityMapper;


    /** 添加分组*/
    @Override
    public int addGoodType(Integer shopId, String typeName, String typeSubName,Integer seatNumber, Integer role) {
        int num=0;
        // 添加时间 为当前时间
        String currentTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        if(StringUtils.isBlank(typeSubName) && seatNumber == -1){
            // 添加商品父分组
            num = commodityMapper.addGoodType(typeName,shopId,currentTime);
        }
        if(seatNumber != -1 && StringUtils.isBlank(typeSubName)){
            //添加座位父分组
            role = 1;
            num = commodityMapper.addSeatType(typeName,shopId,currentTime,role);
        }
        if(seatNumber != -1 && !StringUtils.isBlank(typeSubName)){
            // 添加子分组
            role = 1;
            num = commodityMapper.addGoodSubType(typeName,typeSubName,shopId,seatNumber,currentTime,role);
        }

        return num;
    }

    /** 查询座位分组*/
    @Override
    public PageEntity getGoodType(Integer shopId) {
        List<CommodityType> type = commodityMapper.getGoodType(shopId);
        PageEntity entity = new PageEntity();
        entity.setList(type);
        entity.setCount(0);
        return entity;
    }

    /** 删除分组*/
    @Override
    public int deleteGoodType(Integer shopId, String typeName) {
        return  commodityMapper.deleteGoodType(shopId,typeName);
    }

    /**编辑分组*/
    @Override
    public int updateGoodType(Integer typeId,Integer shopId, String typeName) {
        return commodityMapper.updateGoodType(typeId,shopId,typeName);

    }

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
