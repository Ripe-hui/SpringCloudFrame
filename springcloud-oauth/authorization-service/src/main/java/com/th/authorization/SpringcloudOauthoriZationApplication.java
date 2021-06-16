package com.th.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudOauthoriZationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudOauthoriZationApplication.class, args);
        System.out.println("* * * * * * * * * * *");
        System.out.println("*    Auth授权服务启动   *");
        System.out.println("* * * * * * * * * * *");
    }

}
