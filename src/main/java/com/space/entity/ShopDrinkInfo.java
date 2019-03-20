package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @describe: 存酒/取酒
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Data
public class ShopDrinkInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Integer id;
    private  Integer shopId;
    private  String userName;
    private  String phone;
    private  Integer startTime;
    private  Integer endTime;
    private  Integer drinkName;
    private  Integer drinkCount;
    private  String brokeRage;
    private  String type;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private  Date modifyDate;
}
