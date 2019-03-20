package com.space.service;


import com.space.entity.RoleInfo;
import com.space.entity.RoleMenuInfo;
import com.space.exception.PageEntity;

import java.util.List;

public interface RoleMenuInfoService {
     public  List<RoleMenuInfo>  getMenusByRoleId(Integer roleId);
}
