package cn.studymachine.service.impl;

import cn.studymachine.service.RibbonDiscoveryService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.net.InetAddress;

@DubboService(version = "1.0.0", group = "ribbon-provider")
public class RibbonDiscoveryServiceImpl implements RibbonDiscoveryService {

    @Resource
    private Environment environment;

    @Override
    public String getRibbonConfig() {
        String port = environment.getProperty("local.server.port");
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "负载均衡成功！" + "当前机器节点IP地址为：" + ip + ":" + port;
    }
}
