package com.space.controller;

import com.space.entity.Staff;
import com.space.entity.StaffType;
import com.space.exception.PageEntity;
import com.space.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @describe: 员工管理模块
 * @author: 彭爽pross
 * @date: 2019/02/25
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


    /** 得到商家的员工分类*/
    @RequestMapping(value = "getStaffTypes",method = RequestMethod.GET)
    public List<String> getStaffTypes(@RequestParam(name = "shopMark",required = true)String shopMark){
        logger.info("EmployeeController|getStaffTypes,shopMark:"+shopMark);
        return employeeService.getStaffTypes(shopMark);
    }

    /** 添加员工*/
    @RequestMapping(value = "addStaff",method = RequestMethod.POST)
    public int addStaff(@RequestBody Staff staff){
        logger.info("EmployeeController|addStaff,staff_name:"+staff.getStaffName());
        int addStaff = employeeService.addStaff(staff);
        return addStaff;
    }

    /** 查询员工*/
    @RequestMapping(value = "getStaffs",method = RequestMethod.GET)
    public PageEntity getStaffs(@RequestParam(name="shopMark",required = true)String shopMark,
                                @RequestParam(name="staffName",defaultValue="")String staffName,
                                @RequestParam(name="staffType",defaultValue="")String staffType,
                                @RequestParam(name = "dateFrom", required = false) Date dateFrom,
                                @RequestParam(name = "dateTo", required = false) Date dateTo,
                                @RequestParam(name="pageNo",defaultValue = "1")Integer pageNo,
                                @RequestParam(name="pageSize",defaultValue="20")Integer pageSize){
        logger.info("EmployeeController|getStaffs,pageNo:"+pageNo+",pageSize"+pageSize);
        pageNo = (pageNo -1) * pageSize;
        PageEntity entity = employeeService.getStaffs(shopMark,staffName, staffType, dateFrom, dateTo, pageNo, pageSize);
        return entity;

    }

}
