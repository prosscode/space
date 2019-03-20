package com.space.service;


import com.space.entity.Order;
import com.space.exception.PageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ShopOrderMapperService {

    public List<Order> getList(Integer shopId,
                               String orderNo,
                               String orderName,
                               Integer orderType,
                               Integer orderStatus,
                               String dateFrom,
                               String dateTo,
                               Integer pageNo,
                               Integer pageSize);

    public int deleteByIds(List<Integer> orderIds);

    public int deleteById(Integer orderId);

    public Order getInfoById(Integer orderId);

    public Order getInfoByNo(String orderNo);

}
