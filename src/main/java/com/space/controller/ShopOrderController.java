package com.space.controller;

import com.space.entity.Order;
import com.space.entity.RoleInfo;
import com.space.exception.PageEntity;
import com.space.service.RoleInfoService;
import com.space.service.ShopOrderMapperService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @describe: 订单
 * @author: 吕涛pross
 * @date: 2019/03/19
 */

@RestController
@RequestMapping(value = "/shopOrder")
@Api(tags="订单")
public class ShopOrderController {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private ShopOrderMapperService orderMapperService;
    /** 保存 新增或者更新 id 0代表新增 大于0代表修改*/
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Order save(@RequestBody Order info, @PathVariable(value = "id",required = true)Integer id,@RequestParam(name = "shopId",required = true)Integer shopId) throws Exception{
        if(id!=info.getOrderId())
            throw  new Exception("请求参数错误!");
        if(shopId<=0)
            throw  new Exception("请求参数错误!");
        info.setShopId(shopId);
        if(id<=0){
            info=  orderMapperService.add(info);
        }
        else {
            info=  orderMapperService.update(info);
        }
        return  info;
    }
    /** 修改订单状态*/
    @RequestMapping(value = "status/{orderNo}/{status}",method = RequestMethod.POST)
    public Order updateStatus( @PathVariable(value = "orderNo",required = true)String orderNo,@PathVariable(value = "status",required = true)Integer status) throws Exception{
        Order  info=   orderMapperService.getInfoByNo(orderNo);
        if(info==null)
            throw  new Exception("订单不存在!");
        return   orderMapperService.update(info);
    }

    /** 删除 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public  int deleteById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  orderMapperService.deleteById(id);
    }
    /** 查询单个 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public  Order getInfoById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  orderMapperService.getInfoById(id);
    }

    /** 查询单个 根据订单编号*/
    @RequestMapping(value = "orderNo/{orderNo}",method = RequestMethod.GET)
    public  Order getInfoByNo(@PathVariable(value = "orderNo",required = true)String orderNo) throws Exception{
        return  orderMapperService.getInfoByNo(orderNo);
    }

    /** 分页查询*/
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageEntity getList(@RequestParam(name="shopId",required = false,defaultValue ="0")Integer shopId,
                              @RequestParam(name="orderNo",required = false)String orderNo,
                              @RequestParam(name="orderName",required = false)String orderName,
                              @RequestParam(name="orderType",required = false,defaultValue ="0")Integer orderType,
                              @RequestParam(name="orderStatus",required = false,defaultValue = "0")Integer orderStatus,
                              @RequestParam(name="dateFrom",required = false)String dateFrom,
                              @RequestParam(name="dateTo",required = false)String dateTo,
                              @RequestParam(name="pageNo",required = false,defaultValue ="0")Integer pageNo,
                              @RequestParam(name="pageSize",required = false,defaultValue ="0")Integer pageSize){
        PageEntity entity = orderMapperService.getList(shopId,orderNo,orderName,orderType,orderStatus,dateFrom,dateTo, pageNo, pageSize);
        return entity;
    }

    /** 查询单个 根据ID*/
    @RequestMapping(value = "deskNo/{deskNo}",method = RequestMethod.GET)
    public  Order getLastInfoByDeskId(@PathVariable(value = "deskNo",required = true)String deskNo) throws Exception{
        return  orderMapperService.getLastInfoByDeskNo(deskNo);
    }

}
