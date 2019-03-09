package com.space.entity;

import lombok.Data;

/**
 * @describe: 区间价格
 * @author: 彭爽pross
 * @date: 2019/02/20
 */

@Data
public class CommodityPrice extends Commodity{
    private Integer startTime;
    private Integer endTime;
    private Integer productPrice;
    private Integer offerPrice;

}
