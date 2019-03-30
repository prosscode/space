package com.space.service;


import com.space.entity.Staff;
import com.space.entity.StaffType;
import com.space.exception.PageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    public int addStaffType(StaffType staffType) throws Exception;

    public int deleteStaffType(Integer shopMark,String staffTypeName);

    public int deleteStaffTypeById(Integer staffTypeId);

    public  int updateStaffType(StaffType staffType);

    public  List<StaffType> getStaffTypes(Integer shopMark,String staffTypeName,Integer pageNo,Integer pageSize);

    public int addStaff(Staff staff);

    public PageEntity getStaffs(Integer shopMark,String staffName, String staffType, Date dateFrom, Date dateTo,
                                Integer pageNo, Integer pageSize);

    public StaffType  getStaffTypeById(Integer staffTypeId);

    public int getStaffsCount(Integer shopMark,String staffName, String staffType, Date dateFrom, Date dateTo);


    public  int deleteStaffById(Integer staffId);


    public  int updateStaff(Staff staff);

    public Staff  getStaffById(Integer staffId);
}
