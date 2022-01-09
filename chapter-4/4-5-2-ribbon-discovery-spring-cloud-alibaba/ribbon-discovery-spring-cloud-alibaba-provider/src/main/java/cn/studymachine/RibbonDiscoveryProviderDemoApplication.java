package cn.studymachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RibbonDiscoveryProviderDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonDiscoveryProviderDemoApplication.class, args);
    }
}
