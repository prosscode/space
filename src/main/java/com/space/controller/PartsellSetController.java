package com.space.controller;


import com.space.entity.PartsellSetInfo;

import com.space.exception.BaseExceptionHandler;
import com.space.exception.PageEntity;
import com.space.service.CommodityCategoryService;
import com.space.service.PartsellSetInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
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
 * @describe: 分销设置
 * @author: 吕涛pross
 * @date: 2019/03/19
 */

@RestController
    @RequestMapping(value = "/partSell/set")
@Api(tags="分销设置模块")
public class PartsellSetController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private PartsellSetInfoService partsellSetInfoService;

    /** 查询实体 根据ID*/
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public PartsellSetInfo getInfo(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        logger.info("PartsellSetController|info,id:"+id);
        return partsellSetInfoService.getInfoById(id);
    }

    /** 查询实体 根据商户ID*/
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public PartsellSetInfo getInfoByShopId(@RequestParam(name="shopId",required = true)Integer shopId) throws Exception{
        logger.info("PartsellSetController|info,shopId:"+shopId);
        return partsellSetInfoService.getInfoByShopId(shopId);
    }

    /** 添加或者更新 */
    @RequestMapping(value = "/save/{id}",method = RequestMethod.POST)
    public  PartsellSetInfo save(@RequestBody PartsellSetInfo partsellSetInfo,@PathVariable("id")Integer id,@RequestParam(name = "shopId",required = true)Integer shopId) throws Exception {
        if(partsellSetInfo.getId()!=id)
            throw new Exception("参数请求错误");
        //商家ID
        if(shopId==null||shopId<=0)
            throw  new Exception("请求参数错误!");
        partsellSetInfo.setShopId(shopId);

        return partsellSetInfoService.save(partsellSetInfo);
    }


}
