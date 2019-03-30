package com.space.service;

import com.space.entity.ShopSeat;
import com.space.exception.PageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopSeatService {

    public ShopSeat add(ShopSeat info);

    public int deleteById(Integer id);

    public ShopSeat update(ShopSeat roleInfo);

    public ShopSeat getInfoById(Integer id);

    public PageEntity getList(Integer shopId, Integer typeId,
                              String seatMark,
                              Integer pageNo, Integer pageSize);

    public int getCount(Integer shopId, Integer typeId,
                        String seat_mark);
}
