package com.space.controller;

import com.space.exception.PageEntity;
import com.space.service.WXHomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe: 小程序主页接口
 * @author: 彭爽pross
 * @date: 2019/03/17
 */
@RestController
@RequestMapping(value = "/wx")
public class WXHomeController {

    private static Logger logger = LoggerFactory.getLogger(WXHomeController.class);

    @Autowired
    private WXHomeService wxHomeService;

    /**登录*/
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public void userLogin(){

    }

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
                        @RequestParam(name="barName",defaultValue = "")String barName){
        logger.info("WXHomeController|getShop,type:"+type+",filter:"+filter);
        PageEntity shop = wxHomeService.getShop(filter, provice, city, district, type, barName);
        return shop;
    }

}
