package com.space.service.impl;

import com.space.entity.User;
import com.space.exception.PageEntity;
import com.space.mapper.ShopUserMapper;
import com.space.mapper.ShopUserOfPartSellMapper;
import com.space.service.ShopUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopUserServiceImpl  implements ShopUserService{
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private ShopUserMapper shopUserMapper;

    /**
     * 增加
     */
    @Override
    public User add(User info) {
        shopUserMapper.add(info);
        Integer id = info.getUserId();
        info.setUserId(id);
        return info;
    }

    /**
     * 删除
     */
    @Override
    public int deleteById(Integer id) {
       return shopUserMapper.deleteById(id);
    }

    /**
     * 修改
     */
    @Override
    public User update(User info) {
        shopUserMapper.update(info);
        return info;
    }

    @Override
    public User getInfoById(Integer id){
        return shopUserMapper.getInfoById(id);
    }

    @Override
    public PageEntity getList(
                              Integer shopMark,
                              String userName,
                              String userPhone,
                              String userWechat,
                              Integer userRole,
                              Integer pageNo,
                              Integer pageSize){
        List<User> list=shopUserMapper.getList(shopMark,userName,userPhone,userWechat,userRole,pageNo,pageSize);
        PageEntity pageEntity = new PageEntity();
        pageEntity.setList(list);
        //涉及到分页
        if (pageNo > 0 && pageSize > 0) {
            int rowsCount = shopUserMapper.getCount(shopMark,userName,userPhone,userWechat,userRole);
            pageEntity.setCount(rowsCount);
        }
        else {
            pageEntity.setCount(list.size());
        }
        return pageEntity;
    }

    @Override
    public int getCount(
                        Integer shopMark,
                        String userName,
                        String userPhone,
                        String userWechat,
                        Integer userRole){
        return shopUserMapper.getCount(shopMark,userName,userPhone,userWechat,userRole);
    }
}
