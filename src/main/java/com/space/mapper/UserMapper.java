package com.space.mapper;

import com.space.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /** 添加用户*/
    public int addUser(User user);

}
