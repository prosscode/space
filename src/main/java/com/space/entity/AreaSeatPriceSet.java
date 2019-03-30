package com.space.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @describe: 区域价格设置
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Data
public class AreaSeatPriceSet implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer shopId;
    private Integer areaTypeId;
    private Double price;
    private Integer startHour;
    private Integer endHour;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date modifyDate;
   /* 結果返回字段*/
    private  String areaTypeName;
    private  Integer seatCount;
}
