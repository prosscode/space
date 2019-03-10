package com.space.entity;

import lombok.Data;

import java.util.Date;

/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/03/10
 */
@Data
public class CommodityType {

    private Integer typeId;
    private Integer shopId;
    private String typeName;
    private String typeNameSub;
    private Integer seatNumber;
    private String createTime;
    private Integer role;
}
