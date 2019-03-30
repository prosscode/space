package com.space.mapper;

import com.space.entity.AreaSeatPriceSet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/** 区域价格设置*/
public interface AreaSeatPriceSetMapper {

    /**
     * 增加
     */
    public int add(AreaSeatPriceSet info);

    /**
     * 删除
     */
    public int deleteById(@Param("id") Integer id);

    /**
     * 修改
     */
    public int update(AreaSeatPriceSet info);

    /**
     * 查询详情 根据ID
     */
    public AreaSeatPriceSet getInfoById(@Param("id") Integer id);

    /**
     * 多条件查询
     */
    public List<AreaSeatPriceSet> getList(@Param("shopId") Integer shopId,
                                      @Param("areaTypeId") Integer areaTypeId,
                                      @Param("pageNo") Integer pageNo,
                                      @Param("pageSize") Integer pageSize);

    /**
     * 多条件查询  返回行数
     */
    public int getCount(@Param("shopId") Integer shopId,
                        @Param("areaTypeId") Integer areaTypeId);
}
