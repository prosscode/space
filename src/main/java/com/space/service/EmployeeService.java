package com.space.service;


import com.space.entity.Staff;
import com.space.entity.StaffType;
import com.space.exception.PageEntity;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    public int addStaffType(StaffType staffType) throws Exception;

    public int deleteStaffType(String shopMark,String staffTypeName);

    public  List<StaffType> getStaffTypes(String shopMark,String staffTypeName,Integer pageNo,Integer pageSize);

    public int addStaff(Staff staff);

    public PageEntity getStaffs(String shopMark,String staffName, String staffType, Date dateFrom, Date dateTo,
                                Integer pageNo, Integer pageSize);
}
