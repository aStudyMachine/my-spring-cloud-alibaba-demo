package cn.studymachine.config;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NacosRibbonRuleConfig {

    @Bean
    public IRule nacosRule() {
        return new NacosRule();
    }

    @LoadBalanced  // 标记使用负载均衡
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
