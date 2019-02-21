package com.space.mapper;

import com.space.entity.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {

    public int registered(Login login);

    /** 回溯，插入商家编号*/
    public int insertShopMark(@Param("shopId") int shopId,@Param("shopMark") String shopMark);

    /** 添加到登录表*/
    public int insertLogin(@Param("userName")String userName,@Param("password")String password);

    public int checkUserName(@Param("userName") String userName);

    public int checkBarName(@Param("barName") String barName);

    public String login(@Param("userName")String userName);
}
