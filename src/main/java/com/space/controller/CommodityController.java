package com.space.controller;

import com.space.exception.BaseExceptionHandler;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/02/21
 */

@RestController
@RequestMapping(value = "/commodity")
@Api(tags="商品管理模块")
public class CommodityController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);


    public void publishGoods(){

    }
}
