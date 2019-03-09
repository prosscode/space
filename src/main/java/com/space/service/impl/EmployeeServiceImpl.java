package com.space.service.impl;

import com.space.entity.StaffType;
import com.space.mapper.EmployeeMapper;
import com.space.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @describe: 员工管理
 * @author: 彭爽pross
 * @date: 2019/03/09
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeMapper employeeMapper;


    /**增加员工分类*/
    @Override
    public int addStaffType(StaffType staffType) throws Exception {
        //检查有没有重复的员工分类
        String shopMark = staffType.getShopMark();
        String staffTypeName = staffType.getStaffTypeName();
        int checkStaffType = employeeMapper.checkStaffType(shopMark, staffTypeName);
        if(checkStaffType > 0){
            throw new Exception("新建员工分类存在相同名称");
        }

        return employeeMapper.addStaffType(staffType);

    }

    /**删除员工分类*/
    @Override
    public int deleteStaffType(String shopMark, String staffTypeName) {
        int staffType = employeeMapper.deleteStaffType(shopMark, staffTypeName);
        return staffType;
    }
}
