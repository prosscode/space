package com.space.service.impl;

import com.space.entity.AreaTypeInfo;

import com.space.exception.PageEntity;
import com.space.mapper.AreaTypeInfoMapper;
import com.space.service.AreaTypeInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 区域分组
 */
@Service
public class AreaTypeInfoServiceImpl implements AreaTypeInfoService {
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private AreaTypeInfoMapper areaTypeInfoMapper;


    /**
     * 增加
     */
    @Override
    public AreaTypeInfo add(AreaTypeInfo areaTypeInfo) {
        areaTypeInfo.setCreateTime(new Date());
        areaTypeInfo.setTypeId(areaTypeInfoMapper.add(areaTypeInfo));
        return areaTypeInfo;
    }

    /**
     * 删除
     */
    @Override
    public int deleteById(Integer id) {
        return areaTypeInfoMapper.deleteById(id);
    }

    /**
     * 修改
     */
    @Override
    public AreaTypeInfo update(AreaTypeInfo areaTypeInfo) {
        areaTypeInfo.setTypeId(areaTypeInfoMapper.update(areaTypeInfo));
        return areaTypeInfo;
    }

    /**
     * 查询详情 根据ID
     */
    @Override
    public AreaTypeInfo getInfoById(Integer id) {
        return areaTypeInfoMapper.getInfoById(id);
    }

    /**
     * 多条件查询
     */
    @Override
    public PageEntity getList(Integer shopId,
                              String typeName,
                              Integer pageNo,
                              Integer pageSize) {
        List<AreaTypeInfo> list = areaTypeInfoMapper.getList(shopId, typeName, pageNo, pageSize);
        PageEntity pageEntity = new PageEntity();
        pageEntity.setList(list);
        //涉及到分页
        if (pageNo > 0 && pageSize > 0) {
            int rowsCount = areaTypeInfoMapper.getCount(shopId, typeName);
            pageEntity.setCount(rowsCount);
        }
        else {
            pageEntity.setCount(list.size());
        }
        return pageEntity;
    }

}
