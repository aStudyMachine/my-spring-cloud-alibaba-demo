package com.alibaba.cloud.youxia.service;

import cn.studymachine.service.SentinelDubboService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0",group ="access-sentinel-spring-cloud-alibaba-provider")
public class SentinelDubboServiceImpl implements SentinelDubboService {

    @Override
    public String testSentinelFlow() {
        return "sentinelException";
    }
}
