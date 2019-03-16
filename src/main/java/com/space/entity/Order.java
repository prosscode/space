package com.space.entity;

import lombok.Data;

import java.util.Date;

/**
 * @describe: 订单
 * @author: 彭爽pross
 * @date: 2019/03/16
 */
@Data
public class Order {
    private Integer orderId;
    private Integer shopId;
    private String orderName;
    private Double orderPrice;
    private String orderWaiter;
    private String orderUser;
    private String orderSeat;
    private Double orderCommission;
    private Date orderDate;
    private Integer orderStatus;

    // 订单类型
    private Integer orderType;
    //拼单人
    private String joinUser;
    // 签单人
    private String signer;
}
