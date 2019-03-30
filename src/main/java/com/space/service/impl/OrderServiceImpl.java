package com.space.service.impl;

import com.space.entity.Order;
import com.space.entity.OrderParam;
import com.space.exception.PageEntity;
import com.space.mapper.OrderMapper;
import com.space.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    /**总价*/
    @Override
    public List<OrderParam> totalPrice(Integer shopId) {
        List<OrderParam> params = orderMapper.totalPrice(shopId);
        return  params;
    }

    /**昨日销售*/
    @Override
    public List<OrderParam> yesterdayPrice(Integer shopId) {
        // 昨天时间
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,   -1);
        String yesterday = new SimpleDateFormat( "yyyy-MM-dd 00:00:00").format(cal.getTime());
        // 今天整点
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,   0);
        String today = new SimpleDateFormat( "yyyy-MM-dd 00:00:00").format(calendar.getTime());

        List<OrderParam> orderParams = orderMapper.yesterdayPrice(shopId, yesterday, today);
        return orderParams;
    }
}
