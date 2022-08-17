package com.ouke.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author addison
 * @date 2022年08月16日 18:45
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.ouke.cloud")
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
}
