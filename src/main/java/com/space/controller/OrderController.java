package com.space.controller;

import com.space.exception.PageEntity;
import com.space.service.OrderService;
import com.sun.xml.internal.stream.events.NamedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @describe: 订单管理
 * @author: 彭爽pross
 * @date: 2019/03/10
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    /** 查询订单*/
    @RequestMapping(value = "/getOrders")
    public PageEntity getOrders(@RequestParam(name = "shopId",required = true)Integer shopId,
                                @RequestParam(name = "orderMark",defaultValue = "")String orderMark,
                                @RequestParam(name = "orderName",defaultValue = "")String orderName,
                                @RequestParam(name = "orderType",defaultValue = "0")Integer orderType,
                                @RequestParam(name = "orderStatus",defaultValue = "")Integer orderStatus,
                                @RequestParam(name = "dateFrom",defaultValue = "")String dateFrom,
                                @RequestParam(name = "dateTo",defaultValue = "")String dateTo,
                                @RequestParam(name="pageNo",defaultValue = "1")Integer pageNo,
                                @RequestParam(name="pageSize",defaultValue="20")Integer pageSize){
        logger.info("OrderController|getOrders,orderName:"+orderName);
        pageNo = (pageNo -1) * pageSize;
        return orderService.getOrders(shopId,orderMark,orderName,orderType,orderStatus,dateFrom,dateTo,pageNo, pageSize);
    }

    /** 总成交金额*/
    @RequestMapping(value = "/totalPrice")
    public Double totalPrice(@RequestParam(name = "shopId")Integer shopId){
        logger.info("OrderController|totalPrice,shopId:"+shopId);
        return orderService.totalPrice(shopId);
    }

    /** 昨日成交金额*/
    @RequestMapping(value = "/yesterdayPrice")
    public Double yesterdayPrice(@RequestParam(name = "shopId")Integer shopId){
        logger.info("OrderController|yesterdayPrice,shopId:"+shopId);
        return orderService.yesterdayPrice(shopId);
    }
}
