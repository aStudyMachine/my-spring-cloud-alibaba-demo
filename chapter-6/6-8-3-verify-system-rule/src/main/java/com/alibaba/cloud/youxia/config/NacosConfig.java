package com.alibaba.cloud.youxia.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties(prefix = "youxia")
@Data
public class NacosConfig {

    private String enableCpuAndRt;

    private String enableAddThreadQps;

    public boolean isEnableAddThreadQps() {
        return enableAddThreadQps.equals("1");
    }

    public boolean isEnableCpuAndRt() {
        return enableCpuAndRt.equals("1");
    }

}
