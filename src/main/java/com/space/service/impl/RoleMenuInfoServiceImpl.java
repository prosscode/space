package com.space.service.impl;

import com.space.entity.RoleInfo;
import com.space.entity.RoleMenuInfo;
import com.space.exception.PageEntity;
import com.space.mapper.RoleInfoMapper;
import com.space.mapper.RoleMenuInfoMapper;
import com.space.service.RoleInfoService;
import com.space.service.RoleMenuInfoService;
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
 * @describe: 角色栏目权限
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Service
public class RoleMenuInfoServiceImpl implements RoleMenuInfoService {
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private RoleMenuInfoMapper roleMenuInfoMapper;

    @Override
    public  List<RoleMenuInfo>  getMenusByRoleId(Integer roleId){
        return  roleMenuInfoMapper.getMenusByRoleId(roleId);
    }

}
