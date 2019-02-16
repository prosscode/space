package com.space.controller;

import com.space.exception.ActionResult;
import com.space.exception.BaseExceptionHandler;
import com.space.exception.PageEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
public class LoginController extends BaseExceptionHandler {

    // 通过@ApiOperation注解来给API增加说明
    @ApiOperation(value = "商家注册接口")
    @GetMapping("/registered")
    public void registered(){

    }

    @ApiOperation(value = "登录接口")
    @ApiImplicitParam(name = "name",value = "姓名",required = true,dataType = "String", paramType = "query")
    @GetMapping("/login")
    public ActionResult login(@RequestParam(name="name",defaultValue = "pross") String name) throws Exception{
        String str = "123asa";
        String[] split = str.split(",");
        String demo =split[2];
        ActionResult result = new ActionResult();
        result.setData(demo);
        return result;

    }



}
