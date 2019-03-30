package com.space.service.impl;

import com.space.entity.ShopUserOfPartSell;
import com.space.exception.PageEntity;
import com.space.mapper.ShopSignSetInfoMapper;
import com.space.mapper.ShopUserOfPartSellMapper;
import com.space.service.ShopUserOfPartSellService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ShopUserOfPartSellServiceImpl implements ShopUserOfPartSellService {
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private ShopUserOfPartSellMapper shopUserOfPartSellMapper;

    /**
     * 增加
     */
    @Override
    public ShopUserOfPartSell add(ShopUserOfPartSell info) {
        info.setJoinDate(new Date());
        info.setId(shopUserOfPartSellMapper.add(info));
        return info;
    }

    /**
     * 删除
     */
    @Override
    public int deleteById(Integer id) {
        return shopUserOfPartSellMapper.deleteById(id);
    }

    /**
     * 修改
     */
    @Override
    public ShopUserOfPartSell update(ShopUserOfPartSell info) {
        shopUserOfPartSellMapper.update(info);
        return info;
    }

    /**
     * 查询详情 根据ID
     */
    @Override
    public ShopUserOfPartSell getInfoById(Integer id) {
      return   shopUserOfPartSellMapper.getInfoById(id);
    }

    /**
     * 多条件查询
     */
    @Override
    public PageEntity getList(Integer shopId,
                              String userPhone,
                              String userName,
                              String joinStartDate,
                              String joinEndDate,
                              Integer pageNo,
                              Integer pageSize) {
        List<ShopUserOfPartSell> list= shopUserOfPartSellMapper.getList(shopId,userPhone,userName,joinStartDate,joinEndDate,pageNo,pageSize);
        PageEntity pageEntity = new PageEntity();
        pageEntity.setList(list);
        //涉及到分页
        if (pageNo > 0 && pageSize > 0) {
            int rowsCount = shopUserOfPartSellMapper.getCount(shopId,userPhone,userName,joinStartDate,joinEndDate);
            pageEntity.setCount(rowsCount);
        }
        else {
            pageEntity.setCount(list.size());
        }
        return pageEntity;
    }

    /**
     * 多条件查询  返回行数
     */
    @Override
    public int getCount(Integer shopId,
                        String userPhone,
                        String userName,
                        String joinStartDate,
                        String joinEndDate) {
        return  shopUserOfPartSellMapper.getCount(shopId,userPhone,userName,joinStartDate,joinEndDate);
    }
}
