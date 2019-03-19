package com.space.service.impl;

import com.space.entity.ShopInfo;
import com.space.exception.PageEntity;
import com.space.mapper.WXHomeMapper;
import com.space.service.WXHomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/03/17
 */
@Service
public class WXHomeServiceImpl implements WXHomeService {

    private Logger logger = LoggerFactory.getLogger(WXHomeServiceImpl.class);

    @Autowired
    private WXHomeMapper wxHomeMapper;


    /**查询商家*/
    @Override
    public PageEntity getShop(Integer filter, String provice, String city, String district, String type, String barName) {
        logger.info("WXHomeServiceImplgetShop,filter:"+filter);
        List<ShopInfo> infoList = wxHomeMapper.getShop(filter, provice, city, district, type, barName);
        PageEntity entity = new PageEntity();
        entity.setList(infoList);
        entity.setCount(0);
        return entity;
    }
}
