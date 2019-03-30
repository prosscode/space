package com.space.service.impl;

import com.space.entity.ShopSeat;
import com.space.exception.PageEntity;
import com.space.mapper.ShopSeatMapper;
import com.space.mapper.ShopSignSetInfoMapper;
import com.space.service.ShopSeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopSeatServiceImpl implements ShopSeatService {
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private ShopSeatMapper shopSeatMapper;

    @Override
    public ShopSeat add(ShopSeat info) {
        info.setSeatId(shopSeatMapper.add(info));
        return info;
    }
    @Override
    public int deleteById(Integer id) {
        return shopSeatMapper.deleteById(id);
    }
    @Override
    public ShopSeat update(ShopSeat info) {
        shopSeatMapper.update(info);
        return info;
    }
    @Override
    public ShopSeat getInfoById(Integer id) {
        return shopSeatMapper.getInfoById(id);
    }
    @Override
    public PageEntity getList(Integer shopId, Integer typeId,
                              String seatMark,
                              Integer pageNo, Integer pageSize) {
        List<ShopSeat> list = shopSeatMapper.getList(shopId, typeId, seatMark, pageNo, pageSize);
        PageEntity pageEntity = new PageEntity();
        pageEntity.setList(list);
        //涉及到分页
        if ( pageNo > 0 && pageSize > 0) {
            int rowsCount = shopSeatMapper.getCount(shopId, typeId, seatMark);
            pageEntity.setCount(rowsCount);
        }
        else {
            pageEntity.setCount(list.size());
        }
        return pageEntity;
    }
    @Override
    public int getCount(Integer shopId, Integer typeId, String seatMark) {
        return shopSeatMapper.getCount(shopId, typeId, seatMark);
    }
}
