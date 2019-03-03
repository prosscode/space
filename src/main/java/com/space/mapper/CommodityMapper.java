package com.space.mapper;


import com.space.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommodityMapper {

    /** 查询商品*/
    public List<Commodity> getGoods(@Param("productName") String productName,
                                    @Param("pageNo")Integer pageNo,
                                    @Param("pageSize")Integer pageSize);

    /***/
    public int getGoodsCount(@Param("productName") String productName);

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

    /** 删除价格区间的数据*/
    public int deletePrice(@Param("productIds") List<Integer> productIds);

    /** 更新任务*/
    public int updateGood(@Param("commodity") Commodity commodity);
}
