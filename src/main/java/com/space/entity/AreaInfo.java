package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @describe: 区域分组
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Data

public class AreaInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Integer id;//区域分组ID
    private  String area_name;// 区域分组名称
    private  String       area_desc;//区域分组描述
    private  Date  date;//日期
}
