package com.space.service;

import com.space.entity.Commodity;
import com.space.exception.PageEntity;

import java.util.List;

public interface CommodityService {

    /**增加分组*/
    public int addGoodType(Integer shopId,String typeName,String typeSubName,Integer seatNumber,Integer role);

    /**查询所有分类*/
    public PageEntity getGoodType(Integer shopId);

    /** 删除分组*/
    public int deleteGoodType(Integer shopId,String typeName);
    /** 编辑分组*/
    public int updateGoodType(Integer typeId,Integer shopId,String typeName);

    /**查询商品*/
    public PageEntity getGoods(String productName,
                               Integer pageNo,
                               Integer pageSize,
                               Integer productCategoryNo,
                               Integer shopId,
                               Integer productStatus,
                               String keyWord);

    /** 检查是否有相同的商品名*/
    public int checkProductName(String productName);

    /** 检查商品中是否 存在上架商品*/
    public int checkProductUp(List<Integer> productIds);

    /** 发布商品*/
    public int addGood(Commodity commodity);

    /**删除商品*/
    public int deleteAndUpGoods(List<Integer> productIds,Integer opNumber,List<Object> setValues);

    /** 更新商品*/
    public int updateGood(Commodity commodity);

    /**添加桌位编号*/
    public int addSeatMark(Integer shopId,String seatType,String seatPrefix,Integer seatNum,Integer seatCount);

    /**查询桌位*/
    public PageEntity getSeat(Integer shopId);

    /**删除桌位*/
    public int deleteSeat(Integer seatId,Integer shopId);

}
