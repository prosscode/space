package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @describe: 角色权限
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Data
public class RoleMenuInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private  Integer id;
    private  Integer roleId;
    private  Integer menuId;
    private  Integer shopId;
}
