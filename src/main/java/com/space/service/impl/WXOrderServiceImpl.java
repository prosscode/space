package com.space.service.impl;

import com.space.entity.Order;
import com.space.entity.OrderProduct;
import com.space.exception.PageEntity;
import com.space.mapper.WXOrderMapper;
import com.space.service.WXOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/03/23
 */

@Service
public class WXOrderServiceImpl implements WXOrderService {

    private Logger logger = LoggerFactory.getLogger(WXOrderServiceImpl.class);

    private SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

    @Autowired
    private WXOrderMapper wxOrderMapper;

    /** 拼单信息*/
    @Override
    public PageEntity getSpellOrderInfo() {
        List<Order> orderInfo = wxOrderMapper.getSpellOrderInfo();
        PageEntity entity = new PageEntity();
        entity.setList(orderInfo);
        entity.setCount(0);
        return entity;
    }
    /** 订单信息*/
    @Override
    public PageEntity getUserOrderInfo(String orderUserPhone, Integer orderStatus) {
        List<Order> orderInfo = wxOrderMapper.getUserOrderInfo(orderUserPhone, orderStatus);
        orderInfo.forEach(order->{
            Integer orderId = order.getOrderId();
            List<OrderProduct> orderProduct = wxOrderMapper.getOrderProduct(orderId);
            order.setOrderProductList(orderProduct);
        });
        PageEntity entity = new PageEntity();
        entity.setList(orderInfo);
        entity.setCount(0);
        return entity;
    }

    /** 添加拼吧订单信息*/
    @Override
    public Integer addSpellOrder(Order order) {
        // 生成订单号
        String format = this.format.format(new Date());
        String orderNo = "E"+order.getShopId()+format;
        order.setOrderNo(orderNo);
        wxOrderMapper.addSpellOrder(order);
        return order.getOrderId();
    }
}
