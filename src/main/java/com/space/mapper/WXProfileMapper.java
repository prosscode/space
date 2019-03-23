package com.space.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WXProfileMapper {

    public Integer getPartsellLevel(@Param("shopId")Integer shopId);

    public Integer getUserIdentity(@Param("userId")Integer userId);

}
