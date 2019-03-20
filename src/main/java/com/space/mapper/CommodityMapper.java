package com.space.mapper;


import com.space.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public  interface CommodityMapper {

    /**增加商品分组*/
    public int addGoodType(@Param("typeName")String typeName,@Param("shopId")Integer shopId,@Param("currentTime") String currentTime);

    /** 查询所有分组*/
    public List<CommodityType> getGoodType(@Param("shopId")Integer shopId);

    /** 删除分组*/
    public int deleteGoodType(@Param("shopId")Integer shopId,@Param("typeName")String typeName);

    /** 编辑分组*/
    public int updateGoodType(@Param("typeId")Integer typeId,@Param("shopId")Integer shopId,@Param("typeName")String typeName);

    /** 添加子分组*/
    public int addGoodSubType(@Param("typeName")String typeName,
                              @Param("typeSubName")String typeSubName,
                              @Param("shopId")Integer shopId,
                              @Param("seatNumber")Integer seatNumber,
                              @Param("currentTime") String currentTime,
                              @Param("role")Integer role);

    /** 查询商品*/
    public List<Commodity> getGoods(@Param("productName") String productName,
                                    @Param("pageNo")Integer pageNo,
                                    @Param("pageSize")Integer pageSize,
                                    @Param("productCategoryNo")Integer productCategoryNo,
                                    @Param("shopId")Integer shopId,
                                    @Param("productStatus")Integer productStatus,
                                    @Param("keyWord")String keyWord);

    public int getGoodsCount(@Param("productName") String productName);

    /** 检查是否有相同的商品名*/
    public int checkProductName(@Param("productName") String productName);

    /** 添加商品*/
    public int addGood(Commodity commodity);

    /** 检查商品中是否 存在上架商品*/
    public int checkProductUp(@Param("productIds") List<Integer> productIds);

    /**删除商品*/
    public int deleteProducts(@Param("productIds") List<Integer> productIds);

    /**上架、下架、修改分类、分销等商品*/
    public int upProduct(@Param("optNum")Integer optNum,@Param("productIds") List<Integer> productIds,@Param("setValues")List<Object> setValues);



    /** 更新任务*/
    public int updateGood(@Param("commodity") Commodity commodity);

    /** 商品详情*/
    public Commodity getCommodityById(@Param("commdityId") Integer commdityId);

    /**新增桌位编号*/
    public int addSeatMark(@Param("shopId") Integer shopId,
                           @Param("seatType") String seatType,
                           @Param("seatMark") String seatMark,
                           @Param("seatCount") Integer seatCount);

    /**查询桌位*/
    public List<ShopSeat> getSeat(@Param("shopId")Integer shopId);

    /**删除桌位*/
    public int deleteSeat(@Param("seatId")Integer seatId,@Param("shopId")Integer shopId);

   /*  <!--//////////////////商品关联文档/////////////////////-->*/
    /**查询所有*/
    public List<CommodityDocument> getCommodityDocuments(@Param("commodityIds")List<Integer> commodityIds);
    /**增加*/
    public int  addCommodityDocument(@Param("CommodityDocument") CommodityDocument commodityDocument);
    /**删除 根据商品ID*/
    public int  deleteCommodityDocumentByCommodityId(@Param("commodityId")Integer commodityId);

    /**删除 根据多个商品ID*/
    public int  deleteCommodityDocumentByCommodityIds(@Param("commodityIds")List<Integer> commodityIds);

    /*  <!--//////////////////商品关联价格/////////////////////-->*/
    /** 删除价格区间的数据 根据商品ID*/
    public int deletePriceByCommodityId(@Param("commodityId") Integer commodityId);
    /** 删除价格区间的数据 根据商品ID*/
    public int deletePrice(@Param("commodityIds") List<Integer> commodityIds);
    /** 查询商品价格数据 根据商品ID*/
    public List<CommodityPrice> getPricesByCommodityId(@Param("commodityId")Integer commodityId);
    /** 查询商品价格数据*/
    public List<CommodityPrice>   getCommodityPrices(
            @Param("shopId")Integer shopId
            ,@Param("commodityId")Integer commodityId
            ,@Param("commodityName")String commodityName);
    /** 添加商品价格数据 */
    public int  addCommodityPrices(@Param("CommodityPrice") CommodityPrice commodityPrice);

}
