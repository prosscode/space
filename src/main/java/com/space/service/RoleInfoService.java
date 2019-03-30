package com.space.service;


import com.space.entity.RoleInfo;
import com.space.entity.RoleMenuInfo;
import com.space.exception.PageEntity;

import java.util.List;

/**
 * 角色管理
 */
public interface RoleInfoService {

    public RoleInfo add(RoleInfo roleInfo);

    public int deleteById(Integer id);

    public RoleInfo update(RoleInfo roleInfo);

    public RoleInfo getInfoById(Integer id);

    public PageEntity getList(Integer shopId, String roleName,
                              Integer pageNo, Integer pageSize);

    public int getRolesCount(Integer shopId, String roleName);

    public int SetMenusByRole(Integer shopId, Integer roleId, List<Integer> menuIds);

}
