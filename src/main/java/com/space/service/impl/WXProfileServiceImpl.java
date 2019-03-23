package com.space.service.impl;

import com.space.entity.UserPartSell;
import com.space.exception.PageEntity;
import com.space.mapper.WXProfileMapper;
import com.space.service.WXProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describe: 用户个人信息相关
 * @author: 彭爽pross
 * @date: 2019/03/23
 */
@Service
public class WXProfileServiceImpl implements WXProfileService {

    private Logger logger = LoggerFactory.getLogger(WXProfileServiceImpl.class);

    @Autowired
    private WXProfileMapper wxProfileMapper;

    /**查询商家的分销等级*/
    @Override
    public Integer getPartsellLevel(Integer shopId) {
        return wxProfileMapper.getPartsellLevel(shopId);
    }

    /** 查询用户分销身份*/
    @Override
    public PageEntity getUserIdentity(Integer userId) {
        List<UserPartSell> userIdentity = wxProfileMapper.getUserIdentity(userId);
        String userName = userIdentity.get(0).getSuperUserName();
        System.out.println(userName+"=========");
        PageEntity entity = new PageEntity();
        entity.setList(userIdentity);
        entity.setCount(0);
        return entity;
    }
}
