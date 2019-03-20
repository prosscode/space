package com.space.mapper;

import com.space.entity.Order;
import com.space.entity.OrderParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopOrderMapper {

    public List<Order> getList(@Param("shopId") Integer shopId,
                               @Param("orderNo") String orderNo,
                               @Param("orderName") String orderName,
                               @Param("orderType") Integer orderType,
                               @Param("orderStatus") Integer orderStatus,
                               @Param("dateFrom") String dateFrom,
                               @Param("dateTo") String dateTo,
                               @Param("pageNo") Integer pageNo,
                               @Param("pageSize") Integer pageSize);

    public int deleteByIds(@Param("orderIds") List<Integer> orderIds);

    public int deleteById(@Param("orderId") Integer orderId);

    public Order getInfoById(@Param("orderId") Integer orderId);

    public int getInfoByNo(@Param("orderNo") String orderNo);

}
