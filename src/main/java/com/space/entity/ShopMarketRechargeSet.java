package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @describe: 营销 充值套餐
 * @author: 吕涛pross
 * @date: 2019/02/19
 */

@Data
public class ShopMarketRechargeSet implements Serializable {
    private static final long serialVersionUID = 1L;
    // 充值套餐ID
    private  Integer rechargeId;
    // 商户ID
    private  Integer shop_id;
    // 充值类型名称
    private  String recharge_type_name;
    // 折扣
    private  double recharge_discount;
    // 充值金额 优惠额度(满多少送多少)
    private  double recharge_money;
    // 赠送金额
    private  double recharge_backMoney;
    // 充值优惠详细描述
    private  String recharge_desc;
    // 充值优惠套餐编号
    private  String recharge_set_no;
    // 创建日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date createDate;

}
