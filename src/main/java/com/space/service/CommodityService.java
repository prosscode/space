package com.space.service;

import com.space.entity.Commodity;

import java.util.List;

public interface CommodityService {

    /** 检查是否有相同的商品名*/
    public int checkProductName(String productName);

    /** 检查商品中是否 存在上架商品*/
    public int checkProductUp(List<Integer> productIds);

    /** 发布商品*/
    public int addGood(Commodity commodity);

    /**删除商品*/
    public int deleteAndUpGoods(List<Integer> productIds,List<Object> opNumber);

}
