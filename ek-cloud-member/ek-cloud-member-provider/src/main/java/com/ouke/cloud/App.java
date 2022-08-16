/*
 *
 *  Guangdong Ouke Air Conditioning refrigeration Co., LTD
 *
 *  (C) Copyright Guangdong Ouke Air Conditioning refrigeration Co., LTD. 2022 All Rights Reserved.
 *
 *  NOTICE:  All information contained herein is, and remains the property of
 *  Guangdong Ouke Air Conditioning refrigeration Co., LTD, Co.,Ltd. The intellectual property herein
 *  are protected by trade secret, patent law or copyright law. Dissemination
 *  of this information or reproduction of this material is strictly forbidden
 *  unless prior written permission is obtained from Guangdong Ouke Air Conditioning refrigeration Co., LTD.
 *
 *  http://www.euroklimat.com.cn/
 *
 *
 */

package com.ouke.cloud;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author edison
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan("com.ouke.cloud")
@EnableDiscoveryClient
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
