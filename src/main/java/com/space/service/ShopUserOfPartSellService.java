package com.space.service;

import com.space.entity.ShopUserOfPartSell;
import com.space.exception.PageEntity;
import org.apache.ibatis.annotations.Param;

public interface ShopUserOfPartSellService {
    /**
     * 增加
     */
    public ShopUserOfPartSell add(ShopUserOfPartSell info);

    /**
     * 删除
     */
    public int deleteById(Integer id);

    /**
     * 修改
     */
    public ShopUserOfPartSell update(ShopUserOfPartSell info);

    /**
     * 查询详情 根据ID
     */
    public ShopUserOfPartSell getInfoById(Integer id);

    /**
     * 多条件查询
     */
    public PageEntity getList(Integer shopId,
                              String userPhone,
                              String userName,
                              String joinStartDate,
                              String joinEndDate,
                              Integer pageNo,
                              Integer pageSize);

    /**
     * 多条件查询  返回行数
     */
    public int getCount(Integer shopId,
                        String userPhone,
                        String userName,
                        String joinStartDate,
                        String joinEndDate);
}
