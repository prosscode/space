package com.space.controller;

import com.space.entity.Login;
import com.space.service.LoginService;
import com.space.utils.InfoEncryption;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @describe: 登录注册模块
 * @author: 彭爽pross
 * @date: 2019/02/16
 */

@RestController
@RequestMapping(value = "/user")
@Api(tags="登录注册校验")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    /**
     * 商家注册
     * @param login
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "注册接口")
    @RequestMapping(value = "/registered",method = RequestMethod.POST)
    public String registered(@RequestBody Login login) throws Exception {
        logger.info("LoginController|registered,param: "+login);
        loginService.registered(login);
        return "hello "+login.getUserName();
    }

    /**
     * 检查注册的登录用户名是否存在
     * @param userName
     * @return
     */
    @ApiOperation(value = "检查用户名是否存在")
    @RequestMapping(value = "/checkUserName",method = RequestMethod.GET)
    @ApiImplicitParam(name = "userName",dataType="String",required = true,paramType = "query")
    public void checkUserName(@RequestParam(name = "userName",required = true)String userName) throws Exception {
        logger.info("LoginController|checkUserName,userName = "+userName);
        Integer checkUserName = loginService.checkUserName(userName);
        if(checkUserName > 0 ){
            throw new Exception("用户名已存在");
        }
    }

    /**
     * 检查注册的商家名称是否存在
     * @param barName
     * @return
     */
    @ApiOperation(value = "检查商家名称是否存在")
    @RequestMapping(value = "/checkBarName",method = RequestMethod.GET)
    @ApiImplicitParam(name = "barName",dataType="String",required = true,paramType = "query")
    public void checkBarName(@RequestParam(name = "barName",required = true)String barName) throws Exception {
        logger.info("LoginController|checkUserName,barName = "+barName);
        Integer checkBarName = loginService.checkBarName(barName);
        if(checkBarName > 0 ){
            throw new Exception("名称已存在");
        }
    }

    /**
     * 登录接口
     * @param login
     * @throws Exception
     */
    @ApiOperation(value = "登录接口")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(@RequestBody Login login) throws Exception {
        String userName = login.getUserName();
        String password = login.getPassword();

        String passwordBASE64 = InfoEncryption.encryptBASE64(password);
    }
}
