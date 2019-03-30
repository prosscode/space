package com.space.mapper;


import com.space.entity.AreaTypeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/** 区域分组*/
public interface AreaTypeInfoMapper {
    /**
     * 增加
     */
    public int add(AreaTypeInfo areaTypeInfo);

    /**
     * 删除
     */
    public int deleteById(@Param("id") Integer id);

    /**
     * 修改
     */
    public int update(AreaTypeInfo areaTypeInfo);

    /**
     * 查询详情 根据ID
     */
    public AreaTypeInfo getInfoById(@Param("id") Integer id);

    /**
     * 多条件查询
     */
    public List<AreaTypeInfo> getList(@Param("shopId") Integer shopId,
                                      @Param("typeName")String typeName,
                                      @Param("pageNo") Integer pageNo,
                                      @Param("pageSize") Integer pageSize);

    /**
     * 多条件查询  返回行数
     */
    public int getCount(@Param("shopId") Integer shopId,
                        @Param("typeName") String typeName);
}
