package cn.studymachine.service.fiveteen;

import cn.studymachine.bo.FiveteenTradeBo;
import cn.studymachine.dto.FiveteenTradeDTO;

public interface FiveteenTradeService {
    FiveteenTradeDTO buyGoodAndCreateOrder(FiveteenTradeBo fiveteenTradeBo);
}
