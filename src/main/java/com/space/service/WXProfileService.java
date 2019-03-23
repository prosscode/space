package com.space.service;

import com.space.exception.PageEntity;

public interface WXProfileService {

    public Integer getPartsellLevel(Integer shopId);

    public PageEntity getUserIdentity(Integer userId);
}
