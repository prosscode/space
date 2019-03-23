package com.space.entity;

import lombok.Data;

import java.util.Date;

/**
 * @describe: 分销员
 * @author: 彭爽pross
 * @date: 2019/03/23
 */
@Data
public class UserPartSell {

    private Integer id;
    private Integer shopId;
    private Integer userId;
    private Double commission;
    private Double sumMoney;
    private Integer superUserId;
    private String superUserName;
    private Integer nextUserNum;
    private Date joinDate;
    private Integer isActive;

}
