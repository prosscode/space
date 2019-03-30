package com.space.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @describe: 签单人员配置
 * @author: 吕涛pross
 * @date: 2019/03/10
 */
@Data
public class ShopSignSetInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private Integer id;
    //商户ID
    private Integer shopId;
    //员工类别编号
    private Integer staffCategoryNo;
    //签单员工ID
    private Integer staffId;
    //签单金额
    private Double signAmount;
    //签单数量
    private Integer signNum;
    //签单状态
    private boolean signStatus;

   /* 结果查询返回字段*/
    //员工类别名称
    private   String staffCategoryName;
    private   String staffPhone;
    //签单人员名称
    private   String staffName;
    //签单总额
    private  Double signSumAmont;

}
