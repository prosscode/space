package com.space.controller;

import com.space.entity.User;
import com.space.exception.PageEntity;
import com.space.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @describe: 用户管理模块
 * @author: 彭爽pross
 * @date: 2019/03/09
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /** 添加用户*/
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public int addUser(@RequestBody User user) {
        logger.info("UserController|user,user: " + user.getUserName());

        int addUser = userService.addUser(user);
        return addUser;
    }

    /**
     * 是否开启分销
     * @param openFlag
     * @return
     */
    @RequestMapping(value = "/openDistribution", method = RequestMethod.GET)
    public int openDistribution(@RequestParam(name = "shopMark", required = true) String shopMark,
                                @RequestParam(name = "openFlag", required = true) Integer openFlag) {
        logger.info("UserController|openDistribution,shopMark:" + shopMark + ",openFlag:" + openFlag);
        return userService.openDistribution(shopMark, openFlag);
    }


    /** 查询用户*/
    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    public PageEntity getUsers(@RequestParam(name = "shopMark", required = true) String shopMark,
                               @RequestParam(name = "userName", required = false) String userName,
                               @RequestParam(name = "userPhone", required = false) String userPhone,
                               @RequestParam(name = "userWechat", required = false) String userWechat,
                               @RequestParam(name = "userRole", required = false) Integer userRole,
                               @RequestParam(name="pageNo",defaultValue="1")Integer pageNo ,
                               @RequestParam(name="pageSize",defaultValue="10") Integer pageSize){
        logger.info("UserController|getUsers，shopMark："+shopMark+",userName："+userName+"，userPhone："+userPhone);
        pageNo = (pageNo -1) * pageSize;

        PageEntity entity = userService.getUsers(shopMark, userName, userPhone, userWechat, userRole, pageNo, pageSize);
        return entity;
    }
}
