package com.space.service.impl;

import com.space.entity.User;
import com.space.mapper.UserMapper;
import com.space.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @describe: 用户管理实体类
 * @author: 彭爽pross
 * @date: 2019/03/09
 */
@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;


    @Override
    public int addUser(User user) {
        logger.info("UserServiceImpl|addUser,enter");
        return userMapper.addUser(user);
    }
}
