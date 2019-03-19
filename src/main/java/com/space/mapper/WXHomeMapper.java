package com.space.mapper;

import com.space.entity.ShopInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WXHomeMapper {

    public List<ShopInfo> getShop(@Param("filter") Integer filter,
                                  @Param("provice") String provice,
                                  @Param("city") String city,
                                  @Param("district") String district,
                                  @Param("type") String type,
                                  @Param("barName") String barName);
}
