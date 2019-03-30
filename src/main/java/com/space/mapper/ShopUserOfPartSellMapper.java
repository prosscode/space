package com.space.mapper;

import com.space.entity.RoleInfo;
import com.space.entity.ShopUserOfPartSell;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/** 分销用户*/
public interface ShopUserOfPartSellMapper {

    public int add(ShopUserOfPartSell info);

    public int deleteById(Integer id);

    public int update(ShopUserOfPartSell info);

    public ShopUserOfPartSell getInfoById(Integer id);

    public List<ShopUserOfPartSell> getList(@Param("shopId") Integer shopId,
                                            @Param("userPhone") String userPhone,
                                            @Param("userName") String userName,
                                            @Param("joinStartDate") String joinStartDate,
                                            @Param("joinEndDate") String joinEndDate,
                                            @Param("pageNo") Integer pageNo,
                                            @Param("pageSize") Integer pageSize);

    public int getCount(@Param("shopId") Integer shopId,
                             @Param("userPhone") String userPhone,
                             @Param("userName") String userName,
                             @Param("joinStartDate") String joinStartDate,
                             @Param("joinEndDate") String joinEndDate);
}
