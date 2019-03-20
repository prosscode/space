package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @describe: 营销 充值
 * @author: 吕涛pross
 * @date: 2019/02/19
 */
@Data
public class ShopMarketRechargeInfo  implements Serializable {
    private static final long serialVersionUID = 1L;

    //自增流水号
    private  Integer id;
    //商户ID
    private  Integer shopId;
    //会员手机号
    private  String userPhone;
    //支付方式
    private  Integer payMethod;
    //充值金额
    private  double money;
    //赠送金额 根据对应充值套餐得到
    private  double sendMoney;
    //充值套餐类型编号
    private  String  rechargeSetNo;
    //管理员备注
    private  String adminRemark;
    //服务员用户ID
    private  Integer waiterId;
    //充值日期
    private  Date createDate;
}
