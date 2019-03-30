package com.space.mapper;

import com.space.entity.ShopSeat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/** 桌位管理*/
public interface ShopSeatMapper {
    public  int add(ShopSeat info);
    public  int deleteById(Integer id);
    public  int update(ShopSeat info);
    public  ShopSeat getInfoById(Integer id);
    public List<ShopSeat> getList(@Param("shopId")Integer shopId, @Param("typeId")Integer typeId,
                                  @Param("seatMark")String seatMark,
                                  @Param("pageNo")Integer pageNo, @Param("pageSize")Integer pageSize);

    public int getCount(@Param("shopId")Integer shopId,@Param("typeId")Integer typeId, @Param("seatMark")String seatMark);
}
