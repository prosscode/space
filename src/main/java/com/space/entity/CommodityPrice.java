package com.space.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @describe: 区间价格
 * @author: 彭爽pross
 * @date: 2019/02/20
 */

@Data
public class CommodityPrice extends Commodity implements Serializable {
    private Integer startTime; //开始时间 整点数
    private Integer endTime;    //结束时间 整点数
    private Double productPrice; //商品价格
    private Double offerPrice;  //活动价格
}
