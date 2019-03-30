package com.space.controller;

import com.space.entity.PartsellSetInfo;
import com.space.entity.RoleInfo;
import com.space.entity.User;
import com.space.exception.BaseExceptionHandler;
import com.space.exception.PageEntity;
import com.space.service.PartsellSetInfoService;
import com.space.service.RoleInfoService;
import com.space.service.ShopUserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @describe: 商家用户管理
 * @author: 吕涛pross
 * @date: 2019/03/19
 */

@RestController
@RequestMapping(value = "/shopUser")
@Api(tags="商家用户管理")
public class ShopUserController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);


    @Autowired
    private ShopUserService shopUserService;
    /** 保存 新增或者更新 id 0代表新增 大于0代表修改*/
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public User save(@RequestBody User userInfo,
                     @PathVariable(value = "id",required = true)Integer id,
                     @RequestParam(name = "shopId",required = true)Integer shopId) throws Exception{
        if(id!=userInfo.getUserId())
            throw  new Exception("请求参数错误!");
        //商家ID
        if(shopId==null||shopId<=0)
            throw  new Exception("请求参数错误!");
        userInfo.setShopMark(shopId);
        if(id<=0){
            userInfo=  shopUserService.add(userInfo);
        }
        else {
            userInfo=  shopUserService.update(userInfo);
        }
        return  userInfo;
    }
    /** 删除 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public  int deleteById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  shopUserService.deleteById(id);
    }
    /** 查询单个 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public  User getInfoById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  shopUserService.getInfoById(id);
    }

    /** 分页查询*/
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageEntity getList(
                              @RequestParam(name="shopId",required = false,defaultValue = "0")Integer shopId,
                              @RequestParam(name="userName",required = false,defaultValue = "")String userName,
                              @RequestParam(name="userPhone",required = false,defaultValue = "")String userPhone,
                              @RequestParam(name="userWechat",required = false,defaultValue = "")String userWechat,
                              @RequestParam(name="userType",required = false,defaultValue = "-1")Integer userType,
                              @RequestParam(name="pageNo",required = false,defaultValue ="0")Integer pageNo,
                              @RequestParam(name="pageSize",required = false,defaultValue ="0")Integer pageSize){
        PageEntity entity = shopUserService.getList( shopId,userName,userPhone,userWechat,userType, pageNo, pageSize);
        return entity;
    }

}
