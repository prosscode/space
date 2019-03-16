package com.space.service;

import com.space.entity.OrderParam;
import com.space.exception.PageEntity;

import java.util.List;

public interface OrderService {

    public PageEntity getOrders(Integer shopId, String orderMark, String orderName, Integer orderType,
                                Integer orderStatus, String dateFrom, String dateTo, Integer pageNo, Integer pageSize);

    public List<OrderParam> totalPrice(Integer shopId);

    public List<OrderParam> yesterdayPrice(Integer shopId);
}
