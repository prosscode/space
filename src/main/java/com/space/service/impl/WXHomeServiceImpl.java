package com.space.service.impl;

import com.space.entity.*;
import com.space.exception.PageEntity;
import com.space.mapper.WXHomeMapper;
import com.space.service.WXHomeService;
import com.space.utils.DistanceUtil;
import com.space.wxEntity.WXShopInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public PageEntity getShop(Integer filter, String provice, String city, String district, String type, String barName,
                              Double longUser,Double latUser) {
        logger.info("WXHomeServiceImpl|getShop,filter:"+filter);
        List<WXShopInfo> infoList = null;

        infoList = wxHomeMapper.getShop(filter, provice, city, district, type, barName);

        for(WXShopInfo shop:infoList){
            Integer shopId = shop.getShopId();
            // 查询logo图片
            String shopLogo = wxHomeMapper.getShopLogo(shopId);
            shop.setUrl(shopLogo);

            // 查询商家的订单的评分，计算平均分
            Double score = wxHomeMapper.getShopScore(shopId);
            if(!(score == null)){
                int value = score.intValue();
                shop.setShopScore(value);
            }

            // 计算距离
            if(!(longUser==0 || latUser==0)){
                // 计算距离
                double distance = DistanceUtil.getDistance(shop.getLongitude(), shop.getLatitude(), longUser, latUser);
                shop.setDistance((int) distance);
            }
        }
        // 按商家评分，由高到低
        if(filter == 1){
            Stream<WXShopInfo> sorted = infoList.stream().sorted(Comparator.comparing(WXShopInfo::getShopScore).reversed());
            infoList = sorted.collect(Collectors.toList());
        }
        // 按距离排序,由近到远
        if(filter == 3){
            Stream<WXShopInfo> sorted = infoList.stream().sorted(Comparator.comparing(WXShopInfo::getDistance));
            infoList = sorted.collect(Collectors.toList());
        }

        PageEntity entity = new PageEntity();
        entity.setList(infoList);
        entity.setCount(infoList.size());
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
