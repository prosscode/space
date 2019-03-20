package com.space.entity;

import lombok.Data;

/**
 * @describe: 优惠券
 * @author: 彭爽pross
 * @date: 2019/03/20
 */
@Data
public class CouponInfo {
    private Integer id;
    private Integer shopId;
    private String securitiesNo;
    private String securitiesType;
    private Double worth;
    private Integer useCondition;
    private Double amontCondition;
    private Integer activeDateType;
    private Integer activeRange;
    private String useDesc;

}
