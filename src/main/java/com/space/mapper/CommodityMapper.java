package com.space.mapper;


import com.space.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommodityMapper {

    /** 检查是否有相同的商品名*/
    public int checkProductName(@Param("productName") String productName);

    /** 添加商品*/
    public int addGood(Commodity commodity);

    /** 检查商品中是否 存在上架商品*/
    public int checkProductUp(@Param("productIds") List<Integer> productIds);

    /**删除商品*/
    public int deleteProducts(@Param("productIds") List<Integer> productIds);

    /**上架商品*/
    public int upProduct(@Param("productIds") List<Integer> productIds);
}
