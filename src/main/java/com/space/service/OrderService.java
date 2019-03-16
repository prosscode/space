package com.space.service;

import com.space.exception.PageEntity;

public interface OrderService {

    public PageEntity getOrders(Integer shopId, String orderMark, String orderName, Integer orderType,
                                Integer orderStatus, String dateFrom, String dateTo, Integer pageNo, Integer pageSize);

}
