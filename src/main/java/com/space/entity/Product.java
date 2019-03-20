package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @describe: 商品
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer   product_id; //商品编号
    private Integer      shop_id;//所属商家ID
    private String     product_name;//商品名称
    private String         product_image;//
    private String     product_description;//商品描述
    private int    product_categoryNo;//商品分类编号
    private String          product_category;//商品分类名称
    private int    product_stocks;//商品库存  库存为0时，表示[已售馨]
    private Date           create_time;//创建时间

    private Date          update_time;//商品更新时间
    private int    product_status;//  商品状态，0-未上架，1-上架
    private String           product_sell_desc;//商品卖点详情
    private boolean    show_surplus;//   是否显示剩余商品件数，0代表不显示、1代表显示
    private boolean         is_joinpartsell;// 商品是否参加分销返利,0不参加、1参加
    private Date   publish_time;//商品上架时间
}
