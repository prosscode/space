package com.space.service.impl;

import com.space.entity.User;
import com.space.exception.PageEntity;
import com.space.mapper.UserMapper;
import com.space.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describe: 用户管理实体类
 * @author: 彭爽pross
 * @date: 2019/02/18
 */
@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;


    /**添加用户*/
    @Override
    public int addUser(User user) {
        logger.info("UserServiceImpl|addUser,enter");
        return userMapper.addUser(user);
    }

    /**是否开始分销*/
    @Override
    public int openDistribution(String shopMark, int openFlag) {
        int flag = userMapper.openDistribution(shopMark, openFlag);
        return flag;
    }

    /** 查询用户*/
    @Override
    public PageEntity getUsers(String shopMark,String userName,String userPhone,String userWechat,Integer userRole,
                               Integer pageNo,Integer pageSize) {
        List<User> users = userMapper.getUsers(shopMark, userName, userPhone, userWechat, userRole, pageNo, pageSize);
        PageEntity entity = new PageEntity();
        entity.setList(users);
        int usersCount = userMapper.getUsersCount(shopMark, userName, userPhone, userWechat, userRole);
        entity.setCount(usersCount);

        return entity;
    }
}
