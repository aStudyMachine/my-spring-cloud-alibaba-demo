package cn.studymachine.service;

import cn.studymachine.bo.TccAccountServiceBo;

import java.math.BigDecimal;

public interface TccAccountService {
    boolean transformMoney(TccAccountServiceBo tccAccountServiceBo);
    void decreaseMoney(Long userId, BigDecimal money);
}
