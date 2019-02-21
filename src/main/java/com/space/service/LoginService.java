package com.space.service;

import com.space.entity.Login;

public interface LoginService {

    public void registered(Login login) throws Exception;

    public Integer checkUserName(String userName);

    public Integer checkBarName(String userName);

    public void login(String userName,String password) throws Exception;

}
