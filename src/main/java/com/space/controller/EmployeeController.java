package com.space.controller;

import com.space.entity.StaffType;
import com.space.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @describe: 员工管理模块
 * @author: 彭爽pross
 * @date: 2019/03/09
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    /** 新建员工分类*/
    @RequestMapping(value = "/addStaffType", method = RequestMethod.POST)
    public int addStaffType(@RequestBody StaffType staffType) throws Exception{
        logger.info("EmployeeController|addStaffType,staffTypeName:"+staffType.getStaffTypeName());
        int type = employeeService.addStaffType(staffType);
        return type;
    }


    /** 删除员工分类*/
    @RequestMapping(value = "/deleteStaffType",method = RequestMethod.GET)
    public int deleteStaffType(@RequestParam(name = "shopMark",required = true)String shopMark,
                               @RequestParam(name = "staffTypeName",required = true)String staffTypeName){
        logger.info("EmployeeController|deleteStaffType,shopMark:"+shopMark+",staffTypeName"+staffTypeName);
        int staffType = employeeService.deleteStaffType(shopMark, staffTypeName);
        return staffType;
    }


}
