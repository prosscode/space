package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * @describe: 文档类型定义。其中2000以后的为用户自定义
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Data
public class DocumentTypeInfo implements Serializable{
    private static final long serialVersionUID = 1L;

    // 文档类型
    private Integer documentType;
    // 文档类型名称
    private String documentTypeName;
    // 文档类型的备注或摘要
    private String comment;
}
