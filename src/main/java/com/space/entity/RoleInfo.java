package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * @describe: 角色
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Data
public class RoleInfo implements Serializable{
    private static final long serialVersionUID = 1L;

    private  Integer roleId;
    private  Integer shopId;
    private  String roleName;
    private  String roleRemark;
    private  boolean isActive;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private  Date createDate;
    private  boolean isShowShop;
    private  boolean isShowSys;

    //栏目ID
    public  List<Integer> menuIds;
}
