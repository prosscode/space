package com.space.mapper;

import com.space.entity.ShopDrinkInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDrinkInfoMapper {

    public  int add(ShopDrinkInfo shopDrinkInfo);
    public  int deleteById(@Param("id")Integer id);
    public  int update(ShopDrinkInfo shopDrinkInfo);
    public  ShopDrinkInfo getInfoById(@Param("id")Integer id);

    public List<ShopDrinkInfo> getList(@Param("shopId")Integer shopId, @Param("roleName")String type,
                                  @Param("keyWord")String keyWord,@Param("pageNo")Integer pageNo, @Param("pageSize")Integer pageSize);

    public int getCount(@Param("shopId")Integer shopId, @Param("roleName")String type, @Param("keyWord")String keyWord);
}
