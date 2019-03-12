package com.space.service.impl;

import com.space.controller.ShopController;
import com.space.entity.ShopInfo;
import com.space.exception.PageEntity;
import com.space.mapper.ShopMapper;
import com.space.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describe: 商家管理
 * @author: 彭爽pross
 * @date: 2019/03/10
 */
@Service
public class ShopServiceImpl implements ShopService {

    private static Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);

    @Autowired
    private ShopMapper shopMapper;


    /**查询商家信息*/
    @Override
    public List<ShopInfo> getShopInfo(Integer shopId) {
        List<ShopInfo> shopInfo = shopMapper.getShopInfo(shopId);
        return shopInfo;
    }
}
