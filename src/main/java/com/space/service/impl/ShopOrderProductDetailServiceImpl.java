package com.space.service.impl;

import com.space.entity.ShopOrderProductDetail;
import com.space.mapper.ShopOrderProductDetailMapper;
import com.space.service.ShopOrderProductDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describe: 订单预定
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Service
public class ShopOrderProductDetailServiceImpl implements ShopOrderProductDetailService {
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private ShopOrderProductDetailMapper orderProductDetailMapper;


    /**
     * 增加
     */
    @Override
    public int Add(ShopOrderProductDetail info){
        return  orderProductDetailMapper.Add(info);
    }

    /**
     * 增加 批量
     */
    @Override
    public int addBatch(List<ShopOrderProductDetail> orderDetailList){
        return  orderProductDetailMapper.addBatch(orderDetailList);
    }

    /**
     * 删除  根据订单ID批量删除
     */
    @Override
    public int deleteByOrderId(Integer orderId){
        return  orderProductDetailMapper.deleteByOrderId(orderId);
    }


    /**
     * 多条件查询
     */
    @Override
    public List<ShopOrderProductDetail> getList(
            Integer orderId,
            String productName,
            Integer pageNo,
            Integer pageSize){
        return  orderProductDetailMapper.getList(orderId,productName,pageNo,pageSize);
    }

    /**
     * 多条件查询 返回行数
     */
    @Override
    public int getCount(
            Integer orderId,
            String productName){
        return  orderProductDetailMapper.getCount(orderId,productName);
    }


    /**
     * 订单ID查询商品详情
     */
    @Override
    public  List<ShopOrderProductDetail> getInfosByOrderId(Integer orderId){
        return orderProductDetailMapper.getInfosByOrderId(orderId);
    }


}
