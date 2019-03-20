package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;
import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @describe: 分销设置
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Data
public class PartsellSetInfo  implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer shopId;
    private Integer partSellLevel;
    private double commissionRolePartA;
    private double commissionRolePartB;
    private boolean isJoin;
    private String partSellerLableName;
    private double toCashHowMuch;
    private Date modityDate;

}
