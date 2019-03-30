package com.space.controller;


import com.space.entity.AreaSeatPriceSet;
import com.space.entity.AreaTypeInfo;
import com.space.exception.BaseExceptionHandler;
import com.space.exception.PageEntity;
import com.space.service.AreaSeatPriceSetService;
import com.space.service.AreaTypeInfoService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @describe: 区域价格设置
 * @author: 吕涛pross
 * @date: 2019/03/19
 */

@RestController
@RequestMapping(value = "/area/price")
@Api(tags="区域价格设置")
public class AreaSeatPriceSetController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private AreaSeatPriceSetService areaSeatPriceSetService;
    /** 保存角色 新增或者更新 id 0代表新增 大于0代表修改*/
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public AreaSeatPriceSet save(@RequestBody AreaSeatPriceSet areaSeatPriceSet, @PathVariable(value = "id",required = true)Integer id,@RequestParam(name = "shopId",required = true)Integer shopId) throws Exception{
        if(id!=areaSeatPriceSet.getId())
            throw  new Exception("请求参数错误!");
        //商家ID
        if(shopId==null||shopId<=0)
            throw  new Exception("请求参数错误!");
        areaSeatPriceSet.setShopId(shopId);
        if(id<=0){
            areaSeatPriceSet=  areaSeatPriceSetService.add(areaSeatPriceSet);
        }
        else {
            areaSeatPriceSet=  areaSeatPriceSetService.update(areaSeatPriceSet);
        }
        return  areaSeatPriceSet;
    }
    /** 删除角色 根据角色ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public  int deleteById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  areaSeatPriceSetService.deleteById(id);
    }
    /** 查询单个角色 根据角色ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public  AreaSeatPriceSet getInfoById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  areaSeatPriceSetService.getInfoById(id);
    }

    /** 分页查询角色*/
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageEntity getList(@RequestParam(name="shopId",required = false,defaultValue ="0")Integer shopId,
                              @RequestParam(name="areaTypeId",required = false)Integer areaTypeId,
                              @RequestParam(name="pageNo",required = false,defaultValue ="0")Integer pageNo,
                              @RequestParam(name="pageSize",required = false,defaultValue ="0")Integer pageSize) throws Exception{
        return areaSeatPriceSetService.getList(shopId,areaTypeId, pageNo, pageSize);
    }
}
