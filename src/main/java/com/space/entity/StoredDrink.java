package com.space.entity;

import lombok.Data;

import java.util.Date;

/**
 * @describe: 存酒信息
 * @author: 彭爽pross
 * @date: 2019/03/23
 */
@Data
public class StoredDrink {

    private Integer id;
    private Integer shopId;
    private String userName;
    private String phone;
    private Date startTime;
    private Date endTime;
    private Integer commodityNo;
    private String drinkName;
    private Integer drinkCount;
    private String brokeRage;
    private String type;
    private Date modifyDate;

}
