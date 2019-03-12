package com.space.service;

import com.space.entity.ShopInfo;

public interface LoginService {

    public int registered(ShopInfo login) throws Exception;

    public Integer checkUserName(String userName);

    public Integer checkBarName(String userName);

    public void login(String userName,String password) throws Exception;

}
