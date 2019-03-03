package com.space.controller;

import com.space.entity.Commodity;
import com.space.entity.Login;
import com.space.exception.BaseExceptionHandler;
import com.space.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @describe: 商品管理
 * @author: 彭爽pross
 * @date: 2019/02/21
 */

@RestController
@RequestMapping(value = "/commodity")
@Api(tags="商品管理模块")
public class CommodityController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private CommodityService commodityService;

    /**发布商品*/
    @ApiOperation(value = "发布商品")
    @RequestMapping(value = "/publishGoods",method = RequestMethod.POST)
    public void publishGoods(@RequestBody Commodity commodity) throws Exception {
        logger.info("CommodityController|publishGoods,commodity: "+commodity);
        //查询名字是否已经存在
        int nameCount = commodityService.checkProductName(commodity.getProductName());
        if (nameCount > 0) {
            throw new Exception("商品名称已存在");
        }
        // 添加创建时间
        String currentTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        commodity.setCreateTime(currentTime);

    }
    /**删除和上架商品*/
    public void deleteAndUpGoods(){

    }
}
