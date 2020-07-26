package com.study.springcloud.cfgbeans;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    /**
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    /**
     * 添加默认算法的其中一种
     * @return
     */
//    @Bean
//    public IRule myRule(){
//        return new RandomRule();
//    }
}
