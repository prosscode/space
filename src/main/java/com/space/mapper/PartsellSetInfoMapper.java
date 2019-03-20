package com.space.mapper;


import com.space.entity.Commodity;
import com.space.entity.CommodityCategory;
import com.space.entity.DocumentInfo;
import com.space.entity.PartsellSetInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/** 分销设置*/
public interface PartsellSetInfoMapper {

    /** 设置分销*/
    public  int add(PartsellSetInfo partsellSetInfo);
    /** 删除*/
    public  int deleteById(@Param("id")Integer id);
    /** 修改*/
    public  int update(PartsellSetInfo partsellSetInfo);

    /** 查询*/
    public  PartsellSetInfo getInfoById(@Param("id")Integer id);


    /** 查询 根据shopId*/
    public  PartsellSetInfo getInfoByShopId(@Param("id")Integer shopId);
}
