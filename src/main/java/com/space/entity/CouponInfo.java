package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createDate;

}
