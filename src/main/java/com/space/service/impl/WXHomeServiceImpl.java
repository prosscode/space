package com.space.service.impl;

import com.space.entity.*;
import com.space.exception.PageEntity;
import com.space.mapper.WXHomeMapper;
import com.space.service.WXHomeService;
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
 * @date: 2019/03/17
 */
@Service
public class WXHomeServiceImpl implements WXHomeService {

    private Logger logger = LoggerFactory.getLogger(WXHomeServiceImpl.class);

    private SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

    @Autowired
    private WXHomeMapper wxHomeMapper;

    /**查询商家*/
    @Override
    public PageEntity getShop(Integer filter, String provice, String city, String district, String type, String barName) {
        logger.info("WXHomeServiceImpl|getShop,filter:"+filter);
        List<ShopHome> infoList = wxHomeMapper.getShop(filter, provice, city, district, type, barName);
        PageEntity entity = new PageEntity();
        entity.setList(infoList);
        entity.setCount(0);
        return entity;
    }

    /**查询商品信息*/
    @Override
    public void getGoodInfo(Integer shopId,String productName) {
        logger.info("WXHomeServiceImpl|getGoodInfo,shopId:"+shopId);
        wxHomeMapper.getGoodInfo(shopId,productName);
    }

    /**座位信息*/
    @Override
    public PageEntity getSeatInfo(Integer shopId) {
        logger.info("WXHomeServiceImpl|getGoodInfo,shopId:"+shopId);
        List<SeatInfo> seatInfo = wxHomeMapper.getSeatInfo(shopId);
        PageEntity entity = new PageEntity();
        entity.setList(seatInfo);
        entity.setCount(0);
        return entity;
    }

    /**拿到优惠券信息*/
    @Override
    public PageEntity getCouponInfo(Integer shopId) {
        List<CouponInfo> couponInfo = wxHomeMapper.getCouponInfo(shopId);
        PageEntity entity = new PageEntity();
        entity.setList(couponInfo);
        entity.setCount(0);
        return entity;
    }

    /**拿服务员信息*/
    @Override
    public PageEntity getWaiterInfo(String shopMark) {
        List<Staff> waiterInfo = wxHomeMapper.getWaiterInfo(shopMark);
        PageEntity entity = new PageEntity();
        entity.setList(waiterInfo);
        entity.setCount(0);
        return entity;
    }

    /** 添加订单*/
    @Override
    public Integer addOrder(Order order) {
        // 生成订单号
        String format = this.format.format(new Date());
        String orderNo = "E"+order.getShopId()+format;
        order.setOrderNo(orderNo);
        int addOrder = wxHomeMapper.addOrder(order);
        Integer orderId = order.getOrderId();
        return orderId;
    }

    /** 添加订单的商品详情*/
    @Override
    public int addOrderProduct(List<OrderProduct> orderProduct) {
        return wxHomeMapper.addOrderProduct(orderProduct);
    }

}
