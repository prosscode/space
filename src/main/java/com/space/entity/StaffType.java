package com.space.entity;

import lombok.Data;

/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/03/04
 */
@Data
public class StaffType {

    private String shopMark;
    private String staffTypeName;
    private Double staffTypeCommission;
    private String staffTypeDesc;
    private Integer staffTypeNumber;
    private String status;
}
