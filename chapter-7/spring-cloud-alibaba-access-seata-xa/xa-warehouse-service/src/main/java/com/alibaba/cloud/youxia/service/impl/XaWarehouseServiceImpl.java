package com.alibaba.cloud.youxia.service.impl;

import com.alibaba.cloud.youxia.manager.WarehouseManager;

import javax.annotation.Resource;

@DubboService(version = "1.0.0",group = "SEATA_GROUP")
public class XaWarehouseServiceImpl implements XaWarehouseService {
    @Resource
    private WarehouseManager warehouseManager;
    @Override
    public WarehouseServiceDTO notifyWarehouse(WarehouseServiceBo warehouseServiceBo) {
        boolean result = warehouseManager.notify(warehouseServiceBo);
        WarehouseServiceDTO warehouseServiceDTO = new WarehouseServiceDTO();
        if (result) {
            warehouseServiceDTO.setStatus(200);
        } else {
            warehouseServiceDTO.setStatus(500);
        }
        return warehouseServiceDTO;
    }
}