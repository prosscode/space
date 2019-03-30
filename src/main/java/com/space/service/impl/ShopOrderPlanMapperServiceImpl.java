package com.space.service.impl;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import com.space.entity.ShopOrderPlan;
import com.space.entity.ShopOrderProductDetail;
import com.space.exception.PageEntity;
import com.space.mapper.ShopOrderMapper;
import com.space.mapper.ShopOrderPlanMapper;
import com.space.mapper.ShopOrderProductDetailMapper;
import com.space.service.ShopOrderMapperService;
import com.space.service.ShopOrderPlanMapperService;
import com.sun.org.apache.regexp.internal.REUtil;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @describe: 订单预定  关联订单和订单详情
 * @author: 吕涛pross
 * @date: 2019/03/16
 */
@Service
public class ShopOrderPlanMapperServiceImpl implements ShopOrderPlanMapperService {
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);
    @Autowired
    private ShopOrderPlanMapper shopOrderPlanMapper;

    @Autowired
    private ShopOrderMapper orderMapper;

    @Autowired
    private ShopOrderMapperService orderMapperService;


    @Autowired
    private ShopOrderProductDetailMapper orderProductDetailMapper;

    /**
     * 增加
     */
    @Override
    public ShopOrderPlan add(ShopOrderPlan info) {
        //生成预定订单
        if (info.order != null) {
            //默认订单
            info.order.setOrderType(0);
            info.order = orderMapperService.add(info.order);
            //orderMapper.add(info.order);
            info.setPlanOrderNo(info.order.getOrderNo());
        }
        info.setId(shopOrderPlanMapper.add(info));
        return info;
    }

    /**
     * 删除
     */
    @Override
    public int deleteById(Integer id) {
        //查询订单数据
        return shopOrderPlanMapper.deleteById(id);
    }

    /**
     * 修改
     */
    @Override
    public ShopOrderPlan update(ShopOrderPlan info) {
        shopOrderPlanMapper.update(info);
        return info;
    }

    /**
     * 查询详情 根据ID
     */
    @Override
    public ShopOrderPlan getInfoById(Integer id) {
        ShopOrderPlan model = shopOrderPlanMapper.getInfoById(id);
        model.order = orderMapperService.getInfoByNo(model.getPlanOrderNo());
        return  model;
    }

    /**
     * 多条件查询
     */
    @Override
    public PageEntity getList(Integer shopId,
                              String startToTime,
                              String endToTime,
                              String kewWord,
                              Integer pageNo,
                              Integer pageSize) {
        List<ShopOrderPlan> list = shopOrderPlanMapper.getList(shopId, startToTime, endToTime, kewWord, pageNo, pageSize);
        PageEntity pageEntity = new PageEntity();
        pageEntity.setList(list);
        //涉及到分页
        if (pageNo > 0 && pageSize > 0) {
            int rowsCount = shopOrderPlanMapper.getCount(shopId, startToTime, endToTime, kewWord);
            pageEntity.setCount(rowsCount);
        } else {
            pageEntity.setCount(list.size());
        }
        return pageEntity;
    }

    /**
     * 多条件查询  返回行数
     */
    @Override
    public int getCount(Integer shopId,
                        String startToTime,
                        String endToTime,
                        String kewWord) {
        return shopOrderPlanMapper.getCount(shopId, startToTime, endToTime, kewWord);
    }
}
