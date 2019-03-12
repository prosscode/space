package com.space.mapper;

import com.space.entity.ShopInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ShopMapper {

    /**查询商家信息*/
    public List<ShopInfo> getShopInfo(@Param("shopId")Integer shopId);

}
