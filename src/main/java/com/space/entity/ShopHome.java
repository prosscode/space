package com.space.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/02/19
 */

@Data
public class ShopHome implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer shopId;
    private String shopMark;
    //酒吧名行业
    private String barName;
    private String industry;

    /**设置详细商家信息，新增*/
    private String shopDoorPhoto;
    private String shopLogoPhoto;

    //人均消费
    private Integer perCapitaConsumption;

    private String shopAddress;

}
