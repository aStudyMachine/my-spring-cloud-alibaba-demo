package cn.studymachine.service.impl;

import cn.studymachine.service.PayService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(group = "use-nacos-spring-boot",version = "1.0.0")
public class PayServiceImpl implements PayService {
    @Override
    public String pay() {
        return "payResult";
    }
}
