package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @describe: 员工类
 * @author: 彭爽pross
 * @date: 2019/03/02
 */
@Data
public class Staff {
    private Integer staffId;
    private String staffName;
    private String staffMark;
    //员工类型名称
    private String staffTypeName;
    private String staffImage;
    private String staffPhone;
    private Double staffSale;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private String staffDate;
    private String shopMark;

    private String staffGender;
    private String staffDesc;

}
