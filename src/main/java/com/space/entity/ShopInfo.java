package com.space.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @describe: 登录实体类
 * @author: 彭爽pross
 * @date: 2019/02/19
 */

@Data
public class ShopInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer shopId;
    private String shopMark;
    // 用户名-
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
    private Integer status;
    //创建时间
    private String createDate;
    //是否开启分销
    private Integer shopDistribution;

    /**设置详细商家信息，新增*/
    private String shopLicense;
    private String shopAuthentication;
    private String shopCateringPermit;
    private String shopDoorPhoto;
    private String shopLogoPhoto;
    private String shopDesc;

    //人均消费
    private Integer perCapitaConsumption;

}
