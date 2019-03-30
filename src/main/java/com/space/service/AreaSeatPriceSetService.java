package com.space.service;

import com.space.entity.AreaSeatPriceSet;
import com.space.exception.PageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaSeatPriceSetService {


    /**
     * 增加
     */
    public AreaSeatPriceSet add(AreaSeatPriceSet info);

    /**
     * 删除
     */
    public int deleteById(Integer id);

    /**
     * 修改
     */
    public AreaSeatPriceSet update(AreaSeatPriceSet info);

    /**
     * 查询详情 根据ID
     */
    public AreaSeatPriceSet getInfoById(Integer id);

    /**
     * 多条件查询
     */
    public PageEntity getList(Integer shopId,
                              Integer areaTypeId,
                              Integer pageNo,
                              Integer pageSize);

    /**
     * 多条件查询  返回行数
     */
    public int getCount(Integer shopId,
                        Integer areaTypeId);
}

