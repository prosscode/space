package com.space.mapper;

import com.space.entity.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {

    /**注册*/
    public int registered(Login login);

    /** 回溯，插入商家编号*/
    public int insertShopMark(@Param("shopId") int shopId,@Param("shopMark") String shopMark);

    /** 添加到登录表*/
    public int insertLogin(@Param("userName")String userName,@Param("password")String password);

    /**检查用户名是否存在*/
    public int checkUserName(@Param("userName") String userName);

    /**检测酒吧名是否存在*/
    public int checkBarName(@Param("barName") String barName);

    /** 登录验证*/
    public String login(@Param("userName")String userName);
}
