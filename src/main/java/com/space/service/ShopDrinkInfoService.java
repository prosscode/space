package com.space.service;


import com.space.entity.ShopDrinkInfo;
import com.space.exception.PageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDrinkInfoService {
    public ShopDrinkInfo add(ShopDrinkInfo shopDrinkInfo);

    public int deleteById(Integer id);

    public ShopDrinkInfo update(ShopDrinkInfo shopDrinkInfo);

    public ShopDrinkInfo getInfoById(Integer id);

    public PageEntity getList(Integer shopId, String type,
                              String keyWord, Integer pageNo, Integer pageSize);

    public int getCount(Integer shopId, String type,
                        String keyWord);
}
