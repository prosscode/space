package com.space.service.impl;

import com.space.entity.Staff;
import com.space.entity.StaffType;
import com.space.exception.PageEntity;
import com.space.mapper.EmployeeMapper;
import com.space.service.EmployeeService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @describe: 员工管理
 * @author: 彭爽pross
 * @date: 2019/03/06
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeMapper employeeMapper;


    /** 增加员工分类*/
    @Override
    public int addStaffType(StaffType staffType) throws Exception {
        //检查有没有重复的员工分类
        Integer shopMark = staffType.getShopMark();
        String staffTypeName = staffType.getStaffTypeName();
        int checkStaffType = employeeMapper.checkStaffType(shopMark, staffTypeName);
        if(checkStaffType > 0){
            throw new Exception("新建员工分类存在相同名称");
        }

        return employeeMapper.addStaffType(staffType);

    }

    /** 删除员工分类*/
    @Override
    public int deleteStaffType(Integer shopMark, String staffTypeName) {
        int staffType = employeeMapper.deleteStaffType(shopMark, staffTypeName);
        return staffType;
    }
    /** 删除员工分类 根据ID*/
    @Override
    public int deleteStaffTypeById(Integer staffTypeId){
        return  employeeMapper.deleteStaffTypeById(staffTypeId);
    }

    /** 员工分类修改*/
    @Override
    public  int updateStaffType(StaffType staffType){
        return  employeeMapper.updateStaffType(staffType);
    }

    /** 得到商家设置的员工分类*/
    @Override
    public List<StaffType> getStaffTypes(Integer shopMark,String staffTypeName,Integer pageNo,Integer pageSize) {
        List<StaffType> staffTypes = employeeMapper.getStaffTypes(shopMark,staffTypeName,pageNo,pageSize);
        return staffTypes;
    }

    /** 添加员工*/
    @Transactional
    public int addStaff(Staff staff) {
        // 添加时间 为当前时间
        String currentTime = DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
        staff.setStaffDate(currentTime);
        // 添加员工
        int addStaff = employeeMapper.addStaff(staff);
        // 返回自增编号
        Integer staffId = staff.getStaffId();
        String mark = DateFormatUtils.format(new Date(),"dd");
        String staffMark = "A"+mark+staffId;
        //插入员工编号
        employeeMapper.insertStaffMark(staffId, staffMark);

        return addStaff;
    }

    /**查询员工*/
    @Override
    public PageEntity getStaffs(Integer shopMark,String staffName, String staffType, Date dateFrom, Date dateTo, Integer pageNo, Integer pageSize) {

        List<Staff> staffs = employeeMapper.getStaffs(shopMark,staffName, staffType, dateFrom, dateTo, pageNo, pageSize);
        PageEntity entity = new PageEntity();
        int count = employeeMapper.getStaffsCount(shopMark,staffName, staffType, dateFrom, dateTo);
        entity.setList(staffs);
        entity.setCount(count);
        return entity;
    }

    @Override
    public StaffType  getStaffTypeById(Integer staffTypeId){
        return  employeeMapper.getStaffTypeById(staffTypeId);
    }
    @Override
    public int getStaffsCount(Integer shopMark,String staffName, String staffType, Date dateFrom, Date dateTo){
        return  employeeMapper.getStaffsCount(shopMark,staffName, staffType, dateFrom, dateTo);
    }


    @Override
    public  int deleteStaffById(Integer staffId){
        return  employeeMapper.deleteStaffById(staffId);
    }

    @Override
    public  int updateStaff(Staff staff){
        return  employeeMapper.updateStaff(staff);
    }
    @Override
    public Staff  getStaffById(Integer staffId){
        return employeeMapper.getStaffById(staffId);
    }
}
