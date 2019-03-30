package com.space.service;

import com.space.entity.User;
import com.space.exception.PageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopUserService {
    /**
     * 增加
     */
    public User add(User info);

    /**
     * 删除
     */
    public int deleteById(Integer id);

    /**
     * 修改
     */
    public User update(User info);


    public User getInfoById(Integer id);


    public PageEntity getList(
                              Integer shopMark,
                              String userName,
                              String userPhone,
                              String userWechat,
                              Integer userRole,
                              Integer pageNo,
                              Integer pageSize);



    public int getCount(
                        Integer shopMark,
                        String userName,
                        String userPhone,
                        String userWechat,
                        Integer userRole);
}
