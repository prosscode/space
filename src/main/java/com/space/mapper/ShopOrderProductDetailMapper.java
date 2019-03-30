package com.space.mapper;

import com.space.entity.AreaTypeInfo;
import com.space.entity.ShopOrderProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/** 订单商品详情*/
public interface ShopOrderProductDetailMapper {

    /**
     * 增加
     */
    public int Add(ShopOrderProductDetail info);

    /**
     * 增加 批量
     */
    public int addBatch(@Param("orderDetailList")List<ShopOrderProductDetail> orderDetailList);

    /**
     * 删除  根据订单ID批量删除
     */
    public int deleteByOrderId(@Param("orderId") Integer orderId);


    /**
     * 多条件查询
     */
    public List<ShopOrderProductDetail> getList(
                                      @Param("orderId") Integer orderId,
                                      @Param("productName") String productName,
                                      @Param("pageNo") Integer pageNo,
                                      @Param("pageSize") Integer pageSize);

    /**
     * 多条件查询 返回行数
     */
    public  int getCount(
            @Param("orderId") Integer orderId,
            @Param("productName") String productName);

    /**
     * 订单ID查询商品详情
     */
    public List<ShopOrderProductDetail> getInfosByOrderId( @Param("orderId") Integer orderId);

}
