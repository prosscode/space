package com.space.service;

import com.space.entity.AreaTypeInfo;
import com.space.exception.PageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 区域分组
 */
public interface AreaTypeInfoService {


    /**
     * 增加
     */
    public AreaTypeInfo add(AreaTypeInfo areaTypeInfo);

    /**
     * 删除
     */
    public int deleteById(Integer id);

    /**
     * 修改
     */
    public AreaTypeInfo update(AreaTypeInfo areaTypeInfo);

    /**
     * 查询详情 根据ID
     */
    public AreaTypeInfo getInfoById(Integer id);

    /**
     * 多条件查询
     */
    public PageEntity getList(Integer shopId,
                              String typeName,
                              Integer pageNo,
                              Integer pageSize);


}
