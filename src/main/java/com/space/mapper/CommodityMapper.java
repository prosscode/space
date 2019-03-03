package com.space.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommodityMapper {

    /** 检查是否有相同的商品名*/
    public int checkProductName(@Param("productName") String productName);
}
