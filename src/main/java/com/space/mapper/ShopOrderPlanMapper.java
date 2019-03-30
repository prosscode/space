package com.space.mapper;


import com.space.entity.ShopOrderPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/** 订单预定*/
public interface ShopOrderPlanMapper {
    /**
     * 增加
     */
    public int add(ShopOrderPlan areaTypeInfo);

    /**
     * 删除
     */
    public int deleteById(@Param("id") Integer id);

    /**
     * 修改
     */
    public int update(ShopOrderPlan areaTypeInfo);

    /**
     * 查询详情 根据ID
     */
    public ShopOrderPlan getInfoById(@Param("id") Integer id);

    /**
     * 多条件查询
     */
    public List<ShopOrderPlan> getList(@Param("shopId") Integer shopId,
                                       @Param("startToTime") String startToTime,
                                       @Param("endToTime") String endToTime,
                                      @Param("keyWord") String keyWord,
                                      @Param("pageNo") Integer pageNo,
                                      @Param("pageSize") Integer pageSize);

    /**
     * 多条件查询  返回行数
     */
    public int getCount(@Param("shopId") Integer shopId,
                        @Param("startToTime") String startToTime,
                        @Param("endToTime") String endToTime,
                        @Param("keyWord") String keyWord);
}
