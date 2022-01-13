package cn.studymachine;

import cn.studymachine.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;

@Configuration
@RefreshScope // 用于动态刷新配置
public class ConfigReader {

    @Autowired
    private NacosConfig nacosConfig;

    @PostConstruct
    public void init() {
        Executors.newCachedThreadPool().execute(new ConfigThread());
    }

    class ConfigThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("使用Spring Cloud Alibaba接入Nacos配置中心，获取配置信息name为：" + nacosConfig.getName());
                System.out.println("使用Spring Cloud Alibaba接入Nacos配置中心，获取配置信息value为：" + nacosConfig.getValue());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
