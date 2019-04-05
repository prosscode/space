package com.space.mapper;

import com.space.entity.*;
import com.space.wxEntity.WXShopInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface WXHomeMapper {

    public List<WXShopInfo> getShop(@Param("filter") Integer filter,
                                    @Param("provice") String provice,
                                    @Param("city") String city,
                                    @Param("district") String district,
                                    @Param("type") String type,
                                    @Param("barName") String barName,
                                    @Param("pageNo")Integer pageNo,
                                    @Param("pageSize") Integer pageSize);

    public Double getShopScore(@RequestParam("shopId")Integer shopId);

    public String getShopLogo(@RequestParam("shopId")Integer shopId);

    public List<String> getPhotos(@RequestParam("shopId")Integer shopId);

    public void getGoodInfo(@Param("shopId") Integer shopId,
                            @Param("productName")String productName);

    public List<SeatInfo> getSeatInfo(@Param("shopId") Integer shopId);

    public List<CouponInfo> getCouponInfo(@Param("shopId")Integer shopId);

    public List<Staff> getWaiterInfo(@Param("shopMark")String shopMark);

    public int addOrder(Order order);

    public int addOrderProduct(List<OrderProduct> orderProduct);
}

