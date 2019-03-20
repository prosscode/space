package com.space.mapper;


import com.space.entity.Commodity;
import com.space.entity.CommodityCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommodityCategoryMapper {
    /** 查询所有商品分类*/
    public List<CommodityCategory> GetData(@Param("shopId")Integer shopId);
}
