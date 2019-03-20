package com.space.entity;

import lombok.Data;

/**
 * @describe: 商品桌位
 * @author: 彭爽pross
 * @date: 2019/03/10
 */
@Data
public class ShopSeat {
    private Integer seatId;
    private Integer shopId;
    private String seatMark;
    private String seatType;
    private Integer seatNum;

}
