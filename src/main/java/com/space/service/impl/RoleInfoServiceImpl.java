package com.space.service.impl;

import com.space.entity.RoleInfo;
import com.space.entity.RoleMenuInfo;
import com.space.exception.PageEntity;
import com.space.mapper.RoleInfoMapper;
import com.space.mapper.RoleMenuInfoMapper;
import com.space.service.RoleInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.log.LogInputStream;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @describe: 角色管理
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private RoleInfoMapper roleInfoMapper;
    @Autowired
    private RoleMenuInfoMapper roleMenuInfoMapper;

    @Override
    public RoleInfo add(RoleInfo roleInfo) {
        roleInfo.setCreateDate(new Date());

        int identityId = roleInfoMapper.add(roleInfo);
        roleInfo.setRoleId(identityId);
        if (roleInfo.getMenuIds() != null && roleInfo.getMenuIds().size() > 0)
            //配置角色权限
            this.SetMenusByRole(roleInfo.getRoleId(), roleInfo.getShopId(), roleInfo.getMenuIds());
        return roleInfo;
    }

    @Override
    public int deleteById(Integer id) {
        return roleInfoMapper.deleteById(id);
    }

    @Override
    public RoleInfo update(RoleInfo roleInfo) {
        roleInfoMapper.update(roleInfo);
        if (roleInfo.getMenuIds() != null)
            //配置角色权限
            this.SetMenusByRole(roleInfo.getRoleId(), roleInfo.getShopId(), roleInfo.getMenuIds());
        return roleInfo;
    }

    @Override
    public RoleInfo getInfoById(Integer id) {
        RoleInfo info=roleInfoMapper.getInfoById(id);
        List<RoleMenuInfo>   roleMenuInfoList= roleMenuInfoMapper.getMenusByRoleId(id);
        List<Integer> menuIds=new ArrayList<>();
        if(roleMenuInfoList!=null&&roleMenuInfoList.size()>0){
            for(RoleMenuInfo item:roleMenuInfoList){
                menuIds.add(item.getMenuId());
            }
            info.setMenuIds(menuIds);
        }
        return roleInfoMapper.getInfoById(id);
    }

    @Override
    public PageEntity getList(Integer shopId, String roleName,
                              Integer pageNo, Integer pageSize) {

        List<RoleInfo> list = roleInfoMapper.getList(shopId, roleName, pageNo, pageSize);
        PageEntity entity = new PageEntity();
        int count = roleInfoMapper.getRolesCount(shopId, roleName);
        entity.setList(list);
        entity.setCount(count);
        return entity;
    }

    @Override
    public int getRolesCount(Integer shopId, String roleName) {
        return roleInfoMapper.getRolesCount(shopId, roleName);
    }

    @Override
    public int SetMenusByRole(Integer shopId, Integer roleId, List<Integer> menuIds) {
        List<RoleMenuInfo> roleMenuInfoList = new ArrayList<>();
        for (Integer menuId : menuIds) {
            RoleMenuInfo roleMenuInfo = new RoleMenuInfo();
            roleMenuInfo.setMenuId(menuId);
            roleMenuInfo.setShopId(shopId);
            roleMenuInfo.setRoleId(roleId);
            roleMenuInfoList.add(roleMenuInfo);
        }
        roleMenuInfoMapper.deleteByRoleId(roleId);
        roleMenuInfoMapper.insertBatch(roleMenuInfoList);
        return 1;
    }
}
