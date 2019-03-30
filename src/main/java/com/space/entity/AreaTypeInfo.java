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
public class AreaTypeInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    //自增id
    private  Integer  typeId;
    //商家id
    private  Integer      shopId;
    //区域名称
    private    String    typeName;
    //桌位数量
    private  Integer     seatCount;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private  Date    createTime;
    //区分标签
    private  int label;
}
