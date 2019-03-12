package com.space.controller;

import com.space.entity.ShopInfo;
import com.space.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @describe: 店铺设置
 * @author: 彭爽pross
 * @date: 2019/03/09
 */
@RestController
@RequestMapping(value = "/shop")
public class ShopController {
    private static Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private ShopService shopService;

    /**查询商品信息*/
    @RequestMapping(value = "/getShopInfo",method = RequestMethod.GET)
    public List<ShopInfo> getShopInfo(@RequestParam(name="shopId",required = true)Integer shopId){
        logger.info("ShopController|getShopInfo,shopId:"+shopId);
        return shopService.getShopInfo(shopId);

    }
}
