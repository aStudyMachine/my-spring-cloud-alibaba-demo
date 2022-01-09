package cn.studymachine.service.impl;

import cn.studymachine.service.RibbonTestService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class RibbonTestServiceImpl implements RibbonTestService {
    @Override
    public String test() {
        return "test";
    }
}
