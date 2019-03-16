package com.space.service.impl;

import com.space.controller.OrderController;
import com.space.entity.Order;
import com.space.exception.PageEntity;
import com.space.mapper.OrderMapper;
import com.space.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describe: 订单实现类
 * @author: 彭爽pross
 * @date: 2019/03/16
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;

    /**查询订单*/
    @Override
    public PageEntity getOrders(Integer shopId,String orderMark, String orderName, Integer orderType, Integer orderStatus,
                          String dateFrom, String dateTo,Integer pageNo, Integer pageSize) {

        List<Order> orders = orderMapper.getOrders(shopId, orderMark, orderName, orderType, orderStatus, dateFrom, dateTo, pageNo, pageSize);
        int count = orderMapper.getOrderCount(shopId, orderMark, orderName, orderType, orderStatus, dateFrom, dateTo);

        PageEntity entity = new PageEntity();
        entity.setList(orders);
        entity.setCount(count);
        return entity;
    }
}
