package com.space.mapper;


import com.space.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/** 分销设置*/
public interface RoleInfoMapper {

    public  int add(RoleInfo roleInfo);
    public  int deleteById(Integer id);
    public  int update(RoleInfo roleInfo);
    public  RoleInfo getInfoById(Integer id);
    public  List<RoleInfo> getList(@Param("shopId")Integer shopId,@Param("roleName")String roleName,
                                   @Param("pageNo")Integer pageNo,@Param("pageSize")Integer pageSize);

    public int getRolesCount(@Param("shopId")Integer shopId,@Param("roleName")String roleName);
}
