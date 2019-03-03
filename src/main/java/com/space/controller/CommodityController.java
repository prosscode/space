package com.space.controller;

import com.space.entity.Commodity;
import com.space.entity.Login;
import com.space.exception.BaseExceptionHandler;
import com.space.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public int publishGoods(@RequestBody Commodity commodity) throws Exception {
        //查询名字是否已经存在
        int nameCount = commodityService.checkProductName(commodity.getProductName());
        if (nameCount > 0) {
            throw new Exception("商品名称已存在。");
        }
        // 添加创建时间
        String currentTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        commodity.setCreateTime(currentTime);
        logger.info("CommodityController|publishGoods,commodity: "+commodity);
        return commodityService.addGood(commodity);
    }

    /**删除和上架商品*/
    @ApiOperation(value = "删除和上架商品")
    @RequestMapping(value = "/deleteAndUpGood")
    public int deleteAndUpGoods(@RequestBody Map<String,List<Object>> param) throws Exception {
        List<Object> Ids = param.get("productIds");
        logger.info("CommodityController|deleteAndUpGood,productIds:" + Ids);
        //转化List<Integer>
        List<Integer> productIds=new ArrayList<>();
        String strIds="";
        for(Object id:Ids){
            Integer parseInt = Integer.parseInt(id.toString());
            productIds.add(parseInt);
        }

        List<Object> opNumber = param.get("opNumber");

        int opInt = Integer.parseInt(opNumber.get(0).toString());

        if(opInt == 0){
            // 如果是删除，先检测商品中是否有上架
            int up = commodityService.checkProductUp(productIds);
            if(up > 0){
                throw new Exception("删除的商品中存在上架商品，请先下架商品。");
            }
        }
       return commodityService.deleteAndUpGoods(productIds, opNumber);

    }
}
