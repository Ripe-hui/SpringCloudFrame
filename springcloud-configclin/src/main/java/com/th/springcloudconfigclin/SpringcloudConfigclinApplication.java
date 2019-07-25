package com.th.springcloudconfigclin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudConfigclinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfigclinApplication.class, args);
        System.out.println("* * * * * * * * * * *");
        System.out.println("* Configcli服务启动 *");
        System.out.println("* * * * * * * * * * *");
    }

}
