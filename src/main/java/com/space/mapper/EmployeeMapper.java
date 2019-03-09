package com.space.mapper;

import com.space.entity.StaffType;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {

    public int checkStaffType(@Param("shopMark") String shopMark, @Param("staffTypeName") String staffTypeName);

    public int addStaffType(StaffType staffType);

    public int deleteStaffType(@Param("shopMark")String shopMark,@Param("staffTypeName")String staffTypeName);
}
