package com.study.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.study.springcloud"})
public class Application_Fiegn_80 {

    public static void main(String[] args) {
        SpringApplication.run(Application_Fiegn_80.class,args);
    }
}
