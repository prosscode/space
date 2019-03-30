package com.space.service;

import com.space.entity.ShopSignSetInfo;
import com.space.exception.PageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopSignSetInfoService {

    /**
     * 增加
     */
    public ShopSignSetInfo add(ShopSignSetInfo info);

    /**
     * 删除
     */
    public int deleteById(Integer id);

    /**
     * 修改
     */
    public ShopSignSetInfo update(ShopSignSetInfo info);

    /**
     * 查询详情 根据ID
     */
    public ShopSignSetInfo getInfoById(Integer id);

    /**
     * 多条件查询
     */
    public PageEntity getList(Integer shopId,
                              Integer staffCategoryNo,
                              Integer staffId,
                              Integer pageNo,
                              Integer pageSize);

    /**
     * 列表汇总
     */
    public List<ShopSignSetInfo> summarySignInfo();

    /**
     * 多条件查询  返回行数
     */
    public int getCount(Integer shopId,
                        Integer staffCategoryNo,
                        Integer staffId);
}
