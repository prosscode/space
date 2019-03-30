package com.space.service.impl;

import com.space.definedEnum.OrderStatus;
import com.space.entity.Order;
import com.space.entity.RoleInfo;
import com.space.entity.ShopDrinkInfo;
import com.space.entity.ShopOrderProductDetail;
import com.space.exception.PageEntity;
import com.space.mapper.RoleMenuInfoMapper;
import com.space.mapper.ShopDrinkInfoMapper;
import com.space.mapper.ShopOrderMapper;
import com.space.mapper.ShopOrderProductDetailMapper;
import com.space.service.RoleMenuInfoService;
import com.space.service.ShopDrinkInfoService;
import com.space.service.ShopOrderMapperService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    private ShopOrderProductDetailMapper orderProductDetailMapper;

    @Override
    public Order add(Order order) {
        String orderNo = "0" + UUID.randomUUID().toString().replaceAll("-", "");
        order.setOrderNo(orderNo);
        order.setOrderDate(new Date());
        shopOrderMapper.add(order);
        Integer orderId=order.getOrderId();
        order.setOrderId(orderId);
        //订单产生的金额
        //double orderAmont =0;
        //订单商品详情
        List<ShopOrderProductDetail> orderProductDetails = order.getOrderProductDetails();
        if (orderProductDetails != null && orderProductDetails.size() > 0) {
            for (ShopOrderProductDetail detail : orderProductDetails) {
                detail.setOrderId(order.getOrderId());
                detail.setProductAmount(detail.getProductNum() * detail.getProductPrice());
                //orderAmont+=detail.getProductNum()*detail.getProductPrice();
            }
            orderProductDetailMapper.addBatch(orderProductDetails);
            //反查
            order.orderProductDetails =orderProductDetailMapper.getInfosByOrderId(orderId);
        }

        return order;
    }
    /*订单修改 目前只能修改订单基础数据 跟商品无法关联*/
    @Override
    public Order update(Order order) {
        shopOrderMapper.update(order);
        return order;
    }

    @Override
    public Order getInfoById(Integer orderId) {
        Order model = shopOrderMapper.getInfoById(orderId);
        //设置订单状态 返回中文提示字符串
        model.OrderStatusStr = OrderStatus.getName(model.getOrderStatus());
        //返回订单商品信息
        List<ShopOrderProductDetail> orderProductDetails = orderProductDetailMapper.getInfosByOrderId(orderId);
        model.orderProductDetails = orderProductDetails;
        return model;
    }
    /*订单流水*/
    @Override
    public PageEntity getList(Integer shopId,
                              String orderNo,
                              String orderName,
                              Integer orderType,
                              Integer orderStatus,
                              String dateFrom,
                              String dateTo,
                              Integer pageNo,
                              Integer pageSize) {

        List<Order> orderList = shopOrderMapper.getList(shopId, orderNo, orderName, orderType, orderStatus, dateFrom, dateTo, pageNo, pageSize);
        PageEntity pageEntity = new PageEntity();
        pageEntity.setList(orderList);
        //涉及到分页
        if (pageNo > 0 && pageSize > 0) {
            int rowsCount = shopOrderMapper.getCount(shopId, orderNo, orderName, orderType, orderStatus, dateFrom, dateTo);
            pageEntity.setCount(rowsCount);
        } else {
            pageEntity.setCount(orderList.size());
        }
        return pageEntity;


    }

    @Override
    public int deleteByIds(List<Integer> orderIds) {
        return shopOrderMapper.deleteByIds(orderIds);
    }

    @Override
    public int deleteById(Integer orderId) {
        return shopOrderMapper.deleteById(orderId);
    }

    @Override
    public Order getInfoByNo(String orderNo) {
        Order model = shopOrderMapper.getInfoByNo(orderNo);
        //设置订单状态 返回中文提示字符串
        if(model!=null){
            model.OrderStatusStr = OrderStatus.getName(model.getOrderStatus());
            //返回订单商品信息
            List<ShopOrderProductDetail> orderProductDetails = orderProductDetailMapper.getInfosByOrderId(model.getOrderId());
            model.orderProductDetails = orderProductDetails;
        }
        return model;
    }
    @Override
    public Order getLastInfoByDeskNo(String orderSeat){
        return  shopOrderMapper.getLastInfoByDeskNo(orderSeat);
    }

}
