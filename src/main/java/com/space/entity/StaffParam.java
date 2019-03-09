package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @describe: 员工类
 * @author: 彭爽pross
 * @date: 2019/03/02
 */
@Data
public class StaffParam extends Staff{

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date dateFrom;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date dateTp;

    private Integer pageSize;
    private Integer pageNo;


}
