package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * @describe: 礼劵基础信息表
 * @author: 吕涛pross
 * @date: 2019/03/21
 */

@Data
public class ShopMarketSecurities implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private  Integer   id;
    //商家ID
    private  Integer          shopId;
    //礼劵ID
    private  String     securitiesNo;
    //礼劵类型
    private  String          securitiesType;
    //面值
    private  Double    worth;
    //使用条件 0线下 1线上
    private  Integer        useCondition;
    //金额 条件
    private  Double    amontCondition;
    //有效期类型 0自领取日生效 1自定义有效期
    private  Integer      activeDateType;
    // 有效期范围(天)
    private  Integer    activeRange;
    //使用说明
    private  String      useDesc;
    // 是否自动生成二维码 0否 1是
    private  boolean   isQRCode;
    // 创建日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date createDate;

}
