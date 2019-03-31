package com.space.mapper;


import com.space.entity.Order;
import com.space.entity.OrderProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WXOrderMapper {

    public List<Order> getSpellOrderInfo();

    public List<Order> getUserOrderInfo(@Param("orderUserPhone") String orderUserPhone,
                                        @Param("orderStatus")Integer orderStatus);

    public List<OrderProduct> getOrderProduct(@Param("orderId")Integer orderId);

    public int addSpellOrder(Order order);
}
