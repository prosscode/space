package com.space.mapper;

import com.space.entity.CommodityCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommodityCategoryMapper {

    /**
     * 增加
     */
    public int add(CommodityCategory info);

    /**
     * 删除
     */
    public int deleteById(@Param("id") Integer id);

    /**
     * 删除
     */
    public int deleteByIds(@Param("ids")List<Integer> ids);

    /**
     * 获取子集IDs 逗号分隔
     */
    public String  getChildIdStrByPId(@Param("pid") Integer pid);
    /**
     * 修改
     */
    public int update(CommodityCategory info);

    /**
     * 查询详情 根据ID
     */
    public CommodityCategory getInfoById(@Param("id") Integer id);


    /** 查询所有商品分类*/
    public List<CommodityCategory> GetData(@Param("shopId")Integer shopId);

}
