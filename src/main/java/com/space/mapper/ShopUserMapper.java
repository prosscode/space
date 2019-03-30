package com.space.mapper;

import com.space.entity.ShopSignSetInfo;
import com.space.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/** 商家*/
public interface ShopUserMapper {
    /**
     * 增加
     */
    public int add(User info);

    /**
     * 删除
     */
    public int deleteById(@Param("id") Integer id);

    /**
     * 修改
     */
    public int update(User info);


    public User getInfoById(@Param("id") Integer id);


    public List<User> getList(
                              @Param("shopMark") Integer shopMark,
                              @Param("userName") String userName,
                              @Param("userPhone") String userPhone,
                              @Param("userWechat") String userWechat,
                              @Param("userRole") Integer userRole,
                              @Param("pageNo") Integer pageNo,
                              @Param("pageSize") Integer pageSize);



    public int getCount(
                        @Param("shopMark") Integer shopMark,
                        @Param("userName") String userName,
                        @Param("userPhone") String userPhone,
                        @Param("userWechat") String userWechat,
                        @Param("userRole") Integer userRole);

}
