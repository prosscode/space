package com.space.service.impl;

import com.space.definedEnum.OrderStatus;
import com.space.entity.Order;
import com.space.entity.RoleInfo;
import com.space.entity.ShopDrinkInfo;
import com.space.exception.PageEntity;
import com.space.mapper.RoleMenuInfoMapper;
import com.space.mapper.ShopDrinkInfoMapper;
import com.space.mapper.ShopOrderMapper;
import com.space.service.RoleMenuInfoService;
import com.space.service.ShopDrinkInfoService;
import com.space.service.ShopOrderMapperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @describe: 存酒/取酒
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Service
public class ShopOrderMapperServiceImpl implements ShopOrderMapperService {
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private ShopOrderMapper shopOrderMapper;

    @Override
    public Order getInfoById(Integer orderId){
        Order model =shopOrderMapper.getInfoById(orderId);
        //设置订单状态
        model.OrderStatusStr=   OrderStatus.getName(model.getOrderStatus());
        //返回订单商品信息
        return model;
    }
    @Override
    public List<Order> getList(Integer shopId,
                               String orderNo,
                               String orderName,
                               Integer orderType,
                               Integer orderStatus,
                               String dateFrom,
                               String dateTo,
                               Integer pageNo,
                               Integer pageSize){
        return  null;
    }
    @Override
    public int deleteByIds(List<Integer> orderIds){
        return  -1;
    }
    @Override
    public int deleteById(Integer orderId){
        return  -1;
    }

    @Override
    public Order getInfoByNo(String orderNo){
        return  null;
    }


}
