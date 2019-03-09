package com.space.service;


import com.space.entity.StaffType;

public interface EmployeeService {

    public int addStaffType(StaffType staffType) throws Exception;

    public int deleteStaffType(String shopMarl,String staffTypeName);
}
