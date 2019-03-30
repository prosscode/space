package com.space.mapper;

import com.space.entity.StoredDrink;
import com.space.entity.UserPartSell;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WXProfileMapper {

    public Integer getPartsellLevel(@Param("shopId")Integer shopId);

    public List<UserPartSell> getUserIdentity(@Param("userId")Integer userId);

    public List<StoredDrink> getUserStored(@Param("phone")String phone, @Param("type")String type);

}
