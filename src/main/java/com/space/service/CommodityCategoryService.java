package com.space.service;

import com.space.entity.CommodityCategory;
import com.space.exception.PageEntity;

import java.util.List;

public interface CommodityCategoryService {
    /*  获取商品分类，层级节点形式*/
     public  void GetDataWithNodes(List<CommodityCategory> data,List<CommodityCategory> nodes);

     public List<CommodityCategory>  GetDataWithNodes(Integer shopId);
}
