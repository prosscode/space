package com.space.service;

import com.space.entity.Order;
import com.space.entity.OrderProduct;
import com.space.exception.PageEntity;

import java.util.List;

public interface WXHomeService {

    public PageEntity getShop(Integer filter, String provice, String city, String district, String type, String barName);

    public void getGoodInfo(Integer shopId,String productName);

    public PageEntity getSeatInfo(Integer shopId);

    public PageEntity getCouponInfo(Integer shopId);

    public PageEntity getWaiterInfo(String shopMark);

    public Integer addOrder(Order order);

    public int addOrderProduct(List<OrderProduct> orderProduct);

}
