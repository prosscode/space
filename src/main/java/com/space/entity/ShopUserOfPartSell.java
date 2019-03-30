package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @describe: 商家用户/分销用户
 * @author: 吕涛pross
 * @date: 2019/03/10
 */
@Data
public class ShopUserOfPartSell implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private Integer id;
    //商家ID
    private Integer shopId;
    //分销用户ID
    private Integer userId;
    //已结算佣金
    private Double commission;
    //总额
    private Double sumMoney;
    //上级用户ID
    private Integer superUserId;
    //下级用户人数
    private Integer nextUserNum;
    //加入分销时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date joinDate;
    //状态 是否有效
    private Integer isActive;

    /*结果查询返回字段*/
    //分销用户名称
    private   String userName;
    //分销用户名称
    private   String superUserName;
}
