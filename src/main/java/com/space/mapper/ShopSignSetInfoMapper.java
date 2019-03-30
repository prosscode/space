package com.space.mapper;

import com.space.entity.ShopSignSetInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/** 签单人员配置*/
public interface ShopSignSetInfoMapper {
    /**
     * 增加
     */
    public int add(ShopSignSetInfo info);

    /**
     * 删除
     */
    public int deleteById(@Param("id") Integer id);

    /**
     * 修改
     */
    public int update(ShopSignSetInfo info);


    public ShopSignSetInfo getInfoById(@Param("id") Integer id);


    public List<ShopSignSetInfo> getList(@Param("shopId") Integer shopId,
                                         @Param("staffCategoryNo") Integer staffCategoryNo,
                                         @Param("staffId") Integer staffId,
                                         @Param("pageNo") Integer pageNo,
                                         @Param("pageSize") Integer pageSize);

    public  List<ShopSignSetInfo>  summarySignInfo();

    public int getCount(@Param("shopId") Integer shopId,
                        @Param("staffCategoryNo") Integer staffCategoryNo,
                        @Param("staffId") Integer staffId);

}
