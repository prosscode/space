package com.space.mapper;

import com.space.entity.Staff;
import com.space.entity.StaffType;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {

    public int checkStaffType(@Param("shopMark") String shopMark, @Param("staffTypeName") String staffTypeName);

    public int addStaffType(StaffType staffType);

    public int deleteStaffType(@Param("shopMark")String shopMark,@Param("staffTypeName")String staffTypeName);

    public List<String> getStaffTypes(@Param("shopMark")String shopMark);

    public int addStaff(Staff staff);

    public int insertStaffMark(@Param("staffId") Integer staffId,@Param("staffMark") String staffMark);

    public List<Staff> getStaffs(@Param("shopMark")String shopMark,
                        @Param("staffName") String staffName,
                         @Param("staffType") String staffType,
                         @Param("dateFrom") Date dateFrom,
                         @Param("dateTo") Date dateTo,
                         @Param("pageNo") Integer pageNo,
                         @Param("pageSize") Integer pageSize);

    public int getStaffsCount(@Param("shopMark")String shopMark,
                                @Param("staffName") String staffName,
                                 @Param("staffType") String staffType,
                                 @Param("dateFrom") Date dateFrom,
                                 @Param("dateTo") Date dateTo);
}
