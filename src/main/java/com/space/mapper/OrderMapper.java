package com.space.mapper;

import com.space.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    public List<Order> getOrders(@Param("shopId") Integer shopId,
                                 @Param("orderMark") String orderMark,
                                 @Param("orderName") String orderName,
                                 @Param("orderType") Integer orderType,
                                 @Param("orderStatus")Integer orderStatus,
                                 @Param("dateFrom")String dateFrom,
                                 @Param("dateTo")String dateTo,
                                 @Param("pageNo") Integer pageNo,
                                 @Param("pageSize") Integer pageSize);

    public int getOrderCount(@Param("shopId") Integer shopId,
                             @Param("orderMark") String orderMark,
                             @Param("orderName") String orderName,
                             @Param("orderType") Integer orderType,
                             @Param("orderStatus")Integer orderStatus,
                             @Param("dateFrom")String dateFrom,
                             @Param("dateTo")String dateTo);

    public Double totalPrice(@Param("shopId")Integer shopId);

    public Double yesterdayPrice(@Param("shopId")Integer shopId,@Param("yesterday")String yesterday,@Param("today")String today);
}
