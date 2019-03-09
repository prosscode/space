package com.space.mapper;

import com.space.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    /** 添加用户*/
    public int addUser(User user);

    /** 是否开始分销*/
    public int openDistribution(@Param("shopMark") String shopMark,@Param("openFlag")Integer openFlag);

    /** 查询用户*/
    public List<User> getUsers(@Param("shopMark")String shopMark,
                               @Param("userName")String userName,
                               @Param("userPhone")String userPhone,
                               @Param("userWechat") String userWechat,
                               @Param("userRole") Integer userRole,
                               @Param("pageNo")Integer pageNo,
                               @Param("pageSize")Integer pageSize);

    /** 查询用户总数*/
    public int getUsersCount(@Param("shopMark")String shopMark,
                               @Param("userName")String userName,
                               @Param("userPhone")String userPhone,
                               @Param("userWechat") String userWechat,
                               @Param("userRole") Integer userRole);
}
