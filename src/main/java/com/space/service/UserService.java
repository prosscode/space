package com.space.service;

import com.space.entity.User;
import com.space.exception.PageEntity;

public interface UserService {

    public int addUser(User user);

    public int openDistribution(String shopMark,int openFlag);

    public PageEntity getUsers(String shopMark,String userName,String userPhone,String userWechat,Integer userRole,
                               Integer pageNo,Integer pageSize);

}
