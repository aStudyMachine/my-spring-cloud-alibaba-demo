package com.alibaba.cloud.youxia;

import cn.studymachine.service.RuleService;
import com.alibaba.csp.sentinel.init.InitExecutor;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class NettySpringCloudAlibabaPushApplication {

    private static final String INTERFACE_RES_KEY = RuleService.class.getName();

    private static final String RES_KEY = INTERFACE_RES_KEY + ":rulePush()";


    public static void main(String[] args) {
        // 初始化信道
        InitExecutor.doInit();

        // 初始化流控规则
        initFlowRule(5, true);

        SpringApplicationBuilder providerBuilder = new SpringApplicationBuilder();
        providerBuilder.web(WebApplicationType.NONE)
                .sources(NettySpringCloudAlibabaPushApplication.class)
                .run(args);
    }



    /**
     * Init flow rule.
     *
     * @param interfaceFlowLimit 整个interface方法的流量阈值
     * @param method             是否指定某个方法
     */
    static void initFlowRule(int interfaceFlowLimit, boolean method) {
        List<FlowRule> list = new ArrayList<>();

        FlowRule flowRule = new FlowRule(INTERFACE_RES_KEY)
                .setCount(interfaceFlowLimit)
                .setGrade(RuleConstant.FLOW_GRADE_QPS);
        list.add(flowRule);

        if (method) {
            FlowRule flowRule1 = new FlowRule(RES_KEY)
                    .setCount(5)
                    .setGrade(RuleConstant.FLOW_GRADE_QPS);
            list.add(flowRule1);
        }

        // 推送流量规则
        FlowRuleManager.loadRules(list);
    }
}
