package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @describe: 订单预定
 * @author: 吕涛pross
 * @date: 2019/02/19
 */

@Data
public class ShopOrderPlan implements Serializable {
    private static final long serialVersionUID = 1L;
    // 主键
    private  Integer id;
    // 商户ID
    private  Integer shopId;
    // 预定订单号
    private  String planOrderNo;
    // 用户名称
    private  String userName;
    // 手机号
    private  String userPhone;
    // 性别 0 男 1女
    private  boolean sex;
    // 预抵时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private  Date planToTime;
    // 过期时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private  Date expireTime;
    // 保留时间 分钟
    private  Integer keepMinutes;
    // 人数
    private  Integer peopleNumber;
    // 台数
    private  Integer seatNumber;
    // 服务员用户ID
    private  Integer waiterNo;
    // 营销经理ID
    private  Integer marKetManagerNo;
    //预定状态  100-正常，101-已开台 102-已下单 103-已完成 201-过期取消  202-撤销开台取消  203-商家取消
    private  Integer status;
    //定金
    private  double decisionMoney;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private  Date createDate;

    /*   模型字段,不代表数据库字段*/
    //订单数据
    public  Order order;

    public  String statusStr;
    public  String waiterName;
    public  String marKetManagerName;
}


