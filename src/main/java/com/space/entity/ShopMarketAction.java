package com.space.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @describe: 营销活动管理
 * @author: 吕涛
 * @date: 2019/03/19
 */

@Data
public class ShopMarketAction implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private Integer id;
    //活动名称
    private String actionName;
    //活动开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date beginTime;
    //活动结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone= "GMT+8")
    private Date endTime;
    //活动图片ID
    private String documentId;
    //是否开放前台 0否 1是
    private boolean isOpenReception;
    //审核方式
    private String examineMethod;
    //是否投票
    private boolean isVote;
    //没人可投票数量
    private Integer voteNum;
    //分享图标关联ID
    private String sharedImgId;
    // 是否启用分享设置 0禁用 1启用
    private boolean isActiveUseShared;

}
