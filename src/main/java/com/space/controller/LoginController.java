package com.space.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @describe: 登录注册模块
 * @author: 彭爽pross
 * @date: 2019/02/16
 */

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/user")
@Api(tags="登录注册")
public class LoginController {

    // 通过@ApiOperation注解来给API增加说明
    @ApiOperation(value = "商家注册接口")
    @PostMapping("/registered")
    public void registered(){

    }

    @ApiOperation(value = "登录接口",notes = "")
    @ApiImplicitParam(name = "name",value = "姓名",required = true,dataType = "String", paramType = "query")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String hello(@RequestParam(name="name",defaultValue = "pross") String name){
        return "hello "+name;
    }



}
