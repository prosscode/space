package com.space.service;

import com.space.entity.Login;

public interface LoginService {

    public String registered(Login login) throws Exception;

    public Integer checkUserName(String userName);

    public Integer checkBarName(String userName);

    public String login(String userName);
}
