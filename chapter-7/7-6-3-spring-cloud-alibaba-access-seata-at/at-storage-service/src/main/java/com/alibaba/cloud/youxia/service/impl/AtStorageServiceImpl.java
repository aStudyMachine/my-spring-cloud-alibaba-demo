package com.alibaba.cloud.youxia.service.impl;

import cn.studymachine.service.AtStorageService;
import com.alibaba.cloud.youxia.manager.StorageManager;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService(version = "1.0.0", group = "SEATA_GROUP")
public class AtStorageServiceImpl implements AtStorageService {

    @Resource
    private StorageManager storageManager;

    @Override
    public boolean deductInventory(Long goodId, Integer num) {
        return storageManager.deductInventory(goodId, num);
    }
}
