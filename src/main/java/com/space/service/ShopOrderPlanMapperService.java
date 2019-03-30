package com.space.service;


import com.space.entity.ShopOrderPlan;
import com.space.exception.PageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单预定
 */
public interface ShopOrderPlanMapperService {
    /**
     * 增加
     */
    public ShopOrderPlan add(ShopOrderPlan areaTypeInfo);

    /**
     * 删除
     */
    public int deleteById(Integer id);

    /**
     * 修改
     */
    public ShopOrderPlan update(ShopOrderPlan areaTypeInfo);

    /**
     * 查询详情 根据ID
     */
    public ShopOrderPlan getInfoById(Integer id);

    /**
     * 多条件查询
     */
    public PageEntity getList(Integer shopId,
                              String startToTime,
                              String endToTime,
                              String kewWord,
                              Integer pageNo,
                              Integer pageSize);

    /**
     * 多条件查询  返回行数
     */
    public int getCount(Integer shopId,
                        String startToTime,
                        String endToTime,
                        String kewWord);
}
