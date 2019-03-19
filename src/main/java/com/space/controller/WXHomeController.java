package com.space.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /**登录*/
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public void userLogin(){

    }

    /**主页搜索查询*/
    @RequestMapping(value = "/getShop",method = RequestMethod.GET)
    public void getShop(@RequestParam(name="consumption",defaultValue = "0")Integer consumption,
                        @RequestParam(name="score",defaultValue = "0")Integer score,
                        @RequestParam(name="location",defaultValue = "")String location,
                        @RequestParam(name="type",defaultValue = "")String type){

        logger.info("WXHomeController|getShop,type:"+type+",location:"+location);
        // 人均消费，评分，地点，类型



    }

}
