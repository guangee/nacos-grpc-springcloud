package com.coding;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.naming.NamingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yunji
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UserApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
    }
}
