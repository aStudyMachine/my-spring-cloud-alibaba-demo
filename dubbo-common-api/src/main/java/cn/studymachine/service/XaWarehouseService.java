package cn.studymachine.service;

import cn.studymachine.bo.WarehouseServiceBo;
import cn.studymachine.dto.WarehouseServiceDTO;

public interface XaWarehouseService {
    WarehouseServiceDTO notifyWarehouse(WarehouseServiceBo warehouseServiceBo);
}
