package com.study.springcloud.controller;


import com.study.springcloud.entities.Dept;
import com.study.springcloud.fiegn.DeptClientService;
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
//    private static final String REST_URL = "http://MICROSERVICECLOUD-DEPT";
    @Autowired
    private DeptClientService deptClientService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/consumer/dept/add",method= RequestMethod.POST)
    public boolean add(Dept dept)
    {
        return deptClientService.add(dept);
    }


    @RequestMapping(value="/consumer/dept/get/{id}",method= RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        return deptClientService.get(id);
    }


    @RequestMapping(value="/consumer/dept/list",method= RequestMethod.GET)
    public List<Dept> list()
    {
        return deptClientService.list();
    }


}
