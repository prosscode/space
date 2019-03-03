package com.space.service;

import com.space.entity.Commodity;

public interface CommodityService {

    /** 检查是否有相同的商品名*/
    public int checkProductName(String productName);

    /** 发布商品*/
    public void publishGoods(Commodity commodity);

}
