package cn.studymachine.service;

import cn.studymachine.bo.LogisticsServiceBo;
import cn.studymachine.dto.LogisticsServiceDTO;

public interface XaLogisticsService {
    LogisticsServiceDTO notifyLogistics(LogisticsServiceBo logisticsServiceBo);
}
