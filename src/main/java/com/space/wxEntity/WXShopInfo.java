package com.space.wxEntity;

import lombok.Data;

/**
 * @describe: 商家信息
 * @author: 彭爽pross
 * @date: 2019/04/05
 */
@Data
public class WXShopInfo {

    /** 商家的基本信息：id，名称，类型标签，省市区，地址，简介，营业时间，人均消费*/
    private Integer shopId;
    private String shopName;
    private String shopIndustry;
    private String shopProvice;
    private String shopCity;
    private String shopDistrict;
    private String shopAddress;
    private String shopDesc;
    private String businessStartTime;
    private String businessEndTime;
    private Integer perCapitaConsumption;
    /**距离*/
    private Integer distance;

    /**关联信息：图片，评分*/
    private String url;
    private Integer shopScore;

    /**计算距离的经纬度*/
    private Double longitude;
    private Double latitude;
}
