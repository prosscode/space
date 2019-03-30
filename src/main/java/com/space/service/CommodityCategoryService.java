package com.space.service;

import com.space.entity.CommodityCategory;
import com.space.exception.PageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommodityCategoryService {
    /*  获取商品分类，层级节点形式*/
     public  void GetDataWithNodes(List<CommodityCategory> data,List<CommodityCategory> nodes,boolean spread);

     public List<CommodityCategory>  GetDataWithNodes(Integer shopId,boolean spread);


    /**
     * 增加
     */
    public CommodityCategory add(CommodityCategory info);

    /**
     * 删除
     */
    public int deleteById(  Integer id);

    /**
     * 修改
     */
    public CommodityCategory update(CommodityCategory info);

    /**
     * 删除
     */
    public CommodityCategory getInfoById(  Integer id);
}
