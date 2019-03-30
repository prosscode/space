package com.space.controller;

import com.space.entity.AreaSeatPriceSet;
import com.space.entity.Commodity;
import com.space.entity.CommodityCategory;
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
@Api(tags="商品分类")
public class CommodityCategoryController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private CommodityCategoryService commodityCategoryService;

    /** 保存 新增或者更新 id 0代表新增 大于0代表修改*/
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public CommodityCategory save(@RequestBody CommodityCategory commodityCategory, @PathVariable(value = "id",required = true)Integer id, @RequestParam(name = "shopId",required = true)Integer shopId) throws Exception{
        if(id!=commodityCategory.getId())
            throw  new Exception("请求参数错误!");

        //商家ID
        if(shopId==null||shopId<=0)
            throw  new Exception("请求参数错误!");
        commodityCategory.setShopId(shopId);
        if(id<=0){
            commodityCategory=  commodityCategoryService.add(commodityCategory);
        }
        else {
            commodityCategory=  commodityCategoryService.update(commodityCategory);
        }
        return  commodityCategory;
    }
    /** 删除 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public  int deleteById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  commodityCategoryService.deleteById(id);
    }
    /** 查询单个 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public  CommodityCategory getInfoById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  commodityCategoryService.getInfoById(id);
    }
    /** 查询所有分组*/
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<com.space.entity.CommodityCategory> list(@RequestParam(name="shopId",required = true)Integer shopId
        ,@RequestParam(name="spread",required = false,defaultValue ="false")boolean spread){
        logger.info("CommodityCategoryController|list,shopId:"+shopId);
        return commodityCategoryService.GetDataWithNodes(shopId,spread);
    }


}
