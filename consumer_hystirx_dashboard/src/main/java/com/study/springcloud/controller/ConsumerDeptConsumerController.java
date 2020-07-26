package com.study.springcloud.controller;


import com.study.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerDeptConsumerController {

//    private static final String REST_URL = "http://localhost:8001";
    private static final String REST_URL = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/consumer/dept/add",method= RequestMethod.POST)
    public boolean add(Dept dept)
    {
        return restTemplate.postForObject(REST_URL+"/dept/add",dept,Boolean.class);
    }


    @RequestMapping(value="/consumer/dept/get/{id}",method= RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(REST_URL+"/dept/get/"+id,Dept.class);
    }


    @RequestMapping(value="/consumer/dept/list",method= RequestMethod.GET)
    public List<Dept> list()
    {
        return restTemplate.getForObject(REST_URL+"/dept/list",List.class);
    }

    //测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value="/consumer/dept/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(REST_URL+"/dept/discovery", Object.class);
    }

}
