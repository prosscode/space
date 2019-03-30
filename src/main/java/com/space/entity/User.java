package com.space.entity;

import lombok.Data;

/**
 * @describe: 用户
 * @author: 彭爽pross
 * @date: 2019/03/09
 */
@Data
public class User {

    private Integer userId;
    private String userName;
    private Integer shopMark;
    private String userPhone;
    private String userWechat;
    // 支付金额
    private Double userPay;
    // 返利金额
    private Double userRebate;
    // 提现金额
    private Double userWithdrawal;
    // 下线人数
    private Integer userOffline;
    private Integer userRole;


    private Integer nextLevelNum;
    private Integer orderCount;
    private Integer enterDrinkCount;
    private String userTypeStr;
}
