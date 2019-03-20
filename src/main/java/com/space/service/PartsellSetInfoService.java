package com.space.service;

import com.space.entity.PartsellSetInfo;

/**分销设置*/
public interface PartsellSetInfoService {
    public PartsellSetInfo   save(PartsellSetInfo partsellSetInfo);
    public  PartsellSetInfo getInfoById(Integer id);

    public  PartsellSetInfo  getInfoByShopId(Integer shopId);
}
