package com.space.controller;

import com.space.entity.Commodity;
import com.space.exception.BaseExceptionHandler;
import com.space.exception.PageEntity;
import com.space.service.CommodityCategoryService;
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
 * @describe: 商品分类
 * @author: 吕涛pross
 * @date: 2019/03/19
 */

@RestController
@RequestMapping(value = "/commodity/category")
@Api(tags="商品管理模块")
public class CommodityCategoryController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private CommodityCategoryService commodityCategoryService;

 /*   *//** 查询所有分组*//*
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<com.space.entity.CommodityCategory> list(@RequestParam(name="shopId",required = true,defaultValue ="0")Integer shopId){
        logger.info("CommodityCategoryController|list,shopId:"+shopId);
        return commodityCategoryService.GetDataWithNodes(shopId);
    }*/

    /** 查询所有分组*/
    @RequestMapping(value = "/list/{shopId}",method = RequestMethod.GET)
    public List<com.space.entity.CommodityCategory> list(@PathVariable("shopId")int shopId){
        logger.info("CommodityCategoryController|list,shopId:"+shopId);
        return commodityCategoryService.GetDataWithNodes(shopId);
    }

}
