package com.space.mapper;

import com.space.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WXHomeMapper {

    public List<ShopHome> getShop(@Param("filter") Integer filter,
                                  @Param("provice") String provice,
                                  @Param("city") String city,
                                  @Param("district") String district,
                                  @Param("type") String type,
                                  @Param("barName") String barName);

    public void getGoodInfo(@Param("shopId") Integer shopId,
                            @Param("productName")String productName);

    public List<SeatInfo> getSeatInfo(@Param("shopId") Integer shopId);

    public List<CouponInfo> getCouponInfo(@Param("shopId")Integer shopId);

    public List<Staff> getWaiterInfo(@Param("shopMark")String shopMark);

    public int addOrder(Order order);

    public int addOrderProduct(List<OrderProduct> orderProduct);
}

