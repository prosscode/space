package com.space.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @describe: 商品桌位
 * @author: 彭爽pross
 * @date: 2019/03/10
 */
@Data
public class ShopSeat implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer seatId;
    private Integer shopId;
    private Integer typeId;
    private String seatMark;
    private Integer seatNum;
    private Integer  seatStatus;
}
