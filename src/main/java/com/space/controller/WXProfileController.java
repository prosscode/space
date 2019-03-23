package com.space.controller;

import com.space.service.WXProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe: 小程序，用户个人信息
 * @author: 彭爽pross
 * @date: 2019/03/23
 */
@RestController
@RequestMapping(value = "/wx/profile")
public class WXProfileController {

    private static Logger logger = LoggerFactory.getLogger(WXProfileController.class);

    @Autowired
    private WXProfileService wxProfileService;

    /**查询用户是不是分销员*/
    @RequestMapping(value = "/getUserIdentity")
    public Integer getUserIdentity(@RequestParam(name = "userId") Integer userId){
        logger.info("WXProfileController|getUserIdentity,userId:"+userId);
        return wxProfileService.getUserIdentity(userId);
    }

    /** 查询商家的分销等级*/
    @RequestMapping(value = "/getPartsellLevel")
    public Integer getPartsellLevel(@RequestParam(name = "shopId") Integer shopId){
        logger.info("WXProfileController|getPartsellLevel,shopId:"+shopId);
        return wxProfileService.getPartsellLevel(shopId);
    }

}
