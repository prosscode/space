package com.space.controller;


import com.space.entity.AreaSeatPriceSet;
import com.space.entity.ShopDrinkInfo;
import com.space.exception.BaseExceptionHandler;
import com.space.exception.PageEntity;
import com.space.service.AreaSeatPriceSetService;
import com.space.service.ShopDrinkInfoService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @describe: 存酒/取酒  存酒type="enter" 取酒type="out"
 * @author: 吕涛pross
 * @date: 2019/03/19
 */

@RestController
@RequestMapping(value = "/shopDrink")
@Api(tags="存酒/取酒")
public class ShopDrinkController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private ShopDrinkInfoService  shopDrinkInfoService;
    /** 保存 新增或者更新 id 0代表新增 大于0代表修改*/
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ShopDrinkInfo save(@RequestBody ShopDrinkInfo  shopDrinkInfo, @PathVariable(value = "id",required = true)Integer id,@RequestParam(name = "shopId",required = true)Integer shopId) throws Exception{
        //商家ID
        if(shopId==null||shopId<=0)
            throw  new Exception("请求参数错误!");
        if(id!=shopDrinkInfo.getId())
            throw  new Exception("请求参数错误!");
        shopDrinkInfo.setShopId(shopId);
        if(id<=0){
            shopDrinkInfo=  shopDrinkInfoService.add(shopDrinkInfo);
        }
        else {
            shopDrinkInfo=  shopDrinkInfoService.update(shopDrinkInfo);
        }
        return  shopDrinkInfo;
    }
    /** 删除 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public  int deleteById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  shopDrinkInfoService.deleteById(id);
    }
    /** 查询单个 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public  ShopDrinkInfo getInfoById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  shopDrinkInfoService.getInfoById(id);
    }

    /** 分页查询*/
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageEntity getList(@RequestParam(name="shopId",required = false,defaultValue ="0")Integer shopId,
                              @RequestParam(name="type",required = true)String type,
                              @RequestParam(name="keyWord",required = false)String keyWord,
                              @RequestParam(name="pageNo",required = false,defaultValue ="0")Integer pageNo,
                              @RequestParam(name="pageSize",required = false,defaultValue ="0")Integer pageSize) throws Exception{

        return shopDrinkInfoService.getList(shopId,type,keyWord, pageNo, pageSize);
    }
}
