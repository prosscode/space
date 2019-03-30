package com.space.controller;

import com.space.entity.AreaTypeInfo;
import com.space.entity.ShopSignSetInfo;
import com.space.exception.BaseExceptionHandler;
import com.space.exception.PageEntity;
import com.space.service.AreaTypeInfoService;
import com.space.service.ShopSignSetInfoService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @describe: 签单人员配置
 * @author: 吕涛pross
 * @date: 2019/03/19
 */

@RestController
@RequestMapping(value = "/signSet")
@Api(tags="签单人员配置")
public class ShopSignSetInfoController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private ShopSignSetInfoService signSetInfoService;
    /** 保存 新增或者更新 id 0代表新增 大于0代表修改*/
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public ShopSignSetInfo save(@RequestBody ShopSignSetInfo info, @PathVariable(value = "id",required = true)Integer id,@RequestParam(name = "shopId",required = true)Integer shopId) throws Exception{
        if(id!=info.getId())
            throw  new Exception("请求参数错误!");
        if(shopId<=0)
            throw  new Exception("请求参数错误!");
        info.setShopId(shopId);
        if(id<=0){
            info=  signSetInfoService.add(info);
        }
        else {
            info=  signSetInfoService.update(info);
        }
        return  info;
    }
    /** 删除 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public  int deleteById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  signSetInfoService.deleteById(id);
    }
    /** 查询单个 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public  ShopSignSetInfo getInfoById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  signSetInfoService.getInfoById(id);
    }

    /** 分页查询*/
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageEntity getList(@RequestParam(name="shopId",required = false,defaultValue ="0")Integer shopId,
                              @RequestParam(name="staffCategoryNo",required = false,defaultValue ="-1")Integer staffCategoryNo,
                              @RequestParam(name="staffId",required = false,defaultValue ="0")Integer staffId,
                              @RequestParam(name="pageNo",required = false,defaultValue ="0")Integer pageNo,
                              @RequestParam(name="pageSize",required = false,defaultValue ="0")Integer pageSize) throws Exception{
        return signSetInfoService.getList(shopId,staffCategoryNo,staffId, pageNo, pageSize);
    }

}
