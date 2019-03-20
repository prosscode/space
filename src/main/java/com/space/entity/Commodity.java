package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @describe: 商品
 * @author: 彭爽pross
 * @date: 2019/02/23
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
    private String productDesc;
    //商品分类编号
    private int productCategoryNo;
    // 商品分类名称
    private String productCategory;

    // 商品库存  库存为0时，表示[已售馨]
    private String productStocks;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone= "GMT+8")
    private Date createTime;
    //商品更新时间
    private Date updateTime;
    //  商品状态，0-未上架，1-上架
    private int productStatus;
    //商品卖点详情
    private String productSellDesc;
    //   是否显示剩余商品件数，0代表不显示、1代表显示
    private boolean showSurplus;
    // 商品是否参加分销返利,0不参加、1参加
    private boolean isJoinpartsell;
    //商品上架时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date publishTime;

    //-------------------------------返回结果字段-----------------------------------
    //商品单价 根据时间点自动计算
    public  double Price;
    //默认展示图片
    public  DocumentInfo defaultDocument;

    //文档数据
    public  List<DocumentInfo> documentInfos;
    //商品价格关联
    public List<CommodityPrice> CommodityPriceList;
}




