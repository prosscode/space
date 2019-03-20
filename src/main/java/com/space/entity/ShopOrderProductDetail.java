package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @describe: 订单商品明细
 * @author: 吕涛pross
 * @date: 2019/02/19
 */
@Data
public class ShopOrderProductDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    //自增流水号
    private Integer id;
    //订单id
    private Integer orderId;
    //商品id
    private Integer productId;
    //商品名称
    private Integer producName;
    //商品数量
    private Integer productNum;
    //商品单价
    private Integer productPrice;
    //商品金额
    private Integer productAmount;

}
