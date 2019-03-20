package com.space.entity;

import lombok.Data;

/**
 * @describe: 座位信息
 * @author: 彭爽pross
 * @date: 2019/03/20
 */
@Data
public class SeatInfo {
    private Integer shopId;
    private String seatMark;
    private String typeName;
    private Integer seatNum;
    private Integer seatStatus;
    private Integer seatCount;

}
