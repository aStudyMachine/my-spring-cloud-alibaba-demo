package cn.studymachine.service.fiveteen;

import cn.studymachine.bo.FiveteenOrderBo;
import cn.studymachine.dto.FiveteenOrderDTO;

public interface FiveteenOrderService {
    FiveteenOrderDTO createOrder(FiveteenOrderBo fiveteenOrderBo);
}
