package com.space.mapper;


import com.space.entity.Commodity;
import com.space.entity.CommodityType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommodityMapper {

    /**增加商品分组*/
    public int addGoodType(@Param("typeName")String typeName,@Param("shopId")Integer shopId,@Param("currentTime") String currentTime);

    /**增加商家座位分组*/
    public int addSeatType(@Param("typeName")String typeName,@Param("shopId")Integer shopId,@Param("seatNumber")Integer seatNumber,
                           @Param("currentTime") String currentTime,@Param("role")Integer role);

    /** 查询所有分组*/
    public List<CommodityType> getGoodType(@Param("shopId")Integer shopId);

    /** 删除分组*/
    public int deleteGoodType(@Param("shopId")Integer shopId,@Param("typeName")String typeName);

    /** 编辑分组*/
    public int updateGoodType(@Param("typeId")Integer typeId,@Param("shopId")Integer shopId,@Param("typeName")String typeName);


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
