package com.alibaba.cloud.youxia.controller;

import cn.studymachine.service.SystemRuleService;
import com.alibaba.cloud.youxia.config.NacosConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
@RefreshScope
public class SystemRuleController {

    @Autowired
    private NacosConfig nacosConfig;

    @DubboReference(version = "1.0.0", group = "verify-system-rule")
    private SystemRuleService systemRuleService;


    @GetMapping(value = "/verify")
    @ResponseBody
    public String verifySystemRule() {
        Executors.newFixedThreadPool(50).execute(new Executor());
        Executors.newScheduledThreadPool(1).schedule(new Ext(), 60 * 2, TimeUnit.SECONDS);
        return "成功";
    }

    class Executor implements Runnable {
        @Override
        public void run() {
            while (true) {
                systemRuleService.verifySystemRule();
            }
        }
    }

    class Ext implements Runnable {
        @Override
        public void run() {
            if (nacosConfig.isEnableAddThreadQps()) {
                Executors.newFixedThreadPool(50).execute(new Executor());
            }
        }
    }
}
