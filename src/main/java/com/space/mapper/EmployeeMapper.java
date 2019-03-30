package com.space.mapper;

import com.space.entity.Staff;
import com.space.entity.StaffType;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {

    public int checkStaffType(@Param("shopMark") Integer shopMark, @Param("staffTypeName") String staffTypeName);

    public int addStaffType(StaffType staffType);

    public int deleteStaffType(@Param("shopMark")Integer shopMark,@Param("staffTypeName")String staffTypeName);

    public int deleteStaffTypeById(@Param("staffTypeId")Integer staffTypeId);

    public  int updateStaffType(StaffType staffType);

    public List<StaffType> getStaffTypes(@Param("shopMark")Integer shopMark,
                                      @Param("staffTypeName") String staffTypeName,
                                      @Param("pageNo") Integer pageNo,
                                      @Param("pageSize") Integer pageSize);

    public int addStaff(Staff staff);

    public int insertStaffMark(@Param("staffId") Integer staffId,@Param("staffMark") String staffMark);

    public List<Staff> getStaffs(@Param("shopMark")Integer shopMark,
                        @Param("staffName") String staffName,
                         @Param("staffType") String staffType,
                         @Param("dateFrom") Date dateFrom,
                         @Param("dateTo") Date dateTo,
                         @Param("pageNo") Integer pageNo,
                         @Param("pageSize") Integer pageSize);

    public StaffType  getStaffTypeById(@Param("staffTypeId")Integer staffTypeId);

    public int getStaffsCount(@Param("shopMark")Integer shopMark,
                                @Param("staffName") String staffName,
                                 @Param("staffType") String staffType,
                                 @Param("dateFrom") Date dateFrom,
                                 @Param("dateTo") Date dateTo);

     public  int deleteStaffById(@Param("staffId")Integer staffId);

     public  int updateStaff(@Param("staff")Staff staff);

    public Staff  getStaffById(@Param("staffId")Integer staffId);
}
