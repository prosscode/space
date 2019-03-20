package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @describe: 文档库索引。所有文档索引均在此表中
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Data
public class DocumentInfo implements Serializable{
    private static final long serialVersionUID = 1L;

    // 文档ID
    private String documentId;
    // 文档类型
    private Integer documentType;
    // 文件类型。例如 image/jpeg、image/png
    private String contentType;
    // 引用类型，指本文与商户、商品等相关联的类型
    private Integer refCategory;
    // 引用ID
    private String refId;
    // 引用SequenceNo
    private Integer refSequenceNo;
    // 文档标题，默认使用文件名称
    private String title;
    // 文档摘要
    private String summary;
    // 文档存放位置
    private String url;
    // 图上标注信息,采用JSON格式保存。允许多个标注
    private String markers;
    // 状态字。0未定义；-1删除；
    private Integer state;

}
