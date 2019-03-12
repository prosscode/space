package com.space.service;


import com.space.entity.ShopInfo;

import java.util.List;

public interface ShopService {

    public List<ShopInfo> getShopInfo(Integer shopId);
}
