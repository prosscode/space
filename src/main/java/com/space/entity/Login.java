package com.space.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @describe: 登录实体类
 * @author: 彭爽pross
 * @date: 2019/02/19
 */

@Data
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer shopId;
    private String shopMark;
    // 用户名密码
    private String userName;
    private String password;
    //酒吧名行业
    private String barName;
    private String industry;
    // 省份地址
    private String provice;
    private String city;
    private String address;
    private String inCharge;
    //创建时间
    private String currentTime;

    //是否开启分销
    private Integer shopDistribution;

}
