package com.space.service.impl;

import com.space.entity.ShopSignSetInfo;
import com.space.exception.PageEntity;
import com.space.mapper.AreaTypeInfoMapper;
import com.space.mapper.ShopSignSetInfoMapper;
import com.space.service.ShopSignSetInfoService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopSignSetInfoServiceImpl implements ShopSignSetInfoService {
    private static Logger logger = LoggerFactory.getLogger(CommodityServiceImpl.class);

    @Autowired
    private ShopSignSetInfoMapper signSetInfoMapper;

    /**
     * 增加
     */
    @Override
    public ShopSignSetInfo add(ShopSignSetInfo info) {
        info.setId(signSetInfoMapper.add(info));
        return info;
    }

    /**
     * 删除
     */
    @Override
    public int deleteById(Integer id) {
        return signSetInfoMapper.deleteById(id);
    }

    /**
     * 修改
     */
    @Override
    public ShopSignSetInfo update(ShopSignSetInfo info) {
        signSetInfoMapper.update(info);
        return info;
    }

    /**
     * 查询详情 根据ID
     */
    @Override
    public ShopSignSetInfo getInfoById(Integer id) {
        return signSetInfoMapper.getInfoById(id);
    }

    /**
     * 多条件查询
     */
    @Override
    public PageEntity getList(Integer shopId,
                              Integer staffCategoryNo,
                              Integer staffId,
                              Integer pageNo,
                              Integer pageSize) {

        List<ShopSignSetInfo> list = signSetInfoMapper.getList(shopId, staffCategoryNo, staffId, pageNo, pageSize);
        PageEntity pageEntity = new PageEntity();
        pageEntity.setList(list);
        //涉及到分页
        if (pageNo > 0 && pageSize > 0) {
            int rowsCount = signSetInfoMapper.getCount(shopId, staffCategoryNo, staffId);
            pageEntity.setCount(rowsCount);
        }
        else {
            pageEntity.setCount(list.size());
        }
        return pageEntity;
    }

    /**
     * 列表汇总  统计人员签单情况
     */
    @Override
    public List<ShopSignSetInfo> summarySignInfo() {

        return signSetInfoMapper.summarySignInfo();
    }

    /**
     * 多条件查询  返回行数
     */
    @Override
    public int getCount(Integer shopId,
                        Integer staffCategoryNo,
                        Integer staffId) {
        return signSetInfoMapper.getCount(shopId, staffCategoryNo, staffId);
    }
}
