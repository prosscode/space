package com.space.entity;

import lombok.Data;

/**
 * @describe:员工类型
 * @author: 彭爽pross
 * @date: 2019/03/04
 */
@Data
public class StaffType {
    //员工分类ID
    private Integer  staff_type_id;
    //商家编号
    private String shopMark;
    //员工分类名称
    private String staffTypeName;
    //提成比例
    private Double staffTypeCommission;
    //类型描述
    private String staffTypeDesc;
    //人数
    private Integer staffTypeNumber;
    //状态默认开启-0，关闭-1
    private String status;
    //员工角色ID
    private  Integer roleId;
}
