package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * @describe: 商品文档关联表
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Data
public class CommodityDocument implements Serializable {
    private static final long serialVersionUID = 1L;

    // 自增流水号
    private Integer id;
    // 商品ID
    private Integer commodityId;
    // 文档ID
    private String documentId;
    //商户ID
    private  Integer shopId;
}
