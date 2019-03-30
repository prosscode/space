package com.space.controller;

import com.space.entity.ShopSeat;
import com.space.entity.ShopSignSetInfo;
import com.space.exception.BaseExceptionHandler;
import com.space.exception.PageEntity;
import com.space.service.ShopSeatService;
import com.space.service.ShopSignSetInfoService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @describe: 商家桌位
 * @author: 吕涛pross
 * @date: 2019/03/19
 */

@RestController
@RequestMapping(value = "/desk")
@Api(tags="商家桌位")
public class ShopSeatController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private ShopSeatService shopSeatService;
    /** 保存 新增或者更新 id 0代表新增 大于0代表修改*/
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ShopSeat save(@RequestBody ShopSeat info, @PathVariable(value = "id",required = true)Integer id,@RequestParam(name = "shopId",required = true)Integer shopId) throws Exception{
        if(id!=info.getSeatId())
            throw  new Exception("请求参数错误!");
        if(shopId<=0)
            throw  new Exception("请求参数错误!");
        info.setShopId(shopId);
        if(id<=0){
            info=  shopSeatService.add(info);
        }
        else {
            info=  shopSeatService.update(info);
        }
        return  info;
    }
    /** 删除 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public  int deleteById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  shopSeatService.deleteById(id);
    }
    /** 查询单个 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public  ShopSeat getInfoById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  shopSeatService.getInfoById(id);
    }

    /** 分页查询*/
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageEntity getList(@RequestParam(name="shopId",required = false,defaultValue ="0")Integer shopId,
                              @RequestParam(name="typeId",required = false,defaultValue ="-1")Integer typeId,
                              @RequestParam(name="seatMark",required = false)String seatMark,
                              @RequestParam(name="pageNo",required = false,defaultValue ="0")Integer pageNo,
                              @RequestParam(name="pageSize",required = false,defaultValue ="0")Integer pageSize) throws Exception{
        return shopSeatService.getList(shopId,typeId,seatMark, pageNo, pageSize);
    }

}
