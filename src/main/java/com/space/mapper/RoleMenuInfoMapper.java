package com.space.mapper;


import com.space.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/** 分销设置*/
public  interface RoleMenuInfoMapper {
    public  int insertBatch(List<RoleMenuInfo> roleMenuInfos);

    public  int deleteByRoleId(@Param("roleId")Integer roleId);

    public  List<RoleMenuInfo>  getMenusByRoleId(@Param("roleId")Integer roleId);
}
