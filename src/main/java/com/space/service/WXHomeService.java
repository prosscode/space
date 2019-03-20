package com.space.service;

import com.space.exception.PageEntity;

public interface WXHomeService {

    public PageEntity getShop(Integer filter, String provice, String city, String district, String type, String barName);

    public void getGoodInfo(Integer shopId,String productName);

    public PageEntity getSeatInfo(Integer shopId);

    public PageEntity getCouponInfo(Integer shopId);

    public PageEntity getWaiterInfo(String shopMark);

}
