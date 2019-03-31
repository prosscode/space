package com.space.controller;

import com.space.entity.Order;
import com.space.exception.PageEntity;
import com.space.service.WXOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe: 订单相关
 * @author: 彭爽pross
 * @date: 2019/03/21
 */

@RestController
@RequestMapping(value = "/wx/order")
public class WXOrderController {

    private static Logger logger = LoggerFactory.getLogger(WXOrderController.class);

    @Autowired
    private WXOrderService wxOrderService;

    /**拿到附近的拼吧信息*/
    @RequestMapping(value = "/getSpellOrderInfo")
    public PageEntity getSpellOrderInfo(){
        PageEntity orderInfo = wxOrderService.getSpellOrderInfo();
        return orderInfo;
    }

    /**用户订单信息*/
    @RequestMapping(value = "/getUserOrderInfo")
    public PageEntity getUserOrderInfo(@RequestParam(name = "orderUserPhone",required = true)String orderUserPhone,
                                       @RequestParam(name = "orderStatus",required = true)Integer orderStatus){
        logger.info("WXOrderController|getUserOrderInfo,orderUserPhone:"+orderUserPhone+",orderStatus:"+orderStatus);
        PageEntity orderInfo = wxOrderService.getUserOrderInfo(orderUserPhone, orderStatus);
        return orderInfo;
    }

    /** 添加拼吧订单*/
    @RequestMapping(value = "/addSpellOrder")
    public Integer addSpellOrder(@RequestBody Order order){
        logger.info("WXOrderController|addSpellOrder,shopId:"+order.getShopId());
        return wxOrderService.addSpellOrder(order);
    }
}
