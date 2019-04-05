package com.space.controller;

import com.space.entity.Order;
import com.space.entity.OrderProduct;
import com.space.exception.PageEntity;
import com.space.service.WXHomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @describe: 小程序主页接口
 * @author: 彭爽pross
 * @date: 2019/03/17
 */
@RestController
@RequestMapping(value = "/wx/home")
public class WXHomeController {

    private static Logger logger = LoggerFactory.getLogger(WXHomeController.class);

    @Autowired
    private WXHomeService wxHomeService;

    /**
     * 查询商家基本信息
     * @param filter 筛选，默认排序0，评分最高1，人均消费2，离我最近3
     * @param provice，省
     * @param city，市
     * @param district，区
     * @param type，商家类型
     * @param barName，名字
     */
    @RequestMapping(value = "/getShop",method = RequestMethod.GET)
    public PageEntity getShop(@RequestParam(name="filter",defaultValue = "0")Integer filter,
                              @RequestParam(name="provice",defaultValue = "")String provice,
                              @RequestParam(name="city",defaultValue = "")String city,
                              @RequestParam(name="district",defaultValue = "")String district,
                              @RequestParam(name="type",defaultValue = "")String type,
                              @RequestParam(name="barName",defaultValue = "")String barName,
                              @RequestParam(name="longUser",defaultValue = "0") Double longUser,
                              @RequestParam(name="latiUser",defaultValue = "0") Double latUser,
                              @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                              @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize){
        logger.info("WXHomeController|getShop,type:"+type+",filter:"+filter+",longUser:"+longUser+",latUser:"+latUser);
        pageNo = (pageNo - 1) * pageSize;
        PageEntity shop = wxHomeService.getShop(filter, provice, city, district, type, barName,longUser,latUser,pageNo,pageSize);
        return shop;
    }

    /**查询商家相册*/
    @RequestMapping(value = "/getPhotos",method = RequestMethod.GET)
    public PageEntity getPhotos(@RequestParam(name = "shopId",required = true)Integer shopId){
        logger.info("WXHomeController|getPhotos,shopId:"+shopId);
        return wxHomeService.getPhotos(shopId);
    }

    /**
     * 通过shopId，拿到商品信息
     * @param shopId
     */
    @RequestMapping(value = "/getGoodInfo")
    public void getGoodInfo(@RequestParam(name="shopId",required = true)Integer shopId,
                            @RequestParam(name="productName",defaultValue = "")String productName){
        logger.info("WXHomeController|getGoodInfo,shopId:"+shopId+",productName:"+productName);
        wxHomeService.getGoodInfo(shopId,productName);
    }

    /**拿到座位信息*/
    @RequestMapping(value = "/getSeatInfo")
    public PageEntity getSeatInfo(@RequestParam(name="shopId")Integer shopId){
        logger.info("WXHomeController|getSeatInfo,shopId:"+shopId);
        PageEntity seatInfo = wxHomeService.getSeatInfo(shopId);
        return seatInfo;
    }

    /**拿到优惠券信息*/
    @RequestMapping(value = "/getCouponInfo")
    public PageEntity getCouponInfo(@RequestParam(name="shopId")Integer shopId){
        logger.info("WXHomeController|getCouponInfo,shopId:"+shopId);
        PageEntity info = wxHomeService.getCouponInfo(shopId);
        return info;
    }

    /**拿到服务员信息*/
    @RequestMapping(value = "/getWaiterInfo")
    public PageEntity getWaiterInfo(@RequestParam(name="shopMark")String shopMark){
        logger.info("WXHomeController|getWaiterInfo,shopMark:"+shopMark);
        return wxHomeService.getWaiterInfo(shopMark);
    }

    /** 添加订单*/
    @RequestMapping(value = "/addOrder")
    public Integer addOrder(@RequestBody Order order){
        logger.info("WXHomeController|addOrder,order belong shopId:"+order.getShopId());
        return wxHomeService.addOrder(order);
    }

    /** 添加订单的商品详情*/
    @RequestMapping(value = "/addOrderProduct")
    public int addOrderProduct(@RequestBody List<OrderProduct> orderProduct){
        logger.info("WXHomeController|addOrderProduct，size："+orderProduct.size());
        return wxHomeService.addOrderProduct(orderProduct);
    }

}

