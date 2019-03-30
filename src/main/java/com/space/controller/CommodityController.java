package com.space.controller;

import com.space.entity.Commodity;
import com.space.exception.BaseExceptionHandler;
import com.space.exception.PageEntity;
import com.space.service.CommodityService;
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
 * @describe: 商品管理
 * @author: 彭爽pross
 * @date: 2019/02/21
 */

@RestController
@RequestMapping(value = "/commodity")
@Api(tags = "商品管理模块")
public class CommodityController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private CommodityService commodityService;

    /**
     * 新建商品分组
     */
    @RequestMapping(value = "/addGoodType", method = RequestMethod.GET)
    public int addGoodType(@RequestParam(name = "shopId", required = true) Integer shopId,
                           @RequestParam(name = "typeName", required = true) String typeName,
                           @RequestParam(name = "typeSubName", defaultValue = "") String typeSubName,
                           @RequestParam(name = "seatNumber", defaultValue = "-1") Integer seatNumber,
                           @RequestParam(name = "role", defaultValue = "0") Integer role) {
        logger.info("CommodityController|addGoodType,typeName:" + typeName + ",shopId：" + shopId + ",role:" + role);
        int goodType = commodityService.addGoodType(shopId, typeName, typeSubName, seatNumber, role);
        return goodType;
    }

    /**
     * 查询所有分组
     */
    @RequestMapping(value = "/getGoodType", method = RequestMethod.GET)
    public PageEntity getGoodType(@RequestParam(name = "shopId", required = true) Integer shopId) {
        logger.info("CommodityController|getGoodType,shopId:" + shopId);
        return commodityService.getGoodType(shopId);
    }

    /**
     * 编辑分组
     */
    @RequestMapping(value = "/updateGoodType", method = RequestMethod.GET)
    public int updateGoodType(@RequestParam(name = "typeId", required = true) Integer typeId,
                              @RequestParam(name = "shopId", required = true) Integer shopId,
                              @RequestParam(name = "typeName", required = true) String typeName) {
        logger.info("CommodityController|updateGoodType,shopId:" + shopId + "，typeName" + typeName);
        return commodityService.updateGoodType(typeId, shopId, typeName);
    }

    /**
     * 删除商品分组
     */
    @RequestMapping(value = "/deleteGoodType", method = RequestMethod.GET)
    public int deleteGoodType(@RequestParam(name = "shopId", required = true) Integer shopId,
                              @RequestParam(name = "typeName", required = true) String typeName) {
        logger.info("CommodityController|deleteGoodType,shopId:" + shopId + "，typeName" + typeName);
        return commodityService.deleteGoodType(shopId, typeName);
    }

    /**
     * 展示商品
     */
    @ApiOperation(value = "展示商品")
    @RequestMapping(value = "/getGoods", method = RequestMethod.GET)
    public PageEntity getGoods(@RequestParam(name = "productName", defaultValue = "",required = false) String productName,
                               @RequestParam(name = "pageNo", defaultValue = "1",required = false) Integer pageNo,
                               @RequestParam(name = "pageSize", defaultValue = "20",required = false) Integer pageSize,
                               @RequestParam(name = "productCategoryNo", defaultValue = "0",required = false) Integer productCategoryNo,
                               @RequestParam(name = "shopId", defaultValue = "0",required = false) Integer shopId,
                               @RequestParam(name = "productStatus", defaultValue = "0",required = false) Integer productStatus,
                               @RequestParam(name = "keyWord",required = false) String keyWord,
                               @RequestParam(name = "optNum", defaultValue = "0",required = false) Integer optNum) {

        logger.info("CommodityController|getGoods,productName: " + productName);
        pageNo = (pageNo - 1) * pageSize;
        PageEntity pageEntity = commodityService.getGoods(productName, pageNo, pageSize, productCategoryNo, shopId, productStatus, keyWord, optNum);
        return pageEntity;
    }


    /**
     * 发布商品
     */
    @ApiOperation(value = "发布商品")
    @RequestMapping(value = "/publishGoods", method = RequestMethod.POST)
    public int publishGoods(@RequestBody Commodity commodity, @RequestParam(name = "shopId", required = true) Integer shopId) throws Exception {
        if (shopId == null || shopId <= 0) {
            commodity.setShopId(shopId);
        }
        commodity.setShopId(shopId);
        //查询名字是否已经存在
        int nameCount = commodityService.checkProductName(commodity.getProductName());
        if (nameCount > 0) {
            throw new Exception("商品名称已存在。");
        }
        commodity.setCreateTime(new Date());
        logger.info("CommodityController|publishGoods,commodity: " + commodity);
        return commodityService.addGood(commodity);

    }


    /**
     * 删除和上架商品
     */
    @ApiOperation(value = "删除和上架商品")
    @RequestMapping(value = "/deleteAndUpGood/{optNumber}", method = RequestMethod.POST)
    public int deleteAndUpGoods(@RequestBody Map<String, List<Object>> param,
                                @PathVariable(value = "optNumber", required = true) int optNumber) throws Exception {
        List<Object> Ids = param.get("productIds");
        //转化List<Integer>
        List<Integer> productIds = new ArrayList<>();
        String strIds = "";
        for (Object id : Ids) {
            Integer parseInt = Integer.parseInt(id.toString());
            productIds.add(parseInt);
        }
        logger.info("CommodityController|deleteAndUpGood,productIds:" + productIds.toString());
        //List<Object> opNumber = param.get("opNumber");

        int opInt = optNumber; //Integer.parseInt(opNumber.get(0).toString());

        if (opInt == 0) {
            // 如果是删除，先检测商品中是否有上架
            int up = commodityService.checkProductUp(productIds);
            if (up > 0) {
                throw new Exception("删除的商品中存在上架商品，请先下架商品。");
            }
        }
        List<Object> setValues = param.get("setValues");
        return commodityService.deleteAndUpGoods(productIds, opInt, setValues);
    }

    /**
     * 更新商品
     */
    @RequestMapping(value = "/updateGood", method = RequestMethod.POST)
    public int updateGood(@RequestBody Commodity commodity, @RequestParam(name = "shopId", required = true) Integer shopId,
                          @RequestParam(name = "optNum", defaultValue ="0") Integer optNum) {
        //如果是商户修改，强制更改为当前商户ID
        if (shopId > 0) {
            commodity.setShopId(shopId);
        }
        logger.info("CommodityController|updateGood,commodity: " + commodity);
        return commodityService.updateGood(commodity,optNum);
    }

    /**
     * 展示商品详情
     */
    @RequestMapping(value = "/getGood", method = RequestMethod.GET)
    public Commodity getGood(
            @RequestParam(name = "productId", defaultValue = "0",required = true) Integer productId,
            @RequestParam(name = "optNum", defaultValue = "0",required = true) Integer optNum
    ) {

        logger.info("CommodityController|getGoods,productId: " + productId);
        Commodity entity = commodityService.GetGoodById(productId,optNum);
        return entity;
    }



    /**
     * 增加桌位编号/编辑桌位
     */
    @RequestMapping(value = "/addSeatMark", method = RequestMethod.GET)
    public int addSeatMark(@RequestParam(name = "shopId", required = true) Integer shopId,
                           @RequestParam(name = "seatType", required = true) String seatType,
                           @RequestParam(name = "seatPrefix", required = true) String seatPrefix,
                           @RequestParam(name = "seatNum", required = true) Integer seatNum,
                           @RequestParam(name = "seatCount", required = true) Integer seatCount) {
        logger.info("CommodityController|addSeatMark,seatType:" + seatType + ",seatPrefix" + seatPrefix + ",shopId:" + shopId);
        return commodityService.addSeatMark(shopId, seatType, seatPrefix, seatNum, seatCount);

    }

    /**
     * 查询桌位
     */
    @RequestMapping(value = "/getSeat", method = RequestMethod.GET)
    public PageEntity getSeat(@RequestParam(name = "shopId", required = true) Integer shopId) {
        logger.info("CommodityController|getSeat,shopId:" + shopId);
        PageEntity seat = commodityService.getSeat(shopId);
        return seat;
    }


    /**
     * 删除桌位
     */
    @RequestMapping(value = "/deleteSeat", method = RequestMethod.GET)
    public int deleteSeat(@RequestParam(name = "seatId", required = true) Integer seatId,
                          @RequestParam(name = "shopId", required = true) Integer shopId) {
        logger.info("CommodityController|deleteSeat,seatId:" + seatId + ",shopId:" + shopId);
        return commodityService.deleteSeat(seatId, shopId);
    }

}
