package com.space.service.impl;

import com.space.entity.RoleInfo;
import com.space.entity.ShopDrinkInfo;
import com.space.exception.PageEntity;
import com.space.mapper.RoleMenuInfoMapper;
import com.space.mapper.ShopDrinkInfoMapper;
import com.space.service.RoleMenuInfoService;
import com.space.service.ShopDrinkInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @describe: 存酒/取酒
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Service
public class ShopDrinkInfoServiceImpl implements ShopDrinkInfoService {
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private ShopDrinkInfoMapper shopDrinkInfoMapper;
    @Override
    public  ShopDrinkInfo add(ShopDrinkInfo shopDrinkInfo){
        shopDrinkInfo.setId(shopDrinkInfoMapper.add(shopDrinkInfo));
        shopDrinkInfo.setModifyDate(new Date());
        return  shopDrinkInfo;
    }
    @Override
    public  int deleteById(Integer id){
        return     shopDrinkInfoMapper.deleteById(id);
    }
    @Override
    public  ShopDrinkInfo update(ShopDrinkInfo shopDrinkInfo){
        shopDrinkInfoMapper.update(shopDrinkInfo);
        return  shopDrinkInfo;
    }
    @Override
    public  ShopDrinkInfo getInfoById(Integer id){
        return shopDrinkInfoMapper.getInfoById(id);
    }
    @Override
    public PageEntity getList(Integer shopId, String type,
                              String keyWord, Integer pageNo, Integer pageSize){
        List<ShopDrinkInfo> list = shopDrinkInfoMapper.getList(shopId, type,type ,pageNo, pageSize);
        PageEntity entity = new PageEntity();
        int count = shopDrinkInfoMapper.getCount(shopId, type,type);
        entity.setList(list);
        entity.setCount(count);
        return entity;
    }
    @Override
    public int getCount(Integer shopId, String type,
                        String keyWord){
        return   shopDrinkInfoMapper.getCount(shopId, type,type);
    }
}
