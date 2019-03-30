package com.space.controller;


import com.space.entity.AreaTypeInfo;
import com.space.entity.RoleInfo;
import com.space.exception.BaseExceptionHandler;
import com.space.exception.PageEntity;
import com.space.service.AreaTypeInfoService;
import com.space.service.RoleInfoService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @describe: 区域分组
 * @author: 吕涛pross
 * @date: 2019/03/19
 */

@RestController
@RequestMapping(value = "/area")
@Api(tags="区域分组")
public class AreaTypeInfoController extends BaseExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private AreaTypeInfoService areaTypeInfoService;
    /** 保存 新增或者更新 id 0代表新增 大于0代表修改*/
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public AreaTypeInfo save(@RequestBody AreaTypeInfo areaTypeInfo,@PathVariable(value = "id",required = true)Integer id,@RequestParam(name = "shopId",required = true)Integer shopId) throws Exception{
        if(id!=areaTypeInfo.getTypeId())
            throw  new Exception("请求参数错误!");
        //商家ID
        if(shopId==null||shopId<=0)
            throw  new Exception("请求参数错误!");
        areaTypeInfo.setShopId(shopId);
        if(id<=0){
            areaTypeInfo=  areaTypeInfoService.add(areaTypeInfo);
        }
        else {
            areaTypeInfo=  areaTypeInfoService.update(areaTypeInfo);
        }
        return  areaTypeInfo;
    }
    /** 删除 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public  int deleteById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  areaTypeInfoService.deleteById(id);
    }
    /** 查询单个 根据ID*/
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public  AreaTypeInfo getInfoById(@PathVariable(value = "id",required = true)Integer id) throws Exception{
        return  areaTypeInfoService.getInfoById(id);
    }

    /** 分页查询*/
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public PageEntity getList(@RequestParam(name="shopId",required = false,defaultValue ="0")Integer shopId,
                              @RequestParam(name="typeName",required = false)String typeName,
                              @RequestParam(name="pageNo",required = false,defaultValue ="0")Integer pageNo,
                              @RequestParam(name="pageSize",required = false,defaultValue ="0")Integer pageSize) throws Exception{
         return areaTypeInfoService.getList(shopId,typeName, pageNo, pageSize);
    }

}
