package com.space.service.impl;

import com.space.mapper.WXHomeMapper;
import com.space.service.WXHomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @describe:
 * @author: 彭爽pross
 * @date: 2019/03/17
 */
public class WXHomeServiceImpl implements WXHomeService {

    private Logger logger = LoggerFactory.getLogger(WXHomeServiceImpl.class);

    @Autowired
    private WXHomeMapper wxHomeMapper;

    /**查询商家*/
    @Override
    public void getShop() {

        wxHomeMapper.getShop();
    }
}
