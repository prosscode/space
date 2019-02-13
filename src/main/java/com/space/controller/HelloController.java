package com.space.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/welcome")
public class HelloController {

    // 通过@ApiOperation注解来给API增加说明
    @ApiOperation(value = "第一个接口",notes = "欢迎语")
    // 通过@ApiImplicitParams、@ApiImplicitParam注解来给参数增加说明。
    @ApiImplicitParam(name = "name",value = "姓名",required = true,dataType = "String", paramType = "query")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(@RequestParam(name="name",defaultValue = "pross") String name){
        return "hello "+name;
    }



    // 通过@ApiOperation注解来给API增加说明
    @ApiOperation(value = "第二个接口",notes = "欢迎语2")
    // 通过@ApiImplicitParams注解来给参数增加说明
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name1",value = "姓名1",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "name2",value = "姓名2",required = true,dataType = "String",paramType = "query")
    })
    @RequestMapping(value = "/hello2",method = RequestMethod.POST)
    public String hello2(@RequestParam(name="name1",defaultValue = "pross1") String name1,
                         @RequestParam(name="name2",defaultValue = "pross2") String name2){
        return "hello "+name1+" and "+name2;
    }
}
