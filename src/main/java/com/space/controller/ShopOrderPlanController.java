package com.space.controller;


import com.space.entity.ShopOrderPlan;
import com.space.exception.BaseExceptionHandler;
import com.space.exception.PageEntity;
import com.space.service.ShopOrderPlanMapperService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @describe: 订单预定
 * @author: 吕涛pross
 * @date: 2019/03/19
 */

@RestController
@RequestMapping(value = "/orderPlan")
@Api(tags="角色管理")
public class ShopOrderPlanController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);
    @Autowired
    private ShopOrderPlanMapperService shopPlanService;

    /** 保存角色 新增或者更新 id 0代表新增 大于0代表修改*/
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ShopOrderPlan save(@RequestBody ShopOrderPlan shopOrderPlan, @PathVariable(value = "id",required = true)Integer id,@RequestParam(name = "shopId",required = true)Integer shopId) throws Exception{
        if(id!=shopOrderPlan.getId())
            throw  new Exception("请求参数错误!");
        if(shopId<=0)
            throw  new Exception("请求参数错误!");
        shopOrderPlan.setShopId(shopId);
        if(id<=0){
            shopOrderPlan=  shopPlanService.add(shopOrderPlan);
        }
        else {
            shopOrderPlan=  shopPlanService.update(shopOrderPlan);
        }
        return  shopOrderPlan;
    }

    /** 删除角色 根据角色ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public  int deleteById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  shopPlanService.deleteById(id);
    }
    /** 查询单个角色 根据角色ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public  ShopOrderPlan getInfoById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  shopPlanService.getInfoById(id);
    }

    /** 分页查询角色*/
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageEntity getList(@RequestParam(name="shopId",required = false,defaultValue ="0")Integer shopId,
                              @RequestParam(name="startToTime",required = false)String startToTime,
                              @RequestParam(name="endToTime",required = false)String endToTime,
                              @RequestParam(name="kewWord",required = false)String kewWord,
                              @RequestParam(name="pageNo",required = false,defaultValue ="0")Integer pageNo,
                              @RequestParam(name="pageSize",required = false,defaultValue ="0")Integer pageSize) throws Exception{
        return shopPlanService.getList(shopId,startToTime,endToTime,kewWord, pageNo, pageSize);
    }

}
