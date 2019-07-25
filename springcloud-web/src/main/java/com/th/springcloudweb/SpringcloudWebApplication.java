package com.th.springcloudweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudWebApplication.class, args);
        System.out.println("* * * * * * * * * * *");
        System.out.println("*     Web服务启动   *");
        System.out.println("* * * * * * * * * * *");
    }

}
