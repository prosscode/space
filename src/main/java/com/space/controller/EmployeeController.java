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
    public int addStaffType(@RequestBody StaffType staffType,@RequestParam(name = "shopId",required = true)Integer shopId) throws Exception{
        logger.info("EmployeeController|addStaffType,staffTypeName:"+staffType.getStaffTypeName());
        //商家ID
        if(shopId==null||shopId<=0)
            throw  new Exception("请求参数错误!");
        staffType.setShopMark(shopId);
        int type = employeeService.addStaffType(staffType);
        return type;
    }


    /** 删除员工分类*/
    @RequestMapping(value = "/deleteStaffType",method = RequestMethod.GET)
    public int deleteStaffType(@RequestParam(name = "shopMark",required = true)Integer shopMark,
                               @RequestParam(name = "staffTypeName",required = true)String staffTypeName){
        logger.info("EmployeeController|deleteStaffType,shopMark:"+shopMark+",staffTypeName"+staffTypeName);
        int staffType = employeeService.deleteStaffType(shopMark, staffTypeName);
        return staffType;
    }

    /** 删除员工分类 根据ID*/
    @RequestMapping(value = "/deleteStaffTypeById",method = RequestMethod.DELETE)
    public int deleteStaffTypeById(Integer staffTypeId){
        return  employeeService.deleteStaffTypeById(staffTypeId);
    }

    /** 员工分类修改*/
    @RequestMapping(value = "/updateStaffType",method = RequestMethod.POST)
    public  int updateStaffType(StaffType staffType){
        return  employeeService.updateStaffType(staffType);
    }


    /** 得到商家的员工分类*/
    @RequestMapping(value = "getStaffTypes",method = RequestMethod.GET)
    public List<StaffType> getStaffTypes(@RequestParam(name = "shopId",required = true)Integer shopId
            ,@RequestParam(name = "staffTypeName",required = true)String staffTypeName
            ,@RequestParam(name = "pageNo",required = true)Integer pageNo
            ,@RequestParam(name = "pageSize",required = true)Integer pageSize){
        logger.info("EmployeeController|getStaffTypes,shopMark:"+shopId);
        return employeeService.getStaffTypes(shopId,staffTypeName,pageNo,pageSize);
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
    public PageEntity getStaffs(@RequestParam(name="shopId",required = true)Integer shopId,
                                @RequestParam(name="staffName",defaultValue="")String staffName,
                                @RequestParam(name="staffType",defaultValue="")String staffType,
                                @RequestParam(name = "dateFrom", required = false) Date dateFrom,
                                @RequestParam(name = "dateTo", required = false) Date dateTo,
                                @RequestParam(name="pageNo",defaultValue = "1")Integer pageNo,
                                @RequestParam(name="pageSize",defaultValue="20")Integer pageSize){
        logger.info("EmployeeController|getStaffs,pageNo:"+pageNo+",pageSize"+pageSize);
        pageNo = (pageNo -1) * pageSize;
        PageEntity entity = employeeService.getStaffs(shopId,staffName, staffType, dateFrom, dateTo, pageNo, pageSize);
        return entity;
    }
    /** 查询员工分类详情 根据ID*/

    @RequestMapping(value = "getStaffTypeById",method = RequestMethod.GET)
    public StaffType  getStaffTypeById(Integer staffTypeId){
        return  employeeService.getStaffTypeById(staffTypeId);
    }

    /** 查询员工详情 根据ID*/
    @RequestMapping(value = "getStaffById",method = RequestMethod.GET)
    public Staff  getStaffById(Integer staffTypeId){
        return  employeeService.getStaffById(staffTypeId);
    }

    /** 删除*/
    @RequestMapping(value = "deleteStaffById",method = RequestMethod.DELETE)
    public  int deleteStaffById(Integer staffId){
        return  employeeService.deleteStaffById(staffId);
    }

    /** 修改员工*/
    @RequestMapping(value = "updateStaff",method = RequestMethod.POST)
    public  int updateStaff(Staff staff){
        return  employeeService.updateStaff(staff);
    }
}
