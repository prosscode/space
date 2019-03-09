package com.space.controller;

import com.space.entity.User;
import com.space.service.UserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @describe: 用户管理模块
 * @author: 彭爽pross
 * @date: 2019/03/09
 */

@RestController
@RequestMapping(value = "/user")
@Api(tags="用户管理模块")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    /**
     * 添加用户
     * @param user
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public int addUser(@RequestBody User user){
        logger.info("UserController|user,user: "+user.getUserName());

        int addUser = userService.addUser(user);
        return addUser;
    }
}
