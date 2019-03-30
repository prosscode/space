package com.space.service.impl;

import com.space.entity.AreaSeatPriceSet;
import com.space.exception.PageEntity;

import com.space.mapper.AreaSeatPriceSetMapper;
import com.space.service.AreaSeatPriceSetService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class AreaSeatPriceSetServiceImpl implements AreaSeatPriceSetService {
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private AreaSeatPriceSetMapper areaSeatPriceSetMapper;

    /**
     * 增加
     */
    @Override
    public AreaSeatPriceSet add(AreaSeatPriceSet info) {
        info.setModifyDate(new Date());
        info.setId(areaSeatPriceSetMapper.add(info));
        return info;
    }

    /**
     * 删除
     */
    @Override
    public int deleteById(Integer id) {
        return areaSeatPriceSetMapper.deleteById(id);
    }

    /**
     * 修改
     */
    @Override
    public AreaSeatPriceSet update(AreaSeatPriceSet info) {
        info.setModifyDate(new Date());
        areaSeatPriceSetMapper.update(info);
        return info;
    }

    /**
     * 查询详情 根据ID
     */
    @Override
    public AreaSeatPriceSet getInfoById(Integer id){
        return areaSeatPriceSetMapper.getInfoById(id);
    }

    /**
     * 多条件查询
     */
    @Override
    public PageEntity getList(Integer shopId,
                              Integer areaTypeId,
                              Integer pageNo,
                              Integer pageSize){
        List<AreaSeatPriceSet> list= areaSeatPriceSetMapper.getList(shopId, areaTypeId,pageNo,pageSize);
        PageEntity pageEntity = new PageEntity();
        pageEntity.setList(list);
        //涉及到分页
        if (pageNo > 0 && pageSize > 0) {
            int rowsCount = areaSeatPriceSetMapper.getCount(shopId, areaTypeId);
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
                        Integer areaTypeId){
        return areaSeatPriceSetMapper.getCount(shopId,areaTypeId);
    }
}
