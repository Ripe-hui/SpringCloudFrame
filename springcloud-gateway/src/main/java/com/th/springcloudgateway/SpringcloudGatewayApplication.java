package com.th.springcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.th.client")
@EnableCircuitBreaker
public class SpringcloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGatewayApplication.class, args);
        System.out.println("* * * * * * * * * * *");
        System.out.println("* Gateway服务启动   *");
        System.out.println("* * * * * * * * * * *");
    }

}
