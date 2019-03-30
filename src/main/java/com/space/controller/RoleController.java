package com.space.controller;


import com.space.entity.PartsellSetInfo;

import com.space.entity.RoleInfo;
import com.space.exception.BaseExceptionHandler;
import com.space.exception.PageEntity;
import com.space.service.RoleInfoService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @describe: 角色管理
 * @author: 吕涛pross
 * @date: 2019/03/19
 */

@RestController
@RequestMapping(value = "/role")
@Api(tags="角色管理")
public class RoleController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private RoleInfoService roleInfoService;
    /** 保存角色 新增或者更新 id 0代表新增 大于0代表修改*/
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public RoleInfo save(@RequestBody RoleInfo roleInfo,@PathVariable(value = "id",required = true)Integer id,@RequestParam(name = "shopId",required = true)Integer shopId) throws Exception{
        if(id!=roleInfo.getRoleId())
            throw  new Exception("请求参数错误!");
        //商家ID
        if(shopId==null||shopId<=0)
            throw  new Exception("请求参数错误!");
        roleInfo.setShopId(shopId);
        if(id<=0){
            roleInfo=  roleInfoService.add(roleInfo);
        }
        else {
            roleInfo=  roleInfoService.update(roleInfo);
        }
        return  roleInfo;
    }
    /** 删除角色 根据角色ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public  int deleteById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  roleInfoService.deleteById(id);
    }
    /** 查询单个角色 根据角色ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public  RoleInfo getInfoById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  roleInfoService.getInfoById(id);
    }

    /** 分页查询角色*/
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageEntity   getList(@RequestParam(name="shopId",required = false,defaultValue ="0")Integer shopId,
                                @RequestParam(name="roleName",required = false)String roleName,
                                @RequestParam(name="pageNo",required = false,defaultValue ="0")Integer pageNo,
                                @RequestParam(name="pageSize",required = false,defaultValue ="0")Integer pageSize){
        PageEntity entity = roleInfoService.getList(shopId,roleName, pageNo, pageSize);
        return entity;
    }

}
