package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @describe: 商品分类
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Data
public class CommodityCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    // 商品分类ID
    private Integer id;
    //  商品分类父级ID
    private Integer parentId;
    // 分类名称
    private String name;
    // 更新日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date modifyDate;
    //商品分类描述
    private String categoryDesc;
    //商家ID
    private  Integer shopId;

    //结果返回字段
    //是否展开和折叠
    private  boolean spread;
    //返回字段
    //子级分类
    private List<CommodityCategory> children;
}