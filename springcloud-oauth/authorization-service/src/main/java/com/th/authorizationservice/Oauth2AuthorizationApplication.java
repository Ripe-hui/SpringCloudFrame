package com.th.authorizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Oauth2AuthorizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2AuthorizationApplication.class, args);
        System.out.println("* * * * * * * * * * *");
        System.out.println("*    授权服务启动    *");
        System.out.println("* * * * * * * * * * *");
    }
}
