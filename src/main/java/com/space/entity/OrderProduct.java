package com.space.entity;

import lombok.Data;

/**
 * @describe: 订单中的商品信息
 * @author: 彭爽pross
 * @date: 2019/03/22
 */
@Data
public class OrderProduct extends Order{
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private String productName;
    private Double productPrice;
    private Integer productNum;
    private Double productAmount;
}
