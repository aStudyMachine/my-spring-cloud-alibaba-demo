package cn.studymachine.service.eighteen;

import java.math.BigDecimal;

public interface PayService {
    boolean pay(Long orderId, String goodId, BigDecimal amount);
}
