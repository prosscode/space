package com.space.service;

import com.space.entity.ShopOrderProductDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 订单商品详情
 */
public interface ShopOrderProductDetailService {

    /**
     * 增加
     */
    public int Add(ShopOrderProductDetail info);

    /**
     * 增加 批量
     */
    public int addBatch(List<ShopOrderProductDetail> orderDetailList);

    /**
     * 删除  根据订单ID批量删除
     */
    public int deleteByOrderId(Integer orderId);


    /**
     * 多条件查询
     */
    public List<ShopOrderProductDetail> getList(
            Integer orderId,
            String productName,
            Integer pageNo,
            Integer pageSize);

    /**
     * 多条件查询 返回行数
     */
    public int getCount(
            Integer orderId,
            String productName);

    /**
     * 订单ID查询商品详情
     */
    public  List<ShopOrderProductDetail> getInfosByOrderId(Integer orderId);
}
