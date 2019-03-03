package com.space.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @describe: 商品
 * @author: 彭爽pross
 * @date: 2019/03/03
 */
@Data
public class Commodity implements Serializable {
    private static final long serialVersionUID = 1L;

    // 商品id
    private Integer productId;
    // 所属商家id
    private Integer shopId;
    // 商品名称
    private String productName;
    // 图片
    private String productImage;
    // 描述
    private String productDescription;
    // 分类
    private String productCategory;
    // 库存
    private String productStocks;
    //创建时间
    private String createTime;
    // 商品状态，0-未上架，1-上架
    private String productStatus;

}
