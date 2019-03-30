package com.space.service;


import com.space.exception.PageEntity;

public interface WXOrderService {

    public PageEntity getSpellOrderInfo();

    public PageEntity getUserOrderInfo(String orderUserPhone,Integer orderStatus);
}
